package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise9 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumbersFlux()

		// Print size of intNumbersFlux after the last item returns
		final AtomicInteger counter = new AtomicInteger(0);
		ReactiveSources.intNumbersFlux()
				.doOnNext(n -> counter.incrementAndGet())
				.doOnComplete(() -> System.out.println("size: " + counter.get()))
				.subscribe();

		// Collect all items of intNumbersFlux into a single list and print it
		ReactiveSources.stringNumbersFlux().collectList().subscribe(list -> System.out.println(list));

		// Transform to a sequence of sums of adjacent two numbers
		ReactiveSources.intNumbersFlux().buffer(2, 1).mapNotNull(list -> {
			// check the list size
			if (list.size() == 1) {
				return null;
			}
			return list.get(0) + list.get(1);
		}).subscribe(n -> System.out.println(n));

		System.out.println("Press a key to end");
		System.in.read();
	}

}
