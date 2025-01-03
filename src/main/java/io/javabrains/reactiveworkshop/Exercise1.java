package io.javabrains.reactiveworkshop;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
    	System.out.println("List of numbers in stream");
    	StreamSources.intNumbersStream().forEach(e -> System.out.print(e + ", "));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
    	System.out.println();
    	System.out.println();
    	System.out.println("Numbers less than 5");
    	StreamSources.intNumbersStream()
    	.filter(a -> a < 5)
    	.forEach(e -> System.out.print(e + ", "));
 
        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
    	System.out.println();
    	System.out.println();
    	System.out.println("Filtering with skip and limit");
    	StreamSources.intNumbersStream()
    	.filter(a -> a > 5)
    	.skip(1)
    	.limit(2)
    	.forEach(f -> System.out.print(f+", "));
    	
    	
    	
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
    	System.out.println();
    	System.out.println();
    	System.out.println("Print first number large than 5, or print -1");
    	StreamSources.intNumbersStream()
    			.filter(a -> a > 5)
    			.skip(10)
    			.findFirst()
    			.ifPresentOrElse((x) -> System.out.print(x), 
    					() -> System.out.print(-1));

        // Print first names of all users in userStream
        // TODO: Write code here
    	System.out.println();
    	System.out.println("List of first names");
    	StreamSources.userStream()
    	.map(a -> a.getFirstName())
    	.forEach(e -> System.out.print(e + ", "));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
    	System.out.println();
    	System.out.println();
    	System.out.println("Print first names that also have id");
    	StreamSources.userStream()
    	.peek(a -> a.getId())
    	.map(a -> a.getFirstName())
    	.forEach(e -> System.out.print(e + ", "));
    	
    	System.out.println();
    	System.out.println();
    	System.out.println("Filter to use only names where id in usersStream match numbers in intNumbersStream");
    	StreamSources.userStream()
    	.filter(a -> StreamSources.intNumbersStream().anyMatch(i -> i == a.getId()))
    	.map(a -> a.getFirstName())
    	.forEach(a -> System.out.print(a + ", "));
    	
    	System.out.println();
    	System.out.println();
    	System.out.println("Filter using dropwhile if id's don't match numbers in intstream");
    	
    	StreamSources.userStream()
    	.dropWhile(a -> StreamSources.intNumbersStream().anyMatch(i -> i == a.getId()))
    	.map(a -> a.getFirstName())
    	.forEach(a -> System.out.print(a + ", "));

		System.out.println();
		System.out.println();
		System.out.println("Use of flatMap, filter and map");
		StreamSources.intNumbersStream()
		.flatMap((id -> StreamSources.userStream().filter(u -> u.getId() == id)))
		.map(m -> m.getLastName())
		.forEach(v -> System.out.print(v + ", "));
		
		System.out.println();
		System.out.println();
		System.out.println("Iterator example with Predicate java 9");
		Predicate<Integer> predicate = n -> n < 100;
		Stream.iterate(1, predicate, n -> n * 2)
		.forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		System.out.println();
		System.out.println("Iterator example with limit Java 8");
		Stream.iterate(1, n -> n * 2)
		.limit(7)
		.forEach(n -> System.out.print(n + " "));


    }

}
