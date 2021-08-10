package org.quantum;

import org.quantum.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateStudent {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, 1L);
        EntityTransaction transaction = entityManager.getTransaction();

        System.out.println("before Update "+ student.toString());

        transaction.begin();
        student.setFirstName("ali");
        student.setLastName("hasan");
        transaction.commit();

        System.out.println("after Update "+ student.toString());

        entityManager.close();
        entityManagerFactory.close();
    }
}
