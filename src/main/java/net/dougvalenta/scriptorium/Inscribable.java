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
 * Provides support for polyglot inscription services and inversion of flow control.
 * 
 * <p>
 * Implementers may choose to pass another type {@code <I>} to consumers, e.g. a
 * broader type that does not have methods consumers should not call (like close() or then()).
 * This is referred to as the inscribed type.
 * 
 * @author Doug Valenta
 * @param <I> the inscribed type
 * @param <THIS> this type
 */
public interface Inscribable<I, THIS extends Inscribable<I, THIS>> {
	
	public default <T extends FluentNode<THIS>> T inscribe(IOFunction<? super THIS, T> function) throws IOException {
		return function.apply((THIS) this);
	}
	
	/**
	 * Calls the provided {@link IOConsumer}, passing an instance of the inscribed
	 * type, and returns this object.
	 * 
	 * <p>
	 * When this method returns, the provided consumer's {@link IOConsumer#accept(Object)}
	 * method will have already returned.
	 * 
	 * @param consumer the {@link IOConsumer} to call with an instance of the inscribed type
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 */
	public THIS with(IOConsumer<? super I> consumer) throws IOException;
	
	/**
	 * Calls the provided {@link IOBiConsumer}, passing the provided element and an 
	 * instance of the inscribed type, and returns this object.
	 * 
	 * <p>
	 * When this method returns, the provided bi-consumer's {@link IOBiConsumer#accept(Object, Object)}
	 * method will have already returned.
	 * 
	 * @param element the element to pass as the first argument of the provided bi-consumer
	 * @param biConsumer the {@link IOBiConsumer} to call with an instance of the inscribed type
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 */
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
