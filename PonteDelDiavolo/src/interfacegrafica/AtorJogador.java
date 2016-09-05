package interfacegrafica;

import defaultpackage.Cor;
import defaultpackage.Partida;
import NetGames.AtorNetGames;

public class AtorJogador {

	protected Partida partida;
	protected String nome;
	protected InterfacePonteDelDiavolo janela;
	protected AtorNetGames rede;
	
	public AtorJogador(InterfacePonteDelDiavolo janela) {
		super();
		this.rede = new AtorNetGames(this);
		this.partida = new Partida();
		this.janela = janela;
	}

	public int conectar() {
		int resultado = -1;
		boolean conectado = partida.isConectado();
		if (!conectado) {
			String servidor = this.solicitaDadosConexao();
			/*
			 * resultado: 0 - ja conectado 1 - falha conexao 2 - Exito conexao
			 */
			resultado = rede.conectar(servidor, nome);
			if (resultado == 2) {
				conectado = true;
				partida.estabeleceConectado(conectado);
				janela.desejaIniciarPartida();
			}
		} else
			resultado = 0;

		return resultado;
	}
	
	public String solicitaDadosConexao() {
		nome = janela.solicitaIdJogador();
		String servidor = janela.solicitaIdServidor();
		return servidor;
	}
	
	public boolean querEncerrar() {
			// TODO - implement AtorJogador.querEncerrar
			throw new UnsupportedOperationException();
	}

		public void passaVez() {
			// TODO - implement AtorJogador.passaVez
			throw new UnsupportedOperationException();
		}

		public void informarInvalido() {
			// TODO - implement AtorJogador.informarInvalido
			throw new UnsupportedOperationException();
		}



		public int cancelaInicioPartida() {
			/*
			 * resultado: 3 - cancelado iniciar partida
			 */
			return 3;
		}

		public int iniciarPartida() {
			boolean interromper = false;
			boolean conectado = false;
			int resultado = -1;

			boolean andamento = partida.isJogoEmAndamento();
			if (andamento)
				interromper = avaliarInterrupcao(); // ainda nao foi implementado,
			// esta apenas retornando true
			else
				conectado = partida.isConectado();

			if (interromper || (!andamento && conectado)) 
				rede.iniciarPartida();  
			else
				resultado = 4;
			/*
			 * resultado: 4 - nao esta conectado 
			 * se for exito vai aparecer as pecas no tabuleiro
			 */
			return resultado;
		}

		public boolean avaliarInterrupcao() {
			return true;
		}

		/**
		 * 
		 * @param posicao
		 */
		public void tratarIniciarPartida(int posicao) {
			String nomeOutro = rede.informarNomeAdversario(nome);
			partida.tratarIniciarPartida(posicao, nome, nomeOutro);
			janela.habilitarQuadradoParaSelecao(Cor.BRANCO);			
			janela.exibirEstado();
		}

		public ImagemTabuleiro informarEstado() {
			ImagemTabuleiro estado = partida.informarEstado();
			return estado;
		}

		public int desconectar() {
			/*
			 * resultado: 14 - desconexao com exito 15 - desconexao sem
			 * conexao estabelecida 16 - desconexao falhou
			 */
			boolean andamento = partida.isJogoEmAndamento();
			boolean conectado = false;
			if (andamento) {
				partida.encerrarPartidaAndamento();
			} else {
				conectado = partida.isConectado();
			}

			boolean exito = false;

			if (andamento || conectado) {
				exito = rede.desconectar();
				if (exito) {
					partida.estabeleceConectado(!exito);
				} else {
					return 16;
				}
			} else {
				return 15;
			}

			return 14;
		}

		/**
		 * 
		 * @param posicaoSelecionada
		 */
		public void selecionaPosicao(Posicao posicaoSelecionada) {
			// TODO - implement AtorJogador.selecionaPosicao
			throw new UnsupportedOperationException();
		}

		public void selecionarQuadrado() {
			// TODO - implement AtorJogador.selecionarQuadrado
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param linha1
		 * @param coluna1
		 * @param linha2
		 * @param coluna2
		 */
		public int posicionaPonte(int linha1, int coluna1, int linha2, int coluna2) {
			// TODO - implement AtorJogador.posicionaPonte
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param jogada
		 */
		public void receberJogada(Lance jogada) {
			// TODO - implement AtorJogador.receberJogada
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param pontos
		 */
		public void exibePontos(int[2] pontos) {
			// TODO - implement AtorJogador.exibePontos
			throw new UnsupportedOperationException();
		}

		public boolean perguntaSeQuerTerminar() {
			// TODO - implement AtorJogador.perguntaSeQuerTerminar
			throw new UnsupportedOperationException();
		}

		public void InformaEhVez() {
			// TODO - implement AtorJogador.InformaEhVez
			throw new UnsupportedOperationException();
		}

		public void habilitaPecasBrancasParaSelecao() {
			// TODO - implement AtorJogador.habilitaPecasBrancasParaSelecao
			throw new UnsupportedOperationException();
		}

		public Cor escolheCor() {
			// TODO - implement AtorJogador.escolheCor
			throw new UnsupportedOperationException();
		}

		public void habilitaPecasVermelhasParaSelecao() {
			// TODO - implement AtorJogador.habilitaPecasVermelhasParaSelecao
			throw new UnsupportedOperationException();
		}

		public void habilitaTabuleiroParaSelecao() {
			// TODO - implement AtorJogador.habilitaTabuleiroParaSelecao
			throw new UnsupportedOperationException();
		}

		public boolean habilitarPonteVermelhaPSel() {
			// TODO - implement AtorJogador.habilitarPonteVermelhaPSel
			throw new UnsupportedOperationException();
		}

		public void posicionaQuadrado() {
			// TODO - implement AtorJogador.posicionaQuadrado
			throw new UnsupportedOperationException();
		}

		/**
		 * 
		 * @param linha
		 * @param coluna
		 */
		public int posicionaQuadrado(int linha, int coluna) {
			// TODO - implement AtorJogador.posicionaQuadrado
			throw new UnsupportedOperationException();
		}

		public void desabiltaTabuleiro() {
			// TODO - implement AtorJogador.desabiltaTabuleiro
			throw new UnsupportedOperationException();
		}

		public void posicionaPonte() {
			// TODO - implement AtorJogador.posicionaPonte
			throw new UnsupportedOperationException();
		}

	}
	}

}
