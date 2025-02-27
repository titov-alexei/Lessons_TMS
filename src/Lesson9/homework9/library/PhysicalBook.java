package Lesson9.homework9.library;

public class PhysicalBook implements Book{
    private String title;
    private String author;
    private int year;
    private int page;

    PhysicalBook(String title, String author, int year, int page) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.page = page;
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
        return "В этой книге " + page + " страниц";
    }
}
