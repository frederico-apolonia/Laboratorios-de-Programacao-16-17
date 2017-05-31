import java.util.Scanner;

/**
 * Classe RunCalc para correr a classe Calc.
 * @author Frederico Apolonia - nº 47892
 * @date 24/03/17 - 12h35
 *
 */
public class RunCalc {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input;
		Calc calc = new Calc();
		
		while(sc.hasNextLine()){
			input = sc.nextLine();
			System.out.println(calc.run(input));
			
		}
		
		sc.close();
	}

}
