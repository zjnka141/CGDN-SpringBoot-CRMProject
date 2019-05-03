package dn.codegym.crm.dto;

import dn.codegym.crm.entity.Course;

import java.io.Serializable;

public class ClassRoomDTO implements Serializable {
    private String id;
    private String name;
    private Course course;
    private Boolean deleted;

    public Course getCourse() { return course; }

    public void setCourse(Course course) { this.course = course; }

    public Boolean getDeleted() { return deleted; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
