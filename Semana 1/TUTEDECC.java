import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author Frederico Apolonia - nº 47892
 * @date 24/02/2017
 */

public class TUTEDECC {

	private static int MIN_ASCII = (char) 'a';
	private static int MAX_ASCII = (char) 'z';
	private static String PONTUACAO = "[!,;:.?() ]";

	/**
	 * Retira, de um ficheiro, letras passadas atraves de outro ficheiro 
	 * @param in - ficheiro em que se vao retirar letras
	 * @param letras - letras a retirar
	 * @param out - ficheiro onde vao ser escritas as alteracoes
	 * @throws IOException
	 * @requires in =! null, letras != null
	 */
	public static void retiraLetras(BufferedReader in, BufferedReader letras,
			BufferedWriter out) throws IOException {

		/*
		 * Recebe um conjunto de letras, coloca-as numa string e depois
		 * acrescenta as letras maiusculas, de forma a que estas sejam
		 * retiradas tambem
		 */
		String regex = letras.readLine();
		regex = regex.concat(regex.toUpperCase());

		String line = in.readLine();

		/*
		 * Percorre o input, linha a linha ate nao existirem mais, e retira
		 * as letras a retirar.
		 */
		while(line != null){
			line = unsplit(line.split("[" + regex + "]"));

			out.write(line + "\n");

			line = in.readLine();
		}

	}

	/**
	 * Dado um ficheiro com texto, substitui os 'e' por 3, 's' por 5, 't' por 7 e 'o'
	 * por 0.
	 * @param in - ficheiro de input
	 * @param out - ficheiro de output
	 * @throws IOException
	 * 
	 * @requires in != null (com texto)
	 */
	public static void letrasPorNumeros(BufferedReader in, BufferedWriter out)
			throws IOException {

		String line = in.readLine();
		StringBuilder sb;

		/*
		 * Enquanto o ficheiro contiver linhas, le-se as linhas uma a uma,
		 * retira-se a pontuacao e verifica-se se os caracteres sao para ser
		 * substituidos ou nao. No final do ciclo, escreve-se a linha para o 
		 * ficheiro e vai-se buscar a proxima.
		 */
		while(line != null){

			line = unsplit(line.split(PONTUACAO));

			sb = new StringBuilder(line);

			for(int i = 0; i < sb.length(); i++){
				if(sb.charAt(i) == 'e' || sb.charAt(i) == 'E')
					sb.setCharAt(i, '3');
				else if (sb.charAt(i) == 's' || sb.charAt(i) == 'S')
					sb.setCharAt(i, '5');
				else if (sb.charAt(i) == 't' || sb.charAt(i) == 'T')
					sb.setCharAt(i, '7');
				else if (sb.charAt(i) == 'o' || sb.charAt(i) == 'O')
					sb.setCharAt(i, '0');
			}

			out.write(sb.toString() + "\n");
			line = in.readLine();
		}

	}

	/**
	 * Dado um ficheiro de input e um numero n, esta funcao avancara (de acordo
	 * com o alfabeto) n casas para a frente todas as letras.
	 * @param in  - ficheiro com o texto original
	 * @param out - ficheiro de escrita das alteracoes
	 * @param n   - numero de letras a avancar
	 * @throws IOException
	 * 
	 * @requires n > 0, in != null (com texto)
	 */
	public static void rotacao(BufferedReader in, BufferedWriter out, int n) 
			throws IOException {

		String line = in.readLine();
		StringBuilder sb;
		int posF;

		/*
		 * Enquanto o ficheiro tiver linhas, vai ler uma a uma. Apos ler 
		 * uma linha, retira-se a pontuacao e coloca-se o texto todo em
		 * letras minusculas.
		 * A linha e verificada letra a letra e nessa altura avanca-se as
		 * n casas.
		 */
		while(line != null){
			line = unsplit(line.split(PONTUACAO)).toLowerCase();

			sb = new StringBuilder(line);

			for (int i = 0; i < sb.length(); i++){
				posF = (int) sb.charAt(i) + n;
				//caso posF (codigo ASCII final do caracter a ser introduzido
				//seja maior que o codigo ASCII de 'z', e necessario ajusta-lo
				//para ficar entre 'a' e 'z'
				if(posF > MAX_ASCII){
					posF = posF - MAX_ASCII + MIN_ASCII - 1;
					sb.setCharAt(i, (char) posF);
				}
				else
					sb.setCharAt(i, (char) posF);
			}

			out.write(sb.toString() + "\n");

			line = in.readLine();
		}

	}

	/**
	 * Dada uma string, conta o numero de vezes que aparece cada letra do
	 * alfabeto
	 * @param in - ficheiro com as letras a serem contadas
	 * @param out - ficheiro onde vai ser escrito o resultado
	 * @throws IOException
	 * @requires in != null
	 */
	public static void frequenciasLetras(BufferedReader in, BufferedWriter out)
			throws IOException {

		String line = in.readLine();
		StringBuilder sb;
		/*
		 * Array com o tamanho do alfabeto
		 * a -> 0, b -> 1, ...
		 */
		int [] a2z = new int [MAX_ASCII - MIN_ASCII + 1];

		/*
		 * Apos ler uma linha do ficheiro, vai percorre-la o numero de vezes do alfabeto
		 * e comparar se cada caracter corresponde a letra que se esta a verificar
		 */ 
		while(line != null){

			sb = new StringBuilder(line.toLowerCase());

			for(int i = 0; i < a2z.length; i++){
				for(int j = 0; j < sb.length(); j++){
					if(sb.charAt(j) == getChar(MIN_ASCII + i))
						a2z[i]++;
				}
			}
			
			line = in.readLine();
		}

		for(int i = 0; i < a2z.length; i++){
			out.write(getChar(MIN_ASCII + i) + " " + a2z[i] + "\n");
		}

	}

	/**
	 * Conta o numero de diversos padroes existentes (ou nao) num ficheiro
	 * @param in      - ficheiro de input a verificar
	 * @param padroes - ficheiro que contem os padroes
	 * @param out     - ficheiro onde vai ser escrito o resultado
	 * @throws IOException
	 * 
	 * @requires in 
	 */
	public static void frequenciasPadrao(BufferedReader in, 
			BufferedReader padroes, BufferedWriter out) throws IOException {
		
		String [] pattern = padroes.readLine().split(" ");
		int [] countPattern = new int [pattern.length];
		
		String line = in.readLine();
		
		/*
		 * Percorre linha a linha e aplica o split de acordo com o padrao a verificar.
		 * O que acontece para contar o numero de padroes existentes eh:
		 * Imaginando que temos a string "olaabctudoabcbem?" e queremos saber quantos
		 * "abc" existem.
		 * Ao aplicar o split(string, -1) obtemos o seguinte output:
		 * ["ola","tudo","bem"] e, como se pode verificar, o numero de virgulas
		 * corresponde ao numero de abc existente. logo, os padroes correspondem ao
		 * length do split menos uma unidade.
		 */
		while(line != null){
			
			line = line.toLowerCase();
			
			for(int i = 0; i < pattern.length; i++){
				countPattern[i] += line.split(pattern[i], -1).length - 1;
			}
			
			
			line = in.readLine();
		}
		
		for(int i = 0; i < pattern.length; i++){
			out.write(pattern[i] + " " + countPattern[i] + "\n");
		}

	}

	/**
	 * Recebe uma string que foi splitted e coloca-a numa so
	 * @param splited - String a ser juntada
	 * @return ["a","b","c"] -> "abc"
	 * @requires splitted != null
	 */
	private static String unsplit(String[] splited){
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < splited.length; i++)
			sb.append(splited[i]);

		return sb.toString();
	}

	/**
	 * Recebe um inteiro e converte-o num caracter
	 * @param x - inteiro a converter em caracter
	 * @return - caracter correspondente ao inteiro
	 * @requires x > 0
	 */
	private static char getChar(int x){
		return (char) x;
	}

}
