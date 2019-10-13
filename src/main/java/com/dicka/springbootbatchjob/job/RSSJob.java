package com.dicka.springbootbatchjob.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

@Component
public class RSSJob {

    /** 60 detik **/
    @Scheduled(cron = "0 * * * * *")
    public void read(){
        try{
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse("http://feeds.reuters.com/news/artsculture?format=xml", new DefaultHandler(){

                private boolean isItem = false;
                private String tagName = "";

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {

                    if (this.isItem) {

                        if (tagName.equalsIgnoreCase("title")) {
                            System.out.println("Title : " + (new String(ch, start, length)));
                            tagName = "";
                        }

                        if (tagName.equalsIgnoreCase("description")) {
                            System.out.println("Description : " + (new String(ch, start, length)));
                            tagName = "";
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    tagName = qName;
                    if (tagName.equalsIgnoreCase("item")){
                        this.isItem = false;
                    }
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    tagName = qName;
                    if (tagName.equalsIgnoreCase("item")){
                        this.isItem = true;
                    }
                }
            });
        }catch (Exception e){
            e.getLocalizedMessage();
            System.err.println(e.getLocalizedMessage());
        }
    }
}
