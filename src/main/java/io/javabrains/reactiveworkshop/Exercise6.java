package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static io.javabrains.reactiveworkshop.ReactiveSources.unresponsiveFlux;
import static io.javabrains.reactiveworkshop.ReactiveSources.unresponsiveMono;

public class Exercise6 {
	
	
	public static void main(String[] args) throws IOException {
		
		// Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()
		
		// Get the value from the Mono into a String variable but give up after 5 seconds
		System.out.println("Get the value from the Mono into a String variable but give up after 5 seconds");
		String value = unresponsiveMono().timeout(Duration.ofSeconds(5))
		                                 .doOnError(throwable -> System.out.println(
				                                 "Couldn't retrieve value from Mono within 5 seconds"))
		                                 .onErrorReturn("")
		                                 .block();
		System.out.println(value);
		
		// Get the value from unresponsiveFlux into a String list but give up after 5 seconds
		// Come back and do this when you've learnt about operators!
		System.out.println("Get the value from unresponsiveFlux into a String list but give up after 5 seconds");
		var list = unresponsiveFlux().collectList()
		                             .timeout(Duration.ofSeconds(5))
		                             .doOnError(throwable -> System.out.println(
				                             "Couldn't retrieve value from Mono within 5 seconds"))
		                             .onErrorReturn(List.of())
		                             .block();
		System.out.println(list);
		
		System.out.println("Press a key to end");
		System.in.read();
	}
	
}
