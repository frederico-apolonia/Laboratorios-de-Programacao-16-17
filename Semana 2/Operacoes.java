/**
 * Classe Operacoes
 * @author Frederico Apolonia - 47892
 *
 */
public class Operacoes {

	/**
	 * Verifica o numero de valores maiores que n
	 * @param inteiros - valores a verificar
	 * @param n - numero do qual se quer o numero de numeros maiores
	 * @return numero de todos os inteiros maiores que n no array inteiros
	 */
	int totalMaiores (int[] inteiros, int n){

		int result = 0;

		for (int i = 0; i < inteiros.length; i++) {
			if(inteiros[i] > n)
				result++;
		}

		return result;
	}

	/**
	 * Calcula a soma dos valores maiores que n no array dado
	 * @param inteiros - array com os valores a serem calculados
	 * @param n - numero do qual se quer o numero de numeros maiores
	 * @return - soma dos inteiros maiores que n do array
	 */
	int soma (int[] inteiros, int n){
		int result = 0;

		for (int i = 0; i < inteiros.length; i++) {
			if(inteiros[i] > n)
				result += inteiros[i];
		}

		return result;
	}

	/**
	 * Media dos inteiros maiores que n do array inteiros
	 * @param inteiros - array a ser verificado
	 * @param n - numero do qual se quer o numero de numeros maiores
	 * @return - media dos inteiros maiores que n
	 */
	double media (int[] inteiros, int n){

		/*
		 * Exercicio 4 c) - Apanhar a excepcao AritmeticException e trata-la
		 */
		try{

			int numMaiores = totalMaiores(inteiros, n);
			int somaMaiores = soma(inteiros, n);

			return somaMaiores / numMaiores;

		} catch (ArithmeticException e) {
			System.err.println("Ocorreu um erro no calculo da media\n"
					+ "Exemplo: dividir por 0");
			return 0;
		}
	}
}
