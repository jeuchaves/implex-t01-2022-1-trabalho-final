package br.jeu.heuristica.tsp;

import java.util.Arrays;

import br.jeu.util.Posicao;

/**
 * Classe que armazena as funções e atributos usados nas duas heuristicas
 * @author jeuch
 */
public abstract class Heuristica {

	protected long qtdIteracoes; // Delimita a quantidade de interacoes possiveis para a heuristica
	protected Posicao[] posicoes; // Mapa de todas as posicoes dos vertices
	
	/**
	 * @param qtdIteracoes - Quantidade de interacoes que o algoritmo ira fazer
	 * @param posicoes - Lista contendo todos os vertices do grafo
	 */
	public Heuristica(long qtdIteracoes, Posicao[] posicoes) {
		this.qtdIteracoes = qtdIteracoes;
		this.posicoes = posicoes;
	}
	
	/**
	 * Calcula a distancia euclidiana entre todos os caminhos na ordem que e passado como parametro
	 * @param caminho - Vetor onde sera calculado a distancia
	 * @return distancia para ir da posicao 0 ate a posicao N
	 */
	protected int calcularDistancia(int[] caminho) {
		int soma = 0;
		for(int i = 0; i < caminho.length-1; i++) {
			// Formula Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)
			
			// Instanciar todas as variaveis da formula
			int x1 = posicoes[caminho[i]].getX();
			int x2 = posicoes[caminho[i+1]].getX();
			int y1 = posicoes[caminho[i]].getY();
			int y2 = posicoes[caminho[i+1]].getY();
			
			// Calcular o quadrado de X e Y
			int x = (int) Math.pow(x1-x2, 2);
			int y = (int) Math.pow(y1-y2, 2);
			
			// Calcular a raiz quadrada
			soma += (int) Math.sqrt(x + y);
		} return soma;
		
	}
	
	/**
	 * Retorna todos os vizinhos possiveis para o caminho enviado como parametro
	 * @param caminhoPontoCorrente - Caminho onde sera procurado os vizinhos
	 * @return Lista com todos os vizinhos encontrados
	 */
	protected int[][] encontrarVizinhos(int[] caminhoPontoCorrente) {
		int[][] vizinhos = new int[caminhoPontoCorrente.length-2][caminhoPontoCorrente.length];
		
		/**
		 * A quantida de vizinhos corresponde ao tamanho do vetor-2
		 */
		for(int i = 0; i < vizinhos.length; i++) {
			int[] vizinho = Arrays.copyOf(caminhoPontoCorrente, caminhoPontoCorrente.length);
			int aux = vizinho[i];
			vizinho[i] = vizinho[i+2];
			vizinho[i+2] = aux;
			vizinhos[i] = vizinho;
		}
		return vizinhos;
	}
	
	/**
	 * 
	 * @param caminhos - Lista de caminhos
	 * @return um vetor de 2 posicoes contendo no indice [0] o index e no indice [1] a distancia
	 */
	protected int[] encontrarDistanciaMenor(int[][] caminhos) {
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
}
