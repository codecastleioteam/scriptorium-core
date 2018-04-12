/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium.function;

import java.io.IOException;

/**
 * Represents a function that accepts one argument and returns a result, possibly
 * throwing an {@link java.io.IOException}.
 * 
 * <p>
 * This is a functional interface whose functional method is {@link #apply(Object)}
 * 
 * @author Doug Valenta
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 */
@FunctionalInterface
public interface IOFunction<T, R> {
	
	/**
	 * Applies this function to the given argument.
	 * 
	 * @param t the function argument
	 * @return the function result
	 * @throws IOException if an I/O error occurs
	 */
	public R apply(T t) throws IOException;
	
}
