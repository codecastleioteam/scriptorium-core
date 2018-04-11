/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium;

import java.io.Closeable;
import java.io.IOException;

/**
 * A primitive for nested fluent interfaces.
 * 
 * <p>
 * The {@link #then()} method calls the {@link #close()} method and returns a parent
 * object.
 * 
 * @author Doug Valenta
 * @param <P> the parent type 
 */
public interface FluentNode<P> extends Closeable {
	
	/**
	 * Closes this node and returns its parent.
	 * 
	 * @return this node's parent
	 * @throws IOException if an I/O error occurs
	 * @see #close()
	 */
	public P then() throws IOException;
	
	/**
	 * Closes this node, and any child nodes that remain open.
	 * 
	 * <p>
	 * Subsequent calls to this method after the first on the same object should have no
	 * effect.
	 * 
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	public void close() throws IOException;
	
}
