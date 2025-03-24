package pcd.lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

/**
 * Unsynchronized version
 * 
 * @TODO make it sync 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {

		Semaphore pingSem = new Semaphore(0); //semaforo evento
		Semaphore pongSem = new Semaphore(0); //semaforo evento

		new Ponger(pingSem, pongSem).start();
		new Pinger(pingSem, pongSem).start();

		pongSem.release(); //signal. il semaforo assume valore 1 e l'esecuzione ha inizio con Pinger

	}

}
