import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe que corre a verificacao do Sudoku
 * @author Frederico Apolonia - no 47892
 * @date 10 - 03 - 2017
 */
public class RunSudoku {

	public static void main(String[] args) throws IOException {

		//input do ficheiro, passado atraves dos argumentos
		BufferedReader input = new BufferedReader (new FileReader (args[0]));

		//criacao de um novo objeto sudoku
		Sudoku sudoku = new Sudoku(input);

		//verificacao se o jogo esta correto e a sua impressao
		sudoku.correctGame();
	}

	
}
