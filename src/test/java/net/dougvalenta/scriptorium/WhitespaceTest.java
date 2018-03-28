/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium;

import java.io.IOException;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Doug Valenta
 */
public class WhitespaceTest {
	
	private static final String SPACES_16;
	private static final String SPACES_256;
	private static final String SPACES_700;
	
	private static final String TABS_16;
	private static final String TABS_256;
	private static final String TABS_700;
	
	private static final String NEWLINES_16;
	private static final String NEWLINES_256;
	private static final String NEWLINES_700;
	
	static {
		final char[] char16 = new char[16];
		final char[] char256 = new char[256];
		final char[] char700 = new char[700];
		Arrays.fill(char16, ' ');
		Arrays.fill(char256, ' ');
		Arrays.fill(char700, ' ');
		SPACES_16 = new String(char16);
		SPACES_256 = new String(char256);
		SPACES_700 = new String(char700);
		Arrays.fill(char16, '\t');
		Arrays.fill(char256, '\t');
		Arrays.fill(char700, '\t');
		TABS_16 = new String(char16);
		TABS_256 = new String(char256);
		TABS_700 = new String(char700);
		Arrays.fill(char16, '\n');
		Arrays.fill(char256, '\n');
		Arrays.fill(char700, '\n');
		NEWLINES_16 = new String(char16);
		NEWLINES_256 = new String(char256);
		NEWLINES_700 = new String(char700);
	}
	
	@Test
	public void testOneSpace() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.space();
		Assert.assertEquals(" ", builder.toString());
	}
	
	@Test
	public void testSpaces() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.spaces(16);
		Assert.assertEquals(SPACES_16, builder.toString());
		builder.setLength(0);
		whitespace.spaces(256);
		Assert.assertEquals(SPACES_256, builder.toString());
		builder.setLength(0);
		whitespace.spaces(700);
		Assert.assertEquals(SPACES_700, builder.toString());
	}
	
	@Test
	public void testSpacesWithZero() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.spaces(0);
		Assert.assertEquals(0, builder.length());
	}
	
	@Test
	public void testSpacesWithOne() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.spaces(1);
		Assert.assertEquals(" ", builder.toString());
	}
	
	@Test
	public void testSpacesWithNegative() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.spaces(-99);
		Assert.assertEquals(0, builder.length());
	}
	
	@Test
	public void testOneTab() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.tab();
		Assert.assertEquals("\t", builder.toString());
	}
	
	@Test
	public void testTabs() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.tabs(16);
		Assert.assertEquals(16, builder.length());
		Assert.assertEquals(TABS_16, builder.toString());
		builder.setLength(0);
		whitespace.tabs(256);
		Assert.assertEquals(256, builder.length());
		Assert.assertEquals(TABS_256, builder.toString());
		builder.setLength(0);
		whitespace.tabs(700);
		Assert.assertEquals(700, builder.length());
		Assert.assertEquals(TABS_700, builder.toString());
	}
	
	@Test
	public void testTabsWithZero() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.tabs(0);
		Assert.assertEquals(0, builder.length());
	}
	
	@Test
	public void testTabsWithOne() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.tabs(1);
		Assert.assertEquals("\t", builder.toString());
	}
	
	@Test
	public void testTabsWithNegative() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.tabs(-99);
		Assert.assertEquals(0, builder.length());
	}
	
	@Test
	public void testOneNewline() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.newline();
		Assert.assertEquals("\n", builder.toString());
	}
	
	@Test
	public void testNewlines() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.newlines(16);
		Assert.assertEquals(16, builder.length());
		Assert.assertEquals(NEWLINES_16, builder.toString());
		builder.setLength(0);
		whitespace.newlines(256);
		Assert.assertEquals(256, builder.length());
		Assert.assertEquals(NEWLINES_256, builder.toString());
		builder.setLength(0);
		whitespace.newlines(700);
		Assert.assertEquals(700, builder.length());
		Assert.assertEquals(NEWLINES_700, builder.toString());
	}
	
	@Test
	public void testNewlinesWithZero() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.newlines(0);
		Assert.assertEquals(0, builder.length());
	}
	
	@Test
	public void testNewlinesWithOne() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.newlines(1);
		Assert.assertEquals("\n", builder.toString());
	}
	
	@Test
	public void testNewlinesWithNegative() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		whitespace.newlines(-99);
		Assert.assertEquals(0, builder.length());
	}
	
}
