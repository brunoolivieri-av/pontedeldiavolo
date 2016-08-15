package defaultpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tabuleiro {

	protected Posicao[][] posicoes = null;
	protected List<Ponte> listaPontes = null;
	protected List<Quadrado> listaQuadradosBrancos = null;
	protected List<Quadrado> listaQuadradosVermelhos = null;

	public void inicializa(){
		posicoes = new Posicao[10][10];

        // inicializa todas as posicoes
        for (int linha = 0; linha < 10 ; linha++){
            for (int coluna = 0; coluna < 10 ; coluna++){
                posicoes[linha][coluna] = new Posicao(linha, coluna);
            }
        }
        listaPontes = new ArrayList<>();
        listaQuadradosVermelhos = new ArrayList<>();
        listaQuadradosBrancos = new ArrayList<>();
	}

	//método que retorna uma posicao
	//caso a linha ou a coluna sejam inválidas retorna null
	public Posicao pegaPosicao(int linha, int coluna){
		if(this.posicoes != null
			&& linha >= 0 && linha < 10
			&& coluna >= 0	&& coluna < 10){
			return this.posicoes[linha][coluna];
		}
		return null;

	}

	//método que retorna verdadeiro se puder posicionar
	//ou falso se não puder posicionar em uma posição ou se a posicao
	//for inválida
	public boolean podePosicionarQuadrado(int linha, int coluna, Cor cor){
		Posicao posicao = this.pegaPosicao(linha, coluna);
		HashMap<Direcao, Posicao> todosOsVizinhos = this.pegaVizinhos(linha, coluna);
		
		//primeira verificação: a posicao não está ocupada por um quadrado nem bloquada por ponte
		if(posicao != null && cor != null && !posicao.temQuadrado() && !posicao.bloqueada()){
			
			//essa variável será usada para somar 1 ao tamanho de um banco de areia encontrado
			//devido ao possível posicionamento de mais uma peça
			//caso esse novo tamanho exceda 4 o posicionamento será inválido
			int novoTamanhoDeBancoDeAreia = 1;
			List<BancoDeAreia> bancoDeAreiaEncontrado = new ArrayList<>();
			
			//verificação das demais regras do jogo
			//vefifica cada Posicao vizinha ortogonal
			for(Posicao posicaoVizinha : this.pegaVizinhosOrtogonais(todosOsVizinhos).values()){
				if(posicaoVizinha != null){
					
					Quadrado quadradoVizinho = posicaoVizinha.pegaQuadrado();
					if(quadradoVizinho != null && quadradoVizinho.informaCor() == cor){
						BancoDeAreia bancoDeAreiaVizinho = quadradoVizinho.pegueBancoDeAreia();
						if(bancoDeAreiaVizinho != null){
							
							//não pode posicionar numa posicao ortogonal a uma ilha
							if(bancoDeAreiaVizinho.ehIlha())
								return false;
							
							//se o banco de areia encontrado já não tiver sido tratado, adiciona à lista dos tratados
							//e prossegue para tratá-lo
							if(!bancoDeAreiaEncontrado.contains(bancoDeAreiaVizinho)){
								bancoDeAreiaEncontrado.add(bancoDeAreiaVizinho);
								
								novoTamanhoDeBancoDeAreia += bancoDeAreiaVizinho.informarTamanho();
								
								//um banco de aeria nao pode ter mais de 4 quadrados
								if(novoTamanhoDeBancoDeAreia > 4)
									return false;
							}
						}
					}
				}
			} //fim do for
			
			//um banco de areia só pode ser extendido para formar uma ilha se não tocar outro banco de areia
			//neste caso é uma provável formação de ilha, então ele itera sobre todos os bancos de areia encontrados
			//nas posicoes ortogonais, verificando se algum deles tem vizinhos (o que só poderá ocorrer na diagonal,
			//pois se fossem vizinhos na ortogonal, ele faria parte do banco de areia)
			//caso algum tenha vizinhos ele itera sobre todos os vizinhos para saber se cada um não esta listado 
			//dentre os bancos de areia encontrados inicialmente, pois este é o único caso permitido, tendo em vista 
			//que ele será incorporado a nova ilha. Caso não seja o caso, ele retorna false, pois o posicionamento é 
			//ilegal
			if(novoTamanhoDeBancoDeAreia == 4){
				for(BancoDeAreia bancoDeAreia : bancoDeAreiaEncontrado){
					if(bancoDeAreia != null && bancoDeAreia.temVizinhos()){
						for(BancoDeAreia bancoDeAreiaVizinho : bancoDeAreia.pegaBancosDeAreiaVizinho()){
							if (bancoDeAreiaVizinho != null && !bancoDeAreiaEncontrado.contains(bancoDeAreiaVizinho)){
								return false;
							}
						}
					}
				}
			}
			
			//então parte para o teste dos bancos de areia diagonais
			for(Posicao posicaoVizinha : this.pegaVizinhosDiagonais(todosOsVizinhos).values()){
				if( posicaoVizinha != null){
					
					Quadrado quadradoVizinho = posicaoVizinha.pegaQuadrado();
					if(quadradoVizinho != null && quadradoVizinho.informaCor() == cor){
						
						BancoDeAreia bancoDeAreiaVizinho = quadradoVizinho.pegueBancoDeAreia();
						if(bancoDeAreiaVizinho != null){
							
							//não pode posicionar numa posicao diagonal a uma ilha
							if(bancoDeAreiaVizinho.ehIlha())
								return false;
							
							//se o banco de areia a ser formado juntando esse quadrado com outros bancos já encontrados
							//ja tiver 4  posicoes para formar uma ilha, ele não pode ser vizinho nem diagonalmente a um novo
							//banco de areia
							if(novoTamanhoDeBancoDeAreia == 4 && !bancoDeAreiaEncontrado.contains(bancoDeAreiaVizinho))
								return false;						
								
						}
					}
				}					
			}//fim do segundo for e das verficações. Se chegou até aqui, pode ser posicionado
			return true;
		}//fim do primeiro if. Se chegou até aqui, ainda não retornou e nem passou no primeiro if e a posicao estava ocupada
		return false;
	}
		
	
	private HashMap<Direcao, Posicao> pegaVizinhos(int linha, int coluna){
        HashMap<Direcao, Posicao> vizinhos = new HashMap<Direcao, Posicao>();

                // POSICAO OESTE
                if (coluna > 0){
                    vizinhos.put(Direcao.OESTE, pegaPosicao(linha, coluna - 1));
                } else {
                    vizinhos.put(Direcao.OESTE, null);
                }

                // POSICAO LESTE
                if (coluna < 9){
                    vizinhos.put(Direcao.LESTE, pegaPosicao(linha, coluna + 1));
                }else {
                    vizinhos.put(Direcao.LESTE, null);
                }

                // POSICAO NORTE
                if (linha > 0){
                    vizinhos.put(Direcao.NORTE, pegaPosicao(linha - 1, coluna));
                }else {
                    vizinhos.put(Direcao.NORTE, null);
                }

                // POSICAO SUL
                if (linha < 9){
                    vizinhos.put(Direcao.SUL, pegaPosicao(linha + 1, coluna));
                }else {
                    vizinhos.put(Direcao.SUL, null);
                }

                // POSICAO NORTE_OESTE
                if (linha != 0 && coluna != 0){
                    vizinhos.put(Direcao.NORTE_OESTE, pegaPosicao(linha - 1, coluna - 1));
                }else {
                    vizinhos.put(Direcao.NORTE_OESTE, null);
                }

                // POSICAO NORTE_LESTE
                if (linha != 0 && coluna != 9){
                    vizinhos.put(Direcao.NORTE_LESTE, pegaPosicao(linha - 1, coluna + 1));
                }else {
                    vizinhos.put(Direcao.NORTE_LESTE, null);
                }

                // POSICAO SUL_OESTE
                if (linha != 9 && coluna != 0){
                    vizinhos.put(Direcao.SUL_OESTE, pegaPosicao(linha + 1, coluna - 1));
                }else {
                    vizinhos.put(Direcao.SUL_OESTE, null);
                }

                // POSICAO SUL_LESTE
                if (linha != 9 && coluna != 9){
                    vizinhos.put(Direcao.SUL_LESTE, pegaPosicao(linha + 1, coluna + 1));
                }else {
                    vizinhos.put(Direcao.SUL_LESTE, null);
                }
                
                return vizinhos;
            }
	
	public HashMap<Direcao, Posicao> pegaVizinhosOrtogonais(HashMap<Direcao, Posicao> todosOsVizinhos) {
        HashMap<Direcao, Posicao> vizinhosOrtogonais = new HashMap<>();
        if (todosOsVizinhos.get(Direcao.NORTE) != null)
            vizinhosOrtogonais.put(Direcao.NORTE, todosOsVizinhos.get(Direcao.NORTE));
        if (todosOsVizinhos.get(Direcao.LESTE) != null)
        	vizinhosOrtogonais.put(Direcao.LESTE, todosOsVizinhos.get(Direcao.LESTE));
        if (todosOsVizinhos.get(Direcao.OESTE) != null)
        	vizinhosOrtogonais.put(Direcao.OESTE, todosOsVizinhos.get(Direcao.OESTE));
        if (todosOsVizinhos.get(Direcao.SUL) != null)
        	vizinhosOrtogonais.put(Direcao.SUL, todosOsVizinhos.get(Direcao.SUL));
        return vizinhosOrtogonais;
    }

	public HashMap<Direcao, Posicao> pegaVizinhosDiagonais(HashMap<Direcao, Posicao> todosOsVizinhos) {
        HashMap<Direcao, Posicao> vizinhosDiagonais = new HashMap<>();
        if (todosOsVizinhos.get(Direcao.NORTE_LESTE) != null)
            vizinhosDiagonais.put(Direcao.NORTE_LESTE, todosOsVizinhos.get(Direcao.NORTE_LESTE));
        if (todosOsVizinhos.get(Direcao.NORTE_OESTE) != null)
            vizinhosDiagonais.put(Direcao.NORTE_OESTE, todosOsVizinhos.get(Direcao.NORTE_OESTE));
        if (todosOsVizinhos.get(Direcao.SUL_LESTE) != null)
            vizinhosDiagonais.put(Direcao.SUL_LESTE, todosOsVizinhos.get(Direcao.SUL_LESTE));
        if (todosOsVizinhos.get(Direcao.SUL_OESTE) != null)
            vizinhosDiagonais.put(Direcao.SUL_OESTE, todosOsVizinhos.get(Direcao.SUL_OESTE));
        return vizinhosDiagonais;
    }
        

	/**
	*método para posicionar um quadrado em uma posição
	*não verifica se pode posicionar o Quadrado
	*delega o posicionamento para a Posicao
	*adiciona o quadrado na lista de quadrados daquela cor
	*atentar que retorna void
	**/
	public void posicionarQuadrado(int linha, int coluna, Cor cor){
		Posicao posicao = this.pegaPosicao(linha, coluna);
		Quadrado quadrado = new Quadrado(cor);
		posicao.posicionarQuadrado(quadrado);
		this.pegaListaQuadrados(cor).add(posicao.pegaQuadrado());
		this.atualizaBancoDeAreia();
	}

	private List<Quadrado> pegaListaQuadrados(Cor cor) {
		if(cor == Cor.BRANCO){
			return this.listaQuadradosBrancos;
		}
		else
			return this.listaQuadradosVermelhos;
	}

	/**
	*método verifica se as poscoes não tem null, pois o método pegaPosicao
	*retorna null caso alguma coordenada tenha sido inválida
	*depois verifica com um método estático da classe Ponte se as coordenadas
	*são compatíveis com coordenadas de uma ponte
	*a checagem prossegue se as posicoes tem a mesma cor
	*e a cor delas e igual a da nova ponte
	*entao e verificado se nao tem nenhum quadrado em baixo
	**/
	public boolean podePosicionarPonte(int linha1, int coluna1, int linha2, int coluna2, Cor cor){
		Posicao posicao1 = this.pegaPosicao(linha1, coluna1);
        Posicao posicao2 = this.pegaPosicao(linha2, coluna2);
        if(posicao1 != null && posicao2 != null 
        	&& Ponte.posicoesCompativeis(linha1, coluna1, linha2, coluna2)){
        	Quadrado quadrado1 = posicao1.pegaQuadrado();
        	Quadrado quadrado2 = posicao2.pegaQuadrado();

        	if(quadrado1 != null && quadrado2 != null){
        		if(quadrado1.informaCor() == quadrado2.informaCor() 
        			&& quadrado1.informaCor() == cor
        			&& !posicao1.temPonte() && !posicao2.temPonte()
        			&& !quadradoEntre2Posicoes(posicao1, posicao2)){
        				return true;
        		}
        	}
        }
        return false;
	}

	/**
	*método privado  usado dentro de podePosicionarPonte que retorna
	*true se tem um quadrado entre duas posicoes, impedindo o posicionamento da ponte
	*calcula a media entre as coordenadas para determinar a coordenada do centro
	*caso a divisao por 2 resulte num numero impar e consequentemente numa media
	*não inteira, são verificadas as duas opções: arredondando para baixo e para cima
	*não existe o caso de duas posicoes compativeis para posicionar uma ponte retornarem
	*um somatório das coordenadas de linha e coluna ímpares
	*/
	private boolean quadradoEntre2Posicoes(Posicao posicao1, Posicao posicao2){
		if(posicao1 != null && posicao2 != null){
			int somaLinhas = posicao1.informarLinha() + posicao2.informarLinha();
			int somaColunas = posicao1.informarColuna() + posicao2.informarColuna();

			if(somaLinhas % 2 == 0){
				if(somaColunas % 2 == 0){
					return this.pegaPosicao(somaLinhas / 2, somaColunas / 2).temQuadrado();							
				}
				else{
					return (this.pegaPosicao(somaLinhas / 2, somaColunas / 2).temQuadrado()							
							|| this.pegaPosicao(somaLinhas / 2, somaColunas / 2 + 1).temQuadrado());	
				}
			}
			else
				return (this.pegaPosicao(somaLinhas / 2, somaColunas / 2).temQuadrado()							
							|| this.pegaPosicao(somaLinhas / 2 + 1, somaColunas / 2).temQuadrado());
		}
		return false;
	}

	public void posicionarPonte(int linha1, int coluna1, int linha2, int coluna2, Cor cor){
		Posicao posicao1 = this.pegaPosicao(linha1, coluna1);
        Posicao posicao2 = this.pegaPosicao(linha2, coluna2);
        Quadrado quadrado1 = posicao1.pegaQuadrado();
    	Quadrado quadrado2 = posicao2.pegaQuadrado();
		Ponte ponte = new Ponte(quadrado1, quadrado2);
		posicao1.recebePonte();
		posicao2.recebePonte();
		this.bloquearQuadradoEntre2Posicoes(posicao1, posicao2);
		listaPontes.add(ponte);
	}

	private void bloquearQuadradoEntre2Posicoes(Posicao posicao1, Posicao posicao2){
		if(posicao1 != null && posicao2 != null){
			int somaLinhas = posicao1.informarLinha() + posicao2.informarLinha();
			int somaColunas = posicao1.informarColuna() + posicao2.informarColuna();

			if(somaLinhas % 2 == 0){
				if(somaColunas % 2 == 0){
					this.pegaPosicao(somaLinhas / 2, somaColunas / 2).bloquear();							
				}
				else{
					this.pegaPosicao(somaLinhas / 2, somaColunas / 2).bloquear();							
					this.pegaPosicao(somaLinhas / 2, somaColunas / 2 + 1).bloquear();	
				}
			}
			else{
				this.pegaPosicao(somaLinhas / 2, somaColunas / 2).bloquear();							
				this.pegaPosicao(somaLinhas / 2 + 1, somaColunas / 2).bloquear();
			}	
		}
	}


	/**
	 * 
	 * @param posicaoSelecionada
	 */
	public boolean avaliarFormacaoDeIlha(Posicao posicaoSelecionada) {
		// TODO - implement Tabuleiro.avaliarFormacaoDeIlha
		throw new UnsupportedOperationException();
	}


	public ImagemTabuleiro informarEstado() {
		// TODO - implement Tabuleiro.informarEstado
		throw new UnsupportedOperationException();
	}


	public int somaPontos() {
		// TODO - implement Tabuleiro.somaPontos
		throw new UnsupportedOperationException();
	}

	public boolean podePosicionar2Q(Cor cor) {
		int numeroDeQuadradosPermitidos = 0;

		for (int linha = 0; linha < 10 ; linha++){
            for (int coluna = 0; coluna < 10 ; coluna++){
                Posicao posicao = this.pegaPosicao(linha, coluna);
                if(posicao != null && posicao.quadradoPermitidoAqui(cor)){
                	numeroDeQuadradosPermitidos++;
                }
            }
        }
        return (numeroDeQuadradosPermitidos == 2);
	}


}
