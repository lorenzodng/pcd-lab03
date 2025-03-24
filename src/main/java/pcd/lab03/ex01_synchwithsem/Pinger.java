package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Pinger extends ActiveComponent {

	private Semaphore pingSem;
	private Semaphore pongSem;

	public Pinger(Semaphore pingSem, Semaphore pongSem) {
		this.pingSem= pingSem;
		this.pongSem= pongSem;
	}

	//in questo caso, viene garantita mutua esclusione e sincronizzazione attraverso un semaforo evento
	public void run() {
		while (true) {
            try {
                pongSem.acquire(); //wait. prima di eseguire il codice sotto, aspetto che Ponger abbia rilasciato pongSem
				println("ping");
				pingSem.release(); //signal. rilascio pingSem
			} catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
		}
	}


}