package dn.codegym.crm.dto;

import dn.codegym.crm.entity.Campaign;
import dn.codegym.crm.entity.LeadDetail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class LeadDTO implements Serializable {
    private String id;
    private String product;
    private String status;
    private String lastUpdateStatusDate;
    @NotBlank(message = "Lead name is not null")
    @Pattern(regexp = "(^$|[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ])*$", message = "Lead name is not valid")
    private String name;

    private String gender;

    @NotBlank(message = "Phone number is not null")
    @Pattern(regexp = "(^$|0[0-9]{9})*$", message = "phone number is not valid")
    private String phoneNumber;
    private List<LeadDetail> leadDetails;
    private String job;


    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Source is not valid")
    private String source;

    private String admissionDate;
    private boolean deleted;
    private Campaign campaign;

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

    public void setProduct(String product) {
        this.product = product;
    }

    public String getLastUpdateStatusDate() {
        return lastUpdateStatusDate;
    }

    public void setLastUpdateStatusDate(String lastUpdateStatusDate) {
        this.lastUpdateStatusDate = lastUpdateStatusDate;
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

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
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
