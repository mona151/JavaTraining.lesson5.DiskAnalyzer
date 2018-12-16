import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileSorterBySize {
    public Map getTop5Heaviest (ArrayList<File> file){
        Map<File, Long> filesPlusSizesMap = new HashMap<>();
        for (File x: file) {
            filesPlusSizesMap.put(x, getFileSizeInKB(x));
        }
        return sortBySizeValue(filesPlusSizesMap);
    }
    private long getFileSizeInKB(File file){
        return file.length() / 1024;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortBySizeValue(Map<K, V> filesPlusSizesMap){
        Map <K, V> sortResultMap = new LinkedHashMap<>();
        Stream<Map.Entry<K, V>> sequentialStream = filesPlusSizesMap.entrySet().stream();

        sequentialStream.sorted(Map.Entry.comparingByValue()).forEachOrdered(c -> sortResultMap.put(c.getKey(), c.getValue()));
        return sortResultMap;
    }
}
