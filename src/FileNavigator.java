import java.util.*;

public class FileNavigator {
    Map<String, List<FileData>> files = new HashMap<>();

    public void add(FileData fileData) {
        files.computeIfAbsent(fileData.getPath(), k -> new ArrayList<>()).add(fileData);
    }

    public void find(String pathToFile) {
        for (Map.Entry<String, List<FileData>> i : files.entrySet()) {
            System.out.println("In " + pathToFile + " is restored: ");
            for (FileData s : i.getValue()) {
                System.out.println(s.getName());
            }
        }
    }

    public void filterBySize(int size) {
        for (Map.Entry<String, List<FileData>> i : files.entrySet()) {
            System.out.println("All files that less than " + size + ":");
            for (FileData s : i.getValue()) {
                if (s.getSize()<size) {
                    System.out.println("File - " + s.getName() + ". Weight - " + s.getSize());
                }
            }
        }
    }
    public void sortBySize(){
        ArrayList<FileData> sizes = new ArrayList<>();
        for (List<FileData> i : files.values()) {
            sizes.addAll(i);
        }
        sizes.sort(Comparator.comparingInt(FileData::getSize));
        System.out.println(sizes);
    }
    public void remove(String path) {
        files.remove(path);
    }
}