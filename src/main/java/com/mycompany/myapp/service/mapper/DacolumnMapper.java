package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.DacolumnDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Dacolumn and its DTO DacolumnDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DacolumnMapper extends EntityMapper <DacolumnDTO, Dacolumn> {
    
    @Mapping(target = "datables", ignore = true)
    Dacolumn toEntity(DacolumnDTO dacolumnDTO); 
    default Dacolumn fromId(Long id) {
        if (id == null) {
            return null;
        }
        Dacolumn dacolumn = new Dacolumn();
        dacolumn.setId(id);
        return dacolumn;
    }
}
