package XMLTask;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMProcessing {
    static Masterpiece masterpiece = new Masterpiece();
    static Author author = new Author();
    static Line line = new Line();

    public static Masterpiece toObj() {
        try {
            //  C:\Users\User\IdeaProjects\Homework18\X-Files
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(Processing.getCheckList()));

            //Setting "type" field
            masterpiece.setType(document
                    .getElementsByTagName("sonnet")
                    .item(0)
                    .getAttributes()
                    .getNamedItem("type")
                    .getNodeValue());
            // Setting "title" field
            masterpiece.setTitle(document.getElementsByTagName("title").item(0).getTextContent());
            // Setting "author" fields
            author.setFirstName(document.getElementsByTagName("firstName").item(0).getTextContent());
            author.setLastName(document.getElementsByTagName("lastName").item(0).getTextContent());
            author.setNationality(document.getElementsByTagName("nationality").item(0).getTextContent());
            author.setYearOfBirth(Integer.parseInt(document.getElementsByTagName("yearOfBirth").item(0).getTextContent()));
            author.setYearOfDeath(Integer.parseInt(document.getElementsByTagName("yearOfDeath").item(0).getTextContent()));
            masterpiece.setAuthor(author);
            //Setting "line" field
            NodeList nodeList = document.getElementsByTagName("line");
            for (int i = 0; i < nodeList.getLength(); i++) {
                line.getLine().add(document.getElementsByTagName("line").item(i).getTextContent());
            }
            masterpiece.setLines(line);

            System.out.println(masterpiece);
            return masterpiece;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
