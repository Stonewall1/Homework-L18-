package XMLTask;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Processing {
    public static String getCheckList() {
        return checkList();
    }

    private static String checkList() {
        // C:\Users\User\IdeaProjects\Homework18\X-Files
        String resultFile = "";
        try (DirectoryStream<Path> listOfFiles = Files.newDirectoryStream(Paths.get(Input.getInputPathToFolder()))) {
            List<String> list = listFill(listOfFiles);
            int xmlFilesCount = 0;
            for (String file : list) {
                if (file.matches(".+\\.xml\\b")) {
                    xmlFilesCount++;
                }
            }
            if (xmlFilesCount > 1) {
                throw new LotOfXMLFilesException();
            }
            if (list.size() == 0) {
                throw new NoFilesException();
            }
            for (String f : list) {
                if (f.matches(".+\\.xml\\b")) {
                    resultFile = f;
                    break;
                }
            }
        } catch (IOException | NoFilesException | LotOfXMLFilesException e) {
            e.printStackTrace();
        }
        return resultFile;
    }

    private static List<String> listFill(DirectoryStream<Path> listOfFiles) {
        List<String> list = new ArrayList<>();
        for (Path path : listOfFiles) {
            list.add(path.toString());
        }
        return list;
    }

    public static void writingToTxtFile(Masterpiece master){
        File filePath = new File(master.getAuthor().getFirstName() + "_"
                                    + master.getAuthor().getLastName() + "_"
                                    + master.getTitle() + ".txt");
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(String s : master.getLines().getLine()){
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
