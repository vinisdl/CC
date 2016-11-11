import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class InverteArquivoJava {
	public static void main(String[] args) {
		InverteArquivoJava a = new InverteArquivoJava();
		a.InverteArquivoJava();
	}
	
	
	public void InverteArquivoJava(){		
		try{
			
			File file = new File("ArrayListClass.java");
			FileReader fr = new FileReader(file);
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			boolean pr = false;
			ArrayList<String> guarda = new ArrayList<String>();
			Stack<ArrayList<String>> metodos = new StaticStack<ArrayList<String>>(Integer.MAX_VALUE);
			
			while (line != null) {
				if(!pr){
					guarda.add(line);
				}else if(!pr && line.contains("public class")){
					pr = false;
					guarda.add(line);
				}else {
					if(line.contains("public") && line.contains("(") && line.contains("){")){
						boolean temMais = true;
						int abriu = 0;
						int fexou = 0;
						ArrayList<String> metodo = new ArrayList<String>();
						while(temMais && line != null &&  abriu > fexou ){
							metodo.add(line);
							if(line.contains("{")){
								abriu++;
							}
							if(line.contains("}")){
								fexou++;
							}										
						}
						metodos.push(metodo);
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}	
}
