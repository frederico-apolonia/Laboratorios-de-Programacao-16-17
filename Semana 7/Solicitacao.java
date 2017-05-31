/**
 * @author Frederico Apolonia - nº 47892
 * @date 07 - Abr - 2017 - turno 11h00m Sexta
 */
public class Solicitacao {
	private int ordem;
	private int codigo;
	private int tempo;

	/**
	 * Construtor da classe solicitacao
	 * @param ordem numero da solicitacao
	 * @param codigo codigo da solicitacao
	 * @param tempo tempo desta solicitacao
	 * 
	 * @requires tempo >= 1
	 */
	public Solicitacao(int ordem, int codigo, int tempo){
		this.ordem = ordem;
		this.codigo = codigo;
		this.tempo = tempo;
	}
	
	/**
	 * @return tempo da solicitacao
	 */
	public int tempo(){
		return tempo;
	}
	
	/**
	 * @return ordem da solicitacao
	 */
	public int ordem(){
		return ordem;
	}
	
	/**
	 * @return Representacao textual da solicitacao
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Solicitacao numero " + ordem + " - Codigo " + codigo + "\n");
		
		return sb.toString();
	}
	
}
