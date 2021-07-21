package pl.biblioteka.Strategy;

public class IdentifyNovel implements Identify {
    @Override
    public String display(String name) {
        return name + " is Novel book";
    }
}
