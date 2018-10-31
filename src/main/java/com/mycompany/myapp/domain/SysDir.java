package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A SysDir.
 */
@Entity
@Table(name = "sys_dir")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysDir implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "jhi_type")
    private String type;

    @Column(name = "code")
    private String code;

    @Column(name = "asset_number")
    private String assetNumber;

    @Column(name = "ipv_4")
    private String ipv4;

    @Column(name = "ipv_6")
    private String ipv6;

    @Column(name = "model")
    private String model;

    @Column(name = "config")
    private String config;

    @Column(name = "uses")
    private String uses;

    @Column(name = "developer")
    private String developer;

    @Column(name = "version")
    private String version;

    @Column(name = "prod_date")
    private Instant prodDate;

    @Column(name = "deploy_date")
    private Instant deployDate;

    @Column(name = "service_life")
    private String serviceLife;

    @Column(name = "status")
    private String status;

    @Column(name = "confident_level")
    private String confidentLevel;

    @ManyToOne
    private SysDir parent;

    @ManyToOne(optional = false)
    @NotNull
    private Department department;

    @ManyToOne
    private Person person;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public SysDir name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public SysDir type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public SysDir code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public SysDir assetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
        return this;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getIpv4() {
        return ipv4;
    }

    public SysDir ipv4(String ipv4) {
        this.ipv4 = ipv4;
        return this;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public SysDir ipv6(String ipv6) {
        this.ipv6 = ipv6;
        return this;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getModel() {
        return model;
    }

    public SysDir model(String model) {
        this.model = model;
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getConfig() {
        return config;
    }

    public SysDir config(String config) {
        this.config = config;
        return this;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getUses() {
        return uses;
    }

    public SysDir uses(String uses) {
        this.uses = uses;
        return this;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getDeveloper() {
        return developer;
    }

    public SysDir developer(String developer) {
        this.developer = developer;
        return this;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getVersion() {
        return version;
    }

    public SysDir version(String version) {
        this.version = version;
        return this;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Instant getProdDate() {
        return prodDate;
    }

    public SysDir prodDate(Instant prodDate) {
        this.prodDate = prodDate;
        return this;
    }

    public void setProdDate(Instant prodDate) {
        this.prodDate = prodDate;
    }

    public Instant getDeployDate() {
        return deployDate;
    }

    public SysDir deployDate(Instant deployDate) {
        this.deployDate = deployDate;
        return this;
    }

    public void setDeployDate(Instant deployDate) {
        this.deployDate = deployDate;
    }

    public String getServiceLife() {
        return serviceLife;
    }

    public SysDir serviceLife(String serviceLife) {
        this.serviceLife = serviceLife;
        return this;
    }

    public void setServiceLife(String serviceLife) {
        this.serviceLife = serviceLife;
    }

    public String getStatus() {
        return status;
    }

    public SysDir status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfidentLevel() {
        return confidentLevel;
    }

    public SysDir confidentLevel(String confidentLevel) {
        this.confidentLevel = confidentLevel;
        return this;
    }

    public void setConfidentLevel(String confidentLevel) {
        this.confidentLevel = confidentLevel;
    }

    public SysDir getParent() {
        return parent;
    }

    public SysDir parent(SysDir sysDir) {
        this.parent = sysDir;
        return this;
    }

    public void setParent(SysDir sysDir) {
        this.parent = sysDir;
    }

    public Department getDepartment() {
        return department;
    }

    public SysDir department(Department department) {
        this.department = department;
        return this;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Person getPerson() {
        return person;
    }

    public SysDir person(Person person) {
        this.person = person;
        return this;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SysDir sysDir = (SysDir) o;
        if (sysDir.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), sysDir.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SysDir{" +
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
