package dn.codegym.crm.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "campaigns")
public class Campaign extends BaseEntity {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;
    private boolean deleted;
    private LocalDate start_day;
    private LocalDate end_day;
    private String phone_number;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<Lead> leads;

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public LocalDate getStart_day() {
        return start_day;
    }

    public void setStart_day(LocalDate start_day) {
        this.start_day = start_day;
    }

    public LocalDate getEnd_day() {
        return end_day;
    }

    public void setEnd_day(LocalDate end_day) {
        this.end_day = end_day;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
