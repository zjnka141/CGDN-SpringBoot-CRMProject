package dn.codegym.crm.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CourseDTO implements Serializable {

    private String id;
    @NotEmpty(message = "Course name is not empty")
    private String name;
    @NotEmpty(message = "Start day is not empty")
    private String startDay;
    @NotEmpty(message = "End day is not empty")
    private String endDay;
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
}
