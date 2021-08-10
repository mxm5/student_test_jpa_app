package org.quantum.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(targetEntity = Student.class)
    private Set<Student> students = new HashSet<Student>();

    public School() {
    }

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    private String schoolName;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }



    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", students=" + students +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
