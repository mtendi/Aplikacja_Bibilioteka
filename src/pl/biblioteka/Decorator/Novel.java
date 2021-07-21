package pl.biblioteka.Decorator;

import java.util.List;

public class Novel extends Decorator {
    public Novel(Books books) {
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
            addNovelBookToHistory(name);
            list.remove(name);

        } else {
            System.out.println("Invalid book name");
        }
    }
    public void addNovelBookToHistory(String name) {
        novelBorrowingHistory.add(name);
    }
}
