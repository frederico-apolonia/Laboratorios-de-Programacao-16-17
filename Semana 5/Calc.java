import java.text.NumberFormat;
import java.util.EmptyStackException;
import java.util.Locale;
import java.util.Stack;
/**
 * Classe Calc
 * 
 * @author Frederico Apolonia - nº 47892
 * @date 24/03/17 - 12h35
 */
public class Calc {

	private NumberFormat formatNumb;
	private Stack <Double> stack;
	private int round = 4;

	/**
	 * Construtor da classe Calc
	 */
	public Calc(){

		round = 4;
		formatNumb = formatNumb.getInstance(Locale.GERMAN);
		formatNumb.setMinimumFractionDigits(round);
		formatNumb.setMaximumFractionDigits(round);
		stack = new Stack <Double>();

	}
	
	/**
	 * Metodo para correr uma linha de input da calculadora
	 * @param input - String de operadores separados por espaço
	 * @return String com o resultado no topo da pilha. Em caso de erro devolve a mensagem de erro
	 * @requires input != null
	 */
	public String run(String input){

		String [] line = input.split(" ");
		int i = 0;
		try {
			while(i < line.length){

				switch (line[i]) {
				case "+":
					somar();
					break;
				case "-":
					subtrair();
					break;

				case "/":
					dividir();
					break;

				case "*":
					multiplicar();
					break;

				case "ln":
					logaritmo();
					break;

				case "e":
					euler();
					break;

				case "^":
					expoente();
					break;

				case "tan":
					tangente();
					break;

				case "cotan":
					cotangente();
					break;

				case "dec":
					casasDec();
					break;

				case "#":
					simetrico();
					break;

				default:
					stack.push(Double.parseDouble(line[i]));
					break;
				}

				i++;

			}

			Double result = stack.peek();

			if(result.isInfinite()){
				stack.pop();
				return "Erro arithmético: o resultado é infinito.";
			}
			else if(result.isNaN()){
				return "Erro arithmético: logaritmo com argumento negativo.";
			}

			return formatNumb.format(result);


		} catch (EmptyStackException e) {
			return "Ocorreu um erro na operacao. A pilha nao tem elementos suficientes";
		} catch (NumberFormatException e) {
			return "Erro, comando desconhecido: " + line[i];
		}
	}
	/**
	 * Calcula a soma dos dois elementos no topo da pilha.
	 * Coloca o resultado no topo da mesma.
	 */
	private void somar() {

		stack.push(stack.pop() + stack.pop());

	}
	/**
	 * Calcula a diferenca dos dois elementos no topo da pilha. 
	 * Coloca o resultado no topo da mesma.
	 */
	private void subtrair() {

		stack.push(-stack.pop() + stack.pop());


	}
	/**
	 * Calcula a divisao dos dois elementos no topo da pilha.
	 * Coloca o resultado no topo da mesma.
	 */
	private void dividir() {

		Double divisor = stack.pop();
		Double result = stack.pop() / divisor;



		stack.push(result);

	}
	/**
	 * Calcula a multiplicacao dos dois elementos no topo da pilha.
	 * Coloca o resultado no topo da mesma.
	 */
	private void multiplicar() {

		Double result = stack.pop() * stack.pop();

		stack.push(result);

	}
	/**
	 * Calcula o logaritmo do elemento no topo da pilha.
	 * Coloca o resultado no topo da mesma.
	 */
	private void logaritmo() {

		Double result = Math.log(stack.pop());

		stack.push(result);

	}
	/**
	 * Calcula o expoente com o numero de euler do elemento no topo da pilha.
	 * Coloca o resultado no topo da mesma.
	 */
	private void euler() {

		Double result = Math.exp(stack.pop());

		stack.push(result);

	}
	/**
	 * Calcula o expoente dos dois elementos no topo da pilha.
	 * Coloca o resultado no topo da mesma.
	 */
	private void expoente() {

		Double base = stack.pop();
		Double result = Math.pow(base, stack.pop());

		stack.push(result);

	}
	/**
	 * Calcula a tangente do elemento no topo da pilha.
	 * Coloca o resultado no topo da mesma.
	 */
	private void tangente() {

		Double result = Math.tan(stack.pop());

		stack.push(result);

	}
	/**
	 * Calcula a cotangente do elemento no topo da pilha.
	 * Coloca o resultado no topo da mesma.
	 */
	private void cotangente() {

		Double result = Math.tan(stack.pop());

		stack.push(Math.pow(result, -1));

	}
	/**
	 * Define o numero de casas decimais de acordo com o numero que estiver no topo da pilha
	 */
	private void casasDec() {

		round = stack.peek().intValue();

		formatNumb.setMaximumFractionDigits(round);
		formatNumb.setMinimumFractionDigits(round);

	}
	/**
	 * Coloca o simetrico do valor que estiver atualmente no topo da pilha.
	 */
	private void simetrico() {
		stack.push(- stack.pop());

	}
}
