package com.star.xml;

import java.io.InputStream;
import java.io.Reader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;

public final class StaxUtils {

	private StaxUtils() {
	}

	public static XMLStreamReader createXMLStreamReader(Reader reader) {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		try {
			return factory.createXMLStreamReader(reader);
		} catch (XMLStreamException e) {
			throw new RuntimeException("Couldn't parse stream.", e);
		}
	}

	public static XMLStreamReader createXMLStreamReader(InputStream in, String encoding) {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		try {
			return encoding == null ? factory.createXMLStreamReader(in) : factory.createXMLStreamReader(in, encoding);
		} catch (XMLStreamException e) {
			throw new RuntimeException("Couldn't parse stream.", e);
		}
	}

	public static XMLStreamReader createXMLStreamReader(Source source) {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		try {
			return factory.createXMLStreamReader(source);
		} catch (XMLStreamException e) {
			throw new RuntimeException("Couldn't parse stream.", e);
		}
	}
}
