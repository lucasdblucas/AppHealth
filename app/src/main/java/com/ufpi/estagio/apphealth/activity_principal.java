package com.ufpi.estagio.apphealth;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import java.util.ArrayList;
import java.util.List;

public class activity_principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    private Toolbar toolBar_01;
    private FloatingActionButton actionButton;
    private NavigationView navigationView;

    //componentes da listView
    private List<String> nomes_avaliados;
    private String[] tipoStatus_envio_cliente;
    private TypedArray profile_pics;
    private List<ItemLinha> avaliacoes;
    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //consultar o banco de dados e retornar as avlaições existentes
        inicializarListView();

        toolBar_01 = (Toolbar) findViewById(R.id.toolbar);
        toolBar_01.setTitle("");
        setSupportActionBar(toolBar_01);

        actionButton = (FloatingActionButton) findViewById(R.id.fab);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    //Esse método é sobreescrevido da classe OnClckListener implementado por essa activity
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String nome_avaliado = avaliacoes.get(position).getNome_avaliado();
        Toast.makeText(getApplicationContext(), "" + nome_avaliado,
                Toast.LENGTH_SHORT).show();
    }

    private void inicializarListView(){
        avaliacoes = new ArrayList<>();

        /*nomes avaliados mais adiante será fornecido pelo banco de dados
        a principio enquanto o banco de dados não é implementado, essas informações serão
        iniciadas estaticamente*/
        nomes_avaliados = new ArrayList<>();
        nomes_avaliados. add("Lucas Daniel");
        nomes_avaliados. add("Dona Rosa");
        nomes_avaliados. add("Seu Raimundo");
        nomes_avaliados. add("Seu Domingos");
        nomes_avaliados. add("Dona Lurdes");

        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);
        tipoStatus_envio_cliente = getResources().getStringArray(R.array.statues_envio_cliente);

        for(int i=0; i<nomes_avaliados.size(); i++){
            ItemLinha item_aux = new ItemLinha(nomes_avaliados.get(i), profile_pics.getResourceId(i%2, -1), "Enviado");
            avaliacoes.add(item_aux);
        }

        myListView = (ListView) findViewById(R.id.list_avaliacao);
        CustomListView_Adapter adapter = new CustomListView_Adapter(this, avaliacoes);
        myListView.setAdapter(adapter);

        profile_pics.recycle();

        myListView.setOnItemClickListener(this);
    }
}
