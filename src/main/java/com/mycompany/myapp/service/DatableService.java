package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.DatableDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Datable.
 */
public interface DatableService {

    /**
     * Save a datable.
     *
     * @param datableDTO the entity to save
     * @return the persisted entity
     */
    DatableDTO save(DatableDTO datableDTO);

    /**
     *  Get all the datables.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<DatableDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" datable.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    DatableDTO findOne(Long id);

    /**
     *  Delete the "id" datable.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
