package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.DepDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Dep.
 */
public interface DepService {

    /**
     * Save a dep.
     *
     * @param depDTO the entity to save
     * @return the persisted entity
     */
    DepDTO save(DepDTO depDTO);

    /**
     *  Get all the deps.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<DepDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" dep.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    DepDTO findOne(Long id);

    /**
     *  Delete the "id" dep.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
