package dn.codegym.crm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dn.codegym.crm.entity.Lead;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class LeadDetailDTO implements Serializable {
    private String id;
    private String status;
    private String content;

    private String createBy;
    private Lead lead;
    private String lastUpdateLeadDetailDate;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getlastUpdateLeadDetailDate() {
        return lastUpdateLeadDetailDate;
    }

    public void setLastUpdateLeadDetailDate(String lastUpdateLeadDetailDate) {
        this.lastUpdateLeadDetailDate = lastUpdateLeadDetailDate;
    }

    public String getId() {
        return id;
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

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }
}
