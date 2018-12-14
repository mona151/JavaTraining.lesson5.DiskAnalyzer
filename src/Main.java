public class Main {
    public static void main(String[] args) {
        int mode = Integer.getInteger(args[0]);
        String path = args[1];
        switch (mode) {
            case 1: //Mode 1: Returns file name with max amount of "s" chars in it.
            case 2: //Mode 2: Shows top 5 heaviest files.
            case 3: //Mode 3: Calculates average file size in selected directory and its sub-directories.
            case 4: //Mode 4: Shows amount of files and directories which starts with some char from alphabet (for each char in alphabet).
            default:
                System.out.println("Wrong mode entered");
        }
    }
}
