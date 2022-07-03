package XMLTask;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JAXBProcessing {
    public static Masterpiece toObj() {
        File path = new File(Processing.getCheckList());
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Masterpiece.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Masterpiece unmarshal = (Masterpiece) jaxbUnmarshaller.unmarshal(path);
            System.out.println(unmarshal);
            return unmarshal;
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void toXml() {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Masterpiece.class);
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Masterpiece masterpiece = creatingMyMasterpiece();

            marshallerObj.marshal(masterpiece, new File("result.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private static Masterpiece creatingMyMasterpiece() {
        Masterpiece masterpiece = new Masterpiece();
        masterpiece.setTitle("MyTitle");
        masterpiece.setType("Test");

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("That's");
        list.add("My");
        list.add("Lines");
        Line line = new Line();
        line.setLine(list);
        masterpiece.setLines(line);

        Author myAuthor = new Author();
        myAuthor.setFirstName("Ilya");
        myAuthor.setLastName("Prigozhaev");
        myAuthor.setNationality("Belarus");
        myAuthor.setYearOfBirth(1997);
        masterpiece.setAuthor(myAuthor);
        return masterpiece;
    }
}
