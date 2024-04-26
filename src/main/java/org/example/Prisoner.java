package org.example;

import java.time.LocalDate;

class Prisoner extends Person {
    private String crime;

    public Prisoner(String id, char gender, LocalDate dateOfBirth, String crime) {
        super(id, gender, dateOfBirth);
        this.crime = crime;
    }

    @Override
    public void displayInformation() {
        System.out.println("ID заключенного: " + id);
        System.out.println("Пол: " + gender);
        System.out.println("Дата рождения: " + dateOfBirth);
        System.out.println("Преступление: " + crime);
    }
}
