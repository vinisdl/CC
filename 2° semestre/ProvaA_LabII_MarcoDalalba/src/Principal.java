
public class Principal {
	
	public static void main(String[] args) {
		CriaArquivo c = new CriaArquivo();
		c.insereConteudo("batata.txt", 10);
		
		LeArquivo l = new LeArquivo();
		l.leArquivo("batata.txt");
		int pos = l.textoComMaisVogais();
		System.out.println("Possição string com mais vogais:" + pos);
		
		System.out.println(l.getsArr()[pos]);
	}
	
}
