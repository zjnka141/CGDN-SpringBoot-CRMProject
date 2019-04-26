package dn.codegym.crm.dto;

import dn.codegym.crm.entity.ClassRoom;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    private String id;
    private String name;
    private String birthday;
    private String gender;
    private ClassRoom idClass;
    private Boolean deleted;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public ClassRoom getIdClass() {
        return idClass;
    }

    public void setIdClass(ClassRoom idClass) {
        this.idClass = idClass;
    }

    public Boolean getDeleted() {
        return deleted;
    }
}
