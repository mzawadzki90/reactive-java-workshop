package io.javabrains.reactiveworkshop;

import java.io.IOException;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

	public static void main(String[] args) throws IOException {

		// Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

		// Subscribe to a flux using the error and completion hooks
		ReactiveSources.intNumbersFluxWithException().onErrorContinue((throwable, o) -> {
			System.out.println("error message: " + throwable.getMessage());
			System.out.println("processed object: " + o.toString());
		}).doOnComplete(() -> System.out.println("Hurray!")).subscribe(n -> System.out.println(n));

		// Subscribe to a flux using an implementation of BaseSubscriber
		ReactiveSources.intNumbersFluxWithRepeat().subscribe(new BaseSubscriber<>() {

			@Override
			protected void hookOnNext(Integer value) {
				super.hookOnNext(value);
				System.out.println(value);
			}

			@Override
			protected void hookOnComplete() {
				System.out.println("Hurray! Hurray!!!");
			}
		});

		System.out.println("Press a key to end");
		System.in.read();
	}

}