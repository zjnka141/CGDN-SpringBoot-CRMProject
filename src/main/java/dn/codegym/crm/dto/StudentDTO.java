package dn.codegym.crm.dto;

import dn.codegym.crm.entity.ClassRoom;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class StudentDTO implements Serializable {
    private String id;
    @NotBlank(message = "Student name is not null")
    @Pattern(regexp = "(^$|[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ])*$", message = "Student name is not valid")
    private String name;
    @NotBlank(message = "birth day is not null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;
    private String gender;
    private ClassRoom classRoom;
    private Boolean deleted;
    @NotBlank(message = "Email is not null")
    @Email(message = "Email is not valid")
    private String email;
    private String studentStatus;

    @NotBlank(message = "Phone number is not null")
    @Pattern(regexp = "(^$|[0-9]{10,11})*$", message = "must has 10 or 11 numbers")
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }


}
