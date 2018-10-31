package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.DatableDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Datable and its DTO DatableDTO.
 */
@Mapper(componentModel = "spring", uses = {DacolumnMapper.class, })
public interface DatableMapper extends EntityMapper <DatableDTO, Datable> {
    
    
    default Datable fromId(Long id) {
        if (id == null) {
            return null;
        }
        Datable datable = new Datable();
        datable.setId(id);
        return datable;
    }
}
