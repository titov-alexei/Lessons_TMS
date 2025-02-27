package Lesson9.homework9.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> library = new ArrayList<>();

    public void getBook() {
        for (Book array : library) {
            System.out.println(array.getTitle() + " " + array.getAuthor() + " " + array.getYear() + " " + array.displayInfo());
        }
    }

    public void addBook(Book book) {
        library.add(book);
    }
}
