package Day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Packet implements Comparable<Packet> {
	private final List<Object> objectList;

	public Packet(String s) {
		objectList = buildList(s);
	}

	public Packet(List<Object> objectList) {
		this.objectList = objectList;
	}

	public List<Object> getObjectList() {
		return objectList;
	}

	private List<Object> buildList(String list) {
		Stack<List<Object>> previousLists = new Stack<>();
		List<Object> current = null;
		StringBuilder numBuilder = new StringBuilder();

		for (char c : list.toCharArray()) {
			switch (c) {
			case '[' -> {
				if (current != null)
					previousLists.push(current);
				current = new ArrayList<>();
			}
			case ']' -> {
				numBuilder = addNumber(numBuilder, current);
				if (!previousLists.isEmpty()) {
					previousLists.peek().add(current);
					current = previousLists.pop();
				}
			}
			case ',' -> numBuilder = addNumber(numBuilder, current);
			default -> numBuilder.append(c);
			}
		}
		return current;
	}

	private static StringBuilder addNumber(StringBuilder numBuilder, List<Object> current) {
		if (!numBuilder.isEmpty()) {
			current.add(Integer.parseInt(numBuilder.toString()));
			numBuilder = new StringBuilder();
		}
		return numBuilder;
	}

	public static boolean isInRightOrderAux(Packet firstPacket, Packet secondPacket) {
		for (int i = 0; i < Math.min(firstPacket.getObjectList().size(), secondPacket.getObjectList().size()); i++) {
			Object currentFirst = firstPacket.getObjectList().get(i);
			Object currentSecond = secondPacket.getObjectList().get(i);
			if (compare(currentFirst, currentSecond) != null)
				return Boolean.TRUE.equals(compare(currentFirst, currentSecond));
		}
		return firstPacket.getObjectList().size() <= secondPacket.getObjectList().size();
	}

	private static Boolean compare(Object currentFirst, Object currentSecond) {
		if (currentFirst instanceof Integer && currentSecond instanceof Integer) {
			int first = (Integer) currentFirst;
			int second = (Integer) currentSecond;
			return switch (Integer.compare(first, second)) {
			case -1 -> true;
			case 0 -> null;
			case 1 -> false;
			default -> throw new IllegalStateException("Unexpected value: " + Integer.compare(first, second));
			};
		}
		if (currentFirst instanceof List<?> && currentSecond instanceof List<?>)
			return isInRightOrderAux(new Packet((List<Object>) currentFirst), new Packet((List<Object>) currentSecond));
		if (currentFirst instanceof Integer)
			return compare(List.of(currentFirst), currentSecond);
		if (currentSecond instanceof Integer)
			return compare(currentFirst, List.of(currentSecond));
		return false;
	}

	@Override
	public int compareTo(Packet o) {
		if (isInRightOrderAux(this, o))
			return -1;
		else if (equals(o))
			return 0;
		else
			return 1;
	}

	public boolean equals(Packet o) {
		return objectList.equals(o.getObjectList());
	}
}
