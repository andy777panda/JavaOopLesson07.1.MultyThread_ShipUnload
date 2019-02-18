package net.ukr.andy777;

public class Port {

	// змінна стану зайнятості 2ох доків в порту
	private volatile boolean[] dock = { false, false };

	public Port() {
		super();
	}

	public synchronized void setFreeDock(int freeDock) {
		dock[freeDock] = false;
	}

	// перевірка всіх доків хоча до першого вільного та його резервування
	public synchronized int getFreeDock() {
		for (int i = 0; i < dock.length; i++)
			if (dock[i] == false) {
				dock[i] = true;
				return i; // freeDock
			}
		return -1; // NO freeDock
	}
}
