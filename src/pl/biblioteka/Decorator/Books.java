package pl.biblioteka.Decorator;

import java.util.List;

public interface Books {
    public void add(String name, List<String> list);
    public void remove(String name, List<String> list);
}
