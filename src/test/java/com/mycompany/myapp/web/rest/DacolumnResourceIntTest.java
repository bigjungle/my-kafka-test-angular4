package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterApp;

import com.mycompany.myapp.domain.Dacolumn;
import com.mycompany.myapp.domain.Datable;
import com.mycompany.myapp.repository.DacolumnRepository;
import com.mycompany.myapp.service.DacolumnService;
import com.mycompany.myapp.service.dto.DacolumnDTO;
import com.mycompany.myapp.service.mapper.DacolumnMapper;
import com.mycompany.myapp.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.domain.enumeration.Columntype;
/**
 * Test class for the DacolumnResource REST controller.
 *
 * @see DacolumnResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterApp.class)
public class DacolumnResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Columntype DEFAULT_COLUMNTYPE = Columntype.SYS;
    private static final Columntype UPDATED_COLUMNTYPE = Columntype.LOG;

    @Autowired
    private DacolumnRepository dacolumnRepository;

    @Autowired
    private DacolumnMapper dacolumnMapper;

    @Autowired
    private DacolumnService dacolumnService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restDacolumnMockMvc;

    private Dacolumn dacolumn;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DacolumnResource dacolumnResource = new DacolumnResource(dacolumnService);
        this.restDacolumnMockMvc = MockMvcBuilders.standaloneSetup(dacolumnResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Dacolumn createEntity(EntityManager em) {
        Dacolumn dacolumn = new Dacolumn()
            .name(DEFAULT_NAME)
            .title(DEFAULT_TITLE)
            .description(DEFAULT_DESCRIPTION)
            .columntype(DEFAULT_COLUMNTYPE);
        // Add required entity
        Datable datable = DatableResourceIntTest.createEntity(em);
        em.persist(datable);
        em.flush();
        dacolumn.getDatables().add(datable);
        return dacolumn;
    }

    @Before
    public void initTest() {
        dacolumn = createEntity(em);
    }

    @Test
    @Transactional
    public void createDacolumn() throws Exception {
        int databaseSizeBeforeCreate = dacolumnRepository.findAll().size();

        // Create the Dacolumn
        DacolumnDTO dacolumnDTO = dacolumnMapper.toDto(dacolumn);
        restDacolumnMockMvc.perform(post("/api/dacolumns")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dacolumnDTO)))
            .andExpect(status().isCreated());

        // Validate the Dacolumn in the database
        List<Dacolumn> dacolumnList = dacolumnRepository.findAll();
        assertThat(dacolumnList).hasSize(databaseSizeBeforeCreate + 1);
        Dacolumn testDacolumn = dacolumnList.get(dacolumnList.size() - 1);
        assertThat(testDacolumn.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testDacolumn.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testDacolumn.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testDacolumn.getColumntype()).isEqualTo(DEFAULT_COLUMNTYPE);
    }

    @Test
    @Transactional
    public void createDacolumnWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = dacolumnRepository.findAll().size();

        // Create the Dacolumn with an existing ID
        dacolumn.setId(1L);
        DacolumnDTO dacolumnDTO = dacolumnMapper.toDto(dacolumn);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDacolumnMockMvc.perform(post("/api/dacolumns")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dacolumnDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Dacolumn> dacolumnList = dacolumnRepository.findAll();
        assertThat(dacolumnList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = dacolumnRepository.findAll().size();
        // set the field null
        dacolumn.setName(null);

        // Create the Dacolumn, which fails.
        DacolumnDTO dacolumnDTO = dacolumnMapper.toDto(dacolumn);

        restDacolumnMockMvc.perform(post("/api/dacolumns")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dacolumnDTO)))
            .andExpect(status().isBadRequest());

        List<Dacolumn> dacolumnList = dacolumnRepository.findAll();
        assertThat(dacolumnList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkColumntypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = dacolumnRepository.findAll().size();
        // set the field null
        dacolumn.setColumntype(null);

        // Create the Dacolumn, which fails.
        DacolumnDTO dacolumnDTO = dacolumnMapper.toDto(dacolumn);

        restDacolumnMockMvc.perform(post("/api/dacolumns")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dacolumnDTO)))
            .andExpect(status().isBadRequest());

        List<Dacolumn> dacolumnList = dacolumnRepository.findAll();
        assertThat(dacolumnList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllDacolumns() throws Exception {
        // Initialize the database
        dacolumnRepository.saveAndFlush(dacolumn);

        // Get all the dacolumnList
        restDacolumnMockMvc.perform(get("/api/dacolumns?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dacolumn.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].columntype").value(hasItem(DEFAULT_COLUMNTYPE.toString())));
    }

    @Test
    @Transactional
    public void getDacolumn() throws Exception {
        // Initialize the database
        dacolumnRepository.saveAndFlush(dacolumn);

        // Get the dacolumn
        restDacolumnMockMvc.perform(get("/api/dacolumns/{id}", dacolumn.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(dacolumn.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.columntype").value(DEFAULT_COLUMNTYPE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingDacolumn() throws Exception {
        // Get the dacolumn
        restDacolumnMockMvc.perform(get("/api/dacolumns/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDacolumn() throws Exception {
        // Initialize the database
        dacolumnRepository.saveAndFlush(dacolumn);
        int databaseSizeBeforeUpdate = dacolumnRepository.findAll().size();

        // Update the dacolumn
        Dacolumn updatedDacolumn = dacolumnRepository.findOne(dacolumn.getId());
        updatedDacolumn
            .name(UPDATED_NAME)
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION)
            .columntype(UPDATED_COLUMNTYPE);
        DacolumnDTO dacolumnDTO = dacolumnMapper.toDto(updatedDacolumn);

        restDacolumnMockMvc.perform(put("/api/dacolumns")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dacolumnDTO)))
            .andExpect(status().isOk());

        // Validate the Dacolumn in the database
        List<Dacolumn> dacolumnList = dacolumnRepository.findAll();
        assertThat(dacolumnList).hasSize(databaseSizeBeforeUpdate);
        Dacolumn testDacolumn = dacolumnList.get(dacolumnList.size() - 1);
        assertThat(testDacolumn.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testDacolumn.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testDacolumn.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testDacolumn.getColumntype()).isEqualTo(UPDATED_COLUMNTYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingDacolumn() throws Exception {
        int databaseSizeBeforeUpdate = dacolumnRepository.findAll().size();

        // Create the Dacolumn
        DacolumnDTO dacolumnDTO = dacolumnMapper.toDto(dacolumn);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restDacolumnMockMvc.perform(put("/api/dacolumns")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(dacolumnDTO)))
            .andExpect(status().isCreated());

        // Validate the Dacolumn in the database
        List<Dacolumn> dacolumnList = dacolumnRepository.findAll();
        assertThat(dacolumnList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteDacolumn() throws Exception {
        // Initialize the database
        dacolumnRepository.saveAndFlush(dacolumn);
        int databaseSizeBeforeDelete = dacolumnRepository.findAll().size();

        // Get the dacolumn
        restDacolumnMockMvc.perform(delete("/api/dacolumns/{id}", dacolumn.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Dacolumn> dacolumnList = dacolumnRepository.findAll();
        assertThat(dacolumnList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Dacolumn.class);
        Dacolumn dacolumn1 = new Dacolumn();
        dacolumn1.setId(1L);
        Dacolumn dacolumn2 = new Dacolumn();
        dacolumn2.setId(dacolumn1.getId());
        assertThat(dacolumn1).isEqualTo(dacolumn2);
        dacolumn2.setId(2L);
        assertThat(dacolumn1).isNotEqualTo(dacolumn2);
        dacolumn1.setId(null);
        assertThat(dacolumn1).isNotEqualTo(dacolumn2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DacolumnDTO.class);
        DacolumnDTO dacolumnDTO1 = new DacolumnDTO();
        dacolumnDTO1.setId(1L);
        DacolumnDTO dacolumnDTO2 = new DacolumnDTO();
        assertThat(dacolumnDTO1).isNotEqualTo(dacolumnDTO2);
        dacolumnDTO2.setId(dacolumnDTO1.getId());
        assertThat(dacolumnDTO1).isEqualTo(dacolumnDTO2);
        dacolumnDTO2.setId(2L);
        assertThat(dacolumnDTO1).isNotEqualTo(dacolumnDTO2);
        dacolumnDTO1.setId(null);
        assertThat(dacolumnDTO1).isNotEqualTo(dacolumnDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(dacolumnMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(dacolumnMapper.fromId(null)).isNull();
    }
}
