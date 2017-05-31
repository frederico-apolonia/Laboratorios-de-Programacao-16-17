
/**
 * This class implements a donkey for the "Burros" LabP problem.
 * 
 * @author Thibault Langlois
 * @author Frederico Apolonia (metodo equals, toString e otherFamily) - num 47892
 * 
 * @date 28 Abril 2017 12:10
 */
public class Burro {

	/**
	 * The name of the donkey.
	 */
	private final String name;

	/**
	 * Donkey's father.
	 */
	private Burro father;

	/**
	 * Donkey's mother.
	 */
	private Burro mother;

	/**
	 * Makes an instance of donkey.
	 * 
	 * @param nome
	 */
	public Burro(String nome) {
		this.name = nome;
		father = null;
		mother = null;
	}

	public Burro(String name, Burro father, Burro mother) {
		this.name = name;
		this.father = father;
		this.mother = mother;
	}

	/**
	 * Returns the name of a donkey.
	 * 
	 * @return 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns donkey's father.
	 * @return 
	 */
	public Burro getFather() {
		return father;
	}

	/**
	 * Returns donkey's mother.
	 * @return 
	 */
	public Burro getMother() {
		return mother;
	}

	/**
	 * Set donkey's mother
	 *
	 * @param m the mother
	 */
	public void setMother(Burro m) {
		mother = m;
	}

	/**
	 * Set donkey's father.
	 *
	 * @param p the father
	 */
	public void setFather(Burro p) {
		father = p;
	}

	@Override
	/**
	 * Retorna o nome do burro e os seus pais (apenas se estes estiverem registados, 
	 * ou seja, != null)
	 */
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(getName());
		for(int i = getName().length(); i < 16; i++){
			sb.append(" ");
		}
		
		sb.append(this.getFather().getName());
		for(int i = this.getFather().getName().length(); i < 16; i++){
			sb.append(" ");
		}
		
		sb.append(this.getMother().getName());
		
		return sb.toString();
	}

	/**
	 * Ve se dois burros sao iguais (tem o mesmo nome)
	 * @param b Burro a comparar
	 * @return true if equal
	 * @requires b != null
	 */
	public boolean equals(Burro b){
		return name.equals(b.getName());
	}

	/**
	 * Verifica se o burro corrente esta numa outra familia
	 * @param b Burro com a sua familia
	 * @return true if burro is in b family
	 * @requires b != null
	 */
	public boolean otherFamily(Burro b){

		if(b.getMother() == null)
			return this.equals(b);
		else
			return this.equals(b) || this.otherFamily(b.getFather()) || this.otherFamily(b.getMother());

	}

}
