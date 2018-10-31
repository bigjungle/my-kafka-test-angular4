package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.DatableService;
import com.mycompany.myapp.domain.Datable;
import com.mycompany.myapp.repository.DatableRepository;
import com.mycompany.myapp.service.dto.DatableDTO;
import com.mycompany.myapp.service.mapper.DatableMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Datable.
 */
@Service
@Transactional
public class DatableServiceImpl implements DatableService{

    private final Logger log = LoggerFactory.getLogger(DatableServiceImpl.class);

    private final DatableRepository datableRepository;

    private final DatableMapper datableMapper;
    public DatableServiceImpl(DatableRepository datableRepository, DatableMapper datableMapper) {
        this.datableRepository = datableRepository;
        this.datableMapper = datableMapper;
    }

    /**
     * Save a datable.
     *
     * @param datableDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DatableDTO save(DatableDTO datableDTO) {
        log.debug("Request to save Datable : {}", datableDTO);
        Datable datable = datableMapper.toEntity(datableDTO);
        datable = datableRepository.save(datable);
        return datableMapper.toDto(datable);
    }

    /**
     *  Get all the datables.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DatableDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Datables");
        return datableRepository.findAll(pageable)
            .map(datableMapper::toDto);
    }

    /**
     *  Get one datable by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public DatableDTO findOne(Long id) {
        log.debug("Request to get Datable : {}", id);
        Datable datable = datableRepository.findOneWithEagerRelationships(id);
        return datableMapper.toDto(datable);
    }

    /**
     *  Delete the  datable by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Datable : {}", id);
        datableRepository.delete(id);
    }
}
