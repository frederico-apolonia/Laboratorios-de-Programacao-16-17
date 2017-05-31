import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Frederico Apolonia - 47892
 * @date 05/05/17
 */
public class Expressoes{

	/**
	 * @param args os argumentos do programa
	 * @throws IOException, FileNotFoundException
	 */
	public static void main(String[] args) throws IOException, FileNotFoundException {
		//o padroes a procurar
		Pattern padrao1;
		Pattern padrao2;  
		Pattern padrao3;
		Pattern padrao4;
		Pattern padrao5;
		Pattern padrao6;
		Pattern padrao7;
		Pattern padrao8;
		Pattern padrao9;
		Pattern padrao10;
		Pattern padrao11;
		Pattern padrao12;
		Pattern padrao13;
		Pattern padrao14;
		Pattern padrao15;
		Pattern padrao17;
		Pattern padrao18;
		//o matcher para cada padrao
		Matcher matcher1;  
		Matcher matcher2;
		Matcher matcher3;
		Matcher matcher4;
		Matcher matcher5;
		Matcher matcher6;
		Matcher matcher7;
		Matcher matcher8;
		Matcher matcher9;
		Matcher matcher10;
		Matcher matcher11;
		Matcher matcher12;
		Matcher matcher13;
		Matcher matcher14;
		Matcher matcher15;
		Matcher matcher17;
		Matcher matcher18;
		Scanner sc = new Scanner( new BufferedReader(
				new FileReader("texto.txt")) );
		BufferedWriter outF = new BufferedWriter( new FileWriter("output1.txt"));

		String line;
		//padrao para multibanco
		padrao1 = Pattern.compile("\\d{4}");
		//padrao para telefones
		padrao2 = Pattern.compile("((00351)\\d{9}|([+]351)\\d{9})");
		//padrao para numero de telemovel pt
		padrao3 = Pattern.compile("((91)\\d{7}|(92)\\d{7}|(93)\\d{7}|(96)\\d{7}|)");
		//nome com apelido de uma pessoa
		padrao4 = Pattern.compile("[A-Z]\\w{2,}\\s([A-Z]\\w{2,})?");
		//ficheiro zip || rar
		padrao5 = Pattern.compile("(\\w{1,}[.](zip)|\\w{1,}[.](rar))");
		/* nome var em java
		 * Comeca com uma palavra com letras minusculas, de seguida, palavra com letras
		 * minusculas e letras maiusculas a seguir
		 */
		padrao6 = Pattern.compile("(([a-z0-9]{1,}[A-Z]([a-z0-9]){1,}){1,})|([a-z]{1,})");
		//nome classe em java
		padrao7 = Pattern.compile("(([A-Z][a-z0-9]){1,})");
		//comentario simples em java
		padrao8 = Pattern.compile("//(\\w{1,})|//\\s(\\w{1,})|//\\s((\\w{1,}\\s)|(\\w{1,}))");
		//operador aritmetico
		padrao9 = Pattern.compile("[+]|-|[*]|/");
		//operador logico
		padrao10 = Pattern.compile("&&|(\\|\\|)");
		//possivel ip
		padrao11 = Pattern.compile("\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}");
		//credencial aluno fcul
		padrao12 = Pattern.compile("fc\\d{5}");
		//data no formato DD-MM-YYYY
		padrao13 = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
		//matricula pt
		padrao14 = Pattern.compile("(([A-Z]){2}-([A-Z]){2}-([0-9]){2})|(([0-9]){2}-([A-Z]){2}-([A-Z]){2})|(([A-Z]){2}-([0-9]){2}-([A-Z]){2})");
		//valor monetario €€ ou $$
		padrao15 = Pattern.compile("\\d{1,}([.]\\d{2})?€|\\$\\d{1,}([.]\\d{2})?");
		//sem pontuacao, so ponto final .
		padrao17 = Pattern.compile("(\\w{1,}\\s){0,}\\w{1,}[.]");
		//email
		padrao18 = Pattern.compile("\\w{1,}@\\w{1,}[.]\\w{1,3}([.]\\w{1,3})?");

		//conta numeros
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
		int count6 = 0, count7 = 0, count8 = 0, count9 = 0, count10 = 0;
		int count11 = 0, count12 = 0, count13 = 0, count14 = 0, count15 = 0;
		int count16 = 0, count17 = 0, count18 = 0;
		while (sc.hasNext()) {
			line =sc.nextLine();
			matcher1 = padrao1.matcher(line);
			if (matcher1.matches()) {
				// para ver onde esta o match
				System.out.println(matcher1);
				count1++;
			}
			matcher2 = padrao2.matcher(line);
			if (matcher2.matches()) {
				// para ver onde esta o match
				System.out.println(matcher2);
				count2++;
			}
			matcher3 = padrao3.matcher(line);
			if (matcher3.matches()) {
				// para ver onde esta o match
				System.out.println(matcher3);
				count3++;
			}
			matcher4 = padrao4.matcher(line);
			if (matcher4.matches()) {
				// para ver onde esta o match
				System.out.println(matcher4);
				count4++;
			}
			matcher5 = padrao5.matcher(line);
			if (matcher5.matches()) {
				// para ver onde esta o match
				System.out.println(matcher5);
				count5++;
			}
			matcher6 = padrao6.matcher(line);
			if (matcher6.matches()) {
				// para ver onde esta o match
				System.out.println(matcher6);
				count6++;
			}
			matcher7 = padrao7.matcher(line);
			if (matcher7.matches()) {
				// para ver onde esta o match
				System.out.println(matcher7);
				count7++;
			}
			matcher8 = padrao8.matcher(line);
			if (matcher8.matches()) {
				// para ver onde esta o match
				System.out.println(matcher8);
				count8++;
			}
			matcher9 = padrao9.matcher(line);
			if (matcher9.matches()) {
				// para ver onde esta o match
				System.out.println(matcher9);
				count9++;
			}
			matcher10 = padrao10.matcher(line);
			if (matcher10.matches()) {
				// para ver onde esta o match
				System.out.println(matcher10);
				count10++;
			}
			matcher11 = padrao11.matcher(line);
			if (matcher11.matches()) {
				// para ver onde esta o match
				System.out.println(matcher11);
				count11++;
			}
			matcher12 = padrao12.matcher(line);
			if (matcher12.matches()) {
				// para ver onde esta o match
				System.out.println(matcher12);
				count12++;
			}
			matcher13 = padrao13.matcher(line);
			if (matcher13.matches()) {
				// para ver onde esta o match
				System.out.println(matcher13);
				count13++;
			}
			matcher14 = padrao14.matcher(line);
			if (matcher14.matches()) {
				// para ver onde esta o match
				System.out.println(matcher14);
				count14++;
			}
			matcher15 = padrao15.matcher(line);
			if (matcher15.matches()) {
				// para ver onde esta o match
				System.out.println(matcher15);
				count15++;
			}
			matcher17 = padrao17.matcher(line);
			if (matcher17.matches()) {
				// para ver onde esta o match
				System.out.println(matcher17);
				count17++;
			}
			matcher18 = padrao18.matcher(line);
			if (matcher18.matches()) {
				// para ver onde esta o match
				System.out.println(matcher18);
				count18++;
			}
			

		}
		outF.write("ha "+ count1 +" possiveis numeros de multibanco\n");
		outF.write("ha "+ count2 +" possiveis numeros de telefone\n");
		outF.write("ha "+ count3 +" possiveis numeros de telemovel pt\n");
		outF.write("ha "+ count4 +" possiveis nomes c/ apelido\n");
		outF.write("ha "+ count5 +" possiveis ficheiros zip ou rar\n");
		outF.write("ha "+ count6 +" possiveis variaveis java\n");
		outF.write("ha "+ count7 +" possiveis classes java\n");
		outF.write("ha "+ count8 +" possiveis comentarios\n");
		outF.write("ha "+ count9 +" possiveis operadores binarios\n");
		outF.write("ha "+ count10 +" possiveis operadores logicos binarios\n");
		outF.write("ha "+ count11 +" possiveis ips\n");
		outF.write("ha "+ count12 + " possiveis credencial fcul");
		outF.write("ha "+ count13 + " possiveis datas");
		outF.write("ha "+ count14 + " possiveis matriculas");
		outF.write("ha "+ count15 + " possiveis valores monetarios");
		
		outF.write("ha "+ count18 + " possiveis emails");
		
		outF.close();
		sc.close();
	}
}
