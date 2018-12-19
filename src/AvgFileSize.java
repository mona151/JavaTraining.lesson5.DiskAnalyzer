import java.io.File;
import java.util.ArrayList;

public class AvgFileSize {
    public long getAverageFileSize (ArrayList<File> fileList){
        long fileSizeSum = 0;
        for (File temp : fileList) {
            fileSizeSum += temp.length();
        }
        return fileSizeSum / fileList.size();
    }
}


