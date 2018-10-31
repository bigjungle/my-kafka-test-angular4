package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.SysDirService;
import com.mycompany.myapp.domain.SysDir;
import com.mycompany.myapp.repository.SysDirRepository;
import com.mycompany.myapp.service.dto.SysDirDTO;
import com.mycompany.myapp.service.mapper.SysDirMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing SysDir.
 */
@Service
@Transactional
public class SysDirServiceImpl implements SysDirService{

    private final Logger log = LoggerFactory.getLogger(SysDirServiceImpl.class);

    private final SysDirRepository sysDirRepository;

    private final SysDirMapper sysDirMapper;
    public SysDirServiceImpl(SysDirRepository sysDirRepository, SysDirMapper sysDirMapper) {
        this.sysDirRepository = sysDirRepository;
        this.sysDirMapper = sysDirMapper;
    }

    /**
     * Save a sysDir.
     *
     * @param sysDirDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SysDirDTO save(SysDirDTO sysDirDTO) {
        log.debug("Request to save SysDir : {}", sysDirDTO);
        SysDir sysDir = sysDirMapper.toEntity(sysDirDTO);
        sysDir = sysDirRepository.save(sysDir);
        return sysDirMapper.toDto(sysDir);
    }

    /**
     *  Get all the sysDirs.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SysDirDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SysDirs");
        return sysDirRepository.findAll(pageable)
            .map(sysDirMapper::toDto);
    }

    /**
     *  Get one sysDir by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SysDirDTO findOne(Long id) {
        log.debug("Request to get SysDir : {}", id);
        SysDir sysDir = sysDirRepository.findOne(id);
        return sysDirMapper.toDto(sysDir);
    }

    /**
     *  Delete the  sysDir by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SysDir : {}", id);
        sysDirRepository.delete(id);
    }
}
