package Day3;

public class RuckSack {
	String firstCompartment;
	String secondCompartment;

	public RuckSack(String s) {
		firstCompartment = s.substring(0, s.length() / 2);
		secondCompartment = s.substring(s.length() / 2);
	}

	public static int getPriorityNumber(char c) {
		if (Character.isLowerCase(c))
			return c - 'a' + 1;
		else
			return c - 'A' + 27;
	}

	public int getRuckSackPriorityNumber() {
		for (char c : firstCompartment.toCharArray()) {
			if (secondCompartment.contains(String.valueOf(c)))
				return getPriorityNumber(c);
		}

		return 0;
	}
}
