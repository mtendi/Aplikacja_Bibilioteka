package pl.biblioteka;

import pl.biblioteka.Decorator.*;
import pl.biblioteka.FactoryMethod.*;
import pl.biblioteka.Strategy.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        List<String> reserveList = new ArrayList<>();
        boolean onOff = true;
        boolean onOff2 = true;
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        BaseBooks baseBooks = new BaseBooks();
        Decorator bestsellers = new Bestseller(baseBooks);
        Decorator biography = new Biography(baseBooks);
        Decorator novel = new Novel(baseBooks);
        BooksList bookList = new BooksList();
        bookList.getAllBooks();

        User user = new User();
        Admin admin = new Admin(999, 123);

        while(onOff2) {
            onOff = true;
            System.out.println("1 - Register, 2 - Log in, 3 - Exit");
            int registerOrLogin = scanner.nextInt();
            scanner.nextLine();
            if(registerOrLogin == 1) {
                user.addUser();
            } else if(registerOrLogin == 2) {
                System.out.println("Get id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Get password: ");
                int password = scanner.nextInt();
                scanner.nextLine();
                if (user.checkUser(id, password)) {
                    while(onOff) {
                        System.out.println("Bestsellers list - 1, Biography List - 2, Novel List 3,  Borrow - 4, Reserve - 5, Get Back 6, What Category? - 7, Check reserved - 8, Borrowing history - 9, Log out - 10");
                        int choise = scanner.nextInt();
                        scanner.nextLine();
                        switch(choise) {
                            case 1:
                                display(new BestsellersCreator(), bookList.getBestsellersList());
                                break;
                            case 2:
                                display(new BiographyCreator(), bookList.getBiographyList());
                                break;
                            case 3:
                                display(new NovelCreator(), bookList.getNovelList());
                                break;
                            case 4:
                                System.out.println("Enter the book name");
                                String name = scanner.nextLine();
                                user.borrowBook(id, name);
                                if(bookList.getBestsellersList().contains(name)) {
                                    bestsellers.remove(name, bookList.getBestsellersList());
                                } else if (bookList.getBiographyList().contains(name)) {
                                    biography.remove(name, bookList.getBiographyList());
                                } else if(bookList.getNovelList().contains(name)) {
                                    novel.remove(name, bookList.getNovelList());
                                } else {
                                    System.out.println("This book is not available");
                                }
                                break;
                            case 5:
                                System.out.println("Enter the name of book");
                                String name1 = scanner.nextLine();
                                if(bookList.getBestsellersList().contains(name1) || bookList.getBiographyList().contains(name1) || bookList.getNovelList().contains(name1)) {
                                    reserveList.add(name1);
                                } else {
                                    System.out.println("Invalid book name");
                                }
                                break;
                            case 6:
                                String bookName = user.getBack(id);
                                if(bookList.getBestsellersList().size() < 10) {
                                    bestsellers.add(bookName, bookList.getBestsellersList());
                                } else if(bookList.getBiographyList().size() < 10) {
                                    biography.add(bookName, bookList.getBiographyList());
                                } else if(bookList.getNovelList().size() < 10) {
                                    novel.add(bookName, bookList.getNovelList());
                                } else {
                                    System.out.println("Invalid book name");
                                }
                                break;
                            case 7:
                                System.out.println("Enter the name of book");
                                String name2 = scanner.nextLine();
                                if (bookList.getBestsellersList().contains(name2)) {
                                    context.setDisplay(new IdentifyBestseller());
                                } else if (bookList.getBiographyList().contains(name2)) {
                                    context.setDisplay(new IdentifyBiography());
                                } else if (bookList.getNovelList().contains(name2)) {
                                    context.setDisplay(new IdentifyNovel());
                                } else {
                                    System.out.println("Invalid book name");
                                }
                                String result = context.doDisplay(name2);
                                System.out.println(result);
                                break;
                            case 8:
                                if(reserveList.isEmpty()) {
                                    System.out.println("You don't have reserved book");
                                } else {
                                    System.out.println(reserveList.get(0));
                                }
                                break;
                            case 9:
                                System.out.println("Bestsellers borrowing history:");
                                System.out.println(bestsellers.bestsellersBorrowingHistory);
                                System.out.println("Biography books borrowing history:");
                                System.out.println(biography.biographyBorrowingHistory);
                                System.out.println("Novel books borrowing history:");
                                System.out.println(novel.novelBorrowingHistory);
                                break;
                            case 10:
                                onOff = false;
                                break;
                            default:
                                System.out.println("Bad choise");
                        }
                    }
                } else if (admin.checkAdmin(id, password)) {
                    while(onOff) {
                        System.out.println("Add Bestseller book - 1, Add Biography book - 2, Add Novel book - 3,  Add user - 4, Delete user - 5, Get added books list - 6, Log out - 7");
                        int choise = scanner.nextInt();
                        scanner.nextLine();
                        switch(choise) {
                            case 1:
                                System.out.println("Enter the name of the book");
                                String bestName = scanner.nextLine();
                                bestsellers.add(bestName, bookList.getBestsellersList());
                                break;
                            case 2:
                                System.out.println("Enter the name of the book");
                                String bioName = scanner.nextLine();
                                biography.add(bioName, bookList.getBiographyList());
                                break;
                            case 3:
                                System.out.println("Enter the name of the book");
                                String novelName = scanner.nextLine();
                                novel.add(novelName, bookList.getNovelList());
                                break;
                            case 4:
                                user.addUser();
                                break;
                            case 5:
                                user.deleteUser(id, password);
                                break;
                            case 6:
                                System.out.println(baseBooks.addedBooksList);
                                break;
                            case 7:
                                onOff = false;
                                break;
                            default:
                                System.out.println("Bad choise");
                        }
                    }
                }
                } else if (registerOrLogin == 3){
                    onOff2 = false;
                 } else {
                System.out.println("Bad choise");
            }
        }
    }
    public static void display(Creator creator, List<String> list){
        Display display = creator.getDisplayList();
        display.displayList(list);
    }
}
