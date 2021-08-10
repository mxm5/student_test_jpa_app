package org.quantum.repo;

import org.quantum.models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StudentRepository {


    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public StudentRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("student");
        entityManager = entityManagerFactory.createEntityManager();
    }

    //================================= basic curd

    Student find(Student student) {
        return entityManager.find(Student.class, student.getId());
    }

    Student update(Student student) {
        Student studentRecord = entityManager.find(Student.class, student.getId());
        entityManager.getTransaction().begin();
        studentRecord.setLastName(student.getLastName());
        studentRecord.setFirstName(student.getFirstName());
        entityManager.getTransaction().commit();
        return studentRecord;
    }

    Student add(Student student) {

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }


    Student remove(Student student) {
        Student studentFound = entityManager.find(Student.class, student.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(studentFound);
        entityManager.getTransaction().commit();
        return studentFound;
    }

    //================================= basic find query

    List getAllStudentsFirstName() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select s.lastName from Student s");
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    List getAllStudentsLastNames() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select s.lastName from Student s ");
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    List getAllStudentsIds() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select s.id from Student s ");
        entityManager.getTransaction().commit();
        return query.getResultList();
    }
    //================================= named query

    Student findStudentById(Long id) {
        entityManager.getTransaction().begin();
        Query studentById = entityManager.createNamedQuery("find student by id");
        studentById.setParameter("id", id);
        Object singleResult = studentById.getSingleResult();
        entityManager.getTransaction().commit();
        return ((Student) singleResult);
    }

    //================================= basic update query

    Student updateFirstNameById(Long id, String lastName) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Student set lastName = '" + lastName + "' where id =" + id);
        entityManager.getTransaction().commit();
        return findStudentById(id);
    }


    Student updateLastNameById(Long id, String lastName) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update Student set lastName = '" + lastName + "' where id =" + id);
        entityManager.getTransaction().commit();
        return findStudentById(id);
    }

    //================================= basic delete query

    void removeById(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Student s where s.id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    //================================= basic like query
    List findAllStudentsNamesStartingWith(String keyWord) {
        Query query = entityManager.createQuery("select s from Student s where s.firstName like '" + keyWord + "%'");
        return query.getResultList();


    }

    List findAllStudentsWithNamesEndingWith(String keyWord){
        Query query = entityManager.createQuery("select s from Student s where s.firstName like '%" + keyWord + "'");
        return query.getResultList();
    }
    //================================= basic count query
    Long getAllStudentsCount(){
        Query query = entityManager.createQuery("select count(s) from Student s");
        return ((Long) query.getSingleResult());
    }
    //================================= basic sorting query
    List sortAllStudentsByIdNumber (){
        Query query = entityManager.createQuery("select s from Student s order by s.id desc ");
        return query.getResultList();
    }
    List sortAllStudentsByLastName(){
        Query query = entityManager.createQuery("select s from Student s order by s.lastName desc ");
        return query.getResultList();
    }
    List sortAllStudentsByFirstName (){
        Query query = entityManager.createQuery("select s from Student s order by s.firstName desc ");
return query.getResultList();
    }


}
