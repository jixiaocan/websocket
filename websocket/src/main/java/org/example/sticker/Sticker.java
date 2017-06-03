package org.example.sticker;

public class Sticker {
	private int x;
	private int y;
	private String image;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Sticker(int x, int y, String image) {
		super();
		this.x = x;
		this.y = y;
		this.image = image;
	}

	public Sticker() {
		super();
		// TODO Auto-generated constructor stub
	}
}
