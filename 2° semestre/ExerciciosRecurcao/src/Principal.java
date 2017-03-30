import java.util.Random;
import java.time.LocalDate;
import Array.*;
public class Principal {
	public static void main(String[] args) {
		SequenciaPell sp = new SequenciaPell();
		System.out.println(sp.sequenciaPell(8));
		
		Exercicios ex = new Exercicios();
		ex.exercicio1();
		
		System.out.println("Exercicio2: " + ex.exercicio2(4));
		
		int[] a = Array.criaArrayRandom(5);
		
		System.out.println("Exercicop3: " + ex.exercicio3(a));
		Array.imprimeArray(a);
		
		System.out.println("Exercicio 4: " + ex.mdc(12, 6));
		
		System.out.println("Exercicio 5: Procura A na palavra Banana " + ex.procuraNaString("Banana", 'a'));
		System.out.println("Exercicio 5: Procura C na palavra Banana " + ex.procuraNaString("Banana", 'c'));
		
		Exercicios2 ex1 = new Exercicios2();
		double[] arr = {0,1,3,123.3,5};
		System.out.println("O maior valor do array é :"+ex1.maiorValor(arr));
		
		String[][] stringArr = new String[4][4];
		stringArr[0][1] = "bananaa";
		stringArr[0][0] = "banana";
		System.out.println("Exercicio 2");
		ex1.exercicio2(stringArr);
		
		int[][] a1 = Array.criaArrayBidimensionalRandom(5,5);
		Array.imprimeArrayBidimensional(a1, "Exercicio 3");
		System.out.println();
		System.out.println("Soma diagonal principal:" + ex1.somaDiagonal(a1));
		
		System.out.println();
		
		System.out.println("Soma diagonal secundário: "+ ex1.somaDiagonalSec(a1));
	
	
		System.out.println();
		
		Presidente[] pr = new Presidente[5];
		Random gerador = new Random();
		
		for (int i = 0; i < pr.length; i++) {
			pr[i] = new Presidente("Ladrão "+ i, gerador.nextInt(40), LocalDate.now(), i % 2 == 0 ? false: true);
		}
		
		System.out.println("Presidentes ladrões");
		System.out.println("Mais Novo: " + ex1.presidentesMaisNovoEPresidentesLadroes(pr));
		
	}
		
}
