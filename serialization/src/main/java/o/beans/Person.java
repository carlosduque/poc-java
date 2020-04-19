package o.beans;

import java.util.Objects;

public class Person {

    private final String name;
    private final String lastname;

    public Person(String newName, String newLastname) {
        this.name = Objects.requireNonNull(newName, "name must not be null");
        this.lastname = Objects.requireNonNull(newLastname, "lastname must not be null");
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String toString() {
        return this.lastname + ", " + this.name;
    }
}
