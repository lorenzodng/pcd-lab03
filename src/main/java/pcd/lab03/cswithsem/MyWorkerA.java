package pcd.lab03.cswithsem;

import java.util.concurrent.Semaphore;

public class MyWorkerA extends Worker {
	
	private Semaphore mutex;
	
	public MyWorkerA(String name, Semaphore mutex){
		super(name);
		this.mutex = mutex;
	}

	//in questo caso, la mutua esclusione è implementata attraverso l'utilizzo di un semaforo
	//dal punto di vista funzionale, il comportamento è analogo al metodo synchronized e al lock esplicito, ma bloccano i thread che richiedono un mutex già occupato, permettendo di ottimizzare l'utilizzo delle risorse
	public void run(){
		while (true){
		  action1();	
		  try {
			  mutex.acquire(); //wait
			  action2();	
			  action3();	
		  } catch (InterruptedException ex) {
			  log("interrupted..");
		  } finally {
			  mutex.release(); //signal
		  }
		}
	}
	
	protected void action1(){
		println("a1");
		wasteRandomTime(100,500);	
	}
	
	protected void action2(){
		println("a2");
		wasteRandomTime(300,700);	
	}
	protected void action3(){
		println("a3");
		wasteRandomTime(300,700);	
	}
}

