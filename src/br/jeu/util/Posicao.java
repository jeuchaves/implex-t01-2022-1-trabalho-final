package br.jeu.util;

/**
 * Classe respons�vel por armazenar os dados do v�rtice
 * @author jeuch
 */
public class Posicao {

	private int Y;
	private int X;
	
	/**
	 * @param y - Posi��o no eixo Y
	 * @param x - Posi��o no eixo X
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
