package XMLTask;


public class Main {
    public static void main(String[] args) {

            Masterpiece master1 = JAXBProcessing.toObj();
            Processing.writingToTxtFile(master1);

        JAXBProcessing.toXml(); //Writing my stuff to xml

    }
}
