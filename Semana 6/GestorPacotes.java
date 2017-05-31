import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementa metodos para a criacao de pacotes e operacoes sobre eles
 * @author Frederico Apolonia - nº47892
 */
public class GestorPacotes 
{
	/**
	 * Recebe uma string correspondente a uma linha do ficheiro de items e
	 * devolve um par do tipo String e Double onde a String eh o nome do item e o
	 * Double corresponde ao seu peso.
	 * 
	 * @param str string onde um item esta codificado. deve ter o formato "item;peso"
	 * 
	 * @return um par de String Double
	 */
	public static Par<String, Double> parseItem(String str) 
	{
		String[] input = str.split(";");

		return new Par<> (input[0], Double.parseDouble(input[1]));
	}

	/**
	 * Le items de um ficheiro dado um BufferedReader e cria uma lista de
	 * pacotes com a capacidade maxima recebida
	 * 
	 * @param fileReader
	 *            BufferedReader para o ficheiro onde os items estao armazenados
	 * 
	 * @param capacidadePacotes
	 *            capacidade maxima de cada pacote a ser criado
	 * @return
	 * @throws IOException
	 */ 
	public static List<Pacote<Par<String, Double>>> criaPacotes(
			BufferedReader fileReader, int capacidadePacotes )
					throws IOException 
	{
		Pacote <Par<String,Double>> current = new Pacote<>(capacidadePacotes);

		ArrayList<Pacote<Par<String,Double>>> result = new ArrayList<>();

		String line = fileReader.readLine();

		while(line != null){

			if(current.estaCheio()){

				result.add(current);
				current = new Pacote<>(capacidadePacotes);
				System.out.println("Novo pacote");

				current.empacota(parseItem(line));
			}

			else{

				current.empacota(parseItem(line));

			}

			line = fileReader.readLine();
		}

		result.add(current);

		return result;
	}

	/**
	 * Retorna o peso total do pacote
	 * 
	 * @param pacote
	 *            pacote a ser pesado
	 * @return peso total do pacote
	 */
	public static double pesaPacote( Pacote<Par<String, Double>> pacote )  
	{

		double result = 0.0;

		Iterator<Par<String, Double>> it = pacote.iterator();
		
		while(it.hasNext()){
			result += it.next().segundo();
		}

		return result;
	}

	/**
	 * Verifica se um dado pacote tem um determinado peso
	 * @param pacote O pacote a verificar
	 * @param peso O peso alvo
	 */
	public static boolean pesoIgual( Pacote<Par<String, Double>> pacote, 
			double peso) 
	{	

		double pesoPacote = pesaPacote(pacote);

		return Math.abs(pesoPacote - peso) < 0.0001;
	}


	/**
	 * Devolve uma lista de pacotes que tenham uma fruta do tipo 'fruta'
	 * @param pacotes Lista de pacotes a serem pesquisados
	 * @param fruta Tipo de fruta a ser pesquisada
	 * @return Lista com pacotes que contenham frutas do tipo fruta
	 */
	public static List<Pacote<Par<String, Double>>> pesquisaPacotes( 
			List<Pacote<Par<String, Double>>> pacotes, String fruta)
	{

		ArrayList<Pacote<Par<String,Double>>> result = new ArrayList<>();
		Pacote<Par<String, Double>> currPac;

		for(int i = 0; i < pacotes.size(); i++){
			currPac = pacotes.get(i);
			Iterator<Par<String, Double>> it = currPac.iterator();
			
			while(it.hasNext()){
				if(it.next().primeiro().equals(fruta))
					result.add(currPac);
			}

		}

		return result;
	}
}
