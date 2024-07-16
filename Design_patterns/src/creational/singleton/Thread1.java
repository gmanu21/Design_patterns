package creational.singleton;

public class Thread1 extends Thread{

	public static void main(String[] args) {
		Thread1 t=new Thread1();
		Thread1 t1=new Thread1();
		t.setName("Thread1");
		t1.setName("Thread2");
		t.start();
		t1.start();
		
	}
	
/*	
	here run method  starts exicuting from here 
	where it starts exicuting two objects
	when it starts exicuting it in singleton class it will take as s==null
	so we have to make it synchronized if we have more than one thread that it will start 
	
	@Override
	public void run() {
		SingletonDesignPattern s=SingletonDesignPattern.getInstance();
		System.out.println(Thread.currentThread().getName());	
	}	
*/	
	
/* For ignoring this problem of creating multiple objects we have to make  
   this method synchronized then it will allow only one thread to pass through it
  static synchronized SingletonDesignPattern getInstance() {
		if(s==null) {
			s=new SingletonDesignPattern();
			return s;
		}
		return s;
	}
 */
	@Override
	public void run() {
		try {
			SingletonDesignPattern s=SingletonDesignPattern.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());	
	}	
}
