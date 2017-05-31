/**
 * Classe sequencia
 * @author Frederico Apolonia - 47892
 * @date 10/05/17 - 15h10
 *
 */
public class Sequencia {
	
	private Cores[] sequencia;
	//valor maximo da sequencia
	private static final int LENGTHSEQ = 4;
	
	/**
	 * Construtor da classe sequencia
	 * @param sequencia
	 * @requires sequencia.length == 4
	 */
	public Sequencia(Cores[] sequencia){
		this.sequencia = sequencia;
	}
	
	/**
	 * Construtor de classe sequencia
	 * Inicia uma seq vazia
	 */
	public Sequencia() {
		sequencia = new Cores[LENGTHSEQ];
	}

	/**
	 * Muda a cor da posicao i
	 * @param i
	 * @param cor
	 * @requires i >= 0 && i < 4
	 */
	public void mudaCor(int i, Cores cor) {
		sequencia[i] = cor;
	}

	/**
	 * @return sequencia num array de cores
	 */
	public Cores[] seqInArr() {
		return sequencia;
	}
	
	/**
	 * Representacao textual da sequencia no formato "COLOR COLOR COLOR COLOR"
	 */
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < Sequencia.LENGTHSEQ; i++) {
			sb.append(sequencia[i] + " ");
		}
		
		return sb.toString();
	}

}
