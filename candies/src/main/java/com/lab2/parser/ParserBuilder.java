package com.lab2.parser;

public class ParserBuilder {
    public Parser buildParser(String type) {
        switch (type.toLowerCase()) {
            case "dom":
                return new DOMParser();
            case "sax":
                return new SAXParser();
            case "stax":
                return new StAXParser();
            default:
                throw new IllegalArgumentException("Неизвестный тип парсера: " + type);
        }
    }
}
