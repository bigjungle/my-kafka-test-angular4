package com.mycompany.myapp.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import com.mycompany.myapp.domain.enumeration.Columntype;

/**
 * A DTO for the Dacolumn entity.
 */
public class DacolumnDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private String title;

    private String description;

    @NotNull
    private Columntype columntype;

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

    public Columntype getColumntype() {
        return columntype;
    }

    public void setColumntype(Columntype columntype) {
        this.columntype = columntype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DacolumnDTO dacolumnDTO = (DacolumnDTO) o;
        if(dacolumnDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dacolumnDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DacolumnDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", columntype='" + getColumntype() + "'" +
            "}";
    }
}
