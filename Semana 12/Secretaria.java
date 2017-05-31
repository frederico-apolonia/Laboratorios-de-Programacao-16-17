/**
 * 
 * @author Frederico Apolonia - 47892
 * @date 19/05/17 - 13h17
 */
public class Secretaria {
	
	//numero da secretaria
	private int numero;
	//categoria atribuida a secretaria
	private int categoria;
	
	/**
	 * Construtor da classe secretaria
	 * @param numero numero correspondente a secretaria
	 * @param categoria categoria atribuida a secretaria
	 */
	public Secretaria(int numero, int categoria) {
		this.categoria = categoria;
		this.numero = numero;
	}

	/**
	 * @return categoria da secretaria
	 */
	public int obterCategoria() {
		return categoria;
	}

	/**
	 * @return numero da secretaria
	 */
	public int obterNumero() {
		return numero;
	}
	
	/**
	 * Altera a categoria previamente atribuida a secretaria
	 * @param categoria nova categoria
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoria;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secretaria other = (Secretaria) obj;
		if (categoria != other.categoria)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

}
