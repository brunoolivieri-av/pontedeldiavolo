package defaultpackage;

import NetGames.*;

public class Partida {
	

		protected Jogador vencedor;
		protected Tabuleiro tabuleiro;
		protected Jogador jogador1;
		protected Jogador jogador2;
		protected boolean cancelada;
		protected boolean conectado;
		protected boolean jogoEmAndamento;
		protected Jogador jogadorDaVez;

		public void terminarPartida() {
			// TODO - implement Partida.terminarPartida
			throw new UnsupportedOperationException();
		}

		public boolean isConectado() {
			return this.conectado;
		}

		
		public void estabeleceConectado(boolean conectado) {
			this.conectado = conectado;
		}

		public boolean isJogoEmAndamento() {
			return this.jogoEmAndamento;
		}
		
		public void tratarIniciarPartida(int posicao, String nome,String nomeOutro) {
			this.tabuleiro = new Tabuleiro();
			tabuleiro.inicializa();
			this.jogoEmAndamento = true;
			this.criarJogador(nome, posicao);
			int posicaoOutro = 1;
			if (posicao == 1)
				posicaoOutro = 2;
			this.criarJogador(nomeOutro, posicaoOutro);
			jogador1.assumirCor(Cor.BRANCO);
			jogador2.assumirCor(Cor.VERMELHO);
			this.jogadorDaVez = jogador1;
			jogador1.recebeVez();
		}
		
		public void criarJogador(String nome, int posicao) {
			//jogador 1 é sempre o primeiro a jogar
			if (posicao == 1) {
				jogador1 = new Jogador();
				jogador1.assumirNome(nome);
			} else {
				jogador2 = new Jogador();
				jogador2.assumirNome(nome);
			}
		}

		public void encerrarPartidaAndamento() {
			this.jogoEmAndamento = false;
		}

		/**
		 * 
		 * @param posicao
		 */
		public boolean posicionarQuadrado(Posicao posicao) {
			// TODO - implement Partida.posicionarQuadrado
			throw new UnsupportedOperationException();
		}

		public ImagemTabuleiro informarEstado() {
			// TODO - implement Partida.informarEstado
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param posicao1
		 * @param posicao2
		 */
		public boolean posicionaQuadrado(Posicao posicao1, Posicao posicao2) {
			// TODO - implement Partida.posicionaQuadrado
			throw new UnsupportedOperationException();
		}

		public void perdeVez() {
			// TODO - implement Partida.perdeVez
			throw new UnsupportedOperationException();
		}
		
		
		public int primOuSegQuad() {
			// TODO - implement Partida.primOuSegQuad
			throw new UnsupportedOperationException();
		}

		public void trocaVez() {
			// TODO - implement Partida.trocaVez
			throw new UnsupportedOperationException();
		}

		public boolean primeiroPosicionamentoVez() {
			// TODO - implement Partida.primeiroPosicionamentoVez
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param jogada
		 */
		public void receberJogada(Lance jogada) {
			jogada.ehQuadrado();
		}

		public boolean verificarSeRecJogFinVer() {
			// TODO - implement Partida.verificarSeRecJogFinVer
			throw new UnsupportedOperationException();
		}

		public boolean verificaSeSegJogadaDaPart() {
			// TODO - implement Partida.verificaSeSegJogadaDaPart
			throw new UnsupportedOperationException();
		}

		public void trocarCorJogadores() {
			// TODO - implement Partida.trocarCorJogadores
			throw new UnsupportedOperationException();
		}

		public boolean ehJogadaFinal() {
			// TODO - implement Partida.ehJogadaFinal
			throw new UnsupportedOperationException();
		}
		
		public boolean posicionaQuadrado(int linha, int coluna) {
			Cor cor = jogadorDaVez.informaCor();			
			boolean podePosicionar = this.tabuleiro.podePosicionarQuadrado(linha, coluna, cor);
			if(podePosicionar){
				this.tabuleiro.posicionarQuadrado(linha, coluna, cor);
				return true;		
			}
			else{
				return false; 
			}
		}
		
		public boolean posicionaPonte(int linha1, int coluna1, int linha2, int coluna2) {
			Cor cor = jogadorDaVez.informaCor();			
			boolean podePosicionar = this.tabuleiro.podePosicionarPonte(linha1, coluna1, linha2, coluna2, cor);
			if(podePosicionar){
				this.tabuleiro.posicionarPonte(linha1, coluna1, linha2, coluna2, cor);
				return true;		
			}
			else{
				return false; 
			}
		}

		public void fimDoPosicionamento() {
			this.trocaVez();			
		}

	}

