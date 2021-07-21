package pl.biblioteka.FactoryMethod;

import java.util.List;

public class DisplayNovel implements Display {
    @Override
    public void displayList(List<String> list) {
        System.out.println("List of the novel books");
        for(String name : list) {
            System.out.println(name);
        }
    }
}
