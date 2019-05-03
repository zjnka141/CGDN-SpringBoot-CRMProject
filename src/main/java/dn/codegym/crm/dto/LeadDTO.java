package dn.codegym.crm.dto;

import dn.codegym.crm.entity.Campaign;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LeadDTO {
    private String id;
    @NotBlank(message = "Lead name is not null")
    @Pattern(regexp = "(^$|[a-zA-z ])*$", message = "Lead name is not valid")
    private String name;

    @NotBlank(message = "Phone number is not null")
    @Pattern(regexp = "(^$|[0-9]{10})*$", message = "must has 10 numbers")
    private String phoneNumber;

    @NotBlank(message = "Email is not null")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Source is not valid")
    private String source;
    private String status;
    private boolean deleted;
    private Campaign campaign;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
