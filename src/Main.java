import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    static ArrayList<File> file1 = new ArrayList<>();

    public static void main(String[] args) {

        String mode = args[0];
        String path = args[1];
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
                ArrayList<File> filesSizesSorted = fileSortedBySize.getTop5(file1);
                for (int i = 0; i < 5; i++) {
                    System.out.println(filesSizesSorted.get(i).getName() + " " + fileSortedBySize.getFileSizeInKB(filesSizesSorted.get(i)) + " Kb");
                }
            break;
            case "3": //Mode 3: Calculates average file size in selected directory and its sub-directories.
                System.out.println("Mode 3 selected");
                AvgFileSize avgFileSize = new AvgFileSize();
                processFilesFromFolder(dirPath);
                System.out.println("Average file size is " + avgFileSize.getAverageFileSize(file1) + " bytes");
                break;
            case "4": //Mode 4: Shows amount of files and directories which starts with some char from alphabet (for each char in alphabet).
                System.out.println("Mode 4 selected");
                FirstLetterInFlieNameLister firstLetterInFlieNameLister = new FirstLetterInFlieNameLister();
                processFilesAndDirectoriesFromFolder(dirPath);
                firstLetterInFlieNameLister.logList(file1).forEach((a)-> System.out.println(a.toString()));
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

    private static void processFilesAndDirectoriesFromFolder(File path)
    {
        File[] folderEntries = path.listFiles();
        assert folderEntries != null;
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                file1.add(entry);
                processFilesFromFolder(entry);
            } else
                file1.add(entry);
        }
    }

