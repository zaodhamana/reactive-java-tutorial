package io.javabrains.reactiveworkshop;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

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
		
		System.out.println();
		System.out.println();
		System.out.println("Iterator example 1 java 9");
		
		Predicate<Integer> predicate = n -> n < 5;
		Stream<Integer> finiteStream = Stream.iterate(1, predicate, n -> n + 1);
		finiteStream
		.forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		System.out.println("Iterator example 2 java 8");
		
		Stream<Integer> infiniteStreamLimit = Stream.iterate(1, n -> n +1).limit(5);
		infiniteStreamLimit
		.forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		System.out.println("Various Stream Examples");
		
	
		
				
	}

}
