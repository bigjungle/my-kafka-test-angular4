package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.service.DatableService;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.web.rest.util.PaginationUtil;
import com.mycompany.myapp.service.dto.DatableDTO;
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
 * REST controller for managing Datable.
 */
@RestController
@RequestMapping("/api")
public class DatableResource {

    private final Logger log = LoggerFactory.getLogger(DatableResource.class);

    private static final String ENTITY_NAME = "datable";

    private final DatableService datableService;

    public DatableResource(DatableService datableService) {
        this.datableService = datableService;
    }

    /**
     * POST  /datables : Create a new datable.
     *
     * @param datableDTO the datableDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new datableDTO, or with status 400 (Bad Request) if the datable has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/datables")
    @Timed
    public ResponseEntity<DatableDTO> createDatable(@Valid @RequestBody DatableDTO datableDTO) throws URISyntaxException {
        log.debug("REST request to save Datable : {}", datableDTO);
        if (datableDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new datable cannot already have an ID")).body(null);
        }
        DatableDTO result = datableService.save(datableDTO);
        return ResponseEntity.created(new URI("/api/datables/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /datables : Updates an existing datable.
     *
     * @param datableDTO the datableDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated datableDTO,
     * or with status 400 (Bad Request) if the datableDTO is not valid,
     * or with status 500 (Internal Server Error) if the datableDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/datables")
    @Timed
    public ResponseEntity<DatableDTO> updateDatable(@Valid @RequestBody DatableDTO datableDTO) throws URISyntaxException {
        log.debug("REST request to update Datable : {}", datableDTO);
        if (datableDTO.getId() == null) {
            return createDatable(datableDTO);
        }
        DatableDTO result = datableService.save(datableDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, datableDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /datables : get all the datables.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of datables in body
     */
    @GetMapping("/datables")
    @Timed
    public ResponseEntity<List<DatableDTO>> getAllDatables(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Datables");
        Page<DatableDTO> page = datableService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/datables");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /datables/:id : get the "id" datable.
     *
     * @param id the id of the datableDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the datableDTO, or with status 404 (Not Found)
     */
    @GetMapping("/datables/{id}")
    @Timed
    public ResponseEntity<DatableDTO> getDatable(@PathVariable Long id) {
        log.debug("REST request to get Datable : {}", id);
        DatableDTO datableDTO = datableService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(datableDTO));
    }

    /**
     * DELETE  /datables/:id : delete the "id" datable.
     *
     * @param id the id of the datableDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/datables/{id}")
    @Timed
    public ResponseEntity<Void> deleteDatable(@PathVariable Long id) {
        log.debug("REST request to delete Datable : {}", id);
        datableService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
