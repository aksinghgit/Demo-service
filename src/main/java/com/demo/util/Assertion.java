package com.demo.util;

import java.util.function.Supplier;

/**
 * @author amritesh
 *
 */
public class Assertion {

	private Assertion() {
	}

	/**
	 * @param <T>
	 * @param condition
	 * @param exceptionSupplier
	 * @throws T  If condition is false then throw exception
	 */
	public static <T extends Exception> void assertTrue(boolean condition, Supplier<T> exceptionSupplier) throws T {
		if (!condition) {
			throw exceptionSupplier.get();
		}
	}

	/**
	 * @param <T>
	 * @param condition
	 * @param exceptionSupplier
	 * @throws T If condition is true then throw exception
	 */
	public static <T extends Exception> void assertFalse(boolean condition, Supplier<T> exceptionSupplier) throws T {
		if (condition) {
			throw exceptionSupplier.get();
		}
	}

}
