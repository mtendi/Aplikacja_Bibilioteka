package pl.biblioteka.FactoryMethod;

public class BestsellersCreator extends Creator {
    @Override
    public Display getDisplayList() {
        return new DisplayBestsellers();
    }
}
