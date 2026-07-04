package CollectionsFramework;

import myExperiments.Library;
import myExperiments.LibraryArrayList;
import myExperiments.LibraryList;

public class Main {
    public static void main(String[] args) {
        LibraryList libraries = new LibraryArrayList();
        for (int i = 0; i < 10; i++) {
            libraries.add(new Library(i, "Library " + i, "Author " + i));
        }
        for(Library library: libraries){
            System.out.println(library.getName() + " " + library.getAuthor());
        }
    }
}
