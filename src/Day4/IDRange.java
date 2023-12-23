package Day4;

public class IDRange {
	private final int lowerLimit;
	private final int higherLimit;

	public IDRange(String s) {
		lowerLimit = Integer.parseInt(s.split("-")[0]);
		higherLimit = Integer.parseInt(s.split("-")[1]);
	}

	public int getHigherLimit() {
		return higherLimit;
	}

	public int getLowerLimit() {
		return lowerLimit;
	}
}
