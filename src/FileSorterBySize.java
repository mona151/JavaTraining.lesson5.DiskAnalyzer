import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class FileSorterBySize implements Comparator<File> {

    public ArrayList getTop5 (ArrayList<File> files){
        ArrayList<File> filesSortedBySizeDesc = files;
        Collections.sort(filesSortedBySizeDesc, new FileSorterBySize());
        return filesSortedBySizeDesc;
    }

    public long getFileSizeInKB(File file){
        return file.length() / 1024;
    }


    public int compare (File a, File b){
        long aSize = a.length();
        long bSize = b.length();
        if (aSize > bSize){
            return -1;
        } else {
            return 1;
        }
    }
}
