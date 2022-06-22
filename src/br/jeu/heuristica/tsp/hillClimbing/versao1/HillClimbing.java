package br.jeu.heuristica.tsp.hillClimbing.versao1;

import java.util.Arrays;
import java.util.Random;

import br.jeu.util.Posicao;

/**
 * Algoritmo meta-heuristico para encontrar o menor caminho entre todos os vertices
 * @author jeuch
 */
public class HillClimbing {	
	
	/*
	 * Existe um bug no codigo onde ele apresenta sempre o mesmo resultado independente da quantidade de iteracoes
	 * */
	
	private long qtdIteracoes; // Delimita a quantidade de interacoes possiveis para a heuristica
	private Posicao[] posicoes; // Mapa de todas as posicoes dos vertices
	
	/**
	 * @param qtdIteracoes - Quantidade de interacoes que o algoritmo ira fazer
	 * @param posicoes - Lista contendo todos os vertices do grafo
	 */
	public HillClimbing(long qtdIteracoes, Posicao[] posicoes) {
		this.qtdIteracoes = qtdIteracoes;
		this.posicoes = posicoes;
	}
	
	/**
	 * Escolher aleatoriamente um caminho entre todos os vertices
	 * @return Caminho escolhido
	 */
	private int[] selecionarPontoCorrenteAleatoriamente() {
		int[] vertices = new int[posicoes.length];
		int i = 0;
		while(i < posicoes.length-1) {
			Random gerador = new Random();
			int numeroRandomico = gerador.nextInt(posicoes.length);
			
			// Verificar se o numero sorteado ja contem no vetor
			boolean contem = false;
			for(int j = 0; j < vertices.length; j++)
				if(vertices[j] == numeroRandomico) contem = true;
			
			// Caso o numero ainda nao tenha sido selecionado entao adiciona no vetor
			if(!contem) { 
				vertices[i] = numeroRandomico;
				i++;
			}
		} return vertices;
	}
	
	/**
	 * Calcula a distancia euclidiana entre todos os caminhos na ordem que e passado como parametro
	 * @param caminho - Vetor onde sera calculado a distancia
	 * @return distancia para ir da posicao 0 ate a posicao N
	 */
	private int calcularDistancia(int[] caminho) {
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
	private int[][] encontrarVizinhos(int[] caminhoPontoCorrente) {
		int[][] vizinhos = new int[caminhoPontoCorrente.length-1][caminhoPontoCorrente.length];
		
		/**
		 * A tecnica para encontrar vizinha utilizada nesse codigo e
		 * trocar a posicao do primeiro elemento da lista com as demais posicoes.
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
	 * @return um vetor de 2 posicoes contendo no indice [0] o index e no indice [1] a distancia
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
