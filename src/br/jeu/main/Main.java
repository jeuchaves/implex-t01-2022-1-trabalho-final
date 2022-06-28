package br.jeu.main;

import java.io.IOException;

import br.jeu.heuristica.tsp.HillClimbing;
import br.jeu.heuristica.tsp.SimulateAnnealing;
import br.jeu.util.Leitor;
import br.jeu.util.Posicao;

public class Main {
	
	private static final String[] registros = {
			"registro\\att48.tsp.txt",
			"registro\\berlin52.tsp.txt",
			"registro\\bier127.tsp.txt",
			"registro\\eil76.tsp.txt",
			"registro\\kroA100.tsp.txt",
			"registro\\kroE100.tsp.txt",
			"registro\\pr76.tsp.txt",
			"registro\\rat99.tsp.txt",
			"registro\\st70.tsp.txt",
	};
	
	public static void testesHillClimb() throws IOException {
		int[] it = {1000, 10000, 50000, 100000};
		for(int i = 0; i < it.length; i++) {
			System.out.println("Resultados para " + it[i] + " iteracoes");
			for(int j = 0; j < registros.length; j++) {
				long tempoInicial = System.currentTimeMillis();
				Posicao[] posicoes = Leitor.lerArquivo(registros[j]);
				HillClimbing hc = new HillClimbing(it[i], posicoes);
				int menorCaminho = hc.encontrarMenorCaminho();
				long tempoFinal = (System.currentTimeMillis() - tempoInicial) / 1000;
				System.out.println(registros[j] + " : " + menorCaminho + " em " + tempoFinal + " segundos.");
			}
		}
	}
	
	private static void simulateAnnealing(
			double tempMax, double razaoEsfriamento, long qtdIteracoes, double tempMin) throws IOException {
		for(int j = 0; j < registros.length; j++) {
			long tempoInicial = System.currentTimeMillis();
			Posicao[] posicoes = Leitor.lerArquivo(registros[j]);
			SimulateAnnealing sa = new SimulateAnnealing(qtdIteracoes, posicoes, razaoEsfriamento, tempMax, tempMin);
			int menorCaminho = sa.encontrarMenorCaminho();
			long tempoFinal = (System.currentTimeMillis() - tempoInicial) / 1000;
			System.out.println(registros[j] + " : " + menorCaminho + " em " + tempoFinal + " segundos.");
		}
	}
	
	public static void testesSimulateAnnealing() throws IOException {
		
		/*
		 * Teste C
		 * Temperatura Maxima - 100
		 * Razao de Esfriamento - .80
		 * Quantidade de iteracoes - 50
		 * Temperatura Minima - 5
		 */
		long qtdIteracoes; double razao; double tempMax; double tempMin;
		
		qtdIteracoes = 7000;
		razao = 0.96;
		tempMax = 100;
		tempMin = 50;
		simulateAnnealing(tempMax, razao, qtdIteracoes, tempMin);
		
		qtdIteracoes = 1900;
		razao = 0.55;
		tempMax = 10000;
		tempMin = 100;
		simulateAnnealing(tempMax, razao, qtdIteracoes, tempMin);

		qtdIteracoes = 10000;
		razao = 0.5;
		tempMax = 10000;
		tempMin = 10;
		simulateAnnealing(tempMax, razao, qtdIteracoes, tempMin);
	}

	public static void main(String[] args) throws IOException {
//		testesHillClimb();
		testesSimulateAnnealing();
	}
}
