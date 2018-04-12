/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium;

import java.io.IOException;
import net.dougvalenta.scriptorium.function.IOBiConsumer;
import net.dougvalenta.scriptorium.function.IOConsumer;
import net.dougvalenta.scriptorium.function.IOFunction;

/**
 *
 * @author Doug Valenta
 */
public class StubInscribable implements Inscribable {

	@Override
	public FluentNode inscribe(IOFunction function) throws IOException {
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
