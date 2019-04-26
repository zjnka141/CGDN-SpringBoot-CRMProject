package dn.codegym.crm.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "classes")
public class ClassRoom extends BaseEntity{
    @Id
    private String id= UUID.randomUUID().toString();
    private String name;
    @Column(name = "courses_id")
    private String idCourse;
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

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
