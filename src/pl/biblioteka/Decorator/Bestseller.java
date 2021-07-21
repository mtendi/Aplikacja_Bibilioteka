package pl.biblioteka.Decorator;

import java.util.List;

public class Bestseller extends Decorator {
    public Bestseller(Books books) {
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
            addBestsellerBookToHistory(name);
        } else {
            System.out.println("Invalid book name");
        }
    }
    public void addBestsellerBookToHistory(String name) {
        bestsellersBorrowingHistory.add(name);
    }
}
