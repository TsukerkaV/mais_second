package com.lab2.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SAXParserHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger(SAXParserHandler.class);

    private String currentElement;
    private String candyName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if ("Candy".equals(qName)) {
            String id = attributes.getValue("id");
            logger.info("Начало обработки конфеты с ID: " + id);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).trim();
        if (!data.isEmpty()) {
            if ("Name".equals(currentElement)) {
                candyName = data;
                logger.info("Название конфеты: " + candyName);
            }
            // Обработка других элементов...
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("Candy".equals(qName)) {
            logger.info("Завершена обработка конфеты: " + candyName);
        }
        currentElement = null;
    }
}
