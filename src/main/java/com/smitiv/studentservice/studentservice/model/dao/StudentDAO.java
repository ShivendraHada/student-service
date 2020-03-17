package com.smitiv.studentservice.studentservice.model.dao;

import javax.persistence.*;

@Entity
@Table(name = "T_STUDENT")
public class StudentDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String education;
    private String gender;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "StudentRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", education='" + education + '\'' +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

