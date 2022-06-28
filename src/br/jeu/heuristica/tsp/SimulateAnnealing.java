package br.jeu.heuristica.tsp;

import java.util.Arrays;
import java.util.Random;

import br.jeu.util.Posicao;

public class SimulateAnnealing extends Heuristica {

	private double temperaturaMaxima;
	private double temperaturaMinima;
	private double razaoEsfriamento;
	
	/**
	 * @param qtdIteracoes - Quantidade de vezes que o laco ira se repetir
	 * @param posicoes - Lista de vertices
	 * @param razaoEsfriamento - Valor decrementado da temperatura
	 * @param temperaturaMaxima - Valor inicial da temperatura
	 * @param temperaturaMinima - Valor final da temperatura
	 */
	public SimulateAnnealing(	
			long qtdIteracoes, Posicao[] posicoes, double razaoEsfriamento,
			double temperaturaMaxima, double temperaturaMinima) {
		super(qtdIteracoes, posicoes);
		this.razaoEsfriamento = razaoEsfriamento;
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = temperaturaMinima;
	}
	
	/**
	 * Algoritmo que busca utilizando Simulate Annealing para encontrar o menor caminho para o TSP
	 * @return inteiro contendo o menor caminho
	 */
	public int encontrarMenorCaminho() {
		int menorDistancia = Integer.MAX_VALUE;
		double temperatura = temperaturaMaxima;
		int[] pontoCorrente = selecionarPontoCorrenteAleatoriamente();
		int distanciaPontoCorrente = calcularDistancia(pontoCorrente);
		while(temperatura > temperaturaMinima) {
			for(int i = 0; i < qtdIteracoes; i++) {
				Random gerador = new Random();
				int[][] vizinhos = encontrarVizinhos(pontoCorrente);
				int[] vizinhoSelecionado = vizinhos[gerador.nextInt(vizinhos.length)];
				int distanciaVizinhoSelecionado = calcularDistancia(vizinhoSelecionado);
				if(distanciaVizinhoSelecionado < distanciaPontoCorrente) {
					pontoCorrente = Arrays.copyOf(vizinhoSelecionado, vizinhoSelecionado.length);
					distanciaPontoCorrente = distanciaVizinhoSelecionado;
				} else {
					int calcTemp = (int) ((distanciaPontoCorrente - distanciaVizinhoSelecionado) / temperatura);
					if(gerador.nextInt(100) < calcTemp) {
						pontoCorrente = Arrays.copyOf(vizinhoSelecionado, vizinhoSelecionado.length);
						distanciaPontoCorrente = distanciaVizinhoSelecionado;
					}
				}
			}
			temperatura = razaoEsfriamento * temperatura;
			if(distanciaPontoCorrente < menorDistancia) {
				menorDistancia = distanciaPontoCorrente;
			}
		} return menorDistancia;
	}

}
