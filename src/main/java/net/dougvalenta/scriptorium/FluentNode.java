/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium;

import java.io.Closeable;
import java.io.IOException;

/**
 * A fluent primitive for nested fluent interfaces.
 * 
 * <p>
 * Intended to support fluent interfaces that return FluentNode objects that are parameterized
 * with the returning type, and return the returning object when their {@link FluentNode#then()}
 * method is called.
 * 
 * @author Doug Valenta
 * @param <P> the parent type 
 */
public interface FluentNode<P> extends Closeable {
	
	/**
	 * Returns this nodes parent.
	 * 
	 * <p>
	 * Implementers may output the closure of a nested structure before returning.
	 * 
	 * @return this node's parent
	 * @throws IOException if there is an exception while outputting the closure of a
	 * nested structure
	 */
	public P then() throws IOException;
	
}
