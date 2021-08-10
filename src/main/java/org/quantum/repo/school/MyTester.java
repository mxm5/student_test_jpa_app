package org.quantum.repo.school;

import org.quantum.models.Student;

import java.util.List;

public class MyTester {

    public static void line() {
        System.out.println("_".repeat(100));
    }

    public static <T> void print(T value) {
        line();
        System.out.println(value);
        line();
    }

    public static <T> void print(T value, String explain) {
        line();
        System.out.println(value + "\n :: " + explain);
        line();
    }

    public static void print(List<Student> value, String explain) {
        line();
        for (Student s : value)
            System.out.println(s);
        System.out.println("\n :: " + explain);
        line();
    }
}
