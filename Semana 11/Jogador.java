import java.util.TreeMap;

/**
 * Classe jogador
 * @author Frederico Apolonia - 47892
 * @date 10/05/17 - 15h10
 *
 */
public class Jogador {
	
	private static final int MAX_PRETOS = 4;
	private Mastermind game;
	private TreeMap<String, Pinos> answers;

	public Jogador(Mastermind game) {
		this.game = game;
		answers = new TreeMap<>();
	}

	/**
	 * Faz uma nova jogada
	 * @param tentativa tentativa do jogador
	 * @requires tentativa.length == 4
	 */
	public void fazJogada(Sequencia tentativa) {
		
		//se nao contiver a chave, a jogada ainda nao foi feita
		if(!answers.containsKey(tentativa.toString())) {
			
			Pinos resposta = game.compare(tentativa);
			
			answers.put(tentativa.toString(), resposta);
			game.jogada();
			
			if(resposta.getPretos() == MAX_PRETOS)
				game.setFim();
		}
		
	}
	
	/**
	 * @return TreeMap com as respostas do jogador
	 */
	public TreeMap<String, Pinos> getAnswers() {
		return answers;
	}

	/**
	 * Jogador corrente recebe dicas (recebe todas as respsotas) do jogador A
	 * @param playerB JogadorB para receber as respostas
	 */
	public void hints(Jogador playerB) {
		answers.putAll(playerB.getAnswers());
		
	}
	
	/**
	 * Retorna as respostas (nao ordenadas) do jogador em forma textual
	 */
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("MasterMind\n\n");
		sb.append("N    Tentativas    Respostas\n");
		
		int count = 1;
		
		for (String k : answers.keySet()) {
			
			if(count < 10)
				sb.append(count).append("     ").append(k).append("       ").
				append(answers.get(k).toString() + "\n");
			else if (count < 100 && count >= 10)
				sb.append(count).append("    ").append(k).append("       ").
				append(answers.get(k).toString() + "\n");
			else if (count < 1000)
				sb.append(count).append("   ").append(k).append("       ").
				append(answers.get(k).toString() + "\n");
			else
				sb.append(count).append("  ").append(k).append("       ").
				append(answers.get(k).toString() + "\n");
			count++;
		}
		
		return sb.toString();
	}

}
