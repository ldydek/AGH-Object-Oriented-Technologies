package pl.edu.agh.to.school.student;

import java.time.LocalDate;

public class Student {

    private int id;

    private final String firstName;

    private final String lastName;

    private final LocalDate birthDate;

    private final String indexNumber;

    public Student(String firstName, String lastName, LocalDate birthDate, String indexNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.indexNumber = indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getIndexNumber() {
        return indexNumber;
    }
}
