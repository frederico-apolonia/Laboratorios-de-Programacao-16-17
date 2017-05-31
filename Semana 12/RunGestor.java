import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RunGestor {

    private static final String SEPARADOR = "-";
    private static Gestor gestor;

    public static void main(String[] args) throws FileNotFoundException {
        String input = args[0];
        int nSecretarias = Integer.valueOf(args[1]);
        int categorias = Integer.valueOf(args[2]);
        int estrategiaAtribuicao = Integer.valueOf(args[3]);

        gestor = new Gestor(categorias, nSecretarias, estrategiaAtribuicao);

        Scanner scanner = new Scanner(new FileReader(input));
        while (scanner.hasNextLine()) {
            String comando = scanner.nextLine();
            /* o ficheiro de entrada contem linhas de comentario e linhas com comandos; 
			   as linhas de comentario começam por "-" 
             */
            if (!comando.startsWith("-"))
                gerir(comando);
        }
        scanner.close();
    }

    private static void gerir(String comando) {
        String[] itens = comando.split(SEPARADOR);
        switch (itens[0]) {
            case "total":
                calcularTotal(itens);
                break;
            case "registar":
                concretizarRegisto(itens[1], Integer.valueOf(itens[2]));
                break;
            case "atribuir":  
                concretizarAtribuicao(itens[1]);
                break;
            case "obterDono":
                obterDono(Integer.parseInt(itens[1]));
                break;
            case "obterNumero":
                obterNumero(itens[1]);
                break;
            case "removerPorNome":
                removerPorNome(itens[1]);
                break;
            case "removerPorNumero":
                removerPorNumero(Integer.valueOf(itens[1]));
                break;
            default:
                System.out.println("OPCAO INVALIDA: " + comando);
                break;
        }
    }

    // Calcula o total de secretarias atribuidas
    private static void calcularTotal(String[] campos) {
        if (campos.length == 1)
            System.out.println("TOTAL de secretarias atribuidas: " + gestor.totalAtribuidos());
        else {
            int categoria = Integer.valueOf(campos[1]);
            System.out.println("TOTAL de secretarias atribuidas na " + categoria + "º categoria : " + gestor.atribuidosNaCategoria(categoria));
        }
    }

    // Tenta registar um novo colaborador
    private static void concretizarRegisto(String nome, int categoria) {
        if (gestor.registar(nome, categoria))
            System.out.println("REGISTO do colaborador " + nome + " com categoria " + categoria);
        else 
            System.out.println("ERRO: Nao foi possivel registar o colaborador " + nome);
    }

    // Tenta atribuir uma secretária ao colaborador com o nome dado
    private static void concretizarAtribuicao(String nome) {
        if (gestor.atribuir(nome))
            System.out.println("ATRIBUICAO de secretaria a " + nome);
        else
            System.out.println("ERRO: Nao foi possivel atribuir secretaria a " + nome);
    }

    // Tenta determinar o dono da secretária com o numero dado
    private static void obterDono(int numero) {
        Colaborador colaborador = gestor.obterDono(numero);
        if (colaborador != null)
            System.out.println("O DONO da secretaria no." + numero + " e' " + colaborador.obterNome());
        else 
            System.out.println("SECRETARIA no." + numero + " SEM DONO atribuido");

    }

    // Tenta determinar o numero da secretária atribuida ao colaborador com o nome dado
    private static void obterNumero(String nome) {
        int numero = gestor.obterNumero(nome);
        if (numero > 0)
            System.out.println("O COLABORADOR " + nome + " tem SECRETARIA no. " + numero);
        else
            System.out.println("NAO EXISTE SECRETARIA atribuida a " + nome);
    }

    // Tenta remover uma atribução dado o nome do colaborador
    private static void removerPorNome(String nome) {
        Secretaria secretaria = gestor.removerAtribuicaoPorNome(nome);
        if (secretaria != null){
            System.out.println("REMOCAO (nome) secretaria " + secretaria.obterNumero() + 
                    ", categoria " + secretaria.obterCategoria() + ", de " + nome);
        }else{
            System.out.println("Pessoa " + nome + " nao tem cadeira atribuida");
        }
    }

    // Tenta remover uma atribução dado o numero de uma secretaria
    private static void removerPorNumero(int numero) {
        Secretaria secretaria = gestor.removerAtribuicaoPorNumero(numero);
        if (secretaria != null)
            System.out.println("REMOCAO (no.) secretaria " + secretaria.obterNumero() + 
                    ", categoria " + secretaria.obterCategoria());
        else
            System.out.println("Secretaria " + numero + " nao esta' atribuida");
    }

}
