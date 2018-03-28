/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium;

import java.io.IOException;

/**
 * 
 * @author Doug Valenta
 */
public interface Escaper {
	
	/**
	 * Appends the provided character or its escape sequence to the provided
	 * {@link Appendable}.
	 * 
	 * @param character the character to escape or append
	 * @param appendable the appendable to append the character or its escape sequence to
	 * @throws IOException if an exception occurs while appending to the underlying
	 * {@link Appendable}
	 */
	public void escape(char character, Appendable appendable) throws IOException;
	
}
