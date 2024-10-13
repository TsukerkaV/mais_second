package com.lab2.parser;

//import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXParser implements Parser {
    @Override
    public void parse(String xmlFilePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler();
            saxParser.parse(xmlFilePath, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
