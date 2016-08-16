package defaultpackage;

import javax.swing.JPanel;

import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import NetGames.AtorNetGames;


public class InterfaceGrafica extends JFrame {
	
	protected AtorJogador jogo;

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	protected boolean emRede = false;
	
	private void initialize() {
		this.setSize(610, 680);
		this.setContentPane(getJContentPane());
		this.setTitle("Reversi");
		jogo = new AtorJogador(this);
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
		
		}
		return null;
	}

	public void notificarResultado(int codigo) {
		switch (codigo) {
    		case 0:  JOptionPane.showMessageDialog(this, "Conexão efetuada com exito"); break;        	
    		case 1:  JOptionPane.showMessageDialog(this, "Tentativa de conexão com conexão previamente estabelecida"); break;
        	case 2:  JOptionPane.showMessageDialog(this, "Tentativa de conexao falhou"); break;
        	case 3:  JOptionPane.showMessageDialog(this, "Desonexão efetuada com exito"); break;
        	case 4:  JOptionPane.showMessageDialog(this, "Tentativa de desconexao sem conexao previamente estabelecida"); break;
        	case 5:  JOptionPane.showMessageDialog(this, "Tentativa de desconexao falhou"); break;
        	case 6:  JOptionPane.showMessageDialog(this, "Solicitação de inicio procedida com êxito"); break;
        	case 7:  JOptionPane.showMessageDialog(this, "Tentativa de inicio sem conexao previamente estabelecida"); break;
        	case 8:  JOptionPane.showMessageDialog(this, "Não é a sua vez"); break;
        	case 9:  JOptionPane.showMessageDialog(this, "Partida encerrada"); break;
        	case 10: JOptionPane.showMessageDialog(this, "Lance OK"); break;
        	case 11: JOptionPane.showMessageDialog(this, "Posição ocupada"); break;
        	case 12: JOptionPane.showMessageDialog(this, "Posição ilegal"); break;
        	case 13: JOptionPane.showMessageDialog(this, "Partida corrente não interrompida"); break;
		};
	}
}
