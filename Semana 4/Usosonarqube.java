/**
 * 
 * @author Frederico Apolonia - nº47892
 *
 */
public class Usosonarqube {

    private int j = 0;
    private int i = 0; 

    /*
     * A classe que estava a ser criada dentro do Usosonarqube nunca era
     * utilizada
     */

    /*
     * Construtor da classe Usosonarqube
     */
    public Usosonarqube(){
        //
    }

    //metodo que devolve a soma h e i la de cima!
    int metodo1 (int h) {
        return h + i;
    }

    //metodo que imprime o produto de h por j la de cima
    void metodo2 (int h) {
        System.out.println(h * j);
    } 


    public String metodo3 (String aMinhaLindaString) {

        String result = null;

        if(aMinhaLindaString.equals("a")){
            result = "a";
        }
        if(aMinhaLindaString.equals("b")){
            result = "b";
        }
        if(aMinhaLindaString.equals("c")){
            result = "c";
        }
        if(aMinhaLindaString.equals("d")){
            result = "d";
        }
        if(aMinhaLindaString.equals("e")){
            result = "e";
        }
        if(aMinhaLindaString.equals("f")){
            result = "f";
        }
        return result;
    }
}
