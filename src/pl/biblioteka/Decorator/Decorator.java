package pl.biblioteka.Decorator;

import java.util.ArrayList;
import java.util.List;

public class Decorator implements Books {
    Books books;
    public List<String> bestsellersBorrowingHistory = new ArrayList<>();
    public List<String> biographyBorrowingHistory = new ArrayList<>();
    public List<String> novelBorrowingHistory = new ArrayList<>();

    public Decorator(Books books){
        this.books = books;
    }
    @Override
    public void add(String name, List<String> list) {
        books.add(name, list);
    }

    @Override
    public void remove(String name, List<String> list) {
        if(list.contains(name)) {
            books.remove(name, list);
        }
    }
}
