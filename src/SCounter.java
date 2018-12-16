import java.io.File;
import java.util.ArrayList;

public class SCounter {
    public File maxSSymbolsInFileNames (ArrayList<File> file){
        File fileWithMaxS = null;
        int maxS = 0;
        for (File x: file) {
            if (countS(x) >= maxS){
                fileWithMaxS = x;
                maxS = countS(x);
            }
        }
        return fileWithMaxS;
    }

    private int countS(File file){
        String fileName = file.getName();
        int sCount = 0;
        for (int i = 0; i < fileName.length(); i++) {
            if (fileName.charAt(i) == 's' || fileName.charAt(i) == 'S'){
                sCount++;
            }
        }
        return sCount;
    }
}
