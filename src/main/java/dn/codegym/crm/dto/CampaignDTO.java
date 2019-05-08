package dn.codegym.crm.dto;

import dn.codegym.crm.entity.Lead;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

public class CampaignDTO implements Serializable {

    private String id;
    @NotBlank(message = "Campaign name is not valid")
    private String name;
    private String description;
    @NotEmpty(message = "Start day is not valid")
    private String startDay;
    @NotEmpty(message = "End day is not valid")
    private String endDay;
    @Pattern(regexp = "^((0)[0-9]{9})$", message = "Phone numbers start at 0 and have 10 numbers")
    private String phoneNumber;
    private boolean deleted;
    private List<Lead> leads;

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
