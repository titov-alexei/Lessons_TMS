package Lesson9.homework9.library;

public class EBook implements Book{
    private String title;
    private String author;
    private int year;
    private int page;
    private String format;

    EBook(String title, String author, int year, int page, String format) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.page = page;
        this.format = format;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String displayInfo() {
        return "Эта электронная книга формата " + format + ". Кол-во страниц " + page;
    }
}
