package Leeson7.Homework7.Java;

public class Author {

    private String name;
    private int year;

    public Author(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        return this.name.equals(((Author) obj).name);
    }
}
