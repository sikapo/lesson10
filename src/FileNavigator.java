import java.util.*;

class FileNavigator {
    private final Map<String, List<FileData>> fileMap = new HashMap<>();

    public void add(FileData fileData) {
        String path = fileData.getPath();
        List<FileData> fileList = fileMap.getOrDefault(path, new ArrayList<>());
        fileList.add(fileData);
        fileMap.put(path, fileList);
    }

    public List<FileData> find(String path) {
        return fileMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> filteredFiles = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            for (FileData fileData : fileList) {
                if (fileData.getSize() <= maxSize) {
                    filteredFiles.add(fileData);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            allFiles.addAll(fileList);
        }
        allFiles.sort(Comparator.comparingLong(FileData::getSize));
        return allFiles;
    }

    public void checkConsistency(FileData fileData) {
        String path = fileData.getPath();
        String key = null;
        for (String storedPath : fileMap.keySet()) {
            if (path.startsWith(storedPath)) {
                key = storedPath;
                break;
            }
        }
        if (key != null && !path.equals(key)) {
            System.out.println("Error: Inconsistent path. Key: " + key + ", FileData: " + fileData);
        }
    }
}