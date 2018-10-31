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
 * A Dep.
 */
@Entity
@Table(name = "dep")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Dep implements Serializable {

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

    @ManyToOne
    private Dep upper;

    @OneToMany(mappedBy = "upper")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Dep> deps = new HashSet<>();

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

    public Dep name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Dep code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public Dep tel(String tel) {
        this.tel = tel;
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public Dep fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public Dep mail(String mail) {
        this.mail = mail;
        return this;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Dep getUpper() {
        return upper;
    }

    public Dep upper(Dep dep) {
        this.upper = dep;
        return this;
    }

    public void setUpper(Dep dep) {
        this.upper = dep;
    }

    public Set<Dep> getDeps() {
        return deps;
    }

    public Dep deps(Set<Dep> deps) {
        this.deps = deps;
        return this;
    }

    public Dep addDep(Dep dep) {
        this.deps.add(dep);
        dep.setUpper(this);
        return this;
    }

    public Dep removeDep(Dep dep) {
        this.deps.remove(dep);
        dep.setUpper(null);
        return this;
    }

    public void setDeps(Set<Dep> deps) {
        this.deps = deps;
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
        Dep dep = (Dep) o;
        if (dep.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dep.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Dep{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", tel='" + getTel() + "'" +
            ", fax='" + getFax() + "'" +
            ", mail='" + getMail() + "'" +
            "}";
    }
}
