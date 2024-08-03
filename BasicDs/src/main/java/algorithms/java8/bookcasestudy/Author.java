package main.java.algorithms.java8.bookcasestudy;

import java.util.Objects;
import java.util.PriorityQueue;

public class Author {
    private String name;
    private String lastName;
    private String country;

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.lang.String getCountry() {
        return country;
    }

    public void setCountry(java.lang.String country) {
        this.country = country;
    }

    public Author(String country, String name, String lastName) {
        this.country = country;
        this.name = name;
        this.lastName = lastName;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(lastName, author.lastName) && Objects.equals(country, author.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, country);
    }
}



enum Genre {
    NOVEL,SHORT_NOVEL, NON_FICTION;
}