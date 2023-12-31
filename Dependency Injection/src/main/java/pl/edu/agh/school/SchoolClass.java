package pl.edu.agh.school;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SchoolClass implements Serializable {

    @Serial
    private static final long serialVersionUID = -1458264557391305041L;

    private final String name;

    private final String profile;

    private final List<Student> students = new ArrayList<>();

    private final List<Subject> subjects = new ArrayList<>();

    public SchoolClass(String name, String profile) {
        this.name = name;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "class " + name + ", profile " + profile;
    }

    public void addSubject(Subject subject) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
        }
    }

    public Collection<Subject> getSubjects() {
        return subjects;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.setSchoolClass(this);
        }
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public Collection<Term> getSchedule() {
        Collection<Term> terms = new ArrayList<>();
        for (Subject subject : subjects) {
            terms.addAll(subject.getSchedule());
        }
        return terms;
    }

    public boolean meetSearchCriteria(String name, String profile) {
        return this.name.equals(name) && this.profile.equals(profile);
    }
}
