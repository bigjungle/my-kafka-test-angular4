package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.mycompany.myapp.domain.enumeration.Tabletype;

/**
 * A Datable.
 */
@Entity
@Table(name = "datable")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Datable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tabletype", nullable = false)
    private Tabletype tabletype;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "datable_columns",
               joinColumns = @JoinColumn(name="datables_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="columns_id", referencedColumnName="id"))
    private Set<Dacolumn> columns = new HashSet<>();

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

    public Datable name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public Datable title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Datable description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tabletype getTabletype() {
        return tabletype;
    }

    public Datable tabletype(Tabletype tabletype) {
        this.tabletype = tabletype;
        return this;
    }

    public void setTabletype(Tabletype tabletype) {
        this.tabletype = tabletype;
    }

    public Set<Dacolumn> getColumns() {
        return columns;
    }

    public Datable columns(Set<Dacolumn> dacolumns) {
        this.columns = dacolumns;
        return this;
    }

    public Datable addColumns(Dacolumn dacolumn) {
        this.columns.add(dacolumn);
        dacolumn.getDatables().add(this);
        return this;
    }

    public Datable removeColumns(Dacolumn dacolumn) {
        this.columns.remove(dacolumn);
        dacolumn.getDatables().remove(this);
        return this;
    }

    public void setColumns(Set<Dacolumn> dacolumns) {
        this.columns = dacolumns;
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
        Datable datable = (Datable) o;
        if (datable.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), datable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Datable{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", tabletype='" + getTabletype() + "'" +
            "}";
    }
}
