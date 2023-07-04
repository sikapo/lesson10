import java.io.File;
import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> files = new HashMap<>();

    public void add(FileData fileData) {
        files.computeIfAbsent(fileData.getPath(), k -> new ArrayList<>()).add(fileData);

//        if (files.containsKey(fileData.getPath())){
//            files.get(fileData.getPath()).add(fileData);
//        }
//        else {
//            ArrayList<FileData> file = new ArrayList<>();
//            file.add(fileData);
//            files.put(fileData.getPath(), file);
//        }
    }
    public void add (FileData fileData, String path) {
        if (!fileData.getPath().equals(path)) {
            System.out.println("Incorrect path!");
        }
        add(fileData);

    }

//    public void find(String pathToFile) {
//        for (Map.Entry<String, List<FileData>> i : files.entrySet()) {
//            System.out.println("In " + pathToFile + " is restored: ");
//            for (FileData s : i.getValue()) {
//                System.out.println(s.getName());
//            }
//        }
//    }
    public List<FileData> find (String path){
        return files.get(path);
    }

//    public void filterBySize(int size) {
//        for (Map.Entry<String, List<FileData>> i : files.entrySet()) {
//            System.out.println("All files that less than " + size + ":");
//            for (FileData s : i.getValue()) {
//                if (s.getSize()<size) {
//                    System.out.println("File - " + s.getName() + ". Weight - " + s.getSize());
//                }
//            }
//        }
//    }

    public  List<FileData> filterBySize(int size) {
        return files.values().stream()
                .flatMap(fl -> fl.stream())
                .filter(fl -> fl.getSize() < size)
                .toList();
    }
//    public void sortBySize(){
//        ArrayList<FileData> sizes = new ArrayList<>();
//        for (List<FileData> i : files.values()) {
//            sizes.addAll(i);
//        }
//        sizes.sort(Comparator.comparingInt(FileData::getSize));
//        System.out.println(sizes);
//    }
    public  List<FileData> sortBySize() {
//        TreeSet<FileData> sorted = new TreeSet<>(Comparator.comparingInt(FileData::getSize));
//        for (List<FileData> fileData : files.values()) {
//            sorted.addAll(fileData);
//        }
//        return new ArrayList<>(sorted);
        return files.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(FileData::getSize))
                .toList();
    }
    public void remove(String path) {
        files.remove(path);
    }
}