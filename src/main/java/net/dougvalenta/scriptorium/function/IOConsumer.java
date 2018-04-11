/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium.function;

import java.io.IOException;

/**
 * Represents an operation that accepts a single input argument and returns no result,
 * possibly throwing an {@link java.io.IOException}.
 * 
 * <p>
 * This is a functional interface whose functional method is {@link #accept(Object)}.
 * 
 * @author Doug Valenta
 * @param <T> the type of the argument to the operation
 * @see IOBiConsumer
 * @see java.util.function.Consumer
 */
@FunctionalInterface
public interface IOConsumer<T> {
	
	/**
	 * Performs the operation on the given argument.
	 * 
	 * @param t the input argument
	 * @throws IOException if an I/O error occurs
	 */
	public void accept(T t) throws IOException;
	
}
