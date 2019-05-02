package dn.codegym.crm.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "classes")
public class ClassRoom extends BaseEntity{
    @Id
    private String id= UUID.randomUUID().toString();
    private String name;
    @ManyToOne
    @JoinColumn(name = "courses_id")
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
