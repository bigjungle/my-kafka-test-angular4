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

import com.mycompany.myapp.domain.enumeration.Columntype;

/**
 * A Dacolumn.
 */
@Entity
@Table(name = "dacolumn")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Dacolumn implements Serializable {

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
    @Column(name = "columntype", nullable = false)
    private Columntype columntype;

    @ManyToMany(mappedBy = "columns")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Datable> datables = new HashSet<>();

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

    public Dacolumn name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public Dacolumn title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Dacolumn description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Columntype getColumntype() {
        return columntype;
    }

    public Dacolumn columntype(Columntype columntype) {
        this.columntype = columntype;
        return this;
    }

    public void setColumntype(Columntype columntype) {
        this.columntype = columntype;
    }

    public Set<Datable> getDatables() {
        return datables;
    }

    public Dacolumn datables(Set<Datable> datables) {
        this.datables = datables;
        return this;
    }

    public Dacolumn addDatable(Datable datable) {
        this.datables.add(datable);
        datable.getColumns().add(this);
        return this;
    }

    public Dacolumn removeDatable(Datable datable) {
        this.datables.remove(datable);
        datable.getColumns().remove(this);
        return this;
    }

    public void setDatables(Set<Datable> datables) {
        this.datables = datables;
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
        Dacolumn dacolumn = (Dacolumn) o;
        if (dacolumn.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dacolumn.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Dacolumn{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", columntype='" + getColumntype() + "'" +
            "}";
    }
}
