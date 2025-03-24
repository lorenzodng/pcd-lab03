package pcd.lab03.ex01_synchwithsem;

public abstract class ActiveComponent extends Thread {

	protected void println(String msg){
		synchronized (System.out){
			System.out.println(msg);
		}
	}

}
