package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.ARightUserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing ARightUser.
 */
public interface ARightUserService {

    /**
     * Save a aRightUser.
     *
     * @param aRightUserDTO the entity to save
     * @return the persisted entity
     */
    ARightUserDTO save(ARightUserDTO aRightUserDTO);

    /**
     *  Get all the aRightUsers.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ARightUserDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" aRightUser.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ARightUserDTO findOne(Long id);

    /**
     *  Delete the "id" aRightUser.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
