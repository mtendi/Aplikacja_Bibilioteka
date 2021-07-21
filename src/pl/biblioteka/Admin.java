package pl.biblioteka;

public class Admin {
    private int id;
    private int password;

    public Admin(int id, int password) {
        this.id = id;
        this.password = password;
    }
    public boolean checkAdmin(int id, int password) {
        boolean trueOrFalse;

        if(this.id == id && this.password == password) {
            trueOrFalse = true;
        } else {
            trueOrFalse = false;
        }
        return trueOrFalse;
    }
}
