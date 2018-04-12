/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium.function;

import java.io.IOException;

/**
 * Represents an operation that accepts two input arguments and returns no result,
 * possibly throwing an {@link java.io.IOException}.
 * 
 * This is the two-arity specialization of {@link IOConsumer}.
 * 
 * <p>
 * This is a functional interface whose functional method is {@link #accept(Object, Object)}.
 * 
 * @author Doug Valenta
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @see IOConsumer
 * @see java.util.function.BiConsumer
 */
@FunctionalInterface
public interface IOBiConsumer<T, U> {
	
	/**
	 * Performs the operation on the given arguments.
	 * 
	 * @param t the first input argument
	 * @param u the second input argument
	 * @throws IOException if an I/O error occurs
	 */
	public void accept(T t, U u) throws IOException;
	
}
