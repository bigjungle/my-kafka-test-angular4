package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.SysDirDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity SysDir and its DTO SysDirDTO.
 */
@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, PersonMapper.class, })
public interface SysDirMapper extends EntityMapper <SysDirDTO, SysDir> {

    @Mapping(source = "parent.id", target = "parentId")

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "department.name", target = "departmentName")

    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "person.name", target = "personName")
    SysDirDTO toDto(SysDir sysDir); 

    @Mapping(source = "parentId", target = "parent")

    @Mapping(source = "departmentId", target = "department")

    @Mapping(source = "personId", target = "person")
    SysDir toEntity(SysDirDTO sysDirDTO); 
    default SysDir fromId(Long id) {
        if (id == null) {
            return null;
        }
        SysDir sysDir = new SysDir();
        sysDir.setId(id);
        return sysDir;
    }
}
