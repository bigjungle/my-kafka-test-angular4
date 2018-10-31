package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.DepartmentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Department and its DTO DepartmentDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DepartmentMapper extends EntityMapper <DepartmentDTO, Department> {

    @Mapping(source = "parent.id", target = "parentId")
    DepartmentDTO toDto(Department department); 
    @Mapping(target = "people", ignore = true)
    @Mapping(target = "sysDirs", ignore = true)

    @Mapping(source = "parentId", target = "parent")
    Department toEntity(DepartmentDTO departmentDTO); 
    default Department fromId(Long id) {
        if (id == null) {
            return null;
        }
        Department department = new Department();
        department.setId(id);
        return department;
    }
}
