package pl.biblioteka.FactoryMethod;

public class NovelCreator extends Creator {
    @Override
    public Display getDisplayList() {
        return new DisplayNovel();
    }
}
