
public class Principal {

	public static void main(String[] args) {
		Perguntas p = new Perguntas();

		String[] s =  {"batata", "banana", "bacalhau"};

		System.out.println("{\"batata\", \"banana\", \"bacalhau\"}");

		System.out.println("Quantas vezes aparece a letra b no array");
		System.out.println(p.countVezes(s, 'b'));

		try {

			int[][] m = {{1,0,0,0},{0,1,0,0}, {0,0,1,0},{0,0,0,1}};

			p.imprimeMatriz(m);

			int[][] m1 = {{1,0,0},{0,1,0}, {0,0,0}};
			System.out.println();
			System.out.println("O array acima é identidade?");
			System.out.print(p.verificaMatrizIdentidade(m));
			p.imprimeMatriz(m1);
			System.out.println();
			System.out.println("O array acima é identidade?");
			System.out.println();

			System.out.println(p.verificaMatrizIdentidade(m1));
		} catch (MatrixIncorrectException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}


		int[][] m3 = {{1,2,3,4},{5,6,7,8}};
		System.out.println();
		p.imprimeMatriz(m3);
		System.out.println();

		int[][] m4 = p.transpose(m3);
		System.out.println();
		p.imprimeMatriz(m4);
		System.out.println();

	}

}


