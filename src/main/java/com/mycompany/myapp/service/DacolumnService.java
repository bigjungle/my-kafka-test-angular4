package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.DacolumnDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Dacolumn.
 */
public interface DacolumnService {

    /**
     * Save a dacolumn.
     *
     * @param dacolumnDTO the entity to save
     * @return the persisted entity
     */
    DacolumnDTO save(DacolumnDTO dacolumnDTO);

    /**
     *  Get all the dacolumns.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<DacolumnDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" dacolumn.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    DacolumnDTO findOne(Long id);

    /**
     *  Delete the "id" dacolumn.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
