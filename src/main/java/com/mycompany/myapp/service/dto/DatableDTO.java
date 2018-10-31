package com.mycompany.myapp.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.mycompany.myapp.domain.enumeration.Tabletype;

/**
 * A DTO for the Datable entity.
 */
public class DatableDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private String title;

    private String description;

    @NotNull
    private Tabletype tabletype;

    private Set<DacolumnDTO> columns = new HashSet<>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tabletype getTabletype() {
        return tabletype;
    }

    public void setTabletype(Tabletype tabletype) {
        this.tabletype = tabletype;
    }

    public Set<DacolumnDTO> getColumns() {
        return columns;
    }

    public void setColumns(Set<DacolumnDTO> dacolumns) {
        this.columns = dacolumns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DatableDTO datableDTO = (DatableDTO) o;
        if(datableDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), datableDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DatableDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", tabletype='" + getTabletype() + "'" +
            "}";
    }
}
