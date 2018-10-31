package com.mycompany.myapp.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the SysDir entity.
 */
public class SysDirDTO implements Serializable {

    private Long id;

    private String name;

    private String type;

    private String code;

    private String assetNumber;

    private String ipv4;

    private String ipv6;

    private String model;

    private String config;

    private String uses;

    private String developer;

    private String version;

    private Instant prodDate;

    private Instant deployDate;

    private String serviceLife;

    private String status;

    private String confidentLevel;

    private Long parentId;

    private Long departmentId;

    private String departmentName;

    private Long personId;

    private String personName;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Instant getProdDate() {
        return prodDate;
    }

    public void setProdDate(Instant prodDate) {
        this.prodDate = prodDate;
    }

    public Instant getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Instant deployDate) {
        this.deployDate = deployDate;
    }

    public String getServiceLife() {
        return serviceLife;
    }

    public void setServiceLife(String serviceLife) {
        this.serviceLife = serviceLife;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfidentLevel() {
        return confidentLevel;
    }

    public void setConfidentLevel(String confidentLevel) {
        this.confidentLevel = confidentLevel;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long sysDirId) {
        this.parentId = sysDirId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SysDirDTO sysDirDTO = (SysDirDTO) o;
        if(sysDirDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sysDirDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SysDirDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", code='" + getCode() + "'" +
            ", assetNumber='" + getAssetNumber() + "'" +
            ", ipv4='" + getIpv4() + "'" +
            ", ipv6='" + getIpv6() + "'" +
            ", model='" + getModel() + "'" +
            ", config='" + getConfig() + "'" +
            ", uses='" + getUses() + "'" +
            ", developer='" + getDeveloper() + "'" +
            ", version='" + getVersion() + "'" +
            ", prodDate='" + getProdDate() + "'" +
            ", deployDate='" + getDeployDate() + "'" +
            ", serviceLife='" + getServiceLife() + "'" +
            ", status='" + getStatus() + "'" +
            ", confidentLevel='" + getConfidentLevel() + "'" +
            "}";
    }
}
