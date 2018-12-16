import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    static ArrayList<File> file1 = new ArrayList<>();

    public static void main(String[] args) {

        String mode = "2";
        String path = "C:\\Wrath of the Lich King 3.3.5a (wod models)\\Cache";
        File dirPath = new File(path);
        switch (mode) {
            case "1": //Mode 1: Returns file name with max amount of "s" chars in it.
                System.out.println("Mode 1 selected");
                SCounter sCounter = new SCounter();
                processFilesFromFolder(dirPath);
                file1.forEach((a)-> System.out.println(a.toString()));

                System.out.println("\nResult:\n");

                System.out.println(sCounter.maxSSymbolsInFileNames(file1));
                break;
            case "2": //Mode 2: Shows top 5 heaviest files.
                System.out.println("Mode 2 selected");
                FileSorterBySize fileSortedBySize = new FileSorterBySize();
                processFilesFromFolder(dirPath);
                Map filesSizesSorted = fileSortedBySize.getTop5Heaviest(file1);
                iterateThroughHashMapJava8(filesSizesSorted);
                break;
            case "3": //Mode 3: Calculates average file size in selected directory and its sub-directories.
                System.out.println("Mode 3 selected");
                break;
            case "4": //Mode 4: Shows amount of files and directories which starts with some char from alphabet (for each char in alphabet).
                System.out.println("Mode 4 selected");
                break;
            default:
                System.out.println("Wrong mode entered");
        }


    }

    private static void processFilesFromFolder(File path)
    {
        File[] folderEntries = path.listFiles();
        assert folderEntries != null;
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                processFilesFromFolder(entry);
            } else
                file1.add(entry);
        }
    }

    // How to Iterate through HashMap in Java 8?
    private static void iterateThroughHashMapJava8(Map<File, Long> crunchifyMap) {
            crunchifyMap.forEach((k, v) -> {
            System.out.println("File: " + k.toString() + "\t\t Size: " + v);
        });
    }
    }
