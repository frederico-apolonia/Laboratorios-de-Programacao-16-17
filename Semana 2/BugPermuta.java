import java.util.Random;
import java.util.Scanner;

/**
 * Pede um vector ao utilizador e imprime uma permutacao aleatoria do mesmo 
 * @author Frederico Apolonia - 47892
 */
public class BugPermuta {

	public static void main(String[] args) {
		// Pede ao utilizador os numeros
		Scanner sc = new Scanner(System.in);
		System.out.println("Escreva uma sequencia de numeros separados por espacos:");
		String lido = sc.nextLine();
		sc.close();

		// Cria um vector com os numeros
		/*
		 * Estava um espaco em falta no lido.split(" ");
		 * ANTES: lido.split("");
		 */
		String[] numeros = lido.split(" "); 	
		int[] nums = new int[numeros.length];
		for(int i = 0 ; i < numeros.length ; i++) {
			nums[i] = Integer.parseInt(numeros[i]);
		}

		// Faz a permuta
		permutar(nums);

		// Imprime o resultado
		/*
		 * Estava em falta o incremento do ciclo for,
		 * o que o estava a tornar infinito
		 */
		for(int i = 0 ; i < nums.length ; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Faz permutacoes aleatorias num vector
	 * @param vector O vector que vai ser permutado
	 */
	public static void permutar(int[] vector) {
		Random rnd = new Random();
		/*
		 * O inicio do for estava a ir buscar um valor que ultrapassava
		 * o limite do array.
		 */
		for (int i = vector.length - 1 ; i >= 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Troca o indice index com o indice i
			/*
			 * Antes nao estava a trocar os valores, agora guarda e troca
			 * os valores dos indices pretendidos
			 */
			int a = vector[i];
			vector[i] = vector[index];
			vector[index] = a;
		}
	}

}
