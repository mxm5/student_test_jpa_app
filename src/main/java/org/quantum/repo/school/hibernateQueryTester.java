package org.quantum.repo.school;

import org.quantum.models.Student;

import java.util.List;

public class hibernateQueryTester extends MyTester{

    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        Student student = new Student("nasim", "saleh");
        Student student1 = new Student("saba", "jamshid");
        Student student2 = new Student("mmd", "akbari");
        Student student3 = new Student("ali", "saeedi");
        Student student4 = new Student("hasan", "karimi");

//        repository.add(student);
//        repository.add(student1);
//        repository.add(student2);
//        repository.add(student3);
//        repository.add(student4);

        List<String> allStudentsFirstName =  repository.getAllStudentsFirstName();
        List<String> allStudentsLastNames = repository.getAllStudentsLastNames();
        List<String> allStudentsIds = repository.getAllStudentsIds();

        print(allStudentsIds + " :: q ok");
        print(allStudentsFirstName + " :: q ok");
        print(allStudentsLastNames + " :: q ok");

        print(repository.findStudentById(2L) + " :: founded w id");
        print(repository.updateFirstNameById(2L, "hasan") + " :: updated to hasan");

        print(repository.findAllStudentsNamesStartingWith("m"), "finding ms in query not transaction");

        print(repository.findAllStudentsWithNamesEndingWith("x"), "finding ms in query not transaction");

        print(repository.getAllStudentsCount(), "all students are");


        print(repository.sortAllStudentsByFirstName(), " by fi");
        print(repository.sortAllStudentsByLastName(), "ordering");
        print(repository.sortAllStudentsByIdNumber(), "ordering");

    }
}
