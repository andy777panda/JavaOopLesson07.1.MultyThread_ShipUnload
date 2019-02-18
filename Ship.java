package net.ukr.andy777;

public class Ship implements Runnable {
	String name;
	int boxes;
	private Thread thr;
	private Port port;

	public Ship(String name, int boxes, Port port) {
		super();
		this.name = name;
		this.boxes = boxes;
		this.port = port;
		thr = new Thread(this); // ініціалізація потоку
		thr.start(); // запуск потоку
	}

	// метод потоку
	@Override
	public void run() {
		for (; boxes > 0;) {
			int freeDock = port.getFreeDock();
			String tab = getTab(freeDock);
			if (freeDock == -1) {
				sleep();
				System.out.println(tab + "NO free dock for " + name);
			} else {
				for (int i = boxes; i > 0; i--) {
					sleep();
					System.out.println(tab + "dock" + freeDock + " unload " + name + " box" + boxes);
					boxes--;
				}
				port.setFreeDock(freeDock);
			}
		}
	}

	// сервісний метод призупинення виконання потоку
	private void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// сервісний метод отримання відступу для друку
	private String getTab(int freeDock) {
		switch (freeDock) {
		case 0:
			return " ";
		case 1:
			return "\t\t\t\t";
		default:
			return "\t\t\t\t\t\t\t\t";
		}
	}
}
