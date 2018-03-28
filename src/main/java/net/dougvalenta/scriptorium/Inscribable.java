/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium;

import net.dougvalenta.scriptorium.function.IOFunction;
import net.dougvalenta.scriptorium.function.IOBiConsumer;
import net.dougvalenta.scriptorium.function.IOConsumer;
import java.io.IOException;
import java.util.Optional;

/**
 * Implementers may choose to pass another type {@code <I>} to consumers, e.g. a
 * broader type that does not have methods consumers should not call.
 * 
 * @author Doug Valenta
 * @param <I> the type to pass to consumers
 * @param <THIS> this type
 */
public interface Inscribable<I, THIS extends Inscribable<I, THIS>> {
	
	public default <T extends FluentNode<THIS>> T inscribe(IOFunction<? super THIS, ? extends T> function) throws IOException {
		return function.apply((THIS) this);
	}
	
	public THIS with(IOConsumer<? super I> consumer) throws IOException;
	
	public <T> THIS with(T element, IOBiConsumer<? super T, ? super I> biConsumer) throws IOException;
	
	public default THIS withIf(final boolean condition, final IOConsumer<? super I> consumer) throws IOException {
		if (condition) return with(consumer);
		return (THIS) this;
	}
	
	public default <T> THIS withIfNotNull(final T element, final IOBiConsumer<? super T, ? super I> biConsumer) throws IOException {
		if (element != null) return with(element, biConsumer);
		return (THIS) this;
	}
	
	public default <T> THIS withIfPresent(final Optional<? extends T> optionalElement, final IOBiConsumer<? super T, ? super I> biConsumer) throws IOException {
		if (optionalElement.isPresent()) return with(optionalElement.get(), biConsumer);
		return (THIS) this;
	}
	
	public default <T> THIS withEach(final T[] elements, final IOBiConsumer<? super T, ? super I> biConsumer) throws IOException {
		if (elements != null) {
			for (T element : elements) {
				with(element, biConsumer);
			}
		}
		return (THIS) this;
	}
	
	public default <T> THIS withEach(final Iterable<? extends T> elements, final IOBiConsumer<? super T, ? super I> biConsumer) throws IOException {
		if (elements != null) {
			for (T element : elements) {
				with(element, biConsumer);
			}
		}
		return (THIS) this;
	}
	
}
