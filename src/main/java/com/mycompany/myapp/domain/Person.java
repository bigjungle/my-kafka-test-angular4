package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Person.
 */
@Entity
@Table(name = "person")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "tel")
    private String tel;

    @Column(name = "fax")
    private String fax;

    @Column(name = "mail")
    private String mail;

    @OneToMany(mappedBy = "person")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SysDir> sysDirs = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    private Department department;

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

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Person code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public Person tel(String tel) {
        this.tel = tel;
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public Person fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public Person mail(String mail) {
        this.mail = mail;
        return this;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<SysDir> getSysDirs() {
        return sysDirs;
    }

    public Person sysDirs(Set<SysDir> sysDirs) {
        this.sysDirs = sysDirs;
        return this;
    }

    public Person addSysDir(SysDir sysDir) {
        this.sysDirs.add(sysDir);
        sysDir.setPerson(this);
        return this;
    }

    public Person removeSysDir(SysDir sysDir) {
        this.sysDirs.remove(sysDir);
        sysDir.setPerson(null);
        return this;
    }

    public void setSysDirs(Set<SysDir> sysDirs) {
        this.sysDirs = sysDirs;
    }

    public Department getDepartment() {
        return department;
    }

    public Person department(Department department) {
        this.department = department;
        return this;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        Person person = (Person) o;
        if (person.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", tel='" + getTel() + "'" +
            ", fax='" + getFax() + "'" +
            ", mail='" + getMail() + "'" +
            "}";
    }
}
