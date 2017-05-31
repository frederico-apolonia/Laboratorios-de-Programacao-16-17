/**
 * 
 * @author Frederico Apolonia - nº47892
 *
 */
public class Recursive {

    /**
     * Calcula a potencia n de um numero x
     * @param x - base
     * @param n - expoente
     * @return x ^ n
     */
    public static double potencia(int x, int n) {
        if(n == 0)
            return 1;
        else
            return x * potencia(x, n - 1);
    }

    /**
     * Calcula a soma dos numeros pares ate n
     * @param n - numero "maximo"
     * @return soma dos pares ate n
     */
    public static int soma(int n) {
        if(n == 0)
            return 0;
        else if(n % 2 == 0)
            return n + soma(n - 1);
        else
            return soma(n - 1);
    }

    /**
     * Calcula o menor valor num array
     * @param v - array cujo qual se pretende obter o menor valor
     * @return menor valor do array
     */
    public static int menor(int[] v) {

        return menorVetor(v, 0, Integer.MAX_VALUE);
    }

    /**
     * Funcao auxiliar para calcular o menor valor num array
     * @param v - array
     * @param i - indice
     * @param min - valor minimo
     * @return valor minimo
     */
    private static int menorVetor(int[] v, int i, int min) {

        if(i == v.length)
            return min;
        else if(v[i] < min)
            return menorVetor(v, i+1, v[i]);
        else
            return menorVetor(v, i+1, min);
    }

    /**
     * Calcula o numero de vezes que aparece um caracter numa string
     * @param frase - string a verificar os caracteres
     * @param c - caracter a verificar
     * @return - numero de vezes que c aparece em frase
     */
    public static int countChar(String frase, char c) {

        return countCharAUX(frase, c, 0);
    }

    /**
     * Funcao auxiliar para contar o numero de vezes que aparece um caracter
     * @param frase - string a verificar os caracteres
     * @param c - caracter a verificar
     * @param index - indice corrente
     * @return numero de vezes que aparece c em frase
     */
    private static int countCharAUX(String frase, char c, int index) {
        if (index == frase.length())
            return 0;

        else if (frase.charAt(index) == c)
            return 1 + countCharAUX(frase, c, index + 1);

        else
            return countCharAUX(frase, c, index + 1);
    }

    /**
     * Altera todos os caracteres iguaiqs a um dado por um novo
     * @param frase - string a verificar
     * @param old - caracter a substituir
     * @param newer - novo caracter
     * @return - string com os caracteres substituidos
     */
    public static String change(String frase, char old, char newer) {
        StringBuilder sb = new StringBuilder(frase);
        return changeAUX (sb, old, newer, 0);
    }
    
    /**
     * Funcao auxiliar para alterar os caracteres iguais
     * @param sb - permite alterar os caracteres
     * @param old - caracter a substituir
     * @param newer - novo caracter
     * @param index - indice corrente
     * @return - string com os caracteres substituidos
     */
    private static String changeAUX(StringBuilder sb, char old, char newer, int index) {

        if(index == sb.length())
            return sb.toString();
        else if(sb.charAt(index) == old){
            sb.setCharAt(index, newer);
            return changeAUX(sb, old, newer, index + 1);
        }
        else
            return changeAUX(sb, old, newer, index + 1);

    }
    
    /**
     * Calcula o maior divisor comum entre dois caracteres
     * @param p - numero 1
     * @param q - numero 2
     * @return - maior divisor comum
     */
    public static int gcd(int p, int q) {
        if(q == 0)
            return p;
        if(p >= q)
            return gcd(q, p % q);
        else
            return q % p;
    }

    /**
     * Calcula as combinacoes l k a k 
     * @param l
     * @param k
     * @return Combinacoes l k a k
     */
    public static int binomial(int l, int k) {
        
        if(l == k)
            return 1;
        if( k > l || l == 0)
            return 0;
        else
            return binomial(l-1, k) + binomial(l-1, k-1);

    }

}
