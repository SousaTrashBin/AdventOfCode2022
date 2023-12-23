package Day4;

public class Assignment {
	private final IDRange firstElf;
	private final IDRange secondElf;

	public Assignment(String s) {
		String[] elfs = s.split(",");
		firstElf = new IDRange(elfs[0]);
		secondElf = new IDRange(elfs[1]);
	}

	public boolean containsAnother() {
		boolean secondElfContainedInFirstElf = firstElf.getLowerLimit() <= secondElf.getLowerLimit()
				&& firstElf.getHigherLimit() >= secondElf.getHigherLimit();

		boolean firstElfContainedInSecondElf = secondElf.getLowerLimit() <= firstElf.getLowerLimit()
				&& secondElf.getHigherLimit() >= firstElf.getHigherLimit();

		return secondElfContainedInFirstElf || firstElfContainedInSecondElf;
	}

	public boolean isOverLapped() {
		for (int i = firstElf.getLowerLimit(); i <= firstElf.getHigherLimit(); i++) {
			if (i >= secondElf.getLowerLimit() && i <= secondElf.getHigherLimit())
				return true;
		}
		return false;
	}

}
