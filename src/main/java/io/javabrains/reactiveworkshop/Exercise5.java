package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise5 {
	
	public static void main(String[] args) throws IOException {
		
		// Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()
		
		// Subscribe to a flux using the error and completion hooks
		Disposable completed = intNumbersFlux().subscribe(System.out::println,
		                                                  System.out::println,
		                                                  () -> System.out.println("Completed"));
		// we can dispose the subscription early
//		completed.dispose();
		
		// Subscribe to a flux using an implementation of BaseSubscriber
		intNumbersFlux().subscribe(new BaseSubscriber<>() {
			
			@Override
			public void hookOnSubscribe(Subscription subscription) {
				request(1);
			}
			
			@Override
			public void hookOnNext(Integer value) {
				System.out.println(value);
				request(1);
			}
			
			@Override
			public void hookOnComplete() {
				System.out.println("Completed");
			}
			
			@Override
			public void hookOnError(Throwable throwable) {
				System.out.println("Error: " + throwable);
			}
		});
		
		System.out.println("Press a key to end");
		System.in.read();
		
		// only an item is an intermediate event
		// error and complete are terminal events
		
		// using base subscriber we can control the subscription
		// its not pull based, its push based
		// request method is ok to push signal, not pull
	}
	
}