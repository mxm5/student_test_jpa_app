package org.quantum.repo;

import org.quantum.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentRepository {


    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public StudentRepository() {
         entityManagerFactory = Persistence.createEntityManagerFactory("student");
         entityManager = entityManagerFactory.createEntityManager();
    }

    Student find(Student student){
        return entityManager.find(Student.class,student.getId());
    }

    Student update(Student student){
        Student studentRecord = entityManager.find(Student.class, student.getId());
        entityManager.getTransaction().begin();
        studentRecord.setLastName(student.getLastName());
        studentRecord.setFirstName(student.getFirstName());
        entityManager.getTransaction().commit();
        return studentRecord;
    }

    Student add(Student student){

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }


    Student remove(Student student){
        Student studentFound = entityManager.find(Student.class, student.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(studentFound);
        entityManager.getTransaction().commit();
        return studentFound;
    }

}
