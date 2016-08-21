package defaultpackage;

public class Quadrado {
	
	private Cor cor;
	private BancoDeAreia bancoDeAreia;
	private Ponte ponte;

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
	
	public boolean temPonte(){
		return !(this.ponte == null);
	}
	
	public Ponte pegaPonte(){
		return this.ponte;
	}
	
	public void recebePonte(Ponte ponte){
		this.ponte = ponte;
	}
	
	
}
