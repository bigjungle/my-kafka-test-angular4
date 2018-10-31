package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.ARightPersonService;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.web.rest.util.PaginationUtil;
import com.mycompany.myapp.service.dto.ARightPersonDTO;
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
 * REST controller for managing ARightPerson.
 */
@RestController
@RequestMapping("/api")
public class ARightPersonResource {

    private final Logger log = LoggerFactory.getLogger(ARightPersonResource.class);

    private static final String ENTITY_NAME = "aRightPerson";

    private final ARightPersonService aRightPersonService;

    public ARightPersonResource(ARightPersonService aRightPersonService) {
        this.aRightPersonService = aRightPersonService;
    }

    /**
     * POST  /a-right-people : Create a new aRightPerson.
     *
     * @param aRightPersonDTO the aRightPersonDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new aRightPersonDTO, or with status 400 (Bad Request) if the aRightPerson has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/a-right-people")
    @Timed
    public ResponseEntity<ARightPersonDTO> createARightPerson(@RequestBody ARightPersonDTO aRightPersonDTO) throws URISyntaxException {
        log.debug("REST request to save ARightPerson : {}", aRightPersonDTO);
        if (aRightPersonDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new aRightPerson cannot already have an ID")).body(null);
        }
        ARightPersonDTO result = aRightPersonService.save(aRightPersonDTO);
        return ResponseEntity.created(new URI("/api/a-right-people/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /a-right-people : Updates an existing aRightPerson.
     *
     * @param aRightPersonDTO the aRightPersonDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated aRightPersonDTO,
     * or with status 400 (Bad Request) if the aRightPersonDTO is not valid,
     * or with status 500 (Internal Server Error) if the aRightPersonDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/a-right-people")
    @Timed
    public ResponseEntity<ARightPersonDTO> updateARightPerson(@RequestBody ARightPersonDTO aRightPersonDTO) throws URISyntaxException {
        log.debug("REST request to update ARightPerson : {}", aRightPersonDTO);
        if (aRightPersonDTO.getId() == null) {
            return createARightPerson(aRightPersonDTO);
        }
        ARightPersonDTO result = aRightPersonService.save(aRightPersonDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, aRightPersonDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /a-right-people : get all the aRightPeople.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of aRightPeople in body
     */
    @GetMapping("/a-right-people")
    @Timed
    public ResponseEntity<List<ARightPersonDTO>> getAllARightPeople(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of ARightPeople");
        Page<ARightPersonDTO> page = aRightPersonService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/a-right-people");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /a-right-people/:id : get the "id" aRightPerson.
     *
     * @param id the id of the aRightPersonDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the aRightPersonDTO, or with status 404 (Not Found)
     */
    @GetMapping("/a-right-people/{id}")
    @Timed
    public ResponseEntity<ARightPersonDTO> getARightPerson(@PathVariable Long id) {
        log.debug("REST request to get ARightPerson : {}", id);
        ARightPersonDTO aRightPersonDTO = aRightPersonService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(aRightPersonDTO));
    }

    /**
     * DELETE  /a-right-people/:id : delete the "id" aRightPerson.
     *
     * @param id the id of the aRightPersonDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/a-right-people/{id}")
    @Timed
    public ResponseEntity<Void> deleteARightPerson(@PathVariable Long id) {
        log.debug("REST request to delete ARightPerson : {}", id);
        aRightPersonService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
