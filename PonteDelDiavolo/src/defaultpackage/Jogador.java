package defaultpackage;


	public class Jogador {

		protected String nomeUsuario;
		protected Cor cor;
		protected boolean daVez;
		protected boolean vencedor;

		public boolean informarSeDaVez() {
			//TODO mudar retorno do método no diagrama de classes
			return daVez;
		}

		public void desabilitaSelecaoPeca() {
			// TODO - implement Jogador.desabilitaSelecaoPeca
			throw new UnsupportedOperationException();
		}

		public void recebeVez() {
			this.daVez = true;
		}

		public void perdeVez() {
			this.daVez = false;
		}

		/**
		 * 
		 * @param nome
		 */
		public void assumirNome(String nome) {
			this.nomeUsuario = nome;
		}

		/**
		 * 
		 * @param corJogador
		 */
		public void assumirCor(Cor corJogador) {
			this.cor = corJogador;
		}
}
