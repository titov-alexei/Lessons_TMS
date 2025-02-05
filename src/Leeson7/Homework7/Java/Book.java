package Leeson7.Homework7.Java;

public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //Вывод строки: Название, автор и год издания.
    public void getAboutBook() {
        System.out.println("Книга: " + title +
                "\nАвтор: " + author +
                "\nГод: " + year + ".");
    }

    //Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if ((obj == null) || (this.getClass() != obj.getClass())) return false;

        /* Можно ли так объявить для сравнения свойств? Или это лишнее создание объекта? */
        //Book temp = (Book) obj;
        //return (this.title == temp.title && this.author == temp.author)?true:false;

        if (this.title.equals(((Book) obj).title) && this.author.equals(((Book) obj).author))
            return true;
        else return false;
    }

}
