package org.quantum;

import org.quantum.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateStudent {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Student student1 = new Student("mohammad","mohammadian");

        transaction.begin();

        entityManager.persist(student1);

        transaction.commit();

        entityManager.close();

        entityManagerFactory.close();

    }
}
