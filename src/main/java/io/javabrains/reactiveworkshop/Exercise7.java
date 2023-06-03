package io.javabrains.reactiveworkshop;

import java.io.IOException;

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
		// here we are using flatMap because we dont want to ger the flux but the result of the flux
		intNumbersFlux().flatMap(i -> userFlux().filter(u -> u.getId() == i).take(1))
		                .subscribe(System.out::println);
		
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
