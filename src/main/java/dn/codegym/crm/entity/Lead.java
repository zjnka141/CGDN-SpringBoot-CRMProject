package dn.codegym.crm.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "leads")
public class Lead extends BaseEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String source;
    private boolean deleted;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
