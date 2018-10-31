package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.DepService;
import com.mycompany.myapp.domain.Dep;
import com.mycompany.myapp.repository.DepRepository;
import com.mycompany.myapp.service.dto.DepDTO;
import com.mycompany.myapp.service.mapper.DepMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Dep.
 */
@Service
@Transactional
public class DepServiceImpl implements DepService{

    private final Logger log = LoggerFactory.getLogger(DepServiceImpl.class);

    private final DepRepository depRepository;

    private final DepMapper depMapper;
    public DepServiceImpl(DepRepository depRepository, DepMapper depMapper) {
        this.depRepository = depRepository;
        this.depMapper = depMapper;
    }

    /**
     * Save a dep.
     *
     * @param depDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DepDTO save(DepDTO depDTO) {
        log.debug("Request to save Dep : {}", depDTO);
        Dep dep = depMapper.toEntity(depDTO);
        dep = depRepository.save(dep);
        return depMapper.toDto(dep);
    }

    /**
     *  Get all the deps.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DepDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Deps");
        return depRepository.findAll(pageable)
            .map(depMapper::toDto);
    }

    /**
     *  Get one dep by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public DepDTO findOne(Long id) {
        log.debug("Request to get Dep : {}", id);
        Dep dep = depRepository.findOne(id);
        return depMapper.toDto(dep);
    }

    /**
     *  Delete the  dep by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Dep : {}", id);
        depRepository.delete(id);
    }
}
