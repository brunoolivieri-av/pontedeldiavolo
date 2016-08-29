package defaultpackage;

public class Posicao {
	
	protected int linha;
	protected int coluna;
	protected boolean bloqueada;
	protected boolean temQuadrado;
	protected boolean temPonte;
	protected Quadrado quadrado;
		
	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.bloqueada = false;
		this.temQuadrado = false;
		this.temPonte = false;
		this.quadrado = null;
	}
	
	public int informarLinha() {
		return this.linha;
	}

	public int informarColuna() {
		return this.coluna;
	}
	
	public boolean bloqueada(){
		return this.bloqueada;
	}
	
	public boolean temQuadrado() {
		return this.temQuadrado;
	}
	
	public boolean temPonte() {
		return this.temPonte;
	}
	
	public Quadrado pegaQuadrado() {
		return this.quadrado;
	}
	
	public void bloquear() {
		this.bloqueada = true;
		
	}
	
	public void recebePonte() {
		this.temPonte = true;
		
	}


	public void posicionarQuadrado(Quadrado quadrado) {
		this.quadrado = quadrado;
		this.temQuadrado = true;		
	}
	

	

	public boolean quadradoPermitidoAqui(Cor cor) {
		if( cor != null && !bloqueada && !temQuadrado){
			
		}
		return false;
	}

	
}
