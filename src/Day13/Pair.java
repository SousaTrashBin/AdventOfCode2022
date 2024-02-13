package Day13;

import static Day13.Packet.isInRightOrderAux;

public class Pair {
	Packet firstPacket;
	Packet secondPacket;

	public Pair(String s) {
		String firstPacket = s.split("\n")[0];
		String secondPacket = s.split("\n")[1];
		this.firstPacket = new Packet(firstPacket);
		this.secondPacket = new Packet(secondPacket);
	}

	public boolean isInRightOrder() {
		return isInRightOrderAux(firstPacket, secondPacket);
	}

}
