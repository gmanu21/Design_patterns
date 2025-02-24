package creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton_Pattern {

	public static void main(String[] args) throws Exception {
	
//		this dosent work because we make class constructor as private
//		so we cant create object in another class
//		SingletonDesignPattern s=new SingletonDesignPattern();
		
		SingletonDesignPattern s=SingletonDesignPattern.getInstance();
		SingletonDesignPattern s1=SingletonDesignPattern.getInstance();
		SingletonDesignPattern s2=SingletonDesignPattern.getInstance();

		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
//	Ways to break singleton using these	
//		REFLECTION 
//		CLONING
//		SERELIZATION
//		MULTITHREADING
		
//		we can break singleton by following ways
//		using (serialization/deserialization) ,cloning,reflection,multithreading
//		writeOj->writeObj(serilization),readObjecct(deserialization)
		
//		first we have to implement serializable interface then we can perform this action
//		This will do serialization
		FileOutputStream f=new FileOutputStream("C:\\Users\\Manu\\Pictures\\check_file\\hello.txt");
		ObjectOutputStream obj=new ObjectOutputStream(f);
		obj.writeObject(s);
		
//		This will do deserialization and create object by breaking singleton pattern
		/*
		FileInputStream fi=new FileInputStream("C:\\Users\\Manu\\Pictures\\check_file\\hello.txt");
		ObjectInputStream obji=new ObjectInputStream(fi);
		SingletonDesignPattern s3=(SingletonDesignPattern)obji.readObject();
		System.out.println(s3.name);
		*/
//		here again new object hashcode is generated 
//		which is breaking singleton pattern
//		System.out.println(s3.hashCode()); 
		
//		Difference between serialization and compilation
//		compilation is class level and serialization is for object level
		
//		REFLECTION TO BREAK SINGLETON
//		private constructor can be called using reflection so it break singleton
//		to prevent this we throw eception in constructor
		Constructor<SingletonDesignPattern> s7 = SingletonDesignPattern.class.getDeclaredConstructor();
		s7.setAccessible(true);
		SingletonDesignPattern s9=(SingletonDesignPattern)s7.newInstance();
		System.out.println(s9.hashCode());
		
		
//		CLONING
//		shallow cloning/deep clonning
//		shallow this cloning is used when change the original objecct it have changed object
//		deep cloning will not be like that it wont be changed
		
		SingletonDesignPattern s10=(SingletonDesignPattern)s.clone();
		System.out.println(s10.hashCode());
		
	}
	
}
