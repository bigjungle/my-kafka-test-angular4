package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.DepDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Dep and its DTO DepDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DepMapper extends EntityMapper <DepDTO, Dep> {

    @Mapping(source = "upper.id", target = "upperId")
    DepDTO toDto(Dep dep); 

    @Mapping(source = "upperId", target = "upper")
    @Mapping(target = "deps", ignore = true)
    Dep toEntity(DepDTO depDTO); 
    default Dep fromId(Long id) {
        if (id == null) {
            return null;
        }
        Dep dep = new Dep();
        dep.setId(id);
        return dep;
    }
}
