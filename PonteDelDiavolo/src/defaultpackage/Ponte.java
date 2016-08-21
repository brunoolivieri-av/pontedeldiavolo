package defaultpackage;

import static java.lang.StrictMath.abs;

public class Ponte {

	private Quadrado base1;
	private Quadrado base2;

	public Ponte(Quadrado base1, Quadrado base2) {

		this.base1 = base1;
		this.base2 = base2;

		this.base1.pegueBancoDeAreia().ligado(true);
		this.base2.pegueBancoDeAreia().ligado(true);
		
		this.base1.recebePonte(this);
		this.base2.recebePonte(this);

	}
	
	public Quadrado pegaBase1(){
		return this.base1;
	}
	
	public Quadrado pegaBase2(){
		return this.base2;
	}

	public static boolean posicoesCompativeis(int linha1, int coluna1,
			int linha2, int coluna2) {
		int amplitudeY = abs(linha2 - linha1);
		int amplitudeX = abs(coluna2 - coluna1);
		if (amplitudeY == 2 && amplitudeX <= 2)
			return true;
		else if (amplitudeY < 2 && amplitudeX == 2)
			return true;
		return false;
	}
}
