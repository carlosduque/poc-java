package o.beans;

import java.util.Date;
import java.util.Objects;

import o.beans.Person;

public class Employee extends Person {

    private final Date hireDate;
    private final boolean active;

    public Employee(String name, String lastname, Date newHireDate, boolean active) {
        super(name, lastname);
        this.hireDate = Objects.requireNonNull(newHireDate, "hire date can't be null");
        this.active = active;
    }

    public String toString() {
        return "Employee[" + super.toString() + "::" + active + ":" + hireDate + "]";
    }

    public Date getHireDate() {
        return new Date(hireDate.getTime());
    }

    public boolean isActive() {
        return active;
    }
}
