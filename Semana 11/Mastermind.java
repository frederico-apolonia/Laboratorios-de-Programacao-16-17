import java.util.Random;

/**
 * Classe Mastermind
 * @author Frederico Apolonia - 47892
 * @date 10/05/17 - 15h10
 *
 */
public class Mastermind {

	private static final int MAX_LENGTH_SEQ = 4;

	private Sequencia secret;
	private boolean finish;
	private int count;

	/**
	 * Construtor mastermind c/ parametro sequencia (sequencia nao random)
	 * @param secret
	 */
	public Mastermind(Sequencia secret) {
		this.secret = secret;
		this.finish = false;
		this.count = 0;
	}

	/**
	 * Construtor mastermind s/ parametro sequencia (sequencia random)
	 */
	public Mastermind() {
		Random rd = new Random();
		Cores[] todasCores = Cores.values();

		Cores[] sequencia = new Cores[4];

		for(int i = 0; i < Mastermind.MAX_LENGTH_SEQ; i++) {
			sequencia[i] = todasCores[rd.nextInt(todasCores.length)];
		}

		this.secret = new Sequencia(sequencia);
		this.finish = false;
		this.count = 0;

	}

	/**
	 * @return Numero de jogadas ja efetuadas
	 */
	public int quantas() {
		
		return this.count;
	}

	/**
	 * @return true if finish == true
	 */
	public boolean fim() {

		return finish;
	}

	/**
	 * Foi efetuada uma jogada, logo, o count tem de ser incrementado
	 */
	public void jogada() {
		this.count++;
	}
	
	/**
	 * Coloca o finish a true, ou seja, a sequencia foi encontrada
	 */
	public void setFim() {
		finish = true;
	}

	/**
	 * Verifica os pinos que estao corretos ou fora de sitio
	 * @param tentativa - resposta do jogador
	 * @return par pinos (PRETO, BRANCO)
	 */
	public Pinos compare(Sequencia tentativa) {
		return new Pinos(numPretos(tentativa), numBrancos(tentativa));
	}

	/**
	 * Verifica o numero de pinos pretos
	 * @param resposta resposta do jogador
	 * @return numero de cores no sitio certo
	 */
	private int numPretos(Sequencia resposta) {

		int res = 0;

		for(int i = 0; i < Mastermind.MAX_LENGTH_SEQ; i++) {
			if(secret.seqInArr()[i] == resposta.seqInArr()[i])
				res++;
		}

		return res;
	}

	/**
	 * Verifica o numero de pinos brancos
	 * @param tentativa resposta do jogador
	 * @return numero de cores certas no sitio errado
	 */
	private int numBrancos(Sequencia tentativa) {

		int res = 0;
		boolean found = false;

		for(int i = 0; i < Mastermind.MAX_LENGTH_SEQ; i++) {

			for(int j = 0; j < Mastermind.MAX_LENGTH_SEQ && !found; j++) {
				
				if(i != j && secret.seqInArr()[i] == tentativa.seqInArr()[j] &&
					secret.seqInArr()[i] != tentativa.seqInArr()[i]){
					res++;
					found = true;
				}

			}
			
			found = false;

		}

		return res;
	}

}
