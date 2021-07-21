package pl.biblioteka.Decorator;

import java.util.List;

public class Biography extends Decorator {

    public Biography(Books books) {
        super(books);
    }

    @Override
    public void add(String name, List<String> list) {
        list.add(name);
        super.add(name, list);
    }
    @Override
    public void remove(String name, List<String> list) {
        if (list.contains(name)) {
            super.remove(name, list);
            list.remove(name);
            addBiographyBookToHistory(name);
        } else {
            System.out.println("Invalid book name");
        }
    }
    public void addBiographyBookToHistory(String name) {
        biographyBorrowingHistory.add(name);
    }
}
