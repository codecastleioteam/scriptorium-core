/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.scriptorium;

import java.io.IOException;

/**
 * A primitive for nested fluent interfaces.
 * 
 * @author Doug Valenta
 * @param <P> the parent type 
 */
public interface FluentNode<P> {
	
	/**
	 * Closes this node and returns its parent.
	 * 
	 * @return this node's parent
	 * @throws IOException if an I/O error occurs
	 */
	P then() throws IOException;
	
}
