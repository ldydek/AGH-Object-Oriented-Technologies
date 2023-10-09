package pl.edu.agh.iisg.to.dao;

import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Grade;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;
import java.util.*;

public class StudentDao extends GenericDao<Student> {

    public Optional<Student> create(final String firstName, final String lastName, final int indexNumber) {
        try {
            return Optional.of(save(new Student(firstName, lastName, indexNumber)));
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Student> findByIndexNumber(final int indexNumber) {
        try {
            String queryString = "SELECT s FROM Student s WHERE s.indexNumber = :indexNumber";
            Student student = currentSession().createQuery(queryString, Student.class)
                    .setParameter("indexNumber", indexNumber).getSingleResult();
            return Optional.of(student);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Map<Course, Float> createReport(final Student student) {
        Map<Course, Float> report = new HashMap<>();
        for (Course course : student.courseSet()) {
            float sum = 0;
            float ctr = 0;
            for (Grade grade : course.gradeSet()) {
                ctr++;
                sum += grade.grade();
            }
            report.put(course, sum / ctr);
        }
        return report;
    }
}
