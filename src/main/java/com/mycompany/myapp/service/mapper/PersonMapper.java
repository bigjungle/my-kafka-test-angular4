package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.PersonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Person and its DTO PersonDTO.
 */
@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, })
public interface PersonMapper extends EntityMapper <PersonDTO, Person> {

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "department.name", target = "departmentName")
    PersonDTO toDto(Person person); 
    @Mapping(target = "sysDirs", ignore = true)

    @Mapping(source = "departmentId", target = "department")
    Person toEntity(PersonDTO personDTO); 
    default Person fromId(Long id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
}
