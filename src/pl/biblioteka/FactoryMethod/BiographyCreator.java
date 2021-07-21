package pl.biblioteka.FactoryMethod;

public class BiographyCreator extends Creator{
    @Override
    public Display getDisplayList() {
        return new DisplayBiography();
    }
}
