package pcd.lab03.cswithsem;

import java.util.concurrent.Semaphore;

public class MyWorkerB extends Worker {
	
	private Semaphore mutex;
	
	public MyWorkerB(String name, Semaphore lock){
		super(name);
		this.mutex = lock;
	}

	//in questo caso, la mutua esclusione è implementata attraverso l'utilizzo di un semaforo
	//dal punto di vista funzionale, il comportamento è analogo al metodo synchronized e al lock esplicito, ma bloccano i thread che richiedono un mutex già occupato, permettendo di ottimizzare l'utilizzo delle risorse
	public void run(){
		while (true){
		  try {
			  mutex.acquire(); //wait
			  action1();	
			  action2();
		  } catch (InterruptedException ex) {
			  log("interrupted.");
		  } finally {
			  mutex.release(); //signal
		  }
		  action3();
		}
	}
	
	protected void action1(){
		println("b1");
		wasteRandomTime(0,1000);	
	}
	
	protected void action2(){
		println("b2");
		wasteRandomTime(100,200);	
	}
	protected void action3(){
		println("b3");
		wasteRandomTime(1000,2000);	
	}
}
