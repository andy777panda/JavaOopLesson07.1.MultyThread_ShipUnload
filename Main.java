package net.ukr.andy777;

/*
 Lesson07.1
	 Существуют три корабля. На каждом из них 10 ящиков груза.
	 Они одновременно прибыли в порт, в котором только два дока. 
	 Скорость разгрузки - 1 ящик в 0.5 сек. 
	 Напишите программу, которая, управляя кораблями, позволит им правильно разгрузить груз.
 */

public class Main {

	public static void main(String[] args) {
		Port port = new Port();
		Thread thrShip1 = new Thread(new Ship("ship1", 10, port));
		Thread thrShip2 = new Thread(new Ship("ship2", 10, port));
		Thread thrShip3 = new Thread(new Ship("ship3", 10, port));

		// thrShip1.start(); // запуск потоку
		// thrShip2.start(); // запуск потоку
		// thrShip3.start(); // запуск потоку

		try {
			thrShip1.join();
			thrShip2.join();
			thrShip3.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

	}
}
