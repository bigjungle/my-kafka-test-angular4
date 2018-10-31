package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.DacolumnService;
import com.mycompany.myapp.domain.Dacolumn;
import com.mycompany.myapp.repository.DacolumnRepository;
import com.mycompany.myapp.service.dto.DacolumnDTO;
import com.mycompany.myapp.service.mapper.DacolumnMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Dacolumn.
 */
@Service
@Transactional
public class DacolumnServiceImpl implements DacolumnService{

    private final Logger log = LoggerFactory.getLogger(DacolumnServiceImpl.class);

    private final DacolumnRepository dacolumnRepository;

    private final DacolumnMapper dacolumnMapper;
    public DacolumnServiceImpl(DacolumnRepository dacolumnRepository, DacolumnMapper dacolumnMapper) {
        this.dacolumnRepository = dacolumnRepository;
        this.dacolumnMapper = dacolumnMapper;
    }

    /**
     * Save a dacolumn.
     *
     * @param dacolumnDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DacolumnDTO save(DacolumnDTO dacolumnDTO) {
        log.debug("Request to save Dacolumn : {}", dacolumnDTO);
        Dacolumn dacolumn = dacolumnMapper.toEntity(dacolumnDTO);
        dacolumn = dacolumnRepository.save(dacolumn);
        return dacolumnMapper.toDto(dacolumn);
    }

    /**
     *  Get all the dacolumns.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DacolumnDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Dacolumns");
        return dacolumnRepository.findAll(pageable)
            .map(dacolumnMapper::toDto);
    }

    /**
     *  Get one dacolumn by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public DacolumnDTO findOne(Long id) {
        log.debug("Request to get Dacolumn : {}", id);
        Dacolumn dacolumn = dacolumnRepository.findOne(id);
        return dacolumnMapper.toDto(dacolumn);
    }

    /**
     *  Delete the  dacolumn by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Dacolumn : {}", id);
        dacolumnRepository.delete(id);
    }
}
