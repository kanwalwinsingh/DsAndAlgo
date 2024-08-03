package main.java.algorithms.java8.bookcasestudy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        Author author = new Author("india", "kanwal", "singh");
        Author author2 = new Author("us", "john", "doe");
        Author author3 = new Author("canada", "nil", "ramen");
        Author author4 = new Author("australia", "choi", "manten");

        List<Author> authorList = new ArrayList<>();
        List<Author> authorList1 = new ArrayList<>();
        List<Author> authorList2 = new ArrayList<>();

        authorList1.add(author);
        authorList1.add(author2);

        authorList2.add(author3);

        authorList.add(author);
        authorList.add(author4);
        authorList.add(author2);
        authorList.add(author3);

        Book book = new Book(authorList, "java8", 10, Genre.NON_FICTION, 2021, "ISBN100");
        Book book1 = new Book(authorList1, "Iron Man", 200, Genre.NOVEL, 1990, "ISBN200");
        Book book2 = new Book(authorList2, "Prajatantra", 400, Genre.SHORT_NOVEL, 1970, "ISBN300");
        Book book3 = new Book(authorList, "Dhoni the player", 500, Genre.NON_FICTION, 1890, "ISBN400");
        Book book4 = new Book(authorList1, "Bombkesh bakshi", 250, Genre.NOVEL, 2025, "ISBN400");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        //We need all the books with more than 400 pages

        bookList.stream().filter(booke -> booke.getPages() > 400).collect(Collectors.toList());

        //We need the top three longest books
        bookList.stream().sorted(Comparator.comparing(Book::getPages).reversed()).limit(3).collect(Collectors.toList());

        //We need to get all the publishing years
        bookList.stream().map(Book::getYear).distinct().collect(Collectors.toList());

        //We need all the authors
        bookList.stream().flatMap(b -> b.getAuthors().stream()).distinct().collect(Collectors.toList());

        //We need all the origin countries of the authors
        bookList.stream().flatMap(b->b.getAuthors().stream()).map(Author::getCountry).distinct().collect(Collectors.toList());

        //We want the most recent published book
        bookList.stream().sorted(Comparator.comparing(Book::getYear)).findFirst().get();
        bookList.stream().max(Comparator.comparing(Book::getYear)).get();

        //We want to know if all the books are written by more than one author
        bookList.stream().filter(c -> c.getAuthors().size() > 1).collect(Collectors.toList());
        bookList.stream().allMatch(b-> b.getAuthors().size()>1);

        //We want one of the books written by more than one author.
        bookList.stream().anyMatch(b->b.getAuthors().size()>1);

        //We want the total number of pages published
        bookList.stream().map(Book::getPages).reduce(Integer::sum).get();

        //We want to know how many pages the longest book has
        bookList.stream().map(Book::getPages).reduce(Integer::max);

        //We want the average number of pages of the books.
        bookList.stream().collect(Collectors.averagingInt(Book::getPages));

        //We want all the titles of the books
        System.out.println(bookList.stream().map(Book::getTitle).collect(Collectors.joining(", ")));

        //We want the book with the higher number of authors
        System.out.println(bookList.stream().collect(Collectors.maxBy(Comparator.comparing(b->b.getAuthors().size()))).get());

        //We want a Map of book per year
        Map<Integer, List<Book>> mapBookPerYear = bookList.stream().collect(Collectors.groupingBy(Book::getYear));
        System.out.println(mapBookPerYear);

        //We want a Map of how many books are published per year per genre.
        Map<Integer, Map<Genre, List<Book>>> bookPerYearPerGenre = bookList.stream().collect(Collectors.groupingBy(Book::getYear, Collectors.groupingBy(Book::getGenre)));

        //We want to count how many books are published per year.
        bookList.stream().collect(Collectors.groupingBy(Book::getYear,Collectors.counting()));

        //We want to classify book by hardcover.
        Map<Boolean, List<Book>> doesBooksHashardCover = bookList.stream().collect(Collectors.partitioningBy(Book::hasHardCover));

        // We want to further classify book by genre We want to further classify book by genre
        bookList.stream().collect(Collectors.partitioningBy(Book::hasHardCover,Collectors.groupingBy(Book::getGenre)));

        //We want to count books with/without hardcover
        bookList.stream().collect(Collectors.partitioningBy(Book::hasHardCover,Collectors.counting()));
    }
}
