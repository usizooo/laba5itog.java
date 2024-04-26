package org.example;

import java.time.LocalDate;

abstract class Person {
    protected String id;
    protected char gender;
    protected LocalDate dateOfBirth;

    public Person(String id, char gender, LocalDate dateOfBirth) {
        this.id = id;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public abstract void displayInformation();
}
