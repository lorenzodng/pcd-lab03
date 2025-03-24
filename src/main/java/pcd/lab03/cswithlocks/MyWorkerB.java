package pcd.lab03.cswithlocks;

import java.util.concurrent.locks.Lock;

public class MyWorkerB extends Worker {
	
	private Lock lock;
	
	public MyWorkerB(String name, Lock lock){
		super(name);
		this.lock = lock;
	}

	//in questo caso, la mutua esclusione è implementata attraverso l'utilizzo di un lock in modo "esplicito"
	//dal punto di vista funzionale, il comportamento è analogo al metodo synchronized, ma possono offrire più flessibilità per implementare la mutua esclusione
	public void run(){
		while (true){
		  try {
			  lock.lockInterruptibly(); //acquisisco il lock
			  b1();	
			  b2();
		  } catch (InterruptedException ex) {
		  } finally {
			  lock.unlock(); //rilascio il lock
		  }
		  b3();
		}
	}
	
	protected void b1(){
		println("b1");
		wasteRandomTime(0,1000);	
	}
	
	protected void b2(){
		println("b2");
		wasteRandomTime(100,200);	
	}
	protected void b3(){
		println("b3");
		wasteRandomTime(1000,2000);	
	}
}
