package Day9;

public class Pos {
	private int x;
	private int y;

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(DIRECTION direction) {
		switch (direction) {
		case UP -> y += 1;
		case DOWN -> y -= 1;
		case LEFT -> x -= 1;
		case RIGHT -> x += 1;
		}
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public Pos copy() {
		return new Pos(x, y);
	}

	public boolean equals(Pos p) {
		return getY() == p.getY() && getX() == p.getX();
	}
}
