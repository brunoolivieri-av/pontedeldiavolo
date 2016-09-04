package defaultpackage;


	public class Jogador {

		protected String nomeUsuario;
		protected Cor cor;
		protected boolean daVez;
		protected boolean vencedor;

		//TODO trabalhar melhor a classe jogador tanto código quanto no diagrama de classes
		public boolean informarSeDaVez() {
			//TODO mudar retorno do método no diagrama de classes
			return daVez;
		}



		public void recebeVez() {
			this.daVez = true;
		}

		public void perdeVez() {
			this.daVez = false;
		}

		public void assumirNome(String nome) {
			this.nomeUsuario = nome;
			this.daVez = false;
			this.vencedor = false;
		}

		public void assumirCor(Cor corJogador) {
			this.cor = corJogador;
		}
		
		public Cor informaCor(){
			return this.cor;
		}
}
