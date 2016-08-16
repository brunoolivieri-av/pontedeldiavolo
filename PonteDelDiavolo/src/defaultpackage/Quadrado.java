package defaultpackage;

public class Quadrado {
	
	private Cor cor;
	private BancoDeAreia bancoDeAreia;

	public Quadrado(Cor cor) {
		this.cor = cor;
	}

	public Cor informaCor() {
		return this.cor;
	}

	public BancoDeAreia pegueBancoDeAreia() {
		return this.bancoDeAreia;
	}
	
	public void recebeBancoDeAreia(BancoDeAreia bancoDeAreia){
		this.bancoDeAreia = bancoDeAreia;
	}
	
	
}
