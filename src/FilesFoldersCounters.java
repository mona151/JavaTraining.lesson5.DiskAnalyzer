import java.io.File;

public class FilesFoldersCounters {
    private char firstChar;
    private File fileFolder;
    private int occuranceCounter;

    public FilesFoldersCounters(char firstChar, File fileFolder) {
        this.firstChar = firstChar;
        this.fileFolder = fileFolder;
        this.occuranceCounter = 1;
    }


    public char getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(char firstChar) {
        this.firstChar = firstChar;
    }

    public File getFileFolder() {
        return fileFolder;
    }

    public void setFileFolder(File fileFolder) {
        this.fileFolder = fileFolder;
    }

    public int getOccuranceCounter() {
        return occuranceCounter;
    }

    public void setOccuranceCounter() {
        this.occuranceCounter++;
    }

    @Override
    public String toString() {
        return "Character: " + firstChar + " Occurances: " + occuranceCounter;
    }
}
