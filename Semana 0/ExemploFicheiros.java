import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Frederico Apolonia, nº 47892
 *
 */
public class ExemploFicheiros {

	/**
	 * Calcula o dobro de n valores inteiros dentro de um ficheiro
	 * @param in  - scanner para leitura de ficheiros
	 * @param out - PrintStream para imprimir o output do calculo
	 */
	public static void calculaDobro(Scanner in, PrintStream out) {

		while (in.hasNextInt()) {
			int input = in.nextInt();
			out.append(2 * input + "\n");
		}

	}

	/**
	 * A partir de um dado ficheiro com numeros inteiros, imprime num ficheiro
	 * novo os numeros pares.
	 * @param in  - scanner com os numeros inteiros
	 * @param out - output file onde serao escritos os numeros pares
	 */
	public static void guardaPares(Scanner in, PrintStream out) {

		while (in.hasNextInt()) {
			int input = in.nextInt();
			if(input % 2 == 0)
				out.append(input + "\n");
		}

	}

	/**
	 * Recebe um ficheiro de texto e cria uma copia num ficheiro novo, 
	 * com o conteudo igual ao anterior.
	 * @param in  - Scanner com o ficheiro a ser copiado
	 * @param out - PrintStream que contem o ficheiro de output
	 */
	public static void copiaTexto(Scanner in, PrintStream out) {

		while (in.hasNextLine()) {
			out.append(in.nextLine() + "\n");
		}

	}

	/**
	 * Recebe um ficheiro de texto e cria uma copia, com o texto em minusculas,
	 * num ficheiro novo
	 * @param in  - Scanner com o ficheiro a ser lido
	 * @param out - PrintScream que contem o ficheiro de output
	 */
	public static void tudoMinusculas(Scanner in, PrintStream out) {

		while (in.hasNextLine()) {
			out.append(in.nextLine().toLowerCase() + "\n");
		}

	}

	/**
	 * Dado um ficheiro com inteiros, calcula o numero de cada potencia de 10
	 * existente no mesmo
	 * @param in  - Scanner com os inputs
	 * @param out - PrintStream que contem o ficheiro de output
	 * @param n   - Maior potencia de 10 a ser avaliada
	 */
	public static void potenciasDe10(Scanner in, PrintStream out, int n) {

		ArrayList <Integer> v = new ArrayList<>();

		// Ler numeros de um ficheiro e guardar num array
		while (in.hasNextInt()) {
			v.add(in.nextInt());
		}


		for(int i = 0; i <= n; i++){

			int count = 0;
			
			for(int j = 0; j < v.size(); j++){
				if(v.get(j) == potencia(i))
					count++;
			}

			out.append(count + "\n");

		}



	}
	
	/**
	 * Calcula, recursivamente, a potencia n de 10
	 * @param n - potencia a ser calculada
	 * @return potencia n de 10
	 */
	private static int potencia(int n){
		if(n == 0){
			return 1;
		}
		else
			return 10 * potencia(n - 1);
	}

}
