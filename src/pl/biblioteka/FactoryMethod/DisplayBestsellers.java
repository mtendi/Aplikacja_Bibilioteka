package pl.biblioteka.FactoryMethod;

import java.util.List;

public class DisplayBestsellers implements Display {
    @Override
    public void displayList(List<String> list) {
        System.out.println("List of the bestsellers books");
        for(String name : list) {
            System.out.println(name);
        }
    }
}
