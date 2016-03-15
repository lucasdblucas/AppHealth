package com.ufpi.estagio.apphealth.Avaliacoes_tela;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ufpi.estagio.apphealth.BancoDeDados_Local.Avaliacao;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Avaliado;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Conver_App_Banco;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Usuario;
import com.ufpi.estagio.apphealth.ConsultaAvaliacao_tela.ConsultaAvaliacao_tela;
import com.ufpi.estagio.apphealth.Iniciar_tela.Iniciar_appHealth;
import com.ufpi.estagio.apphealth.R;
import com.ufpi.estagio.apphealth.NovaAvaliacao_tela.tela_NovaAvaliacao;

import java.util.ArrayList;
import java.util.List;

public class activity_principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    private Toolbar toolBar_01;
    private FloatingActionButton actionButton;
    private NavigationView navigationView;

    //conteudo de Intent
    private Usuario usuario;

    //componentes da listView
    private List<Avaliacao> todas_avaliacoes;
    private List<ItemLinha> avaliacoes;

    private TypedArray profile_pics;

    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //recuperar informações de usuario
        Intent intentExtras = getIntent();
        Bundle extraBundle = intentExtras.getExtras();

        if(extraBundle != null && !extraBundle.isEmpty()){
            if(extraBundle.containsKey(Iniciar_appHealth.EXTRA_MESSAGE_USUARIOID)) {
                String[] arrayString = extraBundle.getStringArray(Iniciar_appHealth.EXTRA_MESSAGE_USUARIOID);

                if(arrayString != null && arrayString.length > 0) {
                    Log.i("MENSAGEM_DO_BANCO", "entreamos aqui");
                    usuario = new Usuario();
                    usuario.setID(Long.parseLong(arrayString[0]));
                    usuario.setNome(arrayString[1]);
                    usuario.setSenha(arrayString[2]);

                }else Log.i("MENSAGEM_DO_BANCO", "Array recuperado não possui posições");
            }else Log.i("MENSAGEM_DO_BANCO", "bundley não possui mensagem EXTRA_MESSAGE_USUARIOID");
        }else Log.i("MENSAGEM_DO_BANCO", "bundley empty");

        //consultar o banco de dados e retornar as avlaições existentes
        inicializarListView();

        toolBar_01 = (Toolbar) findViewById(R.id.toolbar);
        toolBar_01.setTitle("Avaliações");
        setSupportActionBar(toolBar_01);

        actionButton = (FloatingActionButton) findViewById(R.id.fab);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( view.getContext(), tela_NovaAvaliacao.class);
                intent.putExtra(Iniciar_appHealth.EXTRA_MESSAGE_USUARIOID, new String[]{""+usuario.getID()
                    , usuario.getNome(), usuario.getSenha()});
                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolBar_01, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Esse método é sobreescrevido da classe OnClickListener implementado por essa activity
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent (this, ConsultaAvaliacao_tela.class);
        startActivity(intent);

        //String nome_avaliado = avaliacoes.get(position).getNome_avaliado();
        //Toast.makeText(getApplicationContext(), "" + nome_avaliado,
        //        Toast.LENGTH_SHORT).show();
    }

    private void inicializarListView(){
        avaliacoes = new ArrayList<>();

        Conver_App_Banco banco = new Conver_App_Banco(this);
        todas_avaliacoes = banco.getAvaliacoesUmUsuario(usuario);


        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);

        int i = 0;
        if(todas_avaliacoes.size() >0) {

            for (Avaliacao avaliacao : todas_avaliacoes) {
                Avaliado avaliado =  banco.consultarAvaliadoByID(avaliacao);
                if(avaliacao.getStatus_Envio().equals("Enviado")) i = 0;
                else i = 1;
                ItemLinha item_aux = new ItemLinha(avaliado.getNome_avaliado(),
                        profile_pics.getResourceId(i, -1), avaliacao.getStatus_Envio());
               avaliacoes.add(item_aux);


            }
        }

        myListView = (ListView) findViewById(R.id.list_avaliacao);
        CustomListView_Adapter adapter = new CustomListView_Adapter(this, avaliacoes);
        myListView.setAdapter(adapter);

        profile_pics.recycle();

        myListView.setOnItemClickListener(this);
    }
}
