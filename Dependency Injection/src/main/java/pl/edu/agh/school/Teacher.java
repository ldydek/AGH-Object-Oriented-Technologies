package pl.edu.agh.school;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Teacher extends Person implements ITeacher, Serializable {

    @Serial
    private static final long serialVersionUID = -5057727100439049074L;

    private final List<Subject> subjects = new ArrayList<>();

    public Teacher(String name, String surname) {

        super(name, surname);
        personType = PersonType.Teacher;
    }

    public void addSubject(Subject newSubject) {
        if (!subjects.contains(newSubject)) {
            subjects.add(newSubject);
        }
    }

    public Collection<Term> getSchedule() {
        ArrayList<Term> schedule = new ArrayList<>();
        for (Subject subject : subjects) {
            schedule.addAll(subject.getSchedule());
        }
        return schedule;
    }
}
