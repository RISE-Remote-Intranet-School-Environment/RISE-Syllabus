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
    @Column(name="idmapdocucourse")
    private Long idMapDocuCourse;

    @Column(name="fkcourse")
    private Long fkcourse;

    @Column(name="fkdocument")
    private Long fkdocument;

    public Long getIdMapDocuCourse() {
        return idMapDocuCourse;
    }

    public void setIdMapDocuCourse(Long idMapDocuCourse) {
        this.idMapDocuCourse = idMapDocuCourse;
    }

    public Long getFkcourse() {
        return fkcourse;
    }

    public void setFkcourse(Long fkCourse_DocCourse) {
        this.fkcourse = fkCourse_DocCourse;
    }

    public Long getFkdocument() {
        return fkdocument;
    }

    public void setFkdocument(Long fkDocument_DocCourse) {
        this.fkdocument = fkDocument_DocCourse;
    }
}
