package org.quantum.repo.school;

import org.quantum.models.Tutor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TutorRepository {


    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public TutorRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("student");
        entityManager = entityManagerFactory.createEntityManager();
    }


    //================================= basic curd

    Tutor find(Tutor Tutor) {
        return entityManager.find(Tutor.class, Tutor.getId());
    }

    Tutor update(Tutor Tutor) {
        Tutor TutorRecord = entityManager.find(Tutor.class, Tutor.getId());
        entityManager.getTransaction().begin();
        TutorRecord.setFirstName(Tutor.getFirstName());
        TutorRecord.setLastName(Tutor.getLastName());
        entityManager.getTransaction().commit();
        return TutorRecord;
    }

    Tutor add(Tutor Tutor) {

        entityManager.getTransaction().begin();
        entityManager.persist(Tutor);
        entityManager.getTransaction().commit();
        return Tutor;
    }


    Tutor remove(Tutor Tutor) {
        Tutor TutorFound = entityManager.find(Tutor.class, Tutor.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(TutorFound);
        entityManager.getTransaction().commit();
        return TutorFound;
    }
}

