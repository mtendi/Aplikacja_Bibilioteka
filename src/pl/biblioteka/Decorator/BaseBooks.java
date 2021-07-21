package pl.biblioteka.Decorator;

import java.util.ArrayList;
import java.util.List;

public class BaseBooks implements Books {
    public List<String> addedBooksList = new ArrayList<>();

    @Override
    public void add(String name, List<String> list) {
        addedBooksList.add(name);
    }

    @Override
    public void remove(String name, List<String> list) {
        if(addedBooksList.contains(name)) {
            addedBooksList.remove(name);
        }
    }
}
