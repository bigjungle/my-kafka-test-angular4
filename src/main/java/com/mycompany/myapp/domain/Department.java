package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Department.
 */
@Entity
@Table(name = "department")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Department implements Serializable {

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

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Person> people = new HashSet<>();

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SysDir> sysDirs = new HashSet<>();

    @ManyToOne
    private Department parent;

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

    public Department name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Department code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public Department tel(String tel) {
        this.tel = tel;
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public Department fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public Department mail(String mail) {
        this.mail = mail;
        return this;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public Department people(Set<Person> people) {
        this.people = people;
        return this;
    }

    public Department addPerson(Person person) {
        this.people.add(person);
        person.setDepartment(this);
        return this;
    }

    public Department removePerson(Person person) {
        this.people.remove(person);
        person.setDepartment(null);
        return this;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    public Set<SysDir> getSysDirs() {
        return sysDirs;
    }

    public Department sysDirs(Set<SysDir> sysDirs) {
        this.sysDirs = sysDirs;
        return this;
    }

    public Department addSysDir(SysDir sysDir) {
        this.sysDirs.add(sysDir);
        sysDir.setDepartment(this);
        return this;
    }

    public Department removeSysDir(SysDir sysDir) {
        this.sysDirs.remove(sysDir);
        sysDir.setDepartment(null);
        return this;
    }

    public void setSysDirs(Set<SysDir> sysDirs) {
        this.sysDirs = sysDirs;
    }

    public Department getParent() {
        return parent;
    }

    public Department parent(Department department) {
        this.parent = department;
        return this;
    }

    public void setParent(Department department) {
        this.parent = department;
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
        Department department = (Department) o;
        if (department.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), department.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Department{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", tel='" + getTel() + "'" +
            ", fax='" + getFax() + "'" +
            ", mail='" + getMail() + "'" +
            "}";
    }
}
