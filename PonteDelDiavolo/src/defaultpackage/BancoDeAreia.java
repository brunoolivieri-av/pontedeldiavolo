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

}
