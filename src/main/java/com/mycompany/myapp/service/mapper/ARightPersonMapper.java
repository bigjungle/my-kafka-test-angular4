package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ARightPersonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ARightPerson and its DTO ARightPersonDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ARightPersonMapper extends EntityMapper <ARightPersonDTO, ARightPerson> {
    
    
    default ARightPerson fromId(Long id) {
        if (id == null) {
            return null;
        }
        ARightPerson aRightPerson = new ARightPerson();
        aRightPerson.setId(id);
        return aRightPerson;
    }
}
