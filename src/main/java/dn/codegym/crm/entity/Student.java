package dn.codegym.crm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    @NotEmpty
    @Size(min=2, max = 100)
    private String name;
    private LocalDate birthday;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "classes_id")
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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
