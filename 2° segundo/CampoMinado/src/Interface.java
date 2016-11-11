import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface implements ActionListener
{
    private JButton botao[][], denovo;
    private ImageIcon imgBomba, imgVazio, imgNumeros[], imgInicio;
    private JLabel titulo, restam;
    private CampoMinado campo;
    private JFrame janela;
    
    public Interface()
    {   
        janela = new JFrame("Campo Minado");
        
        janela.setLayout(null);
        janela.setSize(215,320);
        janela.setResizable(false);
        janela.setLocation(200, 200);
        
        denovo = new JButton("Jogar denovo");
        denovo.addActionListener(this);
        denovo.setBounds(47, 260, 116, 17);
        janela.getContentPane().add(denovo);
        
        botao = new JButton[9][9];
        imgBomba = new ImageIcon(getClass().getResource("bomba.jpg"));
        imgVazio = new ImageIcon(getClass().getResource("vazio.jpg"));
        imgNumeros = new ImageIcon[8];
        for(int i=0; i<8; i++)
            imgNumeros[i] = new ImageIcon(getClass().getResource((i+1)+".jpg"));
        imgInicio = new ImageIcon(getClass().getResource("inicio.jpg"));
        titulo = new JLabel("Campo Minado");
        titulo.setBounds(62, 10, 100, 20);
        janela.getContentPane().add(titulo);
        
        restam = new JLabel("Existem 10 bombas!");
        restam.setBounds(47, 235, 150, 20);
        janela.getContentPane().add(restam);
            
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                botao[i][j] = new JButton();
                botao[i][j].setBounds(10 + (j*21), 40 + (i*21), 20, 20);
                botao[i][j].setBorderPainted(true);
                botao[i][j].addActionListener(this);
                botao[i][j].setIcon(imgInicio);
                janela.getContentPane().add(botao[i][j]);
            }
        }
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
        
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++)
                if( e.getSource() == botao[i][j])
                        campo.posicaoEscolhida(i, j);
        if(e.getSource() == denovo){
            janela.dispose();
            setCampoMinado(new CampoMinado());
        }
            
    }
    
    public void setCampoMinado(CampoMinado campo){
        this.campo = campo;
    }
    
    public void clicouVazio(int linha, int coluna, int tela[][])
    {
        int aux[][] = new int[9][9];
        
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++)
                aux[i][j] = tela[i][j];
        
        boolean branco[][] = new boolean[9][9];
        
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++)
                branco[i][j] = false;
                
        procuraVazios(linha, coluna, aux, branco);
                
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++)
                if(branco[i][j])
                    botao[i][j].setIcon(imgVazio);
                    
        if(ganhou())
            fim();
            
        janela.repaint();
    }
    
    public void clicouNumero(int linha, int coluna, int numero)
    {
        botao[linha][coluna].setIcon(imgNumeros[numero-1]);
        if(ganhou())
            fim();
        janela.repaint();
    }
    
    public void clicouBomba(int tela[][]) //0 = vazio, -1 = bomba, numero = numero
    {   
        int numero = 0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(tela[i][j] == 0)
                    botao[i][j].setIcon(imgVazio);
                else if(tela[i][j] == -1)
                    botao[i][j].setIcon(imgBomba);
                else{
                    numero = tela[i][j];
                    botao[i][j].setIcon(imgNumeros[numero-1]);
                }
            }
        }
        restam.setText("       Voc perdeu!   ");
        
        janela.repaint();
    }
    
    private boolean ganhou()
    {
        int cont = 0;
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++)
                if(botao[i][j].getIcon().equals(imgInicio))
                    cont++;
        if(cont == 10)
            return true;
        else
            return false;
    }
    
    private void fim()
    {
        for(int i=0; i<9; i++)
            for(int j=0; j<9; j++)
                if(botao[i][j].getIcon().equals(imgInicio))
                    botao[i][j].setEnabled(false);
        restam.setText("       Voc ganhou!   ");
        janela.repaint();
    }
    
    private void procuraVazios(int i, int j, int aux[][], boolean branco[][]) //procurar vazios em volta de um vazio
    {
        if(i < 9 && i >= 0 && j < 9 && j >= 0) {
            branco[i][j] = true; //i, j é branco        
            
            if(j+1 < 9)
                if(aux[i][j+1] == 0) //eh branco
                {
                    aux[i][j+1] = -1;
                    branco[i][j+1] = true; //coloca branco no branco
                    procuraVazios(i, j+1, aux, branco);
                }
    
            if(i+1 < 9 && j+1 < 9)
                if(aux[i+1][j+1] == 0)
                {
                    aux[i+1][j+1] = -1;
                    branco[i+1][j+1] = true; //coloca branco no branco
                    procuraVazios(i+1, j+1, aux, branco);
                }
            
            if(i+1 < 9)
                if(aux[i+1][j] == 0)
                {
                    aux[i+1][j] = -1;
                    branco[i+1][j] = true; //coloca branco no branco
                    procuraVazios(i+1, j, aux, branco);
                }
    
            if(i+1 < 9 && j-1 >= 0)
                if(aux[i+1][j-1] == 0)
                {
                    aux[i+1][j-1] = -1;
                    branco[i+1][j-1] = true; //coloca branco no branco
                    procuraVazios(i+1, j-1, aux, branco);
                }
            
            if(j-1 >= 0)
                if(aux[i][j-1] == 0)
                {
                    aux[i][j-1] = -1; 
                    branco[i][j-1] = true; //coloca branco no branco
                    procuraVazios(i, j-1, aux, branco);
                }
            
            if(i-1 >= 0 && j-1 >= 0)
                if(aux[i-1][j-1] == 0)
                {
                    aux[i-1][j-1] = -1;
                    branco[i-1][j-1] = true; //coloca branco no branco
                    procuraVazios(i-1, j-1, aux, branco);
                }
                
            if(i-1 >= 0)
                if(aux[i-1][j] == 0)
                {
                    aux[i-1][j] = -1;
                    branco[i-1][j] = true; //coloca branco no branco
                    procuraVazios(i-1, j, aux, branco);
                }
                    
            if(i-1 >= 0 && j+1 < 9)
                if(aux[i-1][j+1] == 0)
                {
                    aux[i-1][j+1] = -1;
                    branco[i-1][j+1] = true; //coloca branco no branco
                    procuraVazios(i-1, j+1, aux, branco);
                }
        }
    }
}