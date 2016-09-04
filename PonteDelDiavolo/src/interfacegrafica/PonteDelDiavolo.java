package interfacegrafica;

import javax.swing.JFrame;

public class PonteDelDiavolo {
	
	public static void main(String[] args) {
		InterfacePonteDelDiavolo janela;
		janela = new InterfacePonteDelDiavolo();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setVisible(true);
	}
}
