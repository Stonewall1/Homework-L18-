package XMLTask;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXProcessing {
    static Masterpiece masterpiece = new Masterpiece();

    public static Masterpiece toObj() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(Processing.getCheckList()), handler);

            System.out.println(masterpiece);
            return masterpiece;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class XMLHandler extends DefaultHandler {
        private Author author = new Author();
        private String title;
        private Line lines = new Line();
        private String last;


        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            last = qName;
            if (qName.equals("sonnet")) {
                masterpiece.setType(attributes.getValue("type"));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            masterpiece.setAuthor(author);
            masterpiece.setTitle(title);
            masterpiece.setLines(lines);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String info = new String(ch, start, length);
            info = info.replace("\n", "").trim();
            if (!info.isEmpty()) {
                if (last.equals("lastName")) {
                    author.setLastName(info);
                }
                if (last.equals("firstName")) {
                    author.setFirstName(info);
                }
                if (last.equals("nationality")) {
                    author.setNationality(info);
                }
                if (last.equals("yearOfBirth")) {
                    author.setYearOfBirth(Integer.parseInt(info));
                }
                if (last.equals("yearOfDeath")) {
                    author.setYearOfDeath(Integer.parseInt(info));
                }
                if (last.equals("line")) {
                    lines.getLine().add(info);
                }
                if (last.equals("title")) {
                    title = info;
                }
            }
        }
    }
}
