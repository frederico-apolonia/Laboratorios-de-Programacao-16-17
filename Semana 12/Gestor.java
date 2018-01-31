import java.util.HashMap;
import java.util.Map.Entry;
public class Gestor {

	private int categorias;
	private int nSecretarias;
	private int estrategia;

	/**NUMERO (int), CATEGORIA (int)*/
	private HashMap<Integer, Integer> secretarias;
	/**NOME (string), CATEGORIA (int)*/
	private HashMap<String, Integer> colaboradores;
	/**COLABORADOR, SECRETARIA*/
	private BidirectionalHashMap<Colaborador, Secretaria> escritorio;


	/**
	 * Metodo construtor da classe Gestor
	 * @param categorias numero de categorias dos colaboradores
	 * @param nSecretarias numero de secretarias
	 * @param estrategiaAtribuicao estrategia
	 */
	public Gestor(int categorias, int nSecretarias, int estrategiaAtribuicao) {

		this.categorias = categorias;
		this.nSecretarias = nSecretarias;
		this.estrategia = estrategiaAtribuicao;

		escritorio = new BidirectionalHashMap<>();

		secretarias = new HashMap<>();
		colaboradores = new HashMap<>();

		distribuiSecretariasInicial();

	}

	/**
	 * Faz a distribuicao inicial de secretarias em que cada categoria tem
	 * igual numero de secretarias
	 */
	private void distribuiSecretariasInicial() {

		int maxLugares = nSecretarias / categorias;
		int i = 0;
		int currCategoria = 1;

		while (i < nSecretarias) {

			if(i == (maxLugares * currCategoria))
				currCategoria++;

			secretarias.put(i + 1, currCategoria);
			i++;	

		}

	}

	/**
	 * Regista um novo colaborador no sistema, se e so se este nao estiver
	 * ainda registado
	 * @param nome nome do colaborador
	 * @param categoria categoria a ser atribuida ao colaborador
	 * @return true se tiver sido colocado
	 */
	public boolean registar(String nome, int categoria) {
		if(!colaboradores.containsKey(nome)){
			colaboradores.put(nome, categoria);
			return true;
		}
		return false;
	}

	/**
	 * Atribui uma secretaria a um colaborador
	 * @param nome nome do colaborador a quem se vai dar uma secretaria
	 * @return true se tiver sido atribuida uma secretaria c/ sucesso
	 */
	public boolean atribuir(String nome) {

		if(colaboradores.containsKey(nome)) {

			if(estrategia == 1)
				return atribuicaoEstatica(nome);
			else if(estrategia == 2)
				return atribuicaoDinamica(nome);
			else
				return false;
		}
		else 
			return false;
	}

	/**
	 * Obter numero de secretaria atribuida a um colaborador
	 * @param nome nome do colaborador
	 * @return numero da secretaria atribuida a um colaborador || 0 se nao tiver sido atribuido
	 */
	public int obterNumero(String nome) {
		if(colaboradores.containsKey(nome)) {
			Colaborador colaborador = new Colaborador(nome, colaboradores.get(nome));
			if(escritorio.getValue(colaborador) != null)
				return escritorio.getValue(colaborador).obterNumero();
			else
				return 0;
		}
		else
			return 0;
	}

	/**
	 * Remove uma atribuicao de secretaria dado um numero
	 * @param numero
	 * @return a secretaria removida || null se nao existir para remover
	 */
	public Secretaria removerAtribuicaoPorNumero(int numero) {

		if(numero <= nSecretarias) {
			Secretaria secretaria = new Secretaria(numero, secretarias.get(numero));

			Colaborador colaborador = escritorio.getKey(secretaria);

			return escritorio.removeByKey(colaborador);
		}
		else
			return null;
	}

	/**
	 * Remove uma atribuicao de secretaria dado um nome
	 * @param nome nome do colaborador para remover secretaria
	 * @return a secretaria removida || null se nao existir para remover
	 */
	public Secretaria removerAtribuicaoPorNome(String nome) {

		if(colaboradores.containsKey(nome)) {
			Colaborador colaborador = new Colaborador(nome, colaboradores.get(nome));

			return escritorio.removeByKey(colaborador);
		}
		else
			return null;
	}

	/**
	 * Indica qual o dono da secretaria com um numero
	 * @param numero da secretaria do colaborador
	 * @return colaborador se tiver secretaria || null se colaborador nao tiver secretaria atribuida
	 */
	public Colaborador obterDono(int numero) {

		if(numero <= nSecretarias) {
			Secretaria secretaria = new Secretaria(numero, secretarias.get(numero));

			return escritorio.getKey(secretaria);
		}
		else
			return null;

	}

	/**
	 * @return numero de secretarias atribuidas
	 */
	public int totalAtribuidos() {
		return escritorio.size();
	}

	/**
	 * Indica o numero de secretarias atribuidas a uma dada categoria
	 * @param categoria
	 * @return numero de secretarias atribuidas a uma dada categoria
	 * @requires 0 < categoria <= categorias
	 */
	public int atribuidosNaCategoria(int categoria) {

		Secretaria currSec;
		int result = 0;

		for (Entry<Integer, Integer> secretaria : secretarias.entrySet()) {

			currSec = new Secretaria(secretaria.getKey(), secretaria.getValue());

			if(currSec.obterCategoria() == categoria && 
					escritorio.containsValue(currSec))
				result++;
		}


		return result;
	}

	/**
	 * Faz a atribuicao estatica dos colaboradores
	 * @param nome nome do colaborador a colocar
	 * @return true se tiver sido atribuida uma mesa
	 */
	private boolean atribuicaoEstatica(String nome) {

		Colaborador colaborador = new Colaborador(nome, colaboradores.get(nome));
		int categoria = colaborador.obterCategoria();

		Secretaria secretaria = findSecretaria(categoria);

		if(secretaria == null)
			return false;
		else {
			escritorio.put(colaborador, secretaria);
			return true;
		}

	}

	/**
	 * Faz a atribuicao dinamica dos colaboradores
	 * @param nome nome do colaborador a colocar
	 * @return true se tiver sido atribuida uma mesa
	 */
	private boolean atribuicaoDinamica(String nome) {

		if(atribuicaoEstatica(nome))
			return true;

		else {

			Colaborador colaborador = new Colaborador(nome, colaboradores.get(nome));
			int categoria = colaborador.obterCategoria();
			
			if(categoria == categorias)
				return false;
			
			categoria++;
			Secretaria needSecretaria = findSecretaria(categoria);
			
			

			while(categoria <= categorias || needSecretaria == null) {
				needSecretaria = findSecretaria(categoria);
				
				if(needSecretaria != null)
					break;
				
				categoria++;
			}

			if(needSecretaria == null)
				return false;

			needSecretaria.setCategoria(colaborador.obterCategoria());
			secretarias.put(needSecretaria.obterNumero(), needSecretaria.obterCategoria());

			escritorio.put(colaborador, needSecretaria);

			return true;

		}

	}

	/**
	 * Procura uma secretaria livre para uma categoria
	 * @param categoria
	 * @return secretaria se tiver sido encontrada uma livre || null caso contrario
	 */
	private Secretaria findSecretaria(int categoria) {

		Secretaria result;

		for (Entry<Integer, Integer> secretaria : secretarias.entrySet()) {

			result = new Secretaria(secretaria.getKey(), secretaria.getValue());

			if(result.obterCategoria() == categoria && 
					!escritorio.containsValue(result))
				return result;
		}
		return null;
	}

}
