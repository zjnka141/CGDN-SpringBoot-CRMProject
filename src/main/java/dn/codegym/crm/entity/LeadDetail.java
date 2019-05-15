package dn.codegym.crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "lead_detail")
public class LeadDetail extends BaseEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private String status;
    private String content;

    private LocalDate lastUpdateLeadDetailDate;
    private String createdBy;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "leads_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Lead lead;
    public String getId() {
        return id;
    }

    public LocalDate getLastUpdateLeadDetailDate() {
        return lastUpdateLeadDetailDate;
    }

    public void setLastUpdateLeadDetailDate(LocalDate lastUpdateLeadDetailDate) {
        this.lastUpdateLeadDetailDate = lastUpdateLeadDetailDate;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }
}
