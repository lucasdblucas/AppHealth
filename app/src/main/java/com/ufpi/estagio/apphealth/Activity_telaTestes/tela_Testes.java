package com.ufpi.estagio.apphealth.Activity_telaTestes;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.ufpi.estagio.apphealth.BancoDeDados_Local.Avaliacao;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Conver_App_Banco;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Usuario;
import com.ufpi.estagio.apphealth.FimTeste_tela.FimTeste_activity;
import com.ufpi.estagio.apphealth.Iniciar_tela.Iniciar_appHealth;
import com.ufpi.estagio.apphealth.NovaAvaliacao_tela.tela_NovaAvaliacao;
import com.ufpi.estagio.apphealth.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class tela_Testes extends AppCompatActivity {

    public static HashMap<String, HashMap<String, String>> ListaTestes;
    public String ID_tela = "1";
    public String titulo_tela = "";
    public String subTitulo_tela = "";

    private Avaliacao avaliacao;
    private Conver_App_Banco banco;

    private EditText edit_Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__testes);

        edit_Resultado = (EditText) findViewById(R.id.field_Resultados);

        Intent intentExtras = getIntent();
        Bundle extraBundle = intentExtras.getExtras();

        if(extraBundle != null && !extraBundle.isEmpty()){
            if(extraBundle.containsKey(tela_NovaAvaliacao.EXTRA_MESSAGE)) {
                String[] arrayString = extraBundle.getStringArray(tela_NovaAvaliacao.EXTRA_MESSAGE);

                if(arrayString!= null && arrayString.length > 0) {
                    Log.i("MENSAGEM", "entreamos aqui");
                    ID_tela = arrayString[0];
                    titulo_tela = arrayString[1];
                    subTitulo_tela = arrayString[2];

                    if (ID_tela.equals("1")) iniciarHashTestes();
                    if(null != getSupportActionBar()) {
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //ativar botão de voltar da tool bar
                        getSupportActionBar().setTitle(titulo_tela);
                        getSupportActionBar().setSubtitle(subTitulo_tela);
                    }
                }
            }
            if(extraBundle.containsKey(tela_NovaAvaliacao.EXTRA_MESSAGE_AVALIACAOID)) {
                String[] arrayString_02 = extraBundle.getStringArray(tela_NovaAvaliacao.EXTRA_MESSAGE_AVALIACAOID);

                if(arrayString_02!= null && arrayString_02.length > 0) {
                    Log.i("MENSAGEM_AVALIACAOID", "verificar recebimento da avaliacao_ID");
                    banco = new Conver_App_Banco(this);
                    avaliacao = banco.consultarAvaliacaoByID(Long.parseLong(arrayString_02[0]));
                }
            }
        }


        CardFragment frag = (CardFragment) getSupportFragmentManager().findFragmentByTag("tela_testes");
        if(frag == null){
            frag = new CardFragment();
            FragmentTransaction f = getSupportFragmentManager().beginTransaction();
            f.replace(R.id.fragment_Container, frag, "tela_testes");
            f.commit();
        }

    }

    public void iniciarHashTestes(){

        ListaTestes = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> auxHash_01 = new HashMap<String, String>();

        auxHash_01.put("1Relação Cintura Para Quadril", "Medidas circunferenciais com proposito de calcular o percentual de gordura e estimar o risco cardiovascular.");
        auxHash_01.put("2Procedimento","Fazer as medidas circunferencias da cintura e do quadril.");
        auxHash_01.put("3Resultados", "O resultado é a divisão: cintura/quadril do avaliado.");

        ListaTestes.put("1", auxHash_01);


        HashMap<String, String> auxHash_02 = new HashMap<String, String>();

        auxHash_02.put("1Teste de Caminhada de 6 minutos", "Teste aeróbico de caminhada");
        auxHash_02.put("2Instrumentos","cronômetro, cones, fita métrica, palitos de picolé, giz, fita crepe (ou outro tipo de marcador) " +
                "e cadeiras.");
        auxHash_02.put("3Procedimentos", "O teste propõe ao avaliado caminhar a maior distância possível em 6 minutos, em um percurso de " +
                "45,72m. Os cones são distribuídos no formato de um retângulo, um cone em cada aresta.");
        auxHash_02.put("4Cuidados", "A área do teste pode ser em espaço fício aberto ou fechado; porém, em uma superfície não derrapante");
        auxHash_02.put("5Cadeiras de Segunrança", "Podem ser colocadas cadeiras de segunrança ao longo do percurço, para que o avaliado" +
                "possa descansar, caso necessite, e logo após um pequeno descanso, continuar o teste.");
        auxHash_02.put("6Observações", "O teste pode ser interrompido a qualquer momento pelo avaliado, caso sinta tontura, dor, nausea etc." +
                "\n em caso de se avaliar grandes grupos, aconselha-se o tempo de 10 segundos entre a partida de cada indivíduo. O percurso tem" +
                "uma distância total de 45,72m, dividida em 10 segundos de 4,57m.");
        auxHash_02.put("7Resultado", "O campo resultados deve ser preenchido com os metros percorridos do avaliado");

        ListaTestes.put("2", auxHash_02);


        HashMap<String, String> auxHash_03 = new HashMap<String, String>();

        auxHash_03.put("1Teste da marcha estacionária de 2 minutos", "Marcha com o levantamento do juelho a uma marca indicada");
        auxHash_03.put("2Procedimento", "A altura adequado do juelho para realizar a marcha é o nível do ponto médio entre a patela e" +
                        "a crista ilíaca. A atividade inicia-se com o joelho direito; conta-se somente o núemro de vezes em que o juelho" +
                "direito encosta na fita.");
        auxHash_03.put("3Precauções", "O avaliador permanece ao lado do avaliado para, em caso de desequilíbrio segurá-lo");
        auxHash_03.put("4Resultados", "O campo resultados deve ser preechido com o número de steps do avaliado");

        ListaTestes.put("3", auxHash_03);


        HashMap<String, String> auxHash_04 = new HashMap<String, String>();

        auxHash_04.put("1Teste de levantar caminhar e setar", "Este teste tem por objetivo avlaiar a mobilidade físicak: velocidade, " +
                "agilidade e equilíbrio dinâmico.");
        auxHash_04.put("2Instrumentos","nes, cronômetro, fita métrica, cone (ou outro marcador) e cadeira com encosto e uma altura de " +
                "aproximadamente 43 cm até o acento." +
                "e cadeiras.");
        auxHash_04.put("3Organização dos Instrumentos", "A cadeira deve ser posicionada contra a parede ou de forma que garanta a posição" +
                "estática durante o teste. A cadeira deve também estar numa zona desobstruída. Em frente, coloca-se um cone (ou outro marcador)" +
                " à distância de 2.44m (medição desde a ponta da cadeira até a parte anterior do cone). Deverá haver pelo menos 1,22m de " +
                "distância livre à volta do cone, permitindo ao participante contornar livremente o cone");
        auxHash_04.put("4Procedimento", "O avaliado começa em uma posição sentada na cadeira, com uma postura ereta, mão nas coxas e pés no chão, " +
                "um deles levemente na frente do outro. O avaliador deve servir como um marcadro, ficando no meio do caminho entre a cadeira e o cone" +
                ", pronto para auxiliar o avaliado em caso de perda de equilíbrio. Ao sinal indicativo, o avaliado levanta-se da cadeira (ele pode" +
                "dar um impulso nas coxas ou na cadeira), caminha o mais rapido possível em volta do cone retorna para a cadeira e senta-se. Para" +
                " uma marcação confiável, o avaliador deve acionar o cronômetro no movimento do sinal, quer o avaliado tenha ou não começado a se mover, " +
                "e parar o cronômetro no instante exato em que ele se sentar na cadeira\n" +
                "Após a demonstração, o avaliado deve ensaiar o teste uma vez para praticar e então, realizar duas tentativas. Deve-se lembrá-lo que o" +
                "cronômetro não será parado até que ele esteja completamente sentado na cadeira");
        auxHash_04.put("5Como Classificar", "O resultado corresponde ao tempo decorrido entre o sinal de \"partida\" até o momento em que o " +
                "participante está sentado na cadeira. Registram-se dois escores do teste para o décimo de segundo mais próximo. O melhor escore" +
                " (menor tempo) será o escore utilizado para avaliar o desempenho.");
        auxHash_04.put("6Observações", "Lembrando ao avaliado que este é um teste de tempo e que o objetivo é caminhar o mais rapidamente possível " +
                "(sem correr) em volta do cone e voltar para a cadeira");
        auxHash_04.put("7Resultados", "O campo resultados deve ser preenchido com o melhor escore/melhor tempo");

        ListaTestes.put("4", auxHash_04);


        HashMap<String, String> auxHash_05 = new HashMap<String, String>();

        auxHash_05.put("1Flexão de cotovelo", "Mensura indiretamente a força dos membros superiores quando não se tem à disposição" +
                " um dinamômetro manual.");
        auxHash_05.put("2Procedimentos", "O teste é realizado com a mão dominante do avaliado, registrando-se as repetições corretas realizadas" +
                "em 30 segundos");
        auxHash_05.put("3Peso dos hater", "4kg (homens); 2kg (mulheres).");
        auxHash_05.put("4Precauções", "O avaliador deve estar de joelhos ao lado do braço dominante do avaliado, colocando os dedos no meio da " +
                "região bicipital deste, evitando que seu braço se mova e assegurando o movimento completo.");
        auxHash_05.put("5Resultados", "O campo resultados deve ser preenchido com o número de repetições realizadas em 30 segundo.");

        ListaTestes.put("5", auxHash_05);

        HashMap<String, String> auxHash_06 = new HashMap<String, String>();

        auxHash_06.put("1Teste de sentar da cadeira em 30 segundos", "Mensura a força dos membros inferiores.");
        auxHash_06.put("2Procedimentos", "O teste começa com o avaliado sentado, os braços cruzados contra o tórax. Ao sinal, ele deve levantar-se. São " +
                "contadas as repetições corretas em um tempo de 30 sgundos.");
        auxHash_06.put("3Precauções", "O avaliado deve realizar de uma a três vezes o movimento antes do início do teste, para familiarização. Por " +
                "segurança, deve-se utilizar cadeira com encosto e apoiada na parece.");
        auxHash_06.put("4Resultados", "O campo resultados deve ser preenchido com o número de repetições realizadas em 30 segundo.");

        ListaTestes.put("6", auxHash_06);

        HashMap<String, String> auxHash_07 = new HashMap<String, String>();

        auxHash_07.put("1Teste de sentar e alcançar", "Mensura a flexibilidade dos membros inferiores.");
        auxHash_07.put("2Instrumentos", "Cadeira com encosto e sem braços a uma altura de, aproximadamente, 43cm até o assento e uma régua de " +
                "45cm");
        auxHash_07.put("3Organização dos instrumentos", "Pora razões de segurança, deve-se colocar a cadeira contra uma parede, de forma que se mantenha est´vel " +
                "(não deslize para a frente) quando o avaliado se sentar na respectiva extremidade.");
        auxHash_07.put("4Procedimentos", "O ponto aproximado entre a linha inguinal e os glúteos deve estar paralelo ao assento da cadeira. O avaliado" +
                " deve manter um joelho flexionado e o pé no chão. Com os joelhosparalelos, voltados para a frente, o participante estende a outra perna (" +
                "a perna preferida_ à frente do quadril, com o calcanhar no cão e dorsiflexão plantar a aproximadamente 90°. O avaliador deve ficar próximo ao " +
                "avaliado. Com a perna estendida (porém, não hiperestendida), o avaliado inclina-se lentamente para a frente, mantendo a coluna o mais ereta" +
                " possível e a cabeça alinhada com a coluna. O avaliado tenta tocar os dedos dos pés escorregandoas mãos, uma em cima da outra, com as pontas dos dedos médios, na " +
                "perna estendida.\nA posição deve ser mantida por dois egundos. Se o joelho estendido começar a flexionar, pedir ao avaliado para sentar de volta, " +
                "lentamente, até que o joelho esteja estendido. Deve-se lembrar ao avaliado de expirar à medida que se inclina para frente, evitando saltos e movimentos " +
                "forçados rápidos e nunca alongando a ponto de sentir dor. Seguindoa demonstração, peça ao avaliado que determine qual é a sua perna preferida - " +
                "a que produz melhor escore. Dê-lhe então duas tentativas (alongamento) nessa perna, seguidas por duas provas de teste.");
        auxHash_07.put("5Resultados", "Usando uma regua de 45cm, o valiador registra a distância (cm) até os dedos dos pés (resultado mínimo) ou " +
                "distância (cm) que se consegue alcançar para além dos dedos dos pés (resultado máximo). O meio dos dedo grande do pé na estremidade do sapato" +
                " representa o ponto zero. Registrar ambos os valores encontrados, com a aproximação de 1cm, e fazer um círculo sobre o melhor resultado, " +
                "utilizado para avaliar o desempenho.");

        ListaTestes.put("7", auxHash_07);

        HashMap<String, String> auxHash_08 = new HashMap<String, String>();
        //verificar se o resultado desta pode ser diferente (pode ter que mudar a tela)
        auxHash_08.put("1Teste de alcançar atrás das Costas", "Mensura a flexibilidade dos membros superiores.");
        auxHash_08.put("2Instrumentos", "régua de 45,7cm");
        auxHash_08.put("3Procedimentos", "Em pé, o avaqliado coloca a mão preferida sobre o mesmo ombro, a palma aberta e os dedos estendidos, alcançando " +
                "o meio das costas tanto quanto possível (cúbito apontado para cima). A mão do outro braço esta colocada atrás das costas, a palma para cima" +
                ", alcançando para cima o mais distante possível, na tentariva de tocar ou sobrepor os dedos médios estendidos de ambas as mãos. Sem mover as mão do " +
                "avaliado, o avaliador ajuda a verificar se os dedos médios de cada mão estão direcionado um ao outro. Não é permitido ao avaliado agarrar seus dedos" +
                "unidos e puxar. Seguindo a demonstração, o avaliado determina a mão preferida e são feitas duas tentativas de aprendizagem, seguidas pelo teste (duas" +
                "tentativas).");
        auxHash_08.put("4Resultados", "A distância da sobreposição ou a distância entre as ponstas dos dedos médios é a medida ao centímetro mais próximo. " +
                "Os resultados negativos (-) representam a distância mais curta entre os dedos médios; os resultados positivos (+) representam a medida da sobreposição dos" +
                "dedos médios. Registram-se as duas medidas. O \"melhor\" valor é usado para medir o desempenho. Os sinais (-) e (+) devem ser marcados na ficha de pontuação");

        ListaTestes.put("8", auxHash_08);
    }

    public List<ItemCard> getCards(){
        List<ItemCard> listAux = new ArrayList<>();
        int index;

        //esse for é nessesário porque o hash guarda os componentes desordenadamente
        //talvez seja melhor criar uma classe teste com as informações de cada tela de teste.
        //para cada tela haveria uma instancia da classe.
        for(int i = 1; i <= ListaTestes.get(ID_tela).size(); i ++) {
            String aux_03 = Integer.toString(i);
            Iterator in = ListaTestes.get(ID_tela).keySet().iterator();

            while (in.hasNext()){
                String aux = (String) in.next();
                String auxString = aux.substring(0, 1);

                //Log.i("ERROS_TESTES", aux + " __ " + auxString + " __ " + aux_02);

                if(auxString.equals(aux_03)) {
                    String aux_02 = aux.substring(1);
                    ItemCard itemCard_Aux = new ItemCard(aux_02, ListaTestes.get(ID_tela).get(aux));
                    listAux.add(itemCard_Aux);
                }
            }

        }

        return listAux;
    }

    public void onClick_proximoTeste(View view){
        Intent intent;
        String type = new String();
        String id_str = new String();

        String[] aux = edit_Resultado.getText().toString().split(",");
        String aux2;
        if(aux.length > 1) {
            aux2 = aux[0]+"."+aux[1];
        }else{
            aux2 = edit_Resultado.getText().toString();
        }

        if(ID_tela.equals("8")) {
            avaliacao.setTeste_08(Float.parseFloat(aux2));
            banco.atualizarAvaliacao(avaliacao);

            CalcularResultados r = new CalcularResultados(this, avaliacao);

            Usuario usuario = banco.consultarUsuarioByID(avaliacao.getID_Avaliador());
            intent = new Intent( view.getContext(), FimTeste_activity.class);
            intent.putExtra(Iniciar_appHealth.EXTRA_MESSAGE_USUARIOID, new String[]{""+usuario.getID()
                    , usuario.getNome(), usuario.getSenha()});
            startActivity(intent);
        }
        else{
            intent = new Intent( view.getContext(), tela_Testes.class);
            if (ID_tela.equals("1") || ID_tela.equals("2") || ID_tela.equals("3")) {
                if(ID_tela.equals("1")) avaliacao.setTeste_01(Float.parseFloat(aux2));
                if(ID_tela.equals("2")) avaliacao.setTeste_02(Float.parseFloat(aux2));
                if(ID_tela.equals("3")) avaliacao.setTeste_03(Float.parseFloat(aux2));

                int id_int = Integer.parseInt(ID_tela) + 1;
                id_str = Integer.toString(id_int);
                type = "Testes metabólicos";
                subTitulo_tela = "Testes aeróbicos";
            }
            if (ID_tela.equals("4")) {
                avaliacao.setTeste_04(Float.parseFloat(aux2));

                int id_int = Integer.parseInt(ID_tela) + 1;
                id_str = Integer.toString(id_int);
                type = "Testes neuromotores";
                subTitulo_tela = "Força muscalar dos membros superiores";
            }
            if (ID_tela.equals("5")) {
                avaliacao.setTeste_05(Float.parseFloat(aux2));

                int id_int = Integer.parseInt(ID_tela) + 1;
                id_str = Integer.toString(id_int);
                type = "Testes neuromotores";
                subTitulo_tela = "Força muscalar dos membros inferiores";
            }
            if (ID_tela.equals("6")) {
                avaliacao.setTeste_06(Float.parseFloat(aux2));

                int id_int = Integer.parseInt(ID_tela) + 1;
                id_str = Integer.toString(id_int);
                type = "Testes neuromotores";
                subTitulo_tela = "Flexibilidade dos membros inferiores";
            }
            if (ID_tela.equals("7")) {
                avaliacao.setTeste_07(Float.parseFloat(aux2));

                int id_int = Integer.parseInt(ID_tela) + 1;
                id_str = Integer.toString(id_int);
                type = "Testes neuromotores";
                subTitulo_tela = "Flexibilidade dos membros superiores";
            }

            banco.atualizarAvaliacao(avaliacao);

            String[] arrayAux = new String[]{id_str, type, subTitulo_tela};

            intent.putExtra(tela_NovaAvaliacao.EXTRA_MESSAGE, arrayAux);
            intent.putExtra(tela_NovaAvaliacao.EXTRA_MESSAGE_AVALIACAOID, new String[]{""+avaliacao.getID()});

            startActivity(intent);
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //      .setAction("Action", null).show();

        }
    }
}
