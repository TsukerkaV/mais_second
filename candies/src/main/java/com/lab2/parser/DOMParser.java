package com.lab2.parser;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import com.lab2.parser.Parser;

public class DOMParser implements Parser {
    private static final Logger logger = LogManager.getLogger(DOMParser.class);

    @Override
    public void parse(String xmlFilePath) {
        try {
            logger.info("Начало парсинга с помощью DOM Parser");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFilePath);

            NodeList candyList = doc.getElementsByTagName("Candy");

            for (int i = 0; i < candyList.getLength(); i++) {
                Node candy = candyList.item(i);
                if (candy.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) candy;
                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    logger.info("Конфета: " + name);
                    // Обработка других полей...
                }
            }
            logger.info("Парсинг завершен");
        } catch (Exception e) {
            logger.error("Ошибка при парсинге XML", e);
        }
    }
}
