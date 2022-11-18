package com.RISE.sylla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="map_docu_course")
public class mapDocuCourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmap")
    private int idmap;

    @Column(name="course")
    private int course;

    @Column(name="document")
    private int document;

    public int getIdmap() {
        return idmap;
    }

    public void setIdmap(int idmap) {
        this.idmap = idmap;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }
}
