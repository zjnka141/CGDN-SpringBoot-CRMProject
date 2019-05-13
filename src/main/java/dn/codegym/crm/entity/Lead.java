package dn.codegym.crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "leads")
public class Lead extends BaseEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private String product;
    private String status;
    private LocalDate lastUpdateStatusDate;
    private String name;
    private String gender;
    private String phoneNumber;
    private String email;
    private String job;
    private String source;
    private LocalDate admissionDate;
    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "campaigns_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Campaign campaign;

    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL)
    private List<LeadDetail> leadDetails;

    public List<LeadDetail> getLeadDetails() {
        return leadDetails;
    }

    public void setLeadDetails(List<LeadDetail> leadDetails) {
        this.leadDetails = leadDetails;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public String getProduct() {
        return product;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getLastUpdateStatusDate() {
        return lastUpdateStatusDate;
    }

    public void setLastUpdateStatusDate(LocalDate lastUpdateStatusDate) {
        this.lastUpdateStatusDate = lastUpdateStatusDate;
    }

    public void setProduct(String product) {
        this.product = product;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
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
