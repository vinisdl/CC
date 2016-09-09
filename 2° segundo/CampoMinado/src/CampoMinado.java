public class CampoMinado
{
	private Interface inter;
	private int[][] tela;

	public CampoMinado()
	{
		//coloque seu codigo abaixo
		tela = new int[9][9];


		//nao mexa nas linhas abaixo
		inicializaTela();
		inter = new Interface();
		inter.setCampoMinado(this);
	}

	public void posicaoEscolhida(int linha, int coluna)
	{
		//coloque seu codigo abaixo

		if(tela[linha][coluna] == -1)
			inter.clicouBomba(tela);
		else if (tela[linha][coluna] != 0)
			inter.clicouNumero(linha, coluna, tela[linha][coluna]);
		else 
			inter.clicouVazio(linha, coluna, tela);

	}

	public void reinicia()
	{
		//coloque seu codigo abaixo
		tela = new int[9][9];


		//nao mexa nas linhas abaixo
		inicializaTela();
		inter = new Interface();
		inter.setCampoMinado(this);
	}


	public void inicializaTela()
	{
		//coloque seu codigo abaixo
		for (int i = 0; i < 10; i++) {
			int l = (int)(Math.random() * 9);
			int c = (int)(Math.random() * 9);
			if(tela[l][c] == 0)
				tela[l][c] = -1;
			else
				i--;
		}


		preencheNumeros();
		imprimeTela();	
	}


	private void preencheNumeros(){
		for (int i = 0; i < tela.length; i++) {
			for (int j = 0; j < tela[i].length ; j++) {
				if(tela[i][j] == -1)
					checaNumeros(i,j);
			}
		}
	}

	private void checaNumeros(int i, int j){
		if(i < 9 && i >= 0 && j < 9 && j >= 0) {     	            
			if(j+1 < 9)
				if(tela[i][j+1] != -1) 
					tela[i][j+1]++;

			if(i+1 < 9 && j+1 < 9)
				if(tela[i+1][j+1] != -1) 
					tela[i+1][j+1]++;

			if(i+1 < 9)
				if(tela[i+1][j] != -1) 
					tela[i+1][j]++;

			if(i+1 < 9 && j-1 >= 0)
				if(tela[i+1][j-1] != -1) 
					tela[i+1][j-1]++;

			if(j-1 >= 0)
				if(tela[i][j-1] != -1) 
					tela[i][j-1]++;

			if(i-1 >= 0 && j-1 >= 0)
				if(tela[i-1][j-1] != -1) 
					tela[i-1][j-1]++;

			if(i-1 >= 0)
				if(tela[i-1][j] != -1) 
					tela[i-1][j] ++;

			if(i-1 >= 0 && j+1 < 9)
				if(tela[i-1][j+1] != -1) 
					tela[i-1][j+1] ++;

		}
	}

	public void imprimeTela()
	{
		//coloque seu codigo abaixo

		System.out.println();
		for (int i = 0; i < tela.length; i++) {

			System.out.println("");
			System.out.print("L | ");
			for (int j = 0; j < tela[i].length; j++) {
				if(j == 0 && i == 0 ){
					String h = "";
					for (int j2 = 0; j2 < tela[i].length; j2++) 
						h += " C ";
					System.out.println(h);
					System.out.print("L | ");
				}
				String str = tela[i][j] + "";
				if(str.length() == 2)
					System.out.print(tela[i][j] + " ");
				else
					System.out.print(" " + tela[i][j] + " ");
			}
		}
	}


}