package coding.oop;

import coding.oop.filesystem.Directory;
import coding.oop.filesystem.File;

public class Main {
    public static void main(String[] args) {

        Directory root = new Directory("D", null);
        Directory docs = new Directory("Docs", root);
        Directory today = new Directory("Today", root);

        File doc1 = new File("summer.txt", docs);
        File doc2 = new File("winter.txt", docs);
        File doc3 = new File("spring.txt", today);

        doc1.setContent("Summer doc");
        doc2.setContent("Winter doc");
        doc3.setContent("Spring doc");

        System.out.println("D root full path: " + root.getFullPath());
        System.out.println("Docs dir full path: " + docs.getFullPath());
        System.out.println("spring.txt file full path: " + doc3.getFullPath());
    }
}