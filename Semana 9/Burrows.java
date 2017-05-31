import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Frederico Apolonia - num 47892
 * 
 * @date 28 Abril 2017 12:10
 */
public class Burrows {

	private static final String SPACES = "      ";

	public static void main(String[] args) throws IOException {

		//exercicio 1
		if(args.length == 1)  {
			Scanner sc = new Scanner(new FileReader (args[0]));

			Burro burroInput = BibBurro.readFile(args[0], sc);

			System.out.println("A arvore e\n" + printBurrow(burroInput, 0));
		} 	
		//exercicio 2
		else {
			
			//Inputs
			Scanner msc = new Scanner(new FileReader (args[0]));
			Scanner fsc = new Scanner(new FileReader (args[1]));
			
			Burro male = BibBurro.readFile(args[0], msc);
			Burro female = BibBurro.readFile(args[1], fsc);
			
			boolean exist = verificaAntepassados(male, female);
			
			if(!exist) {
				Burro filho = new Burro(args[2]);
				filho.setFather(male);
				filho.setMother(female);
				
				System.out.println("A arvore e\n" + printBurrow(filho, 0));
				

				BufferedWriter out = new BufferedWriter(new FileWriter (args[2]));
				
				out.write(buildStringFile(filho));
				
				out.close();
			}
			else {
				System.out.println("Nao cruzar! Tem antepassados comuns.");
			}
			
			//fechar readers e writer
			msc.close();
			fsc.close();
		}

	}
	
	/**
	 * Constroi a string do ficheiro de output
	 * @param b Burro para criar o ficheiro
	 * @return String final
	 */
	static String buildStringFile(Burro b) {
		
		if(b.getMother() == null)
			return "";
		else{
			return b.toString() + "\n" + buildStringFile(b.getFather()) +
					buildStringFile(b.getMother());
		}
	}

	/**
	 * Verifica se ha algum antepassado comum entre o burro 1 o burro 2
	 * @param b1
	 * @param b2
	 * @return true se existir antepassado
	 * 
	 * @requires b1 && b2 != null
	 */
	static boolean verificaAntepassados(Burro b1, Burro b2) {
		
		if(b1.getMother() == null){
			return b1.otherFamily(b2);
		}
		else {
			return b1.otherFamily(b2) || verificaAntepassados(b1.getFather(), b2) 
					|| verificaAntepassados(b1.getMother(), b2);
		}
		
	}

	/**
	 * Imprime a familia do burro dado
	 * @param b Burro para imprimir a familia
	 * @param passo passo da recursao
	 * @return representacao da familia do burro numa string
	 * 
	 * @requires passo >= 0 && b != null
	 */
	static String printBurrow(Burro b, int passo) {

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < passo; i++)
			sb.append(Burrows.SPACES);

		String spaces = sb.toString();

		if(b.getMother() == null) {
			return spaces + b.getName();
		}
		else {
			return spaces + b.getName() + "\n" + printBurrow(b.getFather(), passo + 1) + "\n" + printBurrow(b.getMother(), passo + 1);
		}
	}

}
