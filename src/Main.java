import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();

        FileData file1 = new FileData("files.txt", 1024, "/path/to/file");
        FileData file2 = new FileData("firstApp.java", 2048, "/path/to/file");

        navigator.add(file1);
        navigator.add(file2);

        List<FileData> files = navigator.find("/path/to/file");
        System.out.println("Files at /path/to/file:");
        for (FileData file : files) {
            System.out.println(file.getName());
        }

        List<FileData> filteredFiles = navigator.filterBySize(1500);
        System.out.println("\nFiltered files (size <= 1500 bytes):");
        for (FileData file : filteredFiles) {
            System.out.println(file.getName() + " (" + file.getSize() + " bytes)");
        }

        navigator.remove("/path/to/file");

        List<FileData> sortedFiles = navigator.sortBySize();
        System.out.println("\nSorted files by size:");
        for (FileData file : sortedFiles) {
            System.out.println(file.getName() + " (" + file.getSize() + " bytes)");
        }

        FileData inconsistentFile = new FileData("file.txt", 512, "/another/path/");
        navigator.checkConsistency(inconsistentFile);
    }
}