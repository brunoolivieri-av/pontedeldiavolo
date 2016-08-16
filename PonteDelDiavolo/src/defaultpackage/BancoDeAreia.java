package defaultpackage;

import java.util.ArrayList;
import java.util.List;

public class BancoDeAreia {
	
	private Cor cor;
	private List<Quadrado> listaQuadrados = new ArrayList<>();
	private int tamanho = 0;
	private int TAMANHO_MAXIMO = 4;
	private boolean ligado = false;
	private List<BancoDeAreia> bancosDeAreiaVizinhos = new ArrayList<>();

	public BancoDeAreia(Quadrado quadrado){
		this.cor = quadrado.informaCor();
		this.listaQuadrados = new ArrayList<>();
		this.listaQuadrados.add(quadrado);
		this.tamanho++;
	}
	
	
	public boolean temVizinhos() {
		return this.bancosDeAreiaVizinhos.size() > 0;
	}

	public List<BancoDeAreia> pegaBancosDeAreiaVizinho() {
		return this.bancosDeAreiaVizinhos;
	}

	public int informarTamanho() {
		return this.tamanho;
	}

	public boolean ehIlha() {
		return this.tamanho == TAMANHO_MAXIMO;
	}
	
	public void ligado(boolean ligado){
		this.ligado = ligado;
	}


	public boolean adicionaQuadrado(Quadrado quadrado) {
		if(quadrado != null && podeReceberQuadrado(quadrado) && quadrado.informaCor() == this.cor){
			this.listaQuadrados.add(quadrado);
			this.tamanho++;
			
			quadrado.recebeBancoDeAreia(this);
			
			return true;
		}
		return false;
	}


	private boolean podeReceberQuadrado(Quadrado quadrado) {
		if(this.tamanho < 3){
			return true;
		}
		else {
			if(this.tamanho == 3){
				if (quadrado != null && temVizinhos()){
					if(this.bancosDeAreiaVizinhos.size() == 1 
							&& this.bancosDeAreiaVizinhos.contains(quadrado.pegueBancoDeAreia())
							&& (this.bancosDeAreiaVizinhos.size() + quadrado.pegueBancoDeAreia().informarTamanho()) <= 4){
						return true;
					}
				}
				else{
					if(!temVizinhos()){
						return true;
					}
				}
			}
			return false;
		}		
	}
// TODO add em banco de areia vizinhos


	public boolean juntarBancoDeAreia(BancoDeAreia bancoDeAreia) {
		if (permitidoJuntarBancoDeAreia(bancoDeAreia)){

            List<Quadrado> novosQuadrados = bancoDeAreia.pegaListaQuadrados();
            for(Quadrado novoQuadrado: novosQuadrados){
            	this.adicionaQuadrado(novoQuadrado);
            }
            if (this.bancosDeAreiaVizinhos.contains(bancoDeAreia))
                this.bancosDeAreiaVizinhos.remove(bancoDeAreia);


            return true;
        }
        return false;
		
	}


private boolean permitidoJuntarBancoDeAreia(BancoDeAreia bancoDeAreia) {
	return (bancoDeAreia != null && this != bancoDeAreia && bancoDeAreia.tamanho + this.tamanho <= 4 && bancoDeAreia.informaCor() == this.cor );
}


private Cor informaCor() {
	return this.cor;
}

public List<Quadrado> pegaListaQuadrados(){
	return this.listaQuadrados;
}
}
