package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterApp;

import com.mycompany.myapp.domain.Datable;
import com.mycompany.myapp.repository.DatableRepository;
import com.mycompany.myapp.service.DatableService;
import com.mycompany.myapp.service.dto.DatableDTO;
import com.mycompany.myapp.service.mapper.DatableMapper;
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

import com.mycompany.myapp.domain.enumeration.Tabletype;
/**
 * Test class for the DatableResource REST controller.
 *
 * @see DatableResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterApp.class)
public class DatableResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final Tabletype DEFAULT_TABLETYPE = Tabletype.PARAMETER;
    private static final Tabletype UPDATED_TABLETYPE = Tabletype.DATA;

    @Autowired
    private DatableRepository datableRepository;

    @Autowired
    private DatableMapper datableMapper;

    @Autowired
    private DatableService datableService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restDatableMockMvc;

    private Datable datable;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DatableResource datableResource = new DatableResource(datableService);
        this.restDatableMockMvc = MockMvcBuilders.standaloneSetup(datableResource)
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
    public static Datable createEntity(EntityManager em) {
        Datable datable = new Datable()
            .name(DEFAULT_NAME)
            .title(DEFAULT_TITLE)
            .description(DEFAULT_DESCRIPTION)
            .tabletype(DEFAULT_TABLETYPE);
        return datable;
    }

    @Before
    public void initTest() {
        datable = createEntity(em);
    }

    @Test
    @Transactional
    public void createDatable() throws Exception {
        int databaseSizeBeforeCreate = datableRepository.findAll().size();

        // Create the Datable
        DatableDTO datableDTO = datableMapper.toDto(datable);
        restDatableMockMvc.perform(post("/api/datables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(datableDTO)))
            .andExpect(status().isCreated());

        // Validate the Datable in the database
        List<Datable> datableList = datableRepository.findAll();
        assertThat(datableList).hasSize(databaseSizeBeforeCreate + 1);
        Datable testDatable = datableList.get(datableList.size() - 1);
        assertThat(testDatable.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testDatable.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testDatable.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testDatable.getTabletype()).isEqualTo(DEFAULT_TABLETYPE);
    }

    @Test
    @Transactional
    public void createDatableWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = datableRepository.findAll().size();

        // Create the Datable with an existing ID
        datable.setId(1L);
        DatableDTO datableDTO = datableMapper.toDto(datable);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDatableMockMvc.perform(post("/api/datables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(datableDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Datable> datableList = datableRepository.findAll();
        assertThat(datableList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = datableRepository.findAll().size();
        // set the field null
        datable.setName(null);

        // Create the Datable, which fails.
        DatableDTO datableDTO = datableMapper.toDto(datable);

        restDatableMockMvc.perform(post("/api/datables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(datableDTO)))
            .andExpect(status().isBadRequest());

        List<Datable> datableList = datableRepository.findAll();
        assertThat(datableList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTabletypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = datableRepository.findAll().size();
        // set the field null
        datable.setTabletype(null);

        // Create the Datable, which fails.
        DatableDTO datableDTO = datableMapper.toDto(datable);

        restDatableMockMvc.perform(post("/api/datables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(datableDTO)))
            .andExpect(status().isBadRequest());

        List<Datable> datableList = datableRepository.findAll();
        assertThat(datableList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllDatables() throws Exception {
        // Initialize the database
        datableRepository.saveAndFlush(datable);

        // Get all the datableList
        restDatableMockMvc.perform(get("/api/datables?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(datable.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].tabletype").value(hasItem(DEFAULT_TABLETYPE.toString())));
    }

    @Test
    @Transactional
    public void getDatable() throws Exception {
        // Initialize the database
        datableRepository.saveAndFlush(datable);

        // Get the datable
        restDatableMockMvc.perform(get("/api/datables/{id}", datable.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(datable.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.tabletype").value(DEFAULT_TABLETYPE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingDatable() throws Exception {
        // Get the datable
        restDatableMockMvc.perform(get("/api/datables/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDatable() throws Exception {
        // Initialize the database
        datableRepository.saveAndFlush(datable);
        int databaseSizeBeforeUpdate = datableRepository.findAll().size();

        // Update the datable
        Datable updatedDatable = datableRepository.findOne(datable.getId());
        updatedDatable
            .name(UPDATED_NAME)
            .title(UPDATED_TITLE)
            .description(UPDATED_DESCRIPTION)
            .tabletype(UPDATED_TABLETYPE);
        DatableDTO datableDTO = datableMapper.toDto(updatedDatable);

        restDatableMockMvc.perform(put("/api/datables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(datableDTO)))
            .andExpect(status().isOk());

        // Validate the Datable in the database
        List<Datable> datableList = datableRepository.findAll();
        assertThat(datableList).hasSize(databaseSizeBeforeUpdate);
        Datable testDatable = datableList.get(datableList.size() - 1);
        assertThat(testDatable.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testDatable.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testDatable.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testDatable.getTabletype()).isEqualTo(UPDATED_TABLETYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingDatable() throws Exception {
        int databaseSizeBeforeUpdate = datableRepository.findAll().size();

        // Create the Datable
        DatableDTO datableDTO = datableMapper.toDto(datable);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restDatableMockMvc.perform(put("/api/datables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(datableDTO)))
            .andExpect(status().isCreated());

        // Validate the Datable in the database
        List<Datable> datableList = datableRepository.findAll();
        assertThat(datableList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteDatable() throws Exception {
        // Initialize the database
        datableRepository.saveAndFlush(datable);
        int databaseSizeBeforeDelete = datableRepository.findAll().size();

        // Get the datable
        restDatableMockMvc.perform(delete("/api/datables/{id}", datable.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Datable> datableList = datableRepository.findAll();
        assertThat(datableList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Datable.class);
        Datable datable1 = new Datable();
        datable1.setId(1L);
        Datable datable2 = new Datable();
        datable2.setId(datable1.getId());
        assertThat(datable1).isEqualTo(datable2);
        datable2.setId(2L);
        assertThat(datable1).isNotEqualTo(datable2);
        datable1.setId(null);
        assertThat(datable1).isNotEqualTo(datable2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DatableDTO.class);
        DatableDTO datableDTO1 = new DatableDTO();
        datableDTO1.setId(1L);
        DatableDTO datableDTO2 = new DatableDTO();
        assertThat(datableDTO1).isNotEqualTo(datableDTO2);
        datableDTO2.setId(datableDTO1.getId());
        assertThat(datableDTO1).isEqualTo(datableDTO2);
        datableDTO2.setId(2L);
        assertThat(datableDTO1).isNotEqualTo(datableDTO2);
        datableDTO1.setId(null);
        assertThat(datableDTO1).isNotEqualTo(datableDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(datableMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(datableMapper.fromId(null)).isNull();
    }
}
