

/**
 * Queue representa uma fila, i.e., uma colecao linear de elementos que suporta 
 * a remocao de elementos na frente da fila e a insercao de elementos no fim da 
 * fila, usando uma lista simplesmente ligada.
 * 
 * @param <E> Tipo de elementos.
 * 
 *
 * @author Frederico Apolonia - nº 47892
 * @date 07 - Abr - 2017 - turno 11h00m Sexta
 *
 */
public class Queue<E> {


	//Classe aninhada para os nos das listas

	private static class Node<E>{

		/**Atributos*/
		//o elemento 
		private E element;
		//proximo noh
		private Node<E> next;

		/**
		 * Um noh com um dado elemento e a indicacao do proximo noh.
		 * @param element o elemento
		 * @param node o proximo noh
		 * @requires element nao null
		 */
		public Node(E element, Node<E> node){
			this.element = element; 
			this.next= node;
		}

		public String toString(){
			return element.toString();
		}

	}



	/**Agora as listas propriamente ditas.*/

	/*Atributos*/
	private Node<E> head;
	private Node<E> rear;
	private int size;

	//construtores

	/**
	 * Construtor vazio da classe Queue.
	 * @return empty queue
	 */
	public Queue() {
		head = null;
		rear = null;
		size = 0;
	}

	/**
	 * Construtor com parametro da classe Queue
	 * @param element Elemento a ser adicionado a queue
	 * @return queue com 1 elemento
	 */
	public Queue(E element){
		head = new Node<> (element, null);
		rear = head;
		size = 1;
	}

	/**
	 * Devolve o numero de elementos presente na queue
	 * @return numero de elementos na queue
	 */
	public int size(){
		return this.size;
	}

	/**
	 * Verifica se a queue esta ou nao vazia
	 * @return true se size for 0, false caso contrario
	 */
	public boolean isEmpty(){
		return size == 0;
	}

	/**
	 * Devolve o elemento da primeira posicao da queue
	 * @return primeiro elemento da queue
	 */
	public E front(){
		return head.element;
	}

	/**
	 * Adiciona um no a queue
	 * @param element elemento a ser adicionado a queue dentro do no
	 */
	public void enqueue(E element) {

		if (isEmpty()) {
			head = new Node<> (element, null);
			rear = head;

			size = 1;
		} else {
			Node<E> toEnqueue = new Node <> (element, null);
			rear.next = toEnqueue;
			rear = toEnqueue;

			size++;
		}

	}

	/**
	 * Remove um elemento da queue
	 * @requires !isEmpty()
	 */
	public void dequeue() {
		
		head = head.next;

		size--;

	}

	/**
	 * @return Representacao textual da queue
	 */
	@Override
	public String toString(){

		StringBuilder sb = new StringBuilder();

		Node<E> current = head;

		while(current != null){

			sb.append(current.toString());

			current = current.next;
		}
		return sb.toString();
	}	

}
