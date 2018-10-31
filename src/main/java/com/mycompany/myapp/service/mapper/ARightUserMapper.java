package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ARightUserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ARightUser and its DTO ARightUserDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ARightUserMapper extends EntityMapper <ARightUserDTO, ARightUser> {
    
    
    default ARightUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        ARightUser aRightUser = new ARightUser();
        aRightUser.setId(id);
        return aRightUser;
    }
}
