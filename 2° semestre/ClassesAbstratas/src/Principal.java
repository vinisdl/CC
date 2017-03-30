import java.util.Random;

public class Principal {
	public static void main(String[] args) {
		Random r = new Random();
		
		Figura[] f = new Figura[3];
		
		f[0] = new Retangulo("Preto", 2, 3);
		f[1] = new Circulo("Amarelo", 10);
		f[2] = new Triangulo("Azul", 10, 5, 8, 8);
	
		
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i].toString());
		}
	}
	
}
