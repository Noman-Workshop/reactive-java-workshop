package io.javabrains.reactiveworkshop;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise9 {
	
	
	public static void main(String[] args) throws IOException {
		
		// Use ReactiveSources.intNumbersFlux()
		
		// Print size of intNumbersFlux after the last item returns
		intNumbersFlux().count()
		                .subscribe((length) -> System.out.println("Length: " + length));
		
		// Collect all items of intNumbersFlux into a single list and print it
		intNumbersFlux().collectList()
		                .subscribe(System.out::println);
		
		// Transform to a sequence of sums of adjacent two numbers
		intNumbersFlux().buffer(2)
		                .map(integers -> integers.stream()
		                                         .reduce(0, Integer::sum))
		                .subscribe(System.out::println);
		
		System.out.println("Press a key to end");
		System.in.read();
	}
	
}
