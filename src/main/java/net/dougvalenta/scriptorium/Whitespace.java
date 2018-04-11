/*
 * Copyright 2018 Doug Valenta.
 * Licensed under the terms of the MIT License.
 */
package net.dougvalenta.scriptorium;

import java.io.IOException;
import java.util.Arrays;

/**
 * Outputs whitespace characters to an {@link Appendable}.
 * 
 * @author Doug Valenta
 */
public class Whitespace {
	
	private static final int FILL_COUNT = 256;
	private static final char SPACE = ' ';
	private static final char TAB = '\t';
	private static final char NEWLINE = '\n';
	
	private static final String SPACES = fillString(FILL_COUNT, SPACE);
	private static final String TABS = fillString(FILL_COUNT, TAB);
	private static final String NEWLINES = fillString(FILL_COUNT, NEWLINE);
	
	private static String fillString(final int count, final char character) {
		final char[] characters = new char[count];
		Arrays.fill(characters, character);
		return new String(characters);
	}
	
	private final Appendable appendable;
	
	/**
	 * Constructs a new Whitespace instance that outputs whitespace to the provided
	 * {@link Appendable}.
	 * 
	 * @param appendable {@link Appendable} the new instance will output whitespace to
	 */
	public Whitespace(final Appendable appendable) {
		this.appendable = appendable;
	}
	
	/**
	 * Outputs a single space character and returns this object.
	 * 
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 * @see spaces(int)
	 */
	public Whitespace space() throws IOException {
		appendable.append(SPACE);
		return this;
	}
	
	/**
	 * Outputs the specified number of space characters and returns this object.
	 * 
	 * @param count the number of space characters to output
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 * @see space()
	 */
	public Whitespace spaces(final int count) throws IOException {
		if (count > 0) {
			switch (count) {
				case 1:
					appendable.append(SPACE);
					return this;
				default:
					if (count > FILL_COUNT) {
						appendable.append(SPACES);
						return spaces(count - FILL_COUNT);
					} else {
						appendable.append(SPACES, 0, count);
						return this;
					}
			}
		}
		return this;
	}
	
	/**
	 * Outputs a single tab character and returns this object.
	 * 
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 */
	public Whitespace tab() throws IOException {
		appendable.append(TAB);
		return this;
	}
	
	/**
	 * Outputs the specified number of tab characters and returns this object.
	 * 
	 * @param count the number of tab characters to output
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 */
	public Whitespace tabs(final int count) throws IOException {
		if (count > 0) {
			switch (count) {
				case 1:
					appendable.append(TAB);
					return this;
				default:
					if (count > FILL_COUNT) {
						appendable.append(TABS);
						return tabs(count - FILL_COUNT);
					} else {
						appendable.append(TABS, 0, count);
						return this;
					}
			}
		}
		return this;
	}
	
	/**
	 * Outputs a single newline character and returns this object.
	 * 
	 * @return this object
	 * @throws IOException if an I/O error occurs
	 */
	public Whitespace newline() throws IOException {
		appendable.append(NEWLINE);
		return this;
	}
	
	/**
	 * Outputs the specified number of newline characters and returns this object.
	 * 
	 * @param count the number of newline characters to output
	 * @return this object
	 * @throws IOException if an I/O error occurs 
	 */
	public Whitespace newlines(final int count) throws IOException {
		if (count > 0) {
			switch (count) {
				case 1:
					appendable.append(NEWLINE);
					return this;
				default:
					if (count > FILL_COUNT) {
						appendable.append(NEWLINES);
						return newlines(count - FILL_COUNT);
					} else {
						appendable.append(NEWLINES, 0, count);
						return this;
					}
			}
		}
		return this;
	}
	
}
