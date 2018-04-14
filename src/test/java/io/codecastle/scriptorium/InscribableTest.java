/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.scriptorium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import io.codecastle.scriptorium.function.IOBiConsumer;
import io.codecastle.scriptorium.function.IOConsumer;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 *
 * @author Doug Valenta
 */
public class InscribableTest {
	
	@Test
	public void testWithIfTrue() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOConsumer consumer = Mockito.mock(IOConsumer.class);
		final Inscribable result = inscribable.withIf(true, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withIf(true, consumer);
		Mockito.verify(inscribable).with(consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithIfFalse() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOConsumer consumer = Mockito.mock(IOConsumer.class);
		final Inscribable result = inscribable.withIf(false, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withIf(false, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithIfNotNullWithNotNull() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Object element = new Object();
		final Inscribable result = inscribable.withIfNotNull(element, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withIfNotNull(element, consumer);
		Mockito.verify(inscribable).with(element, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithIfNotNullWithNull() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Inscribable result = inscribable.withIfNotNull(null, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withIfNotNull(null, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithIfPresentWithPresent() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Object element = new Object();
		final Optional<Object> optional = Optional.of(element);
		final Inscribable result = inscribable.withIfPresent(optional, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withIfPresent(optional, consumer);
		Mockito.verify(inscribable).with(element, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithIfPresentWithNotPresent() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Optional<Object> optional = Optional.empty();
		final Inscribable result = inscribable.withIfPresent(optional, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withIfPresent(optional, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithEachWithArray() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Object[] elements = {new Object(), new Object(), new Object()};
		final Inscribable result = inscribable.withEach(elements, consumer);
		Assert.assertEquals(inscribable, result);
		final InOrder inOrder = Mockito.inOrder(inscribable);
		inOrder.verify(inscribable).withEach(elements, consumer);
		inOrder.verify(inscribable).with(elements[0], consumer);
		inOrder.verify(inscribable).with(elements[1], consumer);
		inOrder.verify(inscribable).with(elements[2], consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithEachWithEmptyArray() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Object[] elements = new Object[0];
		final Inscribable result = inscribable.withEach(elements, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withEach(elements, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithEachWithNullArray() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Inscribable result = inscribable.withEach((Object[]) null, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withEach((Object[]) null, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithEachWithIterable() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final List<Object> elements = new ArrayList<>(3);
		elements.add(new Object());
		elements.add(new Object());
		elements.add(new Object());
		final Inscribable result = inscribable.withEach(elements, consumer);
		Assert.assertEquals(inscribable, result);
		final InOrder inOrder = Mockito.inOrder(inscribable);
		inOrder.verify(inscribable).withEach(elements, consumer);
		inOrder.verify(inscribable).with(elements.get(0), consumer);
		inOrder.verify(inscribable).with(elements.get(1), consumer);
		inOrder.verify(inscribable).with(elements.get(2), consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithEachWithEmptyIterable() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Collection<Object> elements = Collections.emptySet();
		final Inscribable result = inscribable.withEach(elements, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withEach(elements, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
	@Test
	public void testWithEachWithNullIterable() throws IOException {
		final Inscribable inscribable = Mockito.spy(new StubInscribable());
		final IOBiConsumer consumer = Mockito.mock(IOBiConsumer.class);
		final Inscribable result = inscribable.withEach((Iterable<Object>) null, consumer);
		Assert.assertEquals(inscribable, result);
		Mockito.verify(inscribable).withEach((Iterable<Object>) null, consumer);
		Mockito.verifyNoMoreInteractions(inscribable);
		Mockito.verifyZeroInteractions(consumer);
	}
	
}
