package se.lexicon.fullstack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String course;
    private LocalDate registerDate;

    public Student() {
    }

    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.registerDate = LocalDate.now();
    }

    public Student(int id, String name, String email, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.registerDate = LocalDate.now();
    }

    public Student(String name, String email, String course, LocalDate registerDate) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.registerDate = registerDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(course, student.course) &&
                Objects.equals(registerDate, student.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, course, registerDate);
    }
}
