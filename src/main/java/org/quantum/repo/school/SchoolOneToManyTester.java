package org.quantum.repo.school;

import org.quantum.models.School;
import org.quantum.models.Student;
import org.quantum.models.Tutor;

public class SchoolOneToManyTester extends MyTester {
    public static void main(String[] args) {
        SchoolRepository schoolRepository = new SchoolRepository();
        StudentRepository studentRepository = new StudentRepository();
        TutorRepository tutorRepository = new TutorRepository();

        Student seecond = studentRepository.findStudentById(3L);
        Tutor tutor = new Tutor("hasan", "ali");
        Tutor added = tutorRepository.add(tutor);
        Tutor founded = tutorRepository.find(added);
        seecond.setTutor(founded);
        School emam2 = new School("emam mohammad 2");
        emam2 = schoolRepository.add(emam2);
        schoolRepository.addStudent(seecond,emam2);

        print(seecond);
        print(emam2);
        print(added);


    }
}
