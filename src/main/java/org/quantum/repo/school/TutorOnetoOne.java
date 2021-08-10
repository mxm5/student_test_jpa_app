package org.quantum.repo.school;

import org.quantum.models.Student;
import org.quantum.models.Tutor;

public class TutorOnetoOne extends MyTester {
    public static void main(String[] args) {
        TutorRepository tutorRepository = new TutorRepository();

        StudentRepository studentRepository = new StudentRepository();


        Student student = new Student("saeed","khalaji");
        Student saeed = studentRepository.add(student);
        Long saeedId = saeed.getId();
        Tutor tutor = new Tutor("hasan", "kabuki");
        Tutor hasan = tutorRepository.add(tutor);
        Student tutedStudent = studentRepository.addTutor(saeedId, hasan);
        print(tutedStudent);
        print(hasan);

    }
}
