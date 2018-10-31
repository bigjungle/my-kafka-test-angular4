package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.SysDirDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SysDir.
 */
public interface SysDirService {

    /**
     * Save a sysDir.
     *
     * @param sysDirDTO the entity to save
     * @return the persisted entity
     */
    SysDirDTO save(SysDirDTO sysDirDTO);

    /**
     *  Get all the sysDirs.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<SysDirDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" sysDir.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    SysDirDTO findOne(Long id);

    /**
     *  Delete the "id" sysDir.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
