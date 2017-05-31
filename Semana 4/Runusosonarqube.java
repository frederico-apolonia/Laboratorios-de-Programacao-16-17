/**
 * 
 * @author Frederico Apolonia 
 *
 */
public class Runusosonarqube {

    public static final int MAX = 10;
    
    public static void main (String[] args) {
        int queRaioDeVariavel = 0;
        

        Usosonarqube sq = new Usosonarqube();

        sq.metodo1(queRaioDeVariavel);

        sq.metodo2(queRaioDeVariavel);


        for ( int i = 0; i < MAX; i ++){
            System.out.print("ola ");
        }
        System.out.println();


        for ( int i = 0; i < MAX; i++){
            System.out.print("ola de novo ");
        }
        System.out.println();


        System.out.println("Esta linha eh mesmo muuuuuuuuuuuuuuuuuuuuuuuuuuuuuu"
                + "uiiiiiiiiiiiiiiiiiiiiiiiiiiittooooooooo grande");



    }

}
