package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.BookDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Book and its DTO BookDTO.
 */
@Mapper(componentModel = "spring", uses = {AuthorMapper.class, })
public interface BookMapper extends EntityMapper <BookDTO, Book> {

    @Mapping(source = "writer.id", target = "writerId")
    @Mapping(source = "writer.name", target = "writerName")
    BookDTO toDto(Book book); 

    @Mapping(source = "writerId", target = "writer")
    Book toEntity(BookDTO bookDTO); 
    default Book fromId(Long id) {
        if (id == null) {
            return null;
        }
        Book book = new Book();
        book.setId(id);
        return book;
    }
}
