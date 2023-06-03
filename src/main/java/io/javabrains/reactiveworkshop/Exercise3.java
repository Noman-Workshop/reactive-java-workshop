package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise3 {
	
	public static void main(String[] args) throws IOException {
		
		// Use ReactiveSources.intNumbersFlux()
		
		// Get all numbers in the ReactiveSources.intNumbersFlux stream
		// into a List and print the list and its size
		
		// non blocking
//		intNumbersFlux().collectList()
//		                .subscribe(list -> {
//			                System.out.println(list);
//			                System.out.println(list.size());
//		                });
		
		// blocking
		List<Integer> numbers = intNumbersFlux().toStream()
		                                        .collect(Collectors.toList());
		System.out.println(numbers);
		System.out.println(numbers.size());
		
		// Flux is intended to send zero of n items over time
		// We can tell flux to slow down the emission of items

//		System.out.println("Press a key to end");
//		System.in.read();
	
	}
	
}
