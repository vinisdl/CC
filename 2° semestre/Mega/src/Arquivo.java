import java.io.*;


public class Arquivo {
	private File f;
	int linha;
	public Arquivo(String nome){
		try {
			f = new File(nome);
		catch (Exception e) {
			System.out.println ("Erro ao criar o arquivo.");
		}
	}

	public void escreveArquivo(String texto, boolean ln){
		try {

			FileOutputStream out = new FileOutputStream(f);
			PrintStream ps = new PrintStream(out);
			if(ln)
				ps.println (texto);
			else 
				ps.print(texto);
			System.out.println ("Pronto!!");
			ps.close();
		}
		catch (IOException e) {
			System.out.println ("Erro ao escrever arquivo.");
		}
	}
}
