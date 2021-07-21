package pl.biblioteka.Strategy;

public class Context {
    private Identify display;

    public void setDisplay(Identify display) {
        this.display = display;
    }

    public String doDisplay(String name) {
        return display.display(name);
    }
}
