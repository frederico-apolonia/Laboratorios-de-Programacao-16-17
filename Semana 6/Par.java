/**
 * Um par de elementos que armazena dois elementos preservando a sua ordem.
 * 
 * @author Frederico Apolonia - nº47892
 * 
 */
public class Par<E, F> 
{	
	
	private E itemE;
	private F itemF;
	/**
	 * Cria um par imutavel com os dois items dados
	 * @param itemE O primeiro item
	 * @param itemF O segundo item
	 */
	public Par(E itemE, F itemF) {
		this.itemE = itemE;
		this.itemF = itemF;
	}

	/**
	 * @return O primeiro item do par
	 */
	public E primeiro() {
		
		return this.itemE;
	}

	/**
	 * @return O segundo item do par
	 */
	public F segundo() {
		return this.itemF;
	}
}
