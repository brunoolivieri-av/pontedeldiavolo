package interfacegrafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import defaultpackage.Cor;
import defaultpackage.Posicao;


public class InterfacePonteDelDiavolo extends JFrame{
	
		protected AtorJogador atorJog;
		protected JPanel jContentPane;
		protected JLabel mensagem;
		protected JMenu menu;
		protected JMenuBar menuBar;
		protected JMenuBar menuItemConectar;
		protected JMenuItem MenuItemIniciar;
		protected JMenuItem menuItemDesconectar;
		protected JLabel mapaPosicao[][] = new JLabel[10][10];
		private boolean emPosicionamentoQuadrado = false;
		private boolean emPosicionamentoPonte = false;

		public void conectar() {
			int resultado = atorJog.conectar();
			this.notifica(resultado);
		}

		public String solicitaIdJogador() {
			String nome = "jogador";
			nome = JOptionPane.showInputDialog(this, ("Insira o nome do jogador"));
			return nome;
		}

		public String solicitaIdServidor() {
			String idServidor = ("venus.inf.ufsc.br");
			idServidor = JOptionPane.showInputDialog(this,("Insira o endereco do servidor. Se servidor local escreva localhost"), idServidor);
			return idServidor;
		}

		public void desejaIniciarPartida() {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja iniciar partida?");
			if (resposta == 0)
				confirmaInicioPartida();
			else
				cancelaInicioPartida();
		}

		public void confirmaInicioPartida() {
			iniciarPartida();
		}
		
		public void cancelaInicioPartida() {
			int resultado = atorJog.cancelaInicioPartida();
			this.notifica(resultado);
		}

		

		/**
		 * 
		 * @param resultado
		 */
		public void notifica(int resultado) {
			switch (resultado) {
			case 0: JOptionPane.showMessageDialog(this, "Conexao ja estabelecida anteriormente"); break;
			case 1:	JOptionPane.showMessageDialog(this, "Falha ao tentar conectar."); break;
			case 2:	JOptionPane.showMessageDialog(this, "Exito em efetuar conexao"); break;
			case 3:	JOptionPane.showMessageDialog(this, "Cancelado iniciar partida"); break;
			case 4:	JOptionPane.showMessageDialog(this,	"Nao ha conexao para iniciar partida");	break;
			//case 5:	JOptionPane.showMessageDialog(this, "Exito em iniciar partida"); break;
			//case 6:	JOptionPane.showMessageDialog(this, "Posicao selecionada sem peca"); break;
			//case 7:	JOptionPane.showMessageDialog(this,	"Peca invalida \nPeca do oponente"); break;
			//case 10: JOptionPane.showMessageDialog(this, "Movimento invalido \n Ha peca no caminho"); break;
			//case 11: JOptionPane.showMessageDialog(this, "Partida chegou ao fim com derrota"); break;
			//case 12: JOptionPane.showMessageDialog(this, "Partida chegou ao fim com vitoria"); break;
			//case 13: JOptionPane.showMessageDialog(this, "Partida chegou ao fim com empate"); break;
			case 14: JOptionPane.showMessageDialog(this, "Desconexao com exito"); break;
			case 15: JOptionPane.showMessageDialog(this, "Desconexao sem conexao estabelecida"); break;
			case 16: JOptionPane.showMessageDialog(this, "Desconexao falhou"); break;		
			//case 17: JOptionPane.showMessageDialog(this, "Eh sua vez"); break;
			case 18: JOptionPane.showMessageDialog(this, "Nao eh sua vez\nAguarde o lance do outro jogador"); break;
			//case 19: JOptionPane.showMessageDialog(this, "Passou a vez!"); break;
			case 20: JOptionPane.showMessageDialog(this, "Partida nao iniciada"); break;
			case 21: JOptionPane.showMessageDialog(this, "Clique na posição desejada para posicionar primeiro quadrado"); break;
			case 22: JOptionPane.showMessageDialog(this, "Primeiro quadrado posicionado com sucesso! \nClique na posição desejada para posicionar segundo quadrado"); break;
			case 23: JOptionPane.showMessageDialog(this, "Segundo quadrado posicionado com sucesso! \nFim da vez");break;
			case 24: JOptionPane.showMessageDialog(this, "Posicionamento inválido");break;
			case 25: JOptionPane.showMessageDialog(this, "Clique em duas posições para posicionar uma ponte entre elas"); break;
			case 26: JOptionPane.showMessageDialog(this, "Ponte posicionada com sucesso! \nFim da vez"); break;
			}
		}

		public void iniciarPartida() {
			int resultado = atorJog.iniciarPartida();
			if(resultado == 4)
				this.notifica(resultado);
		}

		public void desconectar() {
			int resultado = atorJog.desconectar();
			this.notifica(resultado);
		}

		/**
		 * 
		 * @param estado
		 */
		public void exibirEstado() {
			//TODO
			ImagemTabuleiro estado = atorJog.informarEstado();
			atualizaTela(estado);
		}

		/**
		 * 
		 * @param corPeca
		 */
		public void habilitarQuadradoParaSelecao(Cor corPeca) {
			// TODO - implement InterfacePonteDelDiavolo.habilitarQuadradoParaSelecao
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param pecaSelecionada
		 */
		public void selecionaPeca(Peca pecaSelecionada) {
			// TODO - implement InterfacePonteDelDiavolo.selecionaPeca
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param posicaoSelecionada
		 */
		public void selecionaPosicao(Posicao posicaoSelecionada) {
			// TODO - implement InterfacePonteDelDiavolo.selecionaPosicao
			throw new UnsupportedOperationException();
		}

		public void selecionarQuadrado() {
			// TODO - implement InterfacePonteDelDiavolo.selecionarQuadrado
			throw new UnsupportedOperationException();
		}

		public void informarPosicionamentoInvalido() {
			// TODO - implement InterfacePonteDelDiavolo.informarPosicionamentoInvalido
			throw new UnsupportedOperationException();
		}

		public void selecionaPonte() {
			// TODO - implement InterfacePonteDelDiavolo.selecionaPonte
			throw new UnsupportedOperationException();
		}

		public void desabilitaSelecao() {
			// TODO - implement InterfacePonteDelDiavolo.desabilitaSelecao
			throw new UnsupportedOperationException();
		}

		public void posicionaQuadrado() {
			// clique do mouse no botão de posicionar quadrado
			// TODO fazer métodos que chamem este com o listener
			int resultado = atorJog.posicionaQuadrado();
			// 20 - partida não iniciada, 18 - não é a vez do jogador
			// 21 - Clique na posição desejada para posicionar primeiro quadrado
			if(resultado = 21){
				this.emPosicionamentoQuadrado  = true;
			}
			this.notifica(resultado);
		}
		
		public void posicionaQuadrado(int linha, int coluna) {
			if(emPosicionamentoQuadrado){
				int resultado = atorJog.posicionaQuadrado(linha, coluna);
				if(resultado == 23){
					emPosicionamentoQuadrado = false;
				}
				notifica(resultado);
			}	
		}
		
		public void posicionaPonte() {
			// clique do mouse no botão de posicionar ponte
			// TODO fazer métodos que chamem este com o listener
			int resultado = atorJog.posicionaPonte();
			// 20 - partida não iniciada, 18 - não é a vez do jogador
			// 25 - Clique em duas posições para posicionar uma ponte entre elas
			if(resultado == 25){
				this.emPosicionamentoPonte  = true;
			}
				this.notifica(resultado);
		}
		
		public int posicionaPonte(int linha1, int coluna1, int linha2, int coluna2) {
			if(emPosicionamentoPonte){
				int resultado = atorJog.posicionaPonte(linha1, coluna1, linha2, coluna2);
				if(resultado == 26){
					emPosicionamentoQuadrado = false;
				}
				notifica(resultado);
			}
		}

		/**
		 * 
		 * @param jogada
		 */
		public void receberJogada(Jogada jogada) {
			// TODO - implement InterfacePonteDelDiavolo.receberJogada
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param pontos
		 */
		public void exibePontos(int[2] pontos) {
			// TODO - implement InterfacePonteDelDiavolo.exibePontos
			throw new UnsupportedOperationException();
		}

		public boolean perguntaSeQuerTerminar() {
			// TODO - implement InterfacePonteDelDiavolo.perguntaSeQuerTerminar
			throw new UnsupportedOperationException();
		}

		public void informaEhVez() {
			// TODO - implement InterfacePonteDelDiavolo.informaEhVez
			throw new UnsupportedOperationException();
		}

		public void habilitaPecasBrnancasParaSelecao() {
			// TODO - implement InterfacePonteDelDiavolo.habilitaPecasBrnancasParaSelecao
			throw new UnsupportedOperationException();
		}

		public Cor escolheCor() {
			// TODO - implement InterfacePonteDelDiavolo.escolheCor
			throw new UnsupportedOperationException();
		}

		public void habilitaPecasVermelhasParaSelecao() {
			// TODO - implement InterfacePonteDelDiavolo.habilitaPecasVermelhasParaSelecao
			throw new UnsupportedOperationException();
		}

		public void habilitaTabuleiroParaSelecao() {
			// TODO - implement InterfacePonteDelDiavolo.habilitaTabuleiroParaSelecao
			throw new UnsupportedOperationException();
		}

		public void habilitarPonteVermelhaPSel() {
			// TODO - implement InterfacePonteDelDiavolo.habilitarPonteVermelhaPSel
			throw new UnsupportedOperationException();
		}


		public void desabilitaTabuleiro() {
			// TODO - implement InterfacePonteDelDiavolo.desabilitaTabuleiro
			throw new UnsupportedOperationException();
		}

		
		

	}
}
