package com.lab2;

import com.lab2.parser.ParserBuilder;
// import com.lab2.parser.DOMParser;
// import com.lab2.parser.SAXParser;
// import com.lab2.parser.SAXParserHandler;
// import com.lab2.parser.StAXParser;
import com.lab2.parser.Parser;

public class App {
    public static void main(String[] args) {
        String xmlFilePath = "/Users/verailukevic/Desktop/Раф/МАИС/candies/resources/candies.xml";
        ParserBuilder builder = new ParserBuilder();

        // DOM Parser
        Parser domParser = builder.buildParser("dom");
        domParser.parse(xmlFilePath);

        // SAX Parser
        Parser saxParser = builder.buildParser("sax");
        saxParser.parse(xmlFilePath);

        // StAX Parser
        Parser staxParser = builder.buildParser("stax");
        staxParser.parse(xmlFilePath);
    }
}
