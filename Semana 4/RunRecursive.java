import java.util.Scanner;


/**
 * @author respicio, ans
 * Esta classe testa a classe Recursive
 *
 */

public class RunRecursive {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        /* Ex. 1: Calculo de potencia */
        System.out.println( "Ex. 1: Calculo de potencia" );
        System.out.print( "Introduza uma base e um expoente (inteiro positivo): " );
        int x = s.nextInt();
        int n = s.nextInt();
        System.out.println( (int)Recursive.potencia(x, n) );
        System.out.println();


        /* Ex. 2: Soma dos pares positivos ate n*/
        System.out.println( "Ex. Soma ate n" );
        System.out.print( "Introduza um inteiro nao negativo: " );
        n = s.nextInt(); 
        System.out.println( Recursive.soma(n));


        /* Ex. 3:Menor elemento dum vector */
        System.out.println( "Ex. Maior elemento dum vector" );
        System.out.print( "Introduza um inteiro positivo (dimensao do vector): " );
        n = s.nextInt(); 
        System.out.print( "Introduza " + n
                + " inteiros (os elementos do vector): " );
        int[] v = new int[n]; 
        for( int i = 0; i < n; i++ ) {
            v[i] = s.nextInt(); 
        }
        s.nextLine();
        System.out.println( Recursive.menor( v ) );
        System.out.println();


        /* Ex. 4: Contagem de carateres */
        System.out.println( "Ex. Contagem de carateres" );
        System.out.print( "Introduza uma frase: " );
        String frase = s.nextLine();
        System.out.print( "Introduza um caracter a procurar: " );
        char c = (s.nextLine()).charAt(0);
        System.out.println( Recursive.countChar(frase, c));
        System.out.println();



        /* Ex. 5: Trocar Letras num String */
        System.out.println( "Ex. 5: Trocar Letras" );
        System.out.print( "Introduza uma frase: " );
        String frase5 = s.nextLine();
        System.out.print( "Introduza um caracter a trocar: " );
        char old = (s.nextLine()).charAt(0);
        System.out.print( "Introduza um caracter pelo qual quer trocar: " );
        char newer = (s.nextLine()).charAt(0);
        System.out.println( Recursive.change(frase5, old, newer));
        System.out.println();




        /* Ex. 6: Maior divisor comum */
        System.out.println( "Ex. 5: Maior divisor comum" );
        System.out.print( "Introduza dois inteiros positivos: " );
        int p, q; 
        p = s.nextInt();
        q = s.nextInt();
        System.out.println( Recursive.gcd(p, q) );
        System.out.println();


        /*  Ex. 7: Binomial */
        System.out.print( "Introduza dois inteiros positivos: " );
        int l, k; 
        l = s.nextInt();
        k = s.nextInt();
        System.out.println( Recursive.binomial(l, k) );
        System.out.println();


        s.close();
    }

}

