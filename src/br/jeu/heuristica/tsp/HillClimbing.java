package br.jeu.heuristica.tsp;

import br.jeu.util.Posicao;

/**
 * Algoritmo meta-heuristico para encontrar o menor caminho entre todos os vertices
 * @author jeuch
 */
public class HillClimbing extends Heuristica {	
	
	/**
	 * @param qtdIteracoes - Quantidade de interacoes que o algoritmo ira fazer
	 * @param posicoes - Lista contendo todos os vertices do grafo
	 */
	public HillClimbing(long qtdIteracoes, Posicao[] posicoes) {
		super(qtdIteracoes, posicoes);
	}
	
	/**
	 * Algoritmo que busca utilizando HillClimbing para encontrar o menor caminho para o TSP
	 * @return inteiro contendo o menor caminho
	 */
	public int encontrarMenorCaminho() {
		int melhor = Integer.MAX_VALUE;
		for(int i = 0; i < qtdIteracoes; i++) {
			boolean local = false;
			int[] pontoCorrente = selecionarPontoCorrenteAleatoriamente();
			int distanciaPontoCorrente = calcularDistancia(pontoCorrente);
			while(!local) {
				int[][] vizinhos = encontrarVizinhos(pontoCorrente);
				int[] melhorVizinho = encontrarDistanciaMenor(vizinhos); 
				if(melhorVizinho[1] < distanciaPontoCorrente) {
					pontoCorrente = vizinhos[melhorVizinho[0]];
					distanciaPontoCorrente = melhorVizinho[1];
				} else {
					
					/* DESABILITE ISSO PARA VER O MELHOR RESULTADO DE CADA ITERACAO
					System.out.println("Iteracao " + i);
					System.out.println("Atual caminho: " + Arrays.toString(pontoCorrente));
					System.out.println("Ponto Corrente atual: " + distanciaPontoCorrente);
					*/
					local = true;
					if(distanciaPontoCorrente < melhor) melhor = distanciaPontoCorrente;
				}
			}
		}
		return melhor;
	}

}
