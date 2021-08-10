package org.quantum.repo.school;

import org.quantum.models.School;
import org.quantum.models.School;
import org.quantum.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchoolRepository {


    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public SchoolRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("student");
        entityManager = entityManagerFactory.createEntityManager();
    }


    //================================= basic curd

    School find(School student) {
        return entityManager.find(School.class, student.getId());
    }

    School update(School student) {
        School studentRecord = entityManager.find(School.class, student.getId());
        entityManager.getTransaction().begin();
        studentRecord.setSchoolName(student.getSchoolName());
        entityManager.getTransaction().commit();
        return studentRecord;
    }

    School add(School student) {

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }


    School remove(School student) {
        School studentFound = entityManager.find(School.class, student.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(studentFound);
        entityManager.getTransaction().commit();
        return studentFound;
    }

    //================================= one to many

    School addStudent(Student student,School school){
        School schoolFound = find(school);
        entityManager.getTransaction().begin();
        boolean added = schoolFound.getStudents().add(student);
        entityManager.getTransaction().commit();
        return find(school);
    }

    School removeStudent(Student student,School school){
        School schoolFound = find(school);
        entityManager.getTransaction().begin();
        boolean added = schoolFound.getStudents().remove(student);
        entityManager.getTransaction().commit();
        return find(school);
    }
}

