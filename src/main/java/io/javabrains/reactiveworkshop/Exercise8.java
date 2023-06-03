package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFluxWithException;

public class Exercise8 {
	
	
	public static void main(String[] args) throws IOException {
		
		// Use ReactiveSources.intNumbersFluxWithException()
		
		// Print values from intNumbersFluxWithException and print a message when error happens
		// here the error is propagated to the subscriber, and it stops the stream
		// and the error does not propagate to the next subscriber
		intNumbersFluxWithException()
				.subscribe(System.out::println, error -> System.out.println("Error: " + error));
		
		// the doOnError operator allows us to do something when an error happens
		// but does not stop the error from propagating
//		intNumbersFluxWithException()
//				.doOnError(error -> System.out.println("Error: " + error))
//				.subscribe(System.out::println);
		
		// Print values from intNumbersFluxWithException and continue on errors
		intNumbersFluxWithException()
				.onErrorContinue((throwable, i) -> System.out.println(i))
				.subscribe(System.out::println);
		
		// Print values from intNumbersFluxWithException and when errors
		// happen, replace with a fallback sequence of -1 and -2
		intNumbersFluxWithException()
				.onErrorResume((throwable) -> Flux.just(-1, -2))
				.subscribe(System.out::println);
		
		System.out.println("Press a key to end");
		System.in.read();
	}
	
}
