package br.jeu.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe responsável por gerenciar a leitura de arquivos e converter para vetores
 * @author jeuch
 */
public class Leitor {

	public static Posicao[] lerArquivo(String path) throws IOException {
		ArrayList<Posicao> arraylist = new ArrayList<>();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				linha = linha.trim();
				linha = linha.replaceAll("\s+"," "); 
				String[] palavras = linha.split(" ");
				if(palavras.length == 3) {
					int y = (int) Double.parseDouble(palavras[1]);
					int x = (int) Double.parseDouble(palavras[2]);
					Posicao posicao = new Posicao(y, x);
					arraylist.add(posicao);
				}
			} else break;
			
			
			linha = buffRead.readLine();
		}
		buffRead.close();
		return arraylist.toArray(new Posicao[0]);
	}
	
}
