package pl.edu.agh.school;

import com.google.inject.Inject;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

public class Student extends Person implements Serializable {

    @Serial
    private static final long serialVersionUID = -2700888841101214174L;

    private SchoolClass schoolClass;

    @Inject
    public Student(String name, String surname) {
        super(name, surname);
        personType = PersonType.Student;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Collection<Term> getSchedule() {
        if (schoolClass == null) {
            return null;
        }

        return schoolClass.getSchedule();
    }
}
