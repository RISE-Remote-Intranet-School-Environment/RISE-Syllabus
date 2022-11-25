package com.RISE.sylla.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "course")
public class courseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="courseid")
    private long courseId;

    @Column(name="name")
    private String name;

    @Column(name="teacher")
    private String teacher;

    @Column(name="ue")
    private String ue;

    @Column(name="year")
    private int year;


    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getUE() {
        return ue;
    }

    public void setUE(String ue) {
        this.ue = ue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
