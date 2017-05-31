import java.io.BufferedReader;
import java.io.IOException;

/**
 * Classe sudoku com os metodos para verificar se o jogo esta certo
 * @author Frederico Apolonia - no 47892
 * @date 10 - 03 - 2017
 */
public class Sudoku {

	private static int[][] sudoku;

	/**
	 * Construtor da classe sudoku
	 * @param input - jogo a ser lido de um ficheiro
	 * @throws IOException
	 * 
	 * @requires input != null
	 */
	public Sudoku(BufferedReader input) throws IOException {
		sudoku = readInput(input);
	}

	/**
	 * Retorna o jogo de sudoku que esta a ser analisado
	 * @return jogo sudoku
	 */
	public int[][] getSudoku() {
		return sudoku;
	}

	/**
	 * Este metodo verifica se o jogo de sudoku esta correto
	 * @requires objeto sudoku inicializado
	 */
	public void correctGame() {

		boolean correct = true;

		correct = verifyColumns();
		if(correct == false){
			printSudoku(correct);
			return;
		}

		correct = verifyLines();
		if(correct == false){
			printSudoku(correct);
			return;
		}
		correct = verifyAreas(sudoku2array());
		if(correct == false){
			printSudoku(correct);
			return;
		}
		
		printSudoku(correct);
	}

	/**
	 * Imprime o resultado do jogo sudoku
	 * @param correct - jogo correto ou errado
	 */
	public static void printSudoku(boolean correct){

		String lineSep = "+-----+-----+-----+\n";

		if(correct)
			System.out.println("O jogo respeita as regras do Sudoku");

		else{

			StringBuilder sb = new StringBuilder();

			sb.append("O puzzle seguinte esta errado:" + "\n" + 
					lineSep);

			for(int i = 0; i < 9; i++){
				sb.append("|");

				for(int j = 0; j < 9; j++)
					if((j + 1) % 3 == 0)
						sb.append(sudoku[i][j] + "|");
					else
						sb.append(sudoku[i][j] + " ");

				sb.append("\n");

				if((i + 1) % 3 == 0)
					sb.append(lineSep);
			}

			sb.deleteCharAt(sb.length() - 1);

			System.out.print(sb.toString());
		}


	}

	/**
	 * Cria um array com as dimensoes do sudoku e preenche de acordo com um
	 * input
	 * @param input - ficheiro a ser lido
	 * @return jogo de sudoku preenchido
	 * @throws IOException
	 * 
	 * @requires input != null 
	 */
	private int[][] readInput(BufferedReader input) throws IOException {

		String line = input.readLine();
		String[] lines;
		int i = 0;
		int[][] result = new int [9][9];

		while(i < 9){
			lines = line.split(" ");

			for(int j = 0; j < 9; j++)
				result[i][j] = Integer.parseInt(lines[j]);

			i++;
			line = input.readLine();
		}

		return result;
	}

	/**
	 * Verifica se todas as linhas têm elementos todos diferentes e se a sua
	 * soma e igual a 45 (soma de 1 a 9)
	 * @return true/false consoante os elementos diferentes ou nao
	 */
	private boolean verifyLines() {

		int sum = 0;
		boolean[] numbers = new boolean[9];
		boolean correct = true;

		for(int l = 0; l < 9 && correct; l++) {

			for(int c = 0; c < 9; c++) {
				numbers[sudoku[l][c] - 1] = true;
				sum += sudoku[l][c];
			}

			correct = verifyNumbers(numbers) && (sum == 45);
			sum = 0;
		}



		return correct;
	}

	/**
	 * Verifica se todas as colunas têm elementos todos diferentes e se a sua
	 * soma e igual a 45 (soma de 1 a 9)
	 * @return true/false consoante os elementos diferentes ou nao
	 */
	private boolean verifyColumns() {
		int sum = 0;
		boolean[] numbers = new boolean[9];
		boolean correct = true;

		for(int l = 0; l < 9 && correct; l++) {

			for(int c = 0; c < 9; c++) {
				numbers[sudoku[c][l] - 1] = true;
				sum += sudoku[c][l];
			}

			correct = verifyNumbers(numbers) && (sum == 45);
			sum = 0;
		}



		return correct;
	}

	/**
	 * Verifica se todos os espacos têm elementos todos diferentes e se a sua
	 * soma e igual a 45 (soma de 1 a 9)
	 * @return true/false consoante os elementos diferentes ou nao
	 */
	private boolean verifyAreas(int[] arrSudoku) {

		int sum = 0;
		boolean correct = true;
		boolean [] numbers = new boolean [9];

		int lastPos = 0;

		int line = 0;
		int elem = 0;

		for(int area = 0; area < 9 && correct; area++){

			line = 0;
			while(line < 3){

				while(elem < 3){
					numbers[arrSudoku[lastPos] - 1] = true;
					sum += arrSudoku[lastPos];
					lastPos++;
					elem++;
				}
				elem = 0;
				lastPos += 6;
				line++;
			}

			correct = verifyNumbers(numbers) && (sum == 45);


			if(area == 2 || area == 5)
				lastPos = (area + 1) * 9;
			else
				lastPos -= 24;

			sum = 0;

		}


		return correct;
	}

	/**
	 * Verifica se todos os numeros sao diferentes
	 * @param numbers - array com true se elemento aparecer, false se nao 
	 * aparecer
	 * @return true se todos forem true, false caso contrario
	 */
	private boolean verifyNumbers(boolean[] numbers) {

		for(int i = 0; i < 9; i++)
			if(numbers[i] == false){
				return false;
			}

		return true;
	}

	/**
	 * Coloca um jogo sudoku num array 9*9
	 * @return array com o jogo de sudoku
	 */
	private int[] sudoku2array() {

		int[] arrSudoku = new int[81];
		int lastPos = 0;
		int column = 0;

		for(int line = 0; line < 9; line++){
			column = 0;

			while(column < 9){
				arrSudoku[lastPos] = sudoku[line][column];
				column++;
				lastPos++;
			}
		}

		return arrSudoku;
	}

}
