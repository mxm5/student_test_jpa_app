package org.quantum.repo;

import org.quantum.models.Student;

public class RepoTest {

    public static void line(){
        System.out.println("_".repeat(100));
    }
    public static <T>  void print(T value){
        line();
        System.out.println(value);
        line();
    }

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();

        Student a =new Student("max","maxi");

        studentRepository.add(a);

        Student z = studentRepository.find(a);

        print(z+ " found");


        Student b = new Student("jack","jacki");
        studentRepository.add(b);

        print(studentRepository.find(b)+ " b found");

        studentRepository.remove(b);
        print(studentRepository.find(b)+" b finding");

        Student c = new Student("axel","axeli");
        studentRepository.add(c);

        print(studentRepository.find(c)+" c inserted");

        Student j = new Student( "xcel","xceli");
        j.setId(c.getId());

        studentRepository.update(j);

        print(studentRepository.find(c)+" c updated");

    }
}
