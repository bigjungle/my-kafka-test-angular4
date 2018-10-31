package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.DacolumnService;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.web.rest.util.PaginationUtil;
import com.mycompany.myapp.service.dto.DacolumnDTO;
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
 * REST controller for managing Dacolumn.
 */
@RestController
@RequestMapping("/api")
public class DacolumnResource {

    private final Logger log = LoggerFactory.getLogger(DacolumnResource.class);

    private static final String ENTITY_NAME = "dacolumn";

    private final DacolumnService dacolumnService;

    public DacolumnResource(DacolumnService dacolumnService) {
        this.dacolumnService = dacolumnService;
    }

    /**
     * POST  /dacolumns : Create a new dacolumn.
     *
     * @param dacolumnDTO the dacolumnDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new dacolumnDTO, or with status 400 (Bad Request) if the dacolumn has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/dacolumns")
    @Timed
    public ResponseEntity<DacolumnDTO> createDacolumn(@Valid @RequestBody DacolumnDTO dacolumnDTO) throws URISyntaxException {
        log.debug("REST request to save Dacolumn : {}", dacolumnDTO);
        if (dacolumnDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new dacolumn cannot already have an ID")).body(null);
        }
        DacolumnDTO result = dacolumnService.save(dacolumnDTO);
        return ResponseEntity.created(new URI("/api/dacolumns/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /dacolumns : Updates an existing dacolumn.
     *
     * @param dacolumnDTO the dacolumnDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated dacolumnDTO,
     * or with status 400 (Bad Request) if the dacolumnDTO is not valid,
     * or with status 500 (Internal Server Error) if the dacolumnDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/dacolumns")
    @Timed
    public ResponseEntity<DacolumnDTO> updateDacolumn(@Valid @RequestBody DacolumnDTO dacolumnDTO) throws URISyntaxException {
        log.debug("REST request to update Dacolumn : {}", dacolumnDTO);
        if (dacolumnDTO.getId() == null) {
            return createDacolumn(dacolumnDTO);
        }
        DacolumnDTO result = dacolumnService.save(dacolumnDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, dacolumnDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /dacolumns : get all the dacolumns.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of dacolumns in body
     */
    @GetMapping("/dacolumns")
    @Timed
    public ResponseEntity<List<DacolumnDTO>> getAllDacolumns(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Dacolumns");
        Page<DacolumnDTO> page = dacolumnService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/dacolumns");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /dacolumns/:id : get the "id" dacolumn.
     *
     * @param id the id of the dacolumnDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the dacolumnDTO, or with status 404 (Not Found)
     */
    @GetMapping("/dacolumns/{id}")
    @Timed
    public ResponseEntity<DacolumnDTO> getDacolumn(@PathVariable Long id) {
        log.debug("REST request to get Dacolumn : {}", id);
        DacolumnDTO dacolumnDTO = dacolumnService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(dacolumnDTO));
    }

    /**
     * DELETE  /dacolumns/:id : delete the "id" dacolumn.
     *
     * @param id the id of the dacolumnDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/dacolumns/{id}")
    @Timed
    public ResponseEntity<Void> deleteDacolumn(@PathVariable Long id) {
        log.debug("REST request to delete Dacolumn : {}", id);
        dacolumnService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
