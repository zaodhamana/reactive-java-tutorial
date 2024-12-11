package io.javabrains.reactiveworkshop;

import java.util.List;

public class StreamExamples {
	
	public static void main(String[] args) {
	
		long a;
	
		a = StreamSources.userStream().count();
		
		System.out.println();
		System.out.println("There are "+ a + " items in the stream.");
		System.out.println();
		
		List<String> names = StreamSources.userStream()
		.filter(u -> u.getLastName().contains("a"))
		.map(u->u.getLastName())
		.toList();
		
		System.out.println("List of first name " + names);
		System.out.println();
		
		StreamSources.userStream()
		.filter(u -> u.getLastName().contains("a"))
		.forEach(u -> System.out.println( u));
	
		
				
	}

}
