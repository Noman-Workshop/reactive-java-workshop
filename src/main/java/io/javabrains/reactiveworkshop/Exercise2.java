package io.javabrains.reactiveworkshop;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;
import static io.javabrains.reactiveworkshop.ReactiveSources.userFlux;

public class Exercise2 {
	
	public static void main(String[] args) throws IOException {
		
		// Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()
		
		// Print all numbers in the ReactiveSources.intNumbersFlux stream
		intNumbersFlux().subscribe(System.out::println);
		
		// Print all users in the ReactiveSources.userFlux stream
		userFlux().subscribe(System.out::println);
		
		System.out.println("Press a key to end");
		System.in.read();
	}
	
}
