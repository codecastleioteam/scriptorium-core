/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.scriptorium;

import java.io.IOException;

/**
 * An extension of {@link Appendable} that uses a recursive type parameter for improved
 * fluency.
 * 
 * @author Doug Valenta
 * @param <THIS> this type
 */
public interface FluentAppendable<THIS extends FluentAppendable<THIS>> extends Appendable {
	
	@Override
	public THIS append(final char character) throws IOException;
	
	@Override
	public THIS append(final CharSequence sequence, final int start, final int end) throws IOException;
	
	@Override
	public THIS append(final CharSequence sequence) throws IOException;
	
}
