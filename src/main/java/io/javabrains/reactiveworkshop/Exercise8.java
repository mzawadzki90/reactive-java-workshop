package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise8 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumbersFluxWithException()

		// Print values from intNumbersFluxWithException and print a message when error happens
		ReactiveSources.intNumbersFluxWithException()
				.subscribe(n -> System.out.println(n), throwable -> System.out.println("error message: " + throwable.getMessage()));

		// Print values from intNumbersFluxWithException and continue on errors
		ReactiveSources.intNumbersFluxWithException().onErrorContinue((throwable, o) -> {
			System.out.println("error message: " + throwable.getMessage());
			System.out.println("processed object: " + o.toString());
		}).subscribe(n -> System.out.println(n));

		// Print values from intNumbersFluxWithException and when errors happen, replace with a fallback sequence of -1 and -2
		ReactiveSources.intNumbersFluxWithException()
				.onErrorResume(throwable -> ReactiveSources.fallbackFlux())
				.subscribe(n -> System.out.println(n));

		System.out.println("Press a key to end");
		System.in.read();
	}

}
