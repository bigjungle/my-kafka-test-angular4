package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.ARightUserService;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.web.rest.util.PaginationUtil;
import com.mycompany.myapp.service.dto.ARightUserDTO;
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
 * REST controller for managing ARightUser.
 */
@RestController
@RequestMapping("/api")
public class ARightUserResource {

    private final Logger log = LoggerFactory.getLogger(ARightUserResource.class);

    private static final String ENTITY_NAME = "aRightUser";

    private final ARightUserService aRightUserService;

    public ARightUserResource(ARightUserService aRightUserService) {
        this.aRightUserService = aRightUserService;
    }

    /**
     * POST  /a-right-users : Create a new aRightUser.
     *
     * @param aRightUserDTO the aRightUserDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new aRightUserDTO, or with status 400 (Bad Request) if the aRightUser has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/a-right-users")
    @Timed
    public ResponseEntity<ARightUserDTO> createARightUser(@Valid @RequestBody ARightUserDTO aRightUserDTO) throws URISyntaxException {
        log.debug("REST request to save ARightUser : {}", aRightUserDTO);
        if (aRightUserDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new aRightUser cannot already have an ID")).body(null);
        }
        ARightUserDTO result = aRightUserService.save(aRightUserDTO);
        return ResponseEntity.created(new URI("/api/a-right-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /a-right-users : Updates an existing aRightUser.
     *
     * @param aRightUserDTO the aRightUserDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated aRightUserDTO,
     * or with status 400 (Bad Request) if the aRightUserDTO is not valid,
     * or with status 500 (Internal Server Error) if the aRightUserDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/a-right-users")
    @Timed
    public ResponseEntity<ARightUserDTO> updateARightUser(@Valid @RequestBody ARightUserDTO aRightUserDTO) throws URISyntaxException {
        log.debug("REST request to update ARightUser : {}", aRightUserDTO);
        if (aRightUserDTO.getId() == null) {
            return createARightUser(aRightUserDTO);
        }
        ARightUserDTO result = aRightUserService.save(aRightUserDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, aRightUserDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /a-right-users : get all the aRightUsers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of aRightUsers in body
     */
    @GetMapping("/a-right-users")
    @Timed
    public ResponseEntity<List<ARightUserDTO>> getAllARightUsers(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of ARightUsers");
        Page<ARightUserDTO> page = aRightUserService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/a-right-users");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /a-right-users/:id : get the "id" aRightUser.
     *
     * @param id the id of the aRightUserDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the aRightUserDTO, or with status 404 (Not Found)
     */
    @GetMapping("/a-right-users/{id}")
    @Timed
    public ResponseEntity<ARightUserDTO> getARightUser(@PathVariable Long id) {
        log.debug("REST request to get ARightUser : {}", id);
        ARightUserDTO aRightUserDTO = aRightUserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(aRightUserDTO));
    }

    /**
     * DELETE  /a-right-users/:id : delete the "id" aRightUser.
     *
     * @param id the id of the aRightUserDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/a-right-users/{id}")
    @Timed
    public ResponseEntity<Void> deleteARightUser(@PathVariable Long id) {
        log.debug("REST request to delete ARightUser : {}", id);
        aRightUserService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
