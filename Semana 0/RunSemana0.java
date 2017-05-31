
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Exemplo de como ler um ficheiro de inteiros (um por linha),
 * processar o seu conteudo, e escrever o resultado noutro ficheiro.
 *
 * @author Adaptado de Isabel Nunes 
 *
 */
public class RunSemana0 {

	/**
	 * Abre um ficheiro para leitura e outro para escrita. Le do primeiro, aplica uns metodos,
	 * e escreve o resultado no segundo ficheiro.
	 */

	public static void main(String[] args) throws IOException {

		// canal de leitura
		Scanner in = new Scanner (new FileReader("numeros.txt"));
		// canal de escrita
		PrintStream out = new PrintStream ("dobros.txt");

		//escreve para o ficheiro dobro.txt o dobro de cada numero em numeros.txt
		ExemploFicheiros.calculaDobro (in, out);

		//Agora os pares!
		//escreve para o ficheiro dobro.txt apenas os que são pares de numeros.txt
		in = new Scanner (new FileReader ("numeros.txt"));
		out = new PrintStream ("pares.txt");
		ExemploFicheiros.guardaPares(in, out);

		//Agora ficheiros com texto.
		in = new Scanner (new FileReader ("texto.txt"));
		out = new PrintStream ("copia.txt");
		ExemploFicheiros.copiaTexto (in, out);

		//Transformar tudo em minusculas
		in = new Scanner (new FileReader ("texto.txt"));
		out = new PrintStream ("minusculas.txt");
		ExemploFicheiros.tudoMinusculas (in, out);


		//Um pouco mais trabalhoso
		//Metodo que guarda quantas vezes aparecem cada potencia de 10 entre 1 e 10^n, isto eh,
		//quantas vezes aparece o 1, 10, 100, ..., 10^n, um por linha
		in = new Scanner (new FileReader ("numeros.txt"));
		out = new PrintStream ("potencias.txt");
		ExemploFicheiros.potenciasDe10(in, out, 5);


		in.close();        // contrariamente ao System.in e System.out, 
		out.close();      // estes canais tem de ser fechados

	}

}