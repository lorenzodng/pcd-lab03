package pcd.lab03.cswithlocks;

import java.util.concurrent.locks.Lock;

public class MyWorkerA extends Worker {
	
	private Lock lock;
	
	public MyWorkerA(String name, Lock lock){
		super(name);
		this.lock = lock;
	}

	//in questo caso, la mutua esclusione è implementata attraverso l'utilizzo di un lock in modo "esplicito"
	//dal punto di vista funzionale, il comportamento è analogo al metodo synchronized, ma possono offrire più flessibilità per implementare la mutua esclusione
	public void run(){
		while (true){
		  a1();	
		  try {
			  lock.lockInterruptibly(); //acquisisco il lock
			  a2();	
			  a3();	
		  } catch (InterruptedException ex) {
		  } finally {
			  lock.unlock(); //rilascio il lock
		  }
		}
	}
	
	protected void a1(){
		println("a1");
		wasteRandomTime(100,500);	
	}
	
	protected void a2(){
		println("a2");
		wasteRandomTime(300,700);	
	}
	protected void a3(){
		println("a3");
		wasteRandomTime(300,700);	
	}
}

