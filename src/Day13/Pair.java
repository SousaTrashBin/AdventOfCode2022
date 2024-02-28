package Day13;

import static Day13.Packet.isInRightOrderAux;

public class Pair {
	private final Packet firstPacket;
	private final Packet secondPacket;

	public Pair(String s) {
		firstPacket = new Packet(s.split("\n")[0]);
		secondPacket = new Packet(s.split("\n")[1]);
	}

	public boolean isInRightOrder() {
		return isInRightOrderAux(firstPacket, secondPacket);
	}

}
