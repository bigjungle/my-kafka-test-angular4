package com.mycompany.myapp.service.dto;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Department entity.
 */
public class DepartmentDTO implements Serializable {

    private Long id;

    private String name;

    private String code;

    private String tel;

    private String fax;

    private String mail;

    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long departmentId) {
        this.parentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DepartmentDTO departmentDTO = (DepartmentDTO) o;
        if(departmentDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), departmentDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", tel='" + getTel() + "'" +
            ", fax='" + getFax() + "'" +
            ", mail='" + getMail() + "'" +
            "}";
    }
}
