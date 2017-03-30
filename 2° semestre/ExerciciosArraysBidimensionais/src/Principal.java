import java.util.Random;

public class Principal {
	public static void main(String[] args){
		Exercicios a = new Exercicios();
		
		a.Exercicio1();
		a.exercicio2();
		
		System.out.println("Exercicio 7");
		Random gerador = new Random();
		double[][] arrDouble = new double[3][3];
		int[][] arrInt = new int[3][3];
		for (int i = 0; i < arrDouble.length; i++) {
			for (int j = 0; j < arrDouble[i].length; j++) {
				arrDouble[i][j] = gerador.nextDouble() * 10;
				arrInt[i][j] = gerador.nextInt(100);
			}
		}
		
		System.out.println("O maior valor é: " +  a.exercicio7(arrDouble));
		
		System.out.println("Exercicio 8");
		
		System.out.println("A soma de todos elementos é " + a.exercicio8(arrInt));
		
		
		System.out.println("Exercicio 9");
		a.exercicio9(arrInt, gerador.nextInt(2));
		
		
	}
}
