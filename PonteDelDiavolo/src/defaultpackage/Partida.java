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

		/**
		 * 
		 * @param posicao
		 */
		public void tratarIniciarPartida(int posicao) {
			// TODO - implement Partida.tratarIniciarPartida
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param nome
		 */
		public void criarJogador(string nome) {
			// TODO - implement Partida.criarJogador
			throw new UnsupportedOperationException();
		}

		public void encerrarPartidaAndamento() {
			// TODO - implement Partida.encerrarPartidaAndamento
			throw new UnsupportedOperationException();
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

		/**
		 * 
		 * @param linha1
		 * @param coluna1
		 * @param linha2
		 * @param colina2
		 */
		public int posicionaPonte(int linha1, int coluna1, int linha2, int colina2) {
			// TODO - implement Partida.posicionaPonte
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
			// TODO - implement Partida.receberJogada
			throw new UnsupportedOperationException();
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

		/**
		 * 
		 * @param linha
		 * @param coluna
		 */
		public int posicionaQuadrado(int linha, int coluna) {
			// TODO - implement Partida.posicionaQuadrado
			throw new UnsupportedOperationException();
		}

	}

