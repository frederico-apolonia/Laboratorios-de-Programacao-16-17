import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Um pacote eh uma estrutura de dados que armazena um conjunto fixo de items.

 * @author Frederico Apolonia - nº47892
 * 
 * @param <E> O tipo dos items
 */
public class Pacote<E> implements Iterable<E>
{	

	private ArrayList<E> pacote;
	private int capacidade;
	/**
	 * Construtor
	 * 
	 * @param capacidade
	 *            numero maximo de elementos que o pacote pode conter
	 */
	public Pacote(int capacidade) 
	{
		pacote = new ArrayList<>(capacidade);
		this.capacidade = capacidade;
	}

	/**
	 * Retorna a capacidade maxima do pacote em termos de numero de elementos
	 */
	public int getCapacidade() 
	{
		return this.capacidade;
	}

	/**
	 * Retorna o numero de elementos actualmente contidos no pacote
	 * 
	 * @return numElems
	 */
	public int getNumItems() 
	{
		return pacote.size();
	}

	/**
	 * Retorna verdadeiro se o pacote estiver cheio
	 * 
	 * @return verdadeiro se o pacote estiver cheio e nao for possivel adicionar
	 *         mais items
	 */
	public boolean estaCheio() 
	{
		return pacote.size() == capacidade;
	}

	/**
	 * Empacota um item se a caixa nao estiver cheia.
	 * 
	 * @param item
	 *            o item a ser empacotado
	 * 
	 * @return false se o pacote estiver cheio
	 */
	public boolean empacota(E item) 
	{
		return pacote.add(item);
	}

	/**
	 * Retorna os items empacotados neste pacote
	 * 
	 * @return lista dos items empacotados
	 */
	public List<E> items()  
	{
		ArrayList<E> list = new ArrayList<>();
		for (int i = 0; i < pacote.size(); i++) {
			if(pacote.get(i) != null)
				list.add(pacote.get(i));
		}
		
		return list;
	}

	/**
	 * Retorna um iterador capaz de atravessar todos os itens presentes neste 
	 * pacote
	 * @return iterador
	 */
	public Iterator<E> iterator() 
	{
		return pacote.iterator();
	}
	
}
