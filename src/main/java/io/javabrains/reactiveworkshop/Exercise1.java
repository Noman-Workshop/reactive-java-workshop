package io.javabrains.reactiveworkshop;

import java.util.function.Function;
import java.util.stream.Collectors;

import static io.javabrains.reactiveworkshop.StreamSources.intNumbersStream;
import static io.javabrains.reactiveworkshop.StreamSources.userStream;

public class Exercise1 {
	
	public static void main(String[] args) {
		
		// Use StreamSources.intNumbersStream() and StreamSources.userStream()
		
		// Print all numbers in the intNumbersStream stream
		System.out.println("Print all numbers in the intNumbersStream stream");
		intNumbersStream().forEach(System.out::println);
		
		// Print numbers from intNumbersStream that are less than 5
		System.out.println("Print numbers from intNumbersStream that are less than 5");
		intNumbersStream().filter(i -> i < 5)
		                  .forEach(System.out::println);
		
		// Print the second and third numbers in intNumbersStream that's greater than 5
		System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
		intNumbersStream().filter(i -> i > 5)
		                  .skip(1)
		                  .limit(2)
		                  .forEach(System.out::println);
		
		// Print the first number in intNumbersStream that's greater than 5
		System.out.println("Print the first number in intNumbersStream that's greater than 5");
		// If nothing is found, print -1
		System.out.println("If nothing is found, print -1");
		System.out.println(intNumbersStream().filter(i -> i > 5)
		                                     .findFirst()
		                                     .orElse(-1));
		
		
		// Print first names of all users in userStream
		System.out.println("Print first names of all users in userStream");
		userStream().forEach(user -> System.out.println(user.getFirstName()));
		
		// Print first names in userStream for users that have IDs from number stream
		System.out.println("Print first names in userStream for users that have IDs from number stream");
		var userMap = userStream().collect(Collectors.toMap(User::getId, Function.identity()));
		intNumbersStream().filter(i -> userMap.containsKey(i))
		                  .map(i -> userMap.get(i)
		                                   .getFirstName())
		                  .forEach(System.out::println);
	}
	
}
