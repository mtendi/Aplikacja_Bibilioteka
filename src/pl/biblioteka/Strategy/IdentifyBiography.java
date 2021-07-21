package pl.biblioteka.Strategy;

public class IdentifyBiography implements Identify {
    @Override
    public String display(String name) {
        return name + " is Biography book";
    }
}
