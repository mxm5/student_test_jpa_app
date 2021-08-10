package org.quantum.repo.school;

import org.quantum.models.School;
import org.quantum.models.Student;

public class OneToOneTester extends MyTester {
    public static void main(String[] args) {
        SchoolRepository schoolRepository = new SchoolRepository();
        StudentRepository studentRepository = new StudentRepository();
        Student k = new Student("jack","mak");

        Long k_id = studentRepository.add(k).getId();

        School e = new School("emam mohammad");

        print(schoolRepository.add(e));

//        print(studentRepository.addSchool(k_id,e),"added val");


    }
}
