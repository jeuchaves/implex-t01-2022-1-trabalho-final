package br.jeu.main;

import java.io.IOException;

import br.jeu.heuristica.tsp.hillClimbing.versao1.HillClimbing;
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

	public static void main(String[] args) throws IOException {
		long tempoInicial = System.currentTimeMillis();
		
		Posicao[] posicoes = Leitor.lerArquivo(registros[0]);
		HillClimbing hc = new HillClimbing(10, posicoes);
		int menorCaminho = hc.encontrarMenorCaminho();
		System.out.println("O menor caminho encontrado foi de " + menorCaminho);
		
		long tempoFinal = (System.currentTimeMillis() - tempoInicial) / 1000;
		System.out.println("O sistema foi executado em: " + tempoFinal + " segundos.");
	}
}
