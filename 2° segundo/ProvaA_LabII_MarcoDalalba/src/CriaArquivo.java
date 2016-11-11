import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

public class CriaArquivo {
	public void insereConteudo(String fileOut, int numLinhas){
		String[] lore =  {"b" ,"a", "t", "a","t", "a"};
		try {
			File f = new File(fileOut);
			FileOutputStream out = new FileOutputStream(f);
			PrintStream ps = new PrintStream(out);
			Random gerador = new Random();
			if(numLinhas != 0)
				for (int i = 0; i < numLinhas; i++) {
					int n;
					do{
						n = gerador.nextInt(2);
						if(n == 0){
							n = gerador.nextInt(30);
							if(n == 0){
								ps.print(n);
								ps.println();
							} else {
								ps.print(n + "-");
							}
						} else if(n == 1) {
							
							String  s = "";
							for (int j = 0; j <(gerador.nextInt(9) + 1); j++) {
								s += lore[gerador.nextInt(5)];
							}						
							ps.print(s + "-");
						}			
					}while(n != 0);
				}

			ps.close();
		}
		catch (IOException e) {
			System.out.println ("Erro.");
		}


	}
}
