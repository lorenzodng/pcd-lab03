package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Ponger extends ActiveComponent {

	private Semaphore pingSem;
	private Semaphore pongSem;

	public Ponger(Semaphore pingSem, Semaphore pongSem) {
		this.pingSem= pingSem;
		this.pongSem= pongSem;
	}	

	//in questo caso, viene garantita mutua esclusione e sincronizzazione attraverso un semaforo evento
	public void run() {
		while (true) {
			try {
				pingSem.acquire(); //wait. prima di eseguire il codice sotto, aspetto che Pinger abbia rilasciato pingSem
				println("pong");
				pongSem.release(); //signal. rilascio pongSem
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}