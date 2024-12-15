package io.javabrains.reactiveworkshop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public record Person(String name, int age) implements Serializable {

	public static void main(String[] args) {
	try {
		Person s = new Person("Muhoro", 1);

		System.out.println("Print of record: " + s);
		
		File obj = new File("file1.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(obj));
		out.writeObject(s);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(obj));
		Person inperson = null;
		inperson = (Person)in.readObject();
		System.out.println(inperson.name+ " " + inperson.age);
		in.close();
	}
		
	catch(Exception e) 
	{
		System.out.println(" " + e.getMessage());
	}
	}
}
