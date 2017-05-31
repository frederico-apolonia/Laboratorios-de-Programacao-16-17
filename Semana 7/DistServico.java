
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Frederico Apolonia - nº 47892
 * @date 07 - Abr - 2017 - turno 11h00m Sexta
 */
public class DistServico {

    private int nConServico;
    private Controlador[] controladores;
    private int ordem;
    private int numSolicAtivas;

    /**
     * Cria uma distribuicao de servico vazia.
     *
     *@param nConServico
     *@requires nConServico > 0
     */
    public DistServico(int nConServico) {
        this.nConServico = nConServico;
        controladores = new Controlador[nConServico];
        ordem = 0;
        for(int i = 0; i<nConServico; i++){
            controladores[i] = new Controlador(i+1);
        }
        
    }

    /**
     * Trata o input e distribui a solicitacao para o controlador com menor tempo
     * @param in ficheiro com solicitacoes
     * @throws IOException
     */
    public void leDistribui(BufferedReader in) throws IOException{
    	
    	String input = in.readLine();
    	String[] lines;
    	
    	while(input != null){
    		lines = input.split(" ");
    		
    		request(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
    		
    		input = in.readLine();
    	}
    	
    }


    /**
     * @return numero de solicitacoes a espera de serem resolvidas
     */
    public int total(){
    	
        return numSolicAtivas;
    }



    /**
     * Verifica quais os controladores que tem tempo de espera maior que um valor i
     * @param i Valor minimo do tempo de espera
     * @return Queue com os controladores com tempo de espera maior que i
     * @requires i >= 0
     */
    public Queue<String> tempoSuperior(int i){
    	
    	Queue<String> result = new Queue<>();
    	
    	for (int j = 0; j < nConServico; j++) {
			if(controladores[j].tempoTotal() > i)
				result.enqueue(controladores[j].toString());
		}
    	
    	
        return result;
    }


    /**
     * Calcula o tempo minimo de espera para uma nova solicitacao
     * @return tempo minimo de espera para uma nova solicitacao
     */
    public int tempoMinimoEspera(){
        
    	int tempMin = controladores[0].tempoTotal();
    	
    	for (int i = 1; i < nConServico; i++) {
			if(controladores[i].tempoTotal() < tempMin)
				tempMin = controladores[i].tempoTotal();
		}
    	
    	//+1 eh o tempo minimo de cada solicitacao
        return tempMin + 1;       
    }

    /**
     * Cria uma nova solicitacao e adiciona-a ao controlador com menor tempo
     * @param n codigo da solicitacao
     * @param tempo tempo que a situacao demora a ser resolvida
     * 
     * @requires tempo >= 1
     */
    public void request(int n, int tempo){
    	
    	ordem++;
    	
    	int tempMin = controladores[0].tempoTotal(), controlador = 0;
    	Solicitacao newSol = new Solicitacao(ordem, n, tempo);
    	
    	for (int i = 1; i < nConServico; i++) {
    		if(controladores[i].tempoTotal() < tempMin){
    			tempMin = controladores[i].tempoTotal();
    			controlador = i;
    		}
			
		}
    	
    	controladores[controlador].addSolicitacao(newSol);
    	numSolicAtivas++;
    }

    /**
     * Remove a primeira solicitacao do controlador N
     * @param n Controlador a quem se vai remover a solicitacao
     * 
     * @requires n > 0 && n <= nConServico 
     */
    public void out(int n){
    	
    	controladores[n - 1].removeSolicitacao();
    	
    	numSolicAtivas--;
    	
    }


    /**
  	 * Verifica qual a solicitacao que esta ha mais tempo por resolver
     * @return representacao textual da solicitacao por resolver ha mais tempo
     */
    public String oldest() {
    	
    	int oldest = controladores[0].primeiraSolicitacao().ordem();
    	int controlador = 0;
        
    	for (int i = 1; i < nConServico;i++) {
			if(controladores[i].primeiraSolicitacao().ordem() < oldest){
				oldest = controladores[i].primeiraSolicitacao().ordem();
				controlador = i;
			}
		}
    	
        return controladores[controlador].primeiraSolicitacao().toString();
    }
    
    /**
     * @return Representacao textual da situacao atual da distribuicao de servico
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	/*
    	 * passar por todos os controladores e fazer append aqui das suas solicitacoes
    	 */
    	
    	for (int i = 0; i < nConServico; i++) {
    		sb.append("Controlador " + (i+1) + ":\n");
			sb.append(controladores[i].solicitacoes().toString());
			sb.append("\n");
		}
    	
    	return sb.toString();
    }

}
