/**
 * Classe colaborador
 * @author Frederico Apolonia - 47892
 * @date 19/05/17 - 13h15
 *
 */
public class Colaborador {
	
	//nome colaborador
	private String nome;
	//categoria colaborador
	private int categoria;
	
	/**
	 * Construtor classe colaborador
	 * @param nome nome do colaborador
	 * @param categoria categoria do colaborador
	 */
	public Colaborador(String nome, int categoria) {
		this.nome = nome;
		this.categoria = categoria;
	}

	/**
	 * @return nome do colaborador
	 */
	public String obterNome() {
		return nome;
	}
	
	/**
	 * @return categoria do colaborador
	 */
	public int obterCategoria() {
		return categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoria;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Colaborador other = (Colaborador) obj;
		if (categoria != other.categoria)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
