public class Main {
    public static void main(String[] args) {

        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(new FileData("23r.jpeg", 234, "/path/to/file"));
        fileNavigator.add(new FileData("werw.jpeg", 56, "/path/to/file"));
        fileNavigator.add(new FileData("tttt.jpeg", 111, "/path/to/file"));
        fileNavigator.add(new FileData("r44.jpeg", 8888, "/path/to/file"));

        fileNavigator.find("/path/to/file");
        fileNavigator.filterBySize(3000);
        fileNavigator.sortBySize();
        fileNavigator.remove("/path/to/file");



    }
}