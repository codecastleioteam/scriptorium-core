/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.scriptorium;

import java.io.IOException;

/**
 * Escapes characters being output to an {@link Appendable}.
 * 
 * @author Doug Valenta
 */
@FunctionalInterface
public interface Escaper {
	
	/**
	 * Outputs the provided character or its escape sequence to the provided
	 * {@link Appendable}.
	 * 
	 * @param character the character to escape or append
	 * @param appendable the appendable to append the character or its escape sequence to
	 * @throws IOException if an I/O error occurs
	 */
	public void escape(char character, Appendable appendable) throws IOException;
	
}
