package org.quantum;

import org.quantum.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemoveStudent {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = entityManager.find(Student.class, 1L);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(student);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
