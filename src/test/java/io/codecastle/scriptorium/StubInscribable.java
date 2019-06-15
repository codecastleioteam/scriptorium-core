/*
 * Copyright 2018-2019 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.scriptorium;

import java.io.IOException;
import io.codecastle.scriptorium.function.IOBiConsumer;
import io.codecastle.scriptorium.function.IOConsumer;
import io.codecastle.scriptorium.function.IOFunction;

/**
 *
 * @author Doug Valenta
 */
public class StubInscribable implements Inscribable {

	@Override
	public Inscription inscribe(IOFunction function) throws IOException {
		throw new UnsupportedOperationException("Not implemented");
	}

	@Override
	public Inscribable with(IOConsumer consumer) throws IOException {
		return this;
	}

	@Override
	public Inscribable with(Object element, IOBiConsumer biConsumer) throws IOException {
		return this;
	}
	
}
