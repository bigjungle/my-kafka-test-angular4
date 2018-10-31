package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.service.ARightUserService;
import com.mycompany.myapp.domain.ARightUser;
import com.mycompany.myapp.repository.ARightUserRepository;
import com.mycompany.myapp.service.dto.ARightUserDTO;
import com.mycompany.myapp.service.mapper.ARightUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing ARightUser.
 */
@Service
@Transactional
public class ARightUserServiceImpl implements ARightUserService{

    private final Logger log = LoggerFactory.getLogger(ARightUserServiceImpl.class);

    private final ARightUserRepository aRightUserRepository;

    private final ARightUserMapper aRightUserMapper;
    public ARightUserServiceImpl(ARightUserRepository aRightUserRepository, ARightUserMapper aRightUserMapper) {
        this.aRightUserRepository = aRightUserRepository;
        this.aRightUserMapper = aRightUserMapper;
    }

    /**
     * Save a aRightUser.
     *
     * @param aRightUserDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ARightUserDTO save(ARightUserDTO aRightUserDTO) {
        log.debug("Request to save ARightUser : {}", aRightUserDTO);
        ARightUser aRightUser = aRightUserMapper.toEntity(aRightUserDTO);
        aRightUser = aRightUserRepository.save(aRightUser);
        return aRightUserMapper.toDto(aRightUser);
    }

    /**
     *  Get all the aRightUsers.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ARightUserDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ARightUsers");
        return aRightUserRepository.findAll(pageable)
            .map(aRightUserMapper::toDto);
    }

    /**
     *  Get one aRightUser by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ARightUserDTO findOne(Long id) {
        log.debug("Request to get ARightUser : {}", id);
        ARightUser aRightUser = aRightUserRepository.findOne(id);
        return aRightUserMapper.toDto(aRightUser);
    }

    /**
     *  Delete the  aRightUser by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ARightUser : {}", id);
        aRightUserRepository.delete(id);
    }
}
