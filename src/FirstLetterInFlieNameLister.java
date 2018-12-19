import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FirstLetterInFlieNameLister {
    public List<FilesFoldersCounters> logList(ArrayList<File> fileList) {
        //int charOccurancesCounter;
        //HashSet<Character> charSet = new HashSet<>();
        List<FilesFoldersCounters> summaryList = new ArrayList<>();

        for (int i = 0; i < fileList.size(); i++) {
            char firstChar = fileList.get(i).getName().charAt(0);
            boolean charAlreadyExistsInSummary = false;
            int j;
            for (j = 0; j < summaryList.size(); j++) {
                if (summaryList.get(j).getFirstChar() == firstChar) {
                    charAlreadyExistsInSummary = true;
                    break;
                }
            }
            if (charAlreadyExistsInSummary) {
                summaryList.get(j).setOccuranceCounter();
            } else {
                FilesFoldersCounters ffc = new FilesFoldersCounters(firstChar, fileList.get(j));
                summaryList.add(ffc);
            }
        }
        return summaryList;
    }
}
