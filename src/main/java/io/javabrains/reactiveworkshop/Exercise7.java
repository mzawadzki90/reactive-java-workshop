package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

		// Print all values from intNumbersFlux that's greater than 5
		ReactiveSources.intNumbersFlux().filter(n -> n > 5).subscribe(n -> System.out.println(n));

		// Print 10 times each value from intNumbersFlux that's greater than 5
		ReactiveSources.intNumbersFlux().filter(n -> n > 5).repeat(10).subscribe(n -> System.out.println(n));

		// Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
		ReactiveSources.intNumbersFlux().filter(n -> n > 5).repeat(10).take(3).subscribe(n -> System.out.println(n));

		// Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
		ReactiveSources.intNumbersFlux().filter(n -> n > 20).defaultIfEmpty(-1).subscribe(n -> System.out.println(n));

		// Switch ints from intNumbersFlux to the right user from userFlux
		ReactiveSources.intNumbersFlux().flatMap(n -> ReactiveSources.userMono()).subscribe(u -> System.out.println(u));

		// Print only distinct numbers from intNumbersFluxWithRepeat
		ReactiveSources.intNumbersFluxWithRepeat().distinct().subscribe(n -> System.out.println(n));

		// Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
		ReactiveSources.intNumbersFluxWithRepeat().distinctUntilChanged().subscribe(n -> System.out.println(n));

		System.out.println("Press a key to end");
		System.in.read();
	}

}
