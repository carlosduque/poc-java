package o.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author extends Person {
    private final List<Book> books;

    public Author(String newName, String newLastname, List<Book> books) {
        super(newName, newLastname);
        this.books = Objects.requireNonNull(books, "books can't be null");
    }

    @Override
    public String toString() {
        return super.toString() + "::" + "books=" + books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
