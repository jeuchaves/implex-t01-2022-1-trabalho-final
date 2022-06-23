package br.jeu.main;

import java.io.IOException;

import br.jeu.heuristica.tsp.HillClimbing;
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
	
	public static void bateriaTestesHillClimb() throws IOException {
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

	public static void main(String[] args) throws IOException {
		bateriaTestesHillClimb();
	}
}
