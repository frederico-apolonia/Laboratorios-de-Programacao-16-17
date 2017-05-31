import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class RunOperacoes {

	/**
	 * @param args
	 * @author Frederico Apolonia - 47892
	 */
	public static void main(String[] args) {

		/*
		 * Exercicio 3 - completar o metodo main de forma a apanhar
		 * e tratar todas as excepcoes lancadas
		 */
		try {
			/*
			 * Exercicio 6 - Adicionar try catch para o File not found
			 * exception
			 */
			Scanner sc = new Scanner(new BufferedReader(new FileReader(args[0])));

			int tamanho = lerTamanhoArray(sc);

			int[] inteiros  = lerArrayInteiros(sc,tamanho);

			Operacoes ops = new Operacoes();

			System.out.println("Valor da media dos valores do input maiores "
					+ "que 7 eh " + ops.media(inteiros, 7));

			sc.close();

		} catch (FileNotFoundException e) {
			System.err.println("O ficheiro " + args[0] + " nao existe.");

		} catch (NumberFormatException e) {
			System.err.println("O ficheiro deve conter apenas numeros "
					+ "inteiros");

		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}





	}


	public static int lerTamanhoArray(Scanner sc) throws Exception{
		int n = Integer.parseInt(sc.nextLine());

		/*
		 * Exercicio 1 - Lancar uma excepcao do tipo exception para quando o
		 * primeiro valor nao eh um inteiro positivo.
		 */
		if( n < 0 )
			throw new Exception ("Numero da primeira linha nao eh um inteiro "
					+ "positivo.");

		return n;
	}



	/*
	 * @requires tamanho > 0
	 */
	public static int[] lerArrayInteiros(Scanner sc, int tamanho) 
			throws Exception {
		String linha = sc.nextLine();
		String [] nrs = linha.split(" ");
		int[] inteiros = new int[tamanho];

		/*
		 * Exercicio 2 b) - Lancar uma excepcao quando o tamanho nao eh
		 * igual ao numero de inteiros da segunda linha
		 */
		if (nrs.length != tamanho)
			throw new Exception("A segunda linha nao tem o mesmo numero de "
					+ "inteiros que o valor da primeira linha");

		for (int i = 0; i < tamanho; i++){
			/*
			 * Exercicio 2 a) - Lancar uma excepcao quando o existe um valor
			 * inteiro nao positivo na segunda linha
			 */
			if(Integer.parseInt(nrs[i]) < 0)
				throw new NumberFormatException("O " + i + "o valor eh negativo."
						+ "\nTodos os inteiros tem de ser positivos");
			inteiros[i] = Integer.parseInt(nrs[i]);
		}

		return inteiros;
	}  

}