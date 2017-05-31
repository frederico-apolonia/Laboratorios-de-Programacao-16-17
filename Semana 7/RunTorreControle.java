
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Profs de LabP
 * 
 * NAO PODE ALTERAR ESTA CLASSE
 *
 */
public class RunTorreControle {

    public static final int ARGUMENTO0 = 0;
    public static final int ARGUMENTO1 = 1;
    public static final int ARGUMENTO2 = 2;

    public static final int NUMERO_INICIAL_DE_CONTROLADORES = 4;

    public static void main(String[] args) throws IOException {

        try( FileReader inicial = new FileReader(args[ARGUMENTO0]); 
                FileWriter escrita =  new FileWriter(args[ARGUMENTO1]);
                FileReader evolucao = new FileReader(args[ARGUMENTO2]) ){

            BufferedReader in = new BufferedReader(inicial);
            BufferedWriter out = new BufferedWriter(escrita);
            BufferedReader decurso = new BufferedReader(evolucao);

            // Criacao de uma distribuicao de servico inicial
            DistServico boaViagem = new DistServico(NUMERO_INICIAL_DE_CONTROLADORES);
            boaViagem.leDistribui(in);

            // guarda o que vai ser escrito no ficheiro de output
            StringBuffer aEscrever = new StringBuffer();
            // eh o inicio do servico
            boolean inicio = true;

            //o servico decorre de acordo com o Buffer decurso
            String lido;
            while((lido=decurso.readLine())!=null){
                String[] operacao = lido.split("-");
                switch (operacao[0]) {
                    case "Solicitacao Resolvida":
                        boaViagem.out(Integer.parseInt(operacao[1]));;
                        break;
                    case "Nova Solicitacao":
                        String[] pedido = operacao[1].split(" ");
                        boaViagem.request(Integer.parseInt(pedido[0]), Integer.parseInt(pedido[1]) );
                        break;
                    case "Mais Antiga":
                        aEscrever.append("O pedido mais antigo ainda nao servido eh:" 
                                + boaViagem.oldest() + "\n");
                        break;
                    case "Report": 
                        if(inicio){
                            primeiroRegisto(aEscrever, boaViagem, operacao[1]);
                            inicio = false;
                        }
                        else{
                            proximosRegistos(aEscrever, boaViagem, operacao[1]);
                        }
                        break;
                    default:
                        System.out.println("Comando desconhecido");
                        break;
                }

            }

            out.write(aEscrever.toString());    
            out.close();
        }
    }


    //escrita do 1o registo
    /**
     * escrita do primeiro registo
     * @param aEscrever - StringBuffered onde se vai escrever
     * @param boaViagem - a distribuicao de servica
     * @param f - string com a indicacao dos minutos
     * @requires f, aEscrever, boaViagem != null
     */
    private static void primeiroRegisto(StringBuffer aEscrever, DistServico boaViagem, String f) {
        aEscrever.append("Total de solicitacoes iniciais: " + boaViagem.total()
        + "\n");
        aEscrever.append("Distribuicao de solicitacoes iniciais:\n");
        aEscrever.append(boaViagem.toString() + "\n");
        aEscrever.append("O(s) Controlador(es) com tempo de servico superior a " + f +" minutos eh/sao:\n");
        aEscrever.append(maisAtarefados(boaViagem,Integer.parseInt(f)));
        aEscrever.append("\n");
        aEscrever.append("Para agora o tempo minimo de espera para finalizar uma nova " + "solicitacao eh: ");
        aEscrever.append(boaViagem.tempoMinimoEspera());
        aEscrever.append("\n\n");

    }

    /**
     * escrita dos registos que nao o primeiro
     * @param aEscrever - StringBuffered onde se vai escrever
     * @param boaViagem - a distribuicao de servica
     * @param f - string com a indicacao dos minutos
     * @requires f, aEscrever, boaViagem != null
     */
    private static void proximosRegistos(StringBuffer aEscrever, DistServico boaViagem, String d) {
        aEscrever.append("Depois de algum tempo de servico a situacao " + "na torre de controle eh:\n");
        aEscrever.append("Total de solicitaoes ainda ativas: " + boaViagem.total() + "\n");
        aEscrever.append(boaViagem.toString()+"\n");
        aEscrever.append("Os controladores com tempo de espera superior a " + d + " eh/sao:\n");
        aEscrever.append(maisAtarefados(boaViagem,Integer.parseInt(d))+"\n");
        aEscrever.append("Tempo minimo de espera para um nova solicitacao" + " ser resolvida: ");
        aEscrever.append(boaViagem.tempoMinimoEspera());
        aEscrever.append("\n\n");
    }

    //representacao em string dos controladores com mais servico
    private static String maisAtarefados(DistServico servico, int i){
        StringBuilder result = new StringBuilder();
        Queue<String> listagem = new Queue<String>();
        listagem = servico.tempoSuperior(i);
        int k = listagem.size(); 
        for(int j=0; j<k; j++ ){
            String controlador = listagem.front();
            listagem.dequeue();
            result.append("Controlador Aereo " + controlador + "\n");
        }
        return result.toString();
    }

}