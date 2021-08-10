package org.quantum.crudClasses;

import org.quantum.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudent {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class,1L);

        if(student != null)
        {
            System.out.println("_".repeat(100));
            System.out.println();
            System.out.println();
            System.out.println(student);
            System.out.println();
            System.out.println();
            System.out.println("_".repeat(100));
        }

        entityManager.close();
        entityManagerFactory.close();


    }
}
