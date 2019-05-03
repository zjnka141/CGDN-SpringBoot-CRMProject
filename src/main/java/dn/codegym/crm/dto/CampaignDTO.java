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
    private String start_day;
    @NotEmpty(message = "End day is not valid")
    private String end_day;
    @Pattern(regexp = "^((0)[0-9]{9})$", message = "Phone numbers start at 0 and have 10 numbers")
    private String phone_number;
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

    public String getStart_day() {
        return start_day;
    }

    public void setStart_day(String start_day) {
        this.start_day = start_day;
    }

    public String getEnd_day() {
        return end_day;
    }

    public void setEnd_day(String end_day) {
        this.end_day = end_day;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
