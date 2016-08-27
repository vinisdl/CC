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
	}
}
