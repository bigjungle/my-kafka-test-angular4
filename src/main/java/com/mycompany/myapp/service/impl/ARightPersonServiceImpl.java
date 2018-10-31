package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.ARightPersonService;
import com.mycompany.myapp.domain.ARightPerson;
import com.mycompany.myapp.repository.ARightPersonRepository;
import com.mycompany.myapp.service.dto.ARightPersonDTO;
import com.mycompany.myapp.service.mapper.ARightPersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing ARightPerson.
 */
@Service
@Transactional
public class ARightPersonServiceImpl implements ARightPersonService{

    private final Logger log = LoggerFactory.getLogger(ARightPersonServiceImpl.class);

    private final ARightPersonRepository aRightPersonRepository;

    private final ARightPersonMapper aRightPersonMapper;
    public ARightPersonServiceImpl(ARightPersonRepository aRightPersonRepository, ARightPersonMapper aRightPersonMapper) {
        this.aRightPersonRepository = aRightPersonRepository;
        this.aRightPersonMapper = aRightPersonMapper;
    }

    /**
     * Save a aRightPerson.
     *
     * @param aRightPersonDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ARightPersonDTO save(ARightPersonDTO aRightPersonDTO) {
        log.debug("Request to save ARightPerson : {}", aRightPersonDTO);
        ARightPerson aRightPerson = aRightPersonMapper.toEntity(aRightPersonDTO);
        aRightPerson = aRightPersonRepository.save(aRightPerson);
        return aRightPersonMapper.toDto(aRightPerson);
    }

    /**
     *  Get all the aRightPeople.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ARightPersonDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ARightPeople");
        return aRightPersonRepository.findAll(pageable)
            .map(aRightPersonMapper::toDto);
    }

    /**
     *  Get one aRightPerson by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ARightPersonDTO findOne(Long id) {
        log.debug("Request to get ARightPerson : {}", id);
        ARightPerson aRightPerson = aRightPersonRepository.findOne(id);
        return aRightPersonMapper.toDto(aRightPerson);
    }

    /**
     *  Delete the  aRightPerson by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ARightPerson : {}", id);
        aRightPersonRepository.delete(id);
    }
}
