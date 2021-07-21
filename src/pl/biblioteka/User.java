package pl.biblioteka;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    public Map<Integer, Integer> users = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    Map<Integer, String> borrowBooks = new HashMap<>();


    public void addUser() {
        System.out.println("Get id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Get password: ");
        int password = scanner.nextInt();
        scanner.nextLine();
        if(id == 999) {
            System.out.println("Invalid login, try again");
            addUser();
        } else {
            users.put(id, password);
        }
    }
    public boolean checkUser(int id, int password) {
        boolean trueOrFalse;

        if(users.containsKey(id) && users.containsValue(password)) {
            trueOrFalse = true;
        } else {
            trueOrFalse = false;
        }
        return trueOrFalse;
    }
    public void deleteUser(int id, int password) {
        if (id == 999 && password == 123) {
            System.out.println("Enter user name: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            if(users.containsKey(userId)) {
                users.remove(userId);
            } else {
                System.out.println("Invalid user name");
            }
        }
    }
    public void borrowBook(int id, String name) {
        borrowBooks.put(id, name);
        System.out.println("This book has been borrowed");
    }
    public String getBack(int id) {
        String nameOfBook = borrowBooks.get(id);
        borrowBooks.remove(id);
        return nameOfBook;
    }
}
