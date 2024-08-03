package main.java.algorithms.java8.bookcasestudy;

import java.util.List;
import java.util.Objects;

public class Book {
    private List<Author> authors;
    private String title;
    private int pages;
    private Genre genre;
    private int year;
    private String isbn;

    public boolean hasHardCover() {
        return hardCover;
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }

    private boolean hardCover;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", genre=" + genre +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(List<Author> authors, String title, int pages, Genre genre, int year, String isbn) {
        this.authors = authors;
        this.title = title;
        this.pages = pages;
        this.genre = genre;
        this.year = year;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && year == book.year && Objects.equals(authors, book.authors) && Objects.equals(title, book.title) && genre == book.genre && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authors, title, pages, genre, year, isbn);
    }
}
