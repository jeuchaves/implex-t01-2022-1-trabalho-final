package br.jeu.util;

/**
 * Classe responsável por armazenar os dados do vértice
 * @author jeuch
 */
public class Posicao {

	private int Y;
	private int X;
	
	/**
	 * @param y - Posição no eixo Y
	 * @param x - Posição no eixo X
	 */
	public Posicao(int y, int x) {
		this.Y = y;
		this.X = x;
	}

	public int getY() {
		return Y;
	}

	public int getX() {
		return X;
	}
	
	@Override
	public String toString() {
		return "[" + getY() + "," + getX() + "]";
	}
	
}
