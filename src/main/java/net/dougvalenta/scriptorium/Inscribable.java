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
	
	/**
	 * Inscribes another {@link FluentNode} in this object, and returns it.
	 * 
	 * <p>
	 * This method calls the provided function, passing this object as the input, and 
	 * returns the output.
	 * 
	 * <p>
	 * When the {@link FluentNode#then()} method of the returned node is called, this
	 * object will be returned.
	 * 
	 * <p>
	 * When this object or a parent object is closed, the FluentNode returned by
	 * this method will also be closed if it has not already been.
	 * 
	 * @param <T> the inscription type
	 * @param function a function that returns a {@link FluentNode} whose parent is the
	 * function's argument
	 * @return the output of the provided function when called with this object as an
	 * argument
	 * @throws IOException if an I/O error occurs 
	 */
	public <T extends FluentNode<THIS>> T inscribe(IOFunction<? super THIS, T> function) throws IOException;
	
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
	 * @see #withIf(boolean, IOConsumer)
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
	 * @param <T> the type of the element
	 * @param element the element to pass as the first argument of the provided bi-consumer
	 * @param biConsumer the {@link IOBiConsumer} to call with an instance of the inscribed type
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 * @see #withIfNotNull(Object, IOBiConsumer)
	 * @see #withIfPresent(Optional, IOBiConsumer)
	 * @see #withEach(Object[], IOBiConsumer)
	 * @see #withEach(Iterable, IOBiConsumer)
	 */
	public <T> THIS with(T element, IOBiConsumer<? super T, ? super I> biConsumer) throws IOException;
	
	/**
	 * If the provided condition is true, calls the provided {@link IOConsumer}, 
	 * passing an instance of the inscribed type; then returns this object.
	 * 
	 * <p>
	 * When this method returns, the provided consumer's {@link IOConsumer#accept(Object)}
	 * method will have already returned if the condition is true.
	 * 
	 * <p>
	 * The default implementation delegates to {@link #with(IOConsumer)}
	 * when the provided condition is true.
	 * 
	 * @param condition if this argument is true, the provided consumer will be called,
	 * otherwise this method has no effect
	 * @param consumer the {@link IOConsumer} to call with an instance of the inscribed type
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 * @see #withIfNotNull(Object, IOBiConsumer)
	 * @see #withIfPresent(Optional, IOBiConsumer)
	 */
	public default THIS withIf(final boolean condition, final IOConsumer<? super I> consumer) throws IOException {
		if (condition) return with(consumer);
		return (THIS) this;
	}
	
	/**
	 * If the provided element is not null, calls the provided {@link IOBiConsumer}, 
	 * passing the provided element and an instance of the inscribed type; 
	 * then returns this object.
	 * 
	 * <p>
	 * When this method returns, the provided consumer's {@link IOBiConsumer#accept(Object, Object)}
	 * method will have already returned if the provided element is not null.
	 * 
	 * <p>
	 * The default implementation delegates to {@link #with(Object, IOBiConsumer)}
	 * when the provided element is not null.
	 * 
	 * @param <T> the type of the element
	 * @param element the element to pass as the first argument of the provided bi-consumer;
	 * if this argument is null, this method has no effect
	 * @param biConsumer the {@link IOBiConsumer} to call with an instance of the inscribed type
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 * @see #with(Object, IOBiConsumer)
	 * @see #withIfPresent(Optional, IOBiConsumer)
	 * @see #withIf(boolean, IOConsumer)
	 */
	public default <T> THIS withIfNotNull(final T element, final IOBiConsumer<? super T, ? super I> biConsumer) throws IOException {
		if (element != null) return with(element, biConsumer);
		return (THIS) this;
	}
	
	/**
	 * If the provided optional element is present, calls the provided {@link IOBiConsumer}, 
	 * passing the provided element and an instance of the inscribed type; 
	 * then returns this object.
	 * 
	 * <p>
	 * When this method returns, the provided consumer's {@link IOBiConsumer#accept(Object, Object)}
	 * method will have already returned if the provided optional element is present.
	 * 
	 * <p>
	 * The default implementation delegates to {@link #with(Object, IOBiConsumer)}
	 * when the provided optional element is present.
	 * 
	 * @param <T> the type of the element
	 * @param optionalElement the {@link Optional} whose contents will be pass as the first 
	 * argument of the provided bi-consumer; if this objects {@link Optional#isPresent()}
	 * method returns false, this method has no effect
	 * @param biConsumer the {@link IOBiConsumer} to call with an instance of the inscribed type
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 * @throws NullPointerException if {@code optionalElement} is null
	 * @see #with(Object, IOBiConsumer)
	 * @see #withIfNotNull(Object, IOBiConsumer)
	 * @see #withIf(boolean, IOConsumer)
	 */
	public default <T> THIS withIfPresent(final Optional<? extends T> optionalElement, final IOBiConsumer<? super T, ? super I> biConsumer) throws IOException {
		if (optionalElement.isPresent()) return with(optionalElement.get(), biConsumer);
		return (THIS) this;
	}
	
	/**
	 * Calls the provided {@link IOBiConsumer} multiple times, passing one of the 
	 * provided elements and an instance of the inscribed type; then returns this object.
	 * 
	 * <p>
	 * When this method returns, the provided bi-consumer's {@link IOBiConsumer#accept(Object, Object)}
	 * method will have already returned once for each element in elements.
	 * 
	 * <p>
	 * The default implementation iterates over the provided elements, delegating to
	 * {@link #with(Object, IOBiConsumer)} on each iteration.
	 * 
	 * <p>
	 * If the provided array is empty or null, this method has no effect.
	 * 
	 * @param <T> the type of the elements
	 * @param elements the elements to pass as the first argument of the provided bi-consumer
	 * @param biConsumer the {@link IOBiConsumer} to call with an instance of the inscribed type
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 * @see #withEach(Iterable, IOBiConsumer)
	 */
	public default <T> THIS withEach(final T[] elements, final IOBiConsumer<? super T, ? super I> biConsumer) throws IOException {
		if (elements != null) {
			for (T element : elements) {
				with(element, biConsumer);
			}
		}
		return (THIS) this;
	}
	
	/**
	 * Calls the provided {@link IOBiConsumer} multiple times, passing one of the 
	 * provided elements and an instance of the inscribed type; then returns this object.
	 * 
	 * <p>
	 * When this method returns, the provided bi-consumer's {@link IOBiConsumer#accept(Object, Object)}
	 * method will have already returned once for each element in elements.
	 * 
	 * <p>
	 * The default implementation iterates over the provided elements, delegating to
	 * {@link #with(Object, IOBiConsumer)} on each iteration.
	 * 
	 * <p>
	 * If the provided iterable is empty or null, this method has no effect.
	 * 
	 * @param <T> the type of the elements
	 * @param elements the elements to pass as the first argument of the provided bi-consumer
	 * @param biConsumer the {@link IOBiConsumer} to call with an instance of the inscribed type
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 * @see #withEach(Object[], IOBiConsumer)
	 */
	public default <T> THIS withEach(final Iterable<? extends T> elements, final IOBiConsumer<? super T, ? super I> biConsumer) throws IOException {
		if (elements != null) {
			for (T element : elements) {
				with(element, biConsumer);
			}
		}
		return (THIS) this;
	}
	
}
