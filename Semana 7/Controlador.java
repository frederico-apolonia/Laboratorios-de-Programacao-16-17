/**
 * @author Frederico Apolonia - nº 47892
 * @date 07 - Abr - 2017 - turno 11h00m Sexta
 */
public class Controlador {

	//parametros
    private Queue<Solicitacao> solicitacoes;
    private int id;
    private int tempoTotal;
    
    /**
     * Construtor da classe Controlador
     * @param id ID do controlador
     */
    public Controlador(int id){
    	this.id = id;
    	tempoTotal = 0;
    	solicitacoes = new Queue<>();
    }
    
    /**
     * @return ID do controlador
     */
    public int id(){
    	return this.id;
    }
    
    /**
     * @return Tempo total de todas as solicitacoes deste controlador
     */
	public int tempoTotal() {
		return tempoTotal;
	}
	
	/**
	 * Adiciona uma nova solicitacao a lista de solicitacoes deste controlador
	 * @param s Solicitacao a ser adicionada
	 */
	public void addSolicitacao(Solicitacao s) {
		tempoTotal += s.tempo();
		solicitacoes.enqueue(s);
	}
	
	/**
	 * Remove a primeira solicitacao da lista de solicitacoes deste controlador
	 * 
	 * @requires solicitacoes.isEmpty() != false
	 */
	public void removeSolicitacao() {
		
		tempoTotal -= solicitacoes.front().tempo();
		solicitacoes.dequeue();
		
	}
	
	/**
	 * @return primeira solicitacao deste controlador
	 */
	public Solicitacao primeiraSolicitacao() {
		return solicitacoes.front();
	}
	
	/**
	 * @return Queue com todas as solicitacoes deste controlador
	 */
	public Queue<Solicitacao> solicitacoes() {
		return solicitacoes;
	}

	/**
	 * @return Representacao textual do controlador
	 */
	@Override
	public String toString(){
		
		return "" + id;
	}
}
