package o.beans;

import java.util.Date;

public class Person {

    private final String name;
    private final String lastname;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String toString() {
        return "name=" + this.name + " lastname=" + this.lastname;
    }
}
