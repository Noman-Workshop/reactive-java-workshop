package io.javabrains.reactiveworkshop;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumberMono;

public class Exercise4 {
	
	public static void main(String[] args) throws IOException {
		
		// Use ReactiveSources.intNumberMono()
		
		// Print the value from intNumberMono when it emits
		intNumberMono().subscribe(System.out::println);
		
		// Get the value from the Mono into an integer variable
		System.out.println("Get the value from the Mono into an integer variable");
		var intNumber = intNumberMono().block();
		System.out.println("Blocking call: " + intNumber);
		
		System.out.println("Press a key to end");
		System.in.read();
		
		// with mono we can only get 0 or 1 item
	}
	
}
