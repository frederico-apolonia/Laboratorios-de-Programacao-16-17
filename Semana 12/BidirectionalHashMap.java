import java.util.HashMap;

public class BidirectionalHashMap<K, V> {

	private HashMap<K, V> keyValue;
	private HashMap<V, K> valueKey;
	private int size;

	/**
	 * construtor
	 */
	public BidirectionalHashMap() {
		keyValue = new HashMap<>();
		valueKey = new HashMap<>();
		size = 0;
	}

	// Delegacao.
	// -----------------------------------------------------------------------

	/**
	 * Dado um valor, obter a chave correspondente
	 * @param value - o valor
	 * @return K - a chave
	 */
	public K getKey(V value) {
		return valueKey.get(value);
	}

	/**
	 * Dada uma chave, obter o valor correspondente
	 * @param key - a chave
	 * @return V - o valor
	 */
	public V getValue(K key) {
		return keyValue.get(key);
	}

	/**
	 * Adicionar um par chave-valor
	 * @param key - a chave
	 * @param value - o valor
	 */
	public void put(K key, V value) {
		keyValue.put(key, value);
		valueKey.put(value, key);
		
		size++;
	}

	/**
	 * Verificar se a tabela contem uma chave
	 * @param key -a chave
	 * @return true se contem a chave, false se nao contem.
	 */
	public boolean containsKey(K key) {
		return keyValue.containsKey(key);
	}

	/**
	 * verificar se a tabela contem um certo valor
	 * @param value - o valor
	 * @return true se contem o valor, false caso contrario.
	 */
	public boolean containsValue(V value) {
		return valueKey.containsKey(value);
	}

	/**
	 * Remover um par chave-valor, dada a chave.
	 * @param key - a chave.
	 * @return V - o valor previamente associado a chave.
	 */
	public V removeByKey(K key) {
		
		valueKey.remove(keyValue.get(key));
		size--;
		return keyValue.remove(key);
	}

	/**
	 * Remover um par chave-valor, dado o valor.
	 * @param value - o valor
	 * @return K - a chave associada ao valor antes da remocao do par.
	 */
	public K removeByValue(V value) {
		
		keyValue.remove(valueKey.get(value));
		size--;
		return valueKey.remove(value);
	}

	/**
	 * Retornar o tamanho da tabela (numero de pares chave-valor contidos).
	 * @return o tamanho da tabela.
	 */
	public int size() {
		return this.size;
	}

}
