package br.jeu.heuristica.tsp.hillClimbing.versao1;

import java.util.Arrays;
import java.util.Random;

import br.jeu.util.Posicao;

/**
 * Algoritmo meta-heur�stico para encontrar o menor caminho entre todos os v�rtices
 * @author jeuch
 */
public class HillClimbing {	
	
	private long qtdInteracoes; // Delimita a quantidade de intera��es poss�veis para a heuristica
	private Posicao[] posicoes; // Mapa de todas as posi��es dos v�rtices
	
	/**
	 * @param qtdInteracoes - Quantidade de intera��es que o algor�tmo ir� fazer
	 * @param posicoes - Lista contendo todos os v�rtices do grafo
	 */
	public HillClimbing(long qtdInteracoes, Posicao[] posicoes) {
		this.qtdInteracoes = qtdInteracoes;
		this.posicoes = posicoes;
	}
	
	/**
	 * Escolher aleat�riamente um caminho entre todos os v�rtices
	 * @return Caminho escolhido
	 */
	private int[] selecionarPontoCorrenteAleatoriamente() {
		int[] vertices = new int[posicoes.length];
		int i = 0;
		while(i < posicoes.length-1) {
			Random gerador = new Random();
			int numeroRandomico = gerador.nextInt(posicoes.length);
			
			// Verificar se o n�mero sorteado j� cont�m no vetor
			boolean contem = false;
			for(int j = 0; j < vertices.length; j++)
				if(vertices[j] == numeroRandomico) contem = true;
			
			// Caso o n�mero ainda n�o tenha sido selecionado ent�o adiciona no vetor
			if(!contem) { 
				vertices[i] = numeroRandomico;
				i++;
			}
		} return vertices;
	}
	
	/**
	 * Calcula a dist�ncia euclidiana entre todos os caminhos na ordem que � passado como par�metro
	 * @param caminho - Vetor onde ser� calculado a dist�ncia
	 * @return dist�ncia para ir da posi��o 0 at� o posi��o N
	 */
	private int calcularDistancia(int[] caminho) {
		int soma = 0;
		for(int i = 0; i < caminho.length-1; i++) {
			// F�rmula � Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)
			
			// Instanciar todas as variaveis da f�rmula
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
	 * Retorna todos os vizinhos poss�veis para o caminho enviado como par�metro
	 * @param caminhoPontoCorrente - Caminho onde ser� procurado os vizinhos
	 * @return Lista com todos os vizinhos encontrados
	 */
	private int[][] encontrarVizinhos(int[] caminhoPontoCorrente) {
		int[][] vizinhos = new int[caminhoPontoCorrente.length-1][caminhoPontoCorrente.length];
		
		/**
		 * A t�cnica para encontrar vizinha utilizada nesse c�digo �
		 * trocar a posi��o do primeiro elemento da lista com as demais posi��es.
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
	 * @return um vetor de 2 posi��es contendo no �ndice [0] o index e no �ndice [1] a dist�ncia
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
