package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.SysDirService;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.web.rest.util.PaginationUtil;
import com.mycompany.myapp.service.dto.SysDirDTO;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing SysDir.
 */
@RestController
@RequestMapping("/api")
public class SysDirResource {

    private final Logger log = LoggerFactory.getLogger(SysDirResource.class);

    private static final String ENTITY_NAME = "sysDir";

    private final SysDirService sysDirService;

    public SysDirResource(SysDirService sysDirService) {
        this.sysDirService = sysDirService;
    }

    /**
     * POST  /sys-dirs : Create a new sysDir.
     *
     * @param sysDirDTO the sysDirDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sysDirDTO, or with status 400 (Bad Request) if the sysDir has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sys-dirs")
    @Timed
    public ResponseEntity<SysDirDTO> createSysDir(@Valid @RequestBody SysDirDTO sysDirDTO) throws URISyntaxException {
        log.debug("REST request to save SysDir : {}", sysDirDTO);
        if (sysDirDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new sysDir cannot already have an ID")).body(null);
        }
        SysDirDTO result = sysDirService.save(sysDirDTO);
        return ResponseEntity.created(new URI("/api/sys-dirs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sys-dirs : Updates an existing sysDir.
     *
     * @param sysDirDTO the sysDirDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sysDirDTO,
     * or with status 400 (Bad Request) if the sysDirDTO is not valid,
     * or with status 500 (Internal Server Error) if the sysDirDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sys-dirs")
    @Timed
    public ResponseEntity<SysDirDTO> updateSysDir(@Valid @RequestBody SysDirDTO sysDirDTO) throws URISyntaxException {
        log.debug("REST request to update SysDir : {}", sysDirDTO);
        if (sysDirDTO.getId() == null) {
            return createSysDir(sysDirDTO);
        }
        SysDirDTO result = sysDirService.save(sysDirDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sysDirDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sys-dirs : get all the sysDirs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sysDirs in body
     */
    @GetMapping("/sys-dirs")
    @Timed
    public ResponseEntity<List<SysDirDTO>> getAllSysDirs(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of SysDirs");
        Page<SysDirDTO> page = sysDirService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sys-dirs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sys-dirs/:id : get the "id" sysDir.
     *
     * @param id the id of the sysDirDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sysDirDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sys-dirs/{id}")
    @Timed
    public ResponseEntity<SysDirDTO> getSysDir(@PathVariable Long id) {
        log.debug("REST request to get SysDir : {}", id);
        SysDirDTO sysDirDTO = sysDirService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sysDirDTO));
    }

    /**
     * DELETE  /sys-dirs/:id : delete the "id" sysDir.
     *
     * @param id the id of the sysDirDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sys-dirs/{id}")
    @Timed
    public ResponseEntity<Void> deleteSysDir(@PathVariable Long id) {
        log.debug("REST request to delete SysDir : {}", id);
        sysDirService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
