package XMLTask;

public class Main {
    public static void main(String[] args) {
        // C:\Users\User\IdeaProjects\Homework18\X-Files

        JAXBProcessing.toXml(); //Writing my stuff to xml

        System.out.println("Enter 1,2, or 3");
        String X = Input.numberInput();

        //JAXB
        if(X.equals("1")){
            Masterpiece master1 = JAXBProcessing.toObj();
            Processing.writingToTxtFile(master1);
        }
        //SAX
        else if(X.equals("2")){
            Masterpiece master2 = SAXProcessing.toObj();
            Processing.writingToTxtFile(master2);
        }
        //DOM
        else if(X.equals("3")){
            Masterpiece master3 = DOMProcessing.toObj();
            Processing.writingToTxtFile(master3);
        }
    }
}
