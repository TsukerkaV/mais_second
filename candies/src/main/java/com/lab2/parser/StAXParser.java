package com.lab2.parser;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;

public class StAXParser implements Parser {
    private static final Logger logger = LogManager.getLogger(StAXParser.class);

    @Override
    public void parse(String xmlFilePath) {
        try {
            logger.info("Начало парсинга с помощью StAX Parser");
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileInputStream(xmlFilePath));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName().getLocalPart();
                    if ("Candy".equals(localPart)) {
                        // Обработка конфеты
                        logger.info("Обработка элемента Candy");
                    }
                    // Обработка других элементов...
                }
            }
            logger.info("Парсинг завершен");
        } catch (Exception e) {
            logger.error("Ошибка при парсинге XML", e);
        }
    }
}
