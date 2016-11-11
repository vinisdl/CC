import java.io.*;

public class LeArquivo {
	private String[] sArr;
	private int[] iArr;

	public void leArquivo(String fileIn){
		try {
			FileReader fr = new FileReader(fileIn);
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			int countInt = 0;
			int countString = 0;
			while (line != null) {
				String[] split = line.split("-");
				
				for (int i = 0; i < split.length; i++) {
					try {
						int n = Integer.parseInt(split[i]);
						countInt++;
						int[] temp = iArr;
						iArr = new int[countInt];
						iArr[iArr.length -1] = n;						
						if(temp != null)
							for (int j = 0; j <= temp.length -1; j++) {
								iArr[j] = temp[j];
							}						
					} catch (Exception e) {
						countString++;
						String[] temp = sArr;
						sArr = new String[countString];
						sArr[sArr.length -1] = split[i];						
						if(temp != null)
							for (int j = 0; j <= temp.length -1; j++) {
								sArr[j] = temp[j];
							}					
					}
				}
				
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \""+fileIn+"\" não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura de " + fileIn+".");
		} 
	}


	public int textoComMaisVogais(){
		if(sArr == null)
			System.out.println("Não existem strings");
		return textoComMaisVogais(0, 0, 0);
	}
	
	private int textoComMaisVogais(int i, int pos, int count){
		if(i == sArr.length)
			return pos;
		char[] v = {'a','e','i','o','u'};
		int countInt = 0;
			for (int k = 0; k < sArr[i].length(); k++) {
				for (int j = 0; j < v.length; j++) {
					if(sArr[i].charAt(k) == v[j])
						countInt++;
				}
			}
			if(countInt >= count)
				return textoComMaisVogais(i+1, i, countInt);
			else if(count >= countInt)
				return textoComMaisVogais(i+1, pos, count);
			else 
				return pos;	
	}


	public String[] getsArr() {
		return sArr;
	}


	public int[] getiArr() {
		return iArr;
	}
	
	
}
