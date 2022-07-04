package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.javabrains.reactiveworkshop.ReactiveSources.*;

public class Exercise7 {
	
	
	public static void main(String[] args) throws IOException {
		
		// Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()
		
		// Print all values from intNumbersFlux that's greater than 5
		intNumbersFlux().filter(i -> i > 5)
		                .subscribe(System.out::println);
		
		// Print 10 times each value from intNumbersFlux that's greater than 5
		intNumbersFlux().filter(i -> i > 5)
		                .map(i -> i * 10)
		                .subscribe(System.out::println);
		
		// Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
		intNumbersFlux().filter(i -> i > 5)
		                .map(i -> i * 10)
		                .take(3)
		                .subscribe(System.out::println);
		
		// Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
		intNumbersFlux().filter(i -> i > 20)
		                .defaultIfEmpty(-1)
		                .subscribe(System.out::println);
		
		// Switch ints from intNumbersFlux to the right user from userFlux
		// TODO: Write O(m+n) code without blocking the thread
		
		// Print only distinct numbers from intNumbersFluxWithRepeat
		intNumbersFluxWithRepeat().distinct()
		                          .subscribe(System.out::println);
		
		// Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
		intNumbersFluxWithRepeat().distinctUntilChanged()
		                          .subscribe(System.out::println);
		
		System.out.println("Press a key to end");
		System.in.read();
	}
	
}
