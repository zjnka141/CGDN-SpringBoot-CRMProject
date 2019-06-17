package dn.codegym.crm.dto;

import dn.codegym.crm.validator.validatorName.UniqueName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class ProductDTO implements Serializable {

    private String id;
    @UniqueName
    @Pattern(regexp = "^[a-zA-Z0-9 ]+")
    private String name;
    private String description;
    private boolean deleted;

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
