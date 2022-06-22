package br.jeu.heuristica.tsp.hillClimbing.versao1;

import java.util.Arrays;
import java.util.Random;

import br.jeu.util.Posicao;

/**
 * Algoritmo meta-heurístico para encontrar o menor caminho entre todos os vértices
 * @author jeuch
 */
public class HillClimbing {	
	
	private long qtdInteracoes; // Delimita a quantidade de interações possíveis para a heuristica
	private Posicao[] posicoes; // Mapa de todas as posições dos vértices
	
	/**
	 * @param qtdInteracoes - Quantidade de interações que o algorítmo irá fazer
	 * @param posicoes - Lista contendo todos os vértices do grafo
	 */
	public HillClimbing(long qtdInteracoes, Posicao[] posicoes) {
		this.qtdInteracoes = qtdInteracoes;
		this.posicoes = posicoes;
	}
	
	/**
	 * Escolher aleatóriamente um caminho entre todos os vértices
	 * @return Caminho escolhido
	 */
	private int[] selecionarPontoCorrenteAleatoriamente() {
		int[] vertices = new int[posicoes.length];
		int i = 0;
		while(i < posicoes.length-1) {
			Random gerador = new Random();
			int numeroRandomico = gerador.nextInt(posicoes.length);
			
			// Verificar se o número sorteado já contém no vetor
			boolean contem = false;
			for(int j = 0; j < vertices.length; j++)
				if(vertices[j] == numeroRandomico) contem = true;
			
			// Caso o número ainda não tenha sido selecionado então adiciona no vetor
			if(!contem) { 
				vertices[i] = numeroRandomico;
				i++;
			}
		} return vertices;
	}
	
	/**
	 * Calcula a distância euclidiana entre todos os caminhos na ordem que é passado como parâmetro
	 * @param caminho - Vetor onde será calculado a distância
	 * @return distância para ir da posição 0 até o posição N
	 */
	private int calcularDistancia(int[] caminho) {
		int soma = 0;
		for(int i = 0; i < caminho.length-1; i++) {
			// Fórmula é Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)
			
			// Instanciar todas as variaveis da fórmula
			int x1 = posicoes[i].getX();
			int x2 = posicoes[i+1].getX();
			int y1 = posicoes[i].getY();
			int y2 = posicoes[i+1].getY();
			
			// Calcular o quadrado de X e Y
			int x = (int) Math.pow(x1-x2, 2);
			int y = (int) Math.pow(y1-y2, 2);
			
			// Calcular a raiz quadrada
			soma += (int) Math.sqrt(x + y);
		} return soma;
	}
	
	/**
	 * Retorna todos os vizinhos possíveis para o caminho enviado como parâmetro
	 * @param caminhoPontoCorrente - Caminho onde será procurado os vizinhos
	 * @return Lista com todos os vizinhos encontrados
	 */
	private int[][] encontrarVizinhos(int[] caminhoPontoCorrente) {
		int[][] vizinhos = new int[caminhoPontoCorrente.length-1][caminhoPontoCorrente.length];
		
		/**
		 * A técnica para encontrar vizinha utilizada nesse código é
		 * trocar a posição do primeiro elemento da lista com as demais posições.
		 */
		for(int i = 0; i < vizinhos.length; i++) {
			vizinhos[i] = Arrays.copyOf(caminhoPontoCorrente, caminhoPontoCorrente.length);
			int aux = vizinhos[i][0];
			vizinhos[i][0] = vizinhos[i][i+1];
			vizinhos[i][i+1] = aux;
		}
		return vizinhos;
	}
	
	/**
	 * 
	 * @param caminhos - Lista de caminhos
	 * @return um vetor de 2 posições contendo no índice [0] o index e no índice [1] a distância
	 */
	private int[] encontrarDistanciaMenor(int[][] caminhos) {
		int menor = Integer.MAX_VALUE;
		int index = 0;
		for(int i = 0; i < caminhos.length; i++) {
			int distancia = calcularDistancia(caminhos[i]);
			if(distancia < menor) {
				menor = distancia;
				index = i;
			}
		}
		return new int[] {index, menor};
	}
	
	/**
	 * Algoritmo que busca utilizando HillClimbing o menor caminho para o TSP
	 * @return inteiro contendo o menor caminho
	 */
	public int encontrarMenorCaminho() {
		int melhor = Integer.MAX_VALUE;
		for(int i = 0; i < qtdInteracoes; i++) {
			boolean local = false;
			int[] pontoCorrente = selecionarPontoCorrenteAleatoriamente();
			int distanciaPontoCorrente = calcularDistancia(pontoCorrente);
			while(!local) {
				int[][] vizinhos = encontrarVizinhos(pontoCorrente);
				int[] melhorVizinho = encontrarDistanciaMenor(vizinhos); 
				if(melhorVizinho[1] < distanciaPontoCorrente) {
					pontoCorrente = vizinhos[melhorVizinho[0]];
				} else {
					local = true;
					if(distanciaPontoCorrente < melhor) melhor = distanciaPontoCorrente;
				}
			}
		}
		return melhor;
	}

}
