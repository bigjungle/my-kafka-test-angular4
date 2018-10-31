package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.ARightPersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing ARightPerson.
 */
public interface ARightPersonService {

    /**
     * Save a aRightPerson.
     *
     * @param aRightPersonDTO the entity to save
     * @return the persisted entity
     */
    ARightPersonDTO save(ARightPersonDTO aRightPersonDTO);

    /**
     *  Get all the aRightPeople.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<ARightPersonDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" aRightPerson.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    ARightPersonDTO findOne(Long id);

    /**
     *  Delete the "id" aRightPerson.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
