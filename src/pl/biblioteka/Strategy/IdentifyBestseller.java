package pl.biblioteka.Strategy;

public class IdentifyBestseller implements Identify {
    @Override
    public String display(String name) {
        return name + " is Bestseller book";
    }
}
