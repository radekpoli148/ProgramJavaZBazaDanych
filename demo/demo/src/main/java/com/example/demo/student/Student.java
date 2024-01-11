package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String imie;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer wiek;

    public Student() {
    }

    public Student(Long id,
                   String imie,
                   String email,
                   LocalDate dob) {
        this.id = id;
        this.imie = imie;
        this.email = email;
        this.dob = dob;
    }

    public Student(String imie,
                   String email,
                   LocalDate dob) {
        this.imie = imie;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getWiek() {

        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", wiek=" + wiek +
                '}';
    }
}
