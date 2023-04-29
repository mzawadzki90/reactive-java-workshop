package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise3 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumbersFlux()

		// Get all numbers in the ReactiveSources.intNumbersFlux stream
		// into a List and print the list and its size
		ReactiveSources.intNumbersFlux().collectList().subscribe(list -> {
			System.out.println(list.size());
			list.forEach(n -> System.out.print(n + " "));
			System.out.println();
		});

		System.out.println("Press a key to end");
		System.in.read();
	}

}
