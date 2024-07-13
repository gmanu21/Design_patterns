package creational.singleton;

import java.io.Serializable;

public class SingletonDesignPattern implements Serializable{

	String name="manu";
	
	static SingletonDesignPattern  s=null;
	
	//private constructor so no one can create a object outside of class
	private SingletonDesignPattern(){
		
	}
	/*
	//here we are maintaining the synchronized kw because when we use two threads 
	//at a time we have to use synchroized block so that it gets locked and another
	//thread wont exicute .

	static synchronized SingletonDesignPattern getInstance() {
		if(s==null) {
			s=new SingletonDesignPattern();
			return s;
		}
		return s;
	}
	*/
	
	/*
	//-->we can use synchronized block as well to exicute specific block
	static  SingletonDesignPattern getInstance() {
		synchronized(s) {
			if(s==null) {
				s=new SingletonDesignPattern();
				return s;
			}
		}
		return s;
	}
	*/
	//here we are doing DOUBLE checked locking for bcs if s gets instance
	//we are not even allowing it to enter into synchronized block
	static  SingletonDesignPattern getInstance() {
		if(s==null) {
			synchronized(s) {
				if(s==null) {
					s=new SingletonDesignPattern();
					return s;
				}
			}
		}
		return s;
	}
//	whenerver readObject() in ObjectInputStream is called there is read resolve method
//	it is responsible to create new object so we override that method
//	When it is getting (deserialized)
	Object readResolve(){
		return s;
	}
}
