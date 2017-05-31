/**
 * Classe pinos para guardar as respostas que dizem respeito aos pinos pretos e aos brancos
 * @author Frederico Apolonia - 47892
 * @date 10/05/17 - 15h12
 *
 */
public class Pinos {
	private int brancos;
	private int pretos;
	
	public Pinos(int pretos, int brancos) {
		this.brancos = brancos;
		this.pretos = pretos;
	}
	
	public int getPretos() {
		return this.pretos;
	}

	public int getBrancos() {
		return this.brancos;
	}

	/**
	 * Representacao textual dos pinos
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(pretos + "   " + brancos);
		
		return sb.toString();
	}
}
