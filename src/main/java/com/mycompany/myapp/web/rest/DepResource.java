package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.DepService;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.web.rest.util.PaginationUtil;
import com.mycompany.myapp.service.dto.DepDTO;
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

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Dep.
 */
@RestController
@RequestMapping("/api")
public class DepResource {

    private final Logger log = LoggerFactory.getLogger(DepResource.class);

    private static final String ENTITY_NAME = "dep";

    private final DepService depService;

    public DepResource(DepService depService) {
        this.depService = depService;
    }

    /**
     * POST  /deps : Create a new dep.
     *
     * @param depDTO the depDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new depDTO, or with status 400 (Bad Request) if the dep has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/deps")
    @Timed
    public ResponseEntity<DepDTO> createDep(@RequestBody DepDTO depDTO) throws URISyntaxException {
        log.debug("REST request to save Dep : {}", depDTO);
        if (depDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new dep cannot already have an ID")).body(null);
        }
        DepDTO result = depService.save(depDTO);
        return ResponseEntity.created(new URI("/api/deps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /deps : Updates an existing dep.
     *
     * @param depDTO the depDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated depDTO,
     * or with status 400 (Bad Request) if the depDTO is not valid,
     * or with status 500 (Internal Server Error) if the depDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/deps")
    @Timed
    public ResponseEntity<DepDTO> updateDep(@RequestBody DepDTO depDTO) throws URISyntaxException {
        log.debug("REST request to update Dep : {}", depDTO);
        if (depDTO.getId() == null) {
            return createDep(depDTO);
        }
        DepDTO result = depService.save(depDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, depDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /deps : get all the deps.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of deps in body
     */
    @GetMapping("/deps")
    @Timed
    public ResponseEntity<List<DepDTO>> getAllDeps(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Deps");
        Page<DepDTO> page = depService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/deps");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /deps/:id : get the "id" dep.
     *
     * @param id the id of the depDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the depDTO, or with status 404 (Not Found)
     */
    @GetMapping("/deps/{id}")
    @Timed
    public ResponseEntity<DepDTO> getDep(@PathVariable Long id) {
        log.debug("REST request to get Dep : {}", id);
        DepDTO depDTO = depService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(depDTO));
    }

    /**
     * DELETE  /deps/:id : delete the "id" dep.
     *
     * @param id the id of the depDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/deps/{id}")
    @Timed
    public ResponseEntity<Void> deleteDep(@PathVariable Long id) {
        log.debug("REST request to delete Dep : {}", id);
        depService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
