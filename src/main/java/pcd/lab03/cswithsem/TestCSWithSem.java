package pcd.lab03.cswithsem;

import java.util.concurrent.Semaphore;

public class TestCSWithSem {

	public static void main(String[] args) {
		Semaphore mutex = new Semaphore(1,true); //semaforo mutex strong
		new MyWorkerA("MyAgent-01", mutex).start();		
		new MyWorkerB("MyAgent-02", mutex).start();
		new MyWorkerC("MyAgent-03", mutex).start();
	}

}
