package o.beans;

import java.util.Date;

import o.beans.Person;

public class Employee extends Person {

    private final Date dob;
    private final boolean active;

    public Employee(String name, String lastname, Date dob, boolean active) {
        super(name, lastname);
        this.dob = dob;
        this.active = active;
    }

    public String toString() {
        return "Employee[" + super.toString() + "::" + active + ":" + dob + "]";
    }

    public Date getDateOfBirth() {
        return this.dob;
    }

    public boolean isActive() {
        return this.active;
    }
}
