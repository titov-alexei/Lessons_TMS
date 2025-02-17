package Lesson9.homework9.library;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new PhysicalBook("Кинга 1", "Автор 1", 2020, 133));
        lib.addBook(new PhysicalBook("Кинга 2", "Автор 2", 2021, 234));
        lib.addBook(new EBook("Кинга 3", "Автор 3", 2024, 555, "pdf"));
        lib.getBook();
    }
}
