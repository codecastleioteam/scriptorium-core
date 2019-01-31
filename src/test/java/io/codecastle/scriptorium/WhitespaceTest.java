/*
 * Copyright 2018-2019 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package io.codecastle.scriptorium;

import io.codecastle.scriptorium.scribe.Whitespace;
import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
		final Whitespace result = whitespace.space();
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(" ", builder.toString());
	}
	
	@Test
	public void testSpaces() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		Whitespace result = whitespace.spaces(16);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(SPACES_16, builder.toString());
		builder.setLength(0);
		result = whitespace.spaces(256);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(SPACES_256, builder.toString());
		builder.setLength(0);
		result = whitespace.spaces(700);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(SPACES_700, builder.toString());
	}
	
	@Test
	public void testSpacesWithZero() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.spaces(0);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(0, builder.length());
	}
	
	@Test
	public void testSpacesWithOne() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.spaces(1);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(" ", builder.toString());
	}
	
	@Test
	public void testSpacesWithNegative() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.spaces(-99);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(0, builder.length());
	}
	
	@Test
	public void testOneTab() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.tab();
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals("\t", builder.toString());
	}
	
	@Test
	public void testTabs() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		Whitespace result = whitespace.tabs(16);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(16, builder.length());
		Assertions.assertEquals(TABS_16, builder.toString());
		builder.setLength(0);
		result = whitespace.tabs(256);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(256, builder.length());
		Assertions.assertEquals(TABS_256, builder.toString());
		builder.setLength(0);
		result = whitespace.tabs(700);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(700, builder.length());
		Assertions.assertEquals(TABS_700, builder.toString());
	}
	
	@Test
	public void testTabsWithZero() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.tabs(0);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(0, builder.length());
	}
	
	@Test
	public void testTabsWithOne() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.tabs(1);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals("\t", builder.toString());
	}
	
	@Test
	public void testTabsWithNegative() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.tabs(-99);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(0, builder.length());
	}
	
	@Test
	public void testOneNewline() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.newline();
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals("\n", builder.toString());
	}
	
	@Test
	public void testNewlines() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		Whitespace result = whitespace.newlines(16);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(16, builder.length());
		Assertions.assertEquals(NEWLINES_16, builder.toString());
		builder.setLength(0);
		result = whitespace.newlines(256);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(256, builder.length());
		Assertions.assertEquals(NEWLINES_256, builder.toString());
		builder.setLength(0);
		result = whitespace.newlines(700);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(700, builder.length());
		Assertions.assertEquals(NEWLINES_700, builder.toString());
	}
	
	@Test
	public void testNewlinesWithZero() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.newlines(0);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(0, builder.length());
	}
	
	@Test
	public void testNewlinesWithOne() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.newlines(1);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals("\n", builder.toString());
	}
	
	@Test
	public void testNewlinesWithNegative() throws IOException {
		final StringBuilder builder = new StringBuilder();
		final Whitespace whitespace = new Whitespace(builder);
		final Whitespace result = whitespace.newlines(-99);
		Assertions.assertEquals(whitespace, result);
		Assertions.assertEquals(0, builder.length());
	}
	
}
