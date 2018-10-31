package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterApp;

import com.mycompany.myapp.domain.Dep;
import com.mycompany.myapp.repository.DepRepository;
import com.mycompany.myapp.service.DepService;
import com.mycompany.myapp.service.dto.DepDTO;
import com.mycompany.myapp.service.mapper.DepMapper;
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

/**
 * Test class for the DepResource REST controller.
 *
 * @see DepResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterApp.class)
public class DepResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_TEL = "AAAAAAAAAA";
    private static final String UPDATED_TEL = "BBBBBBBBBB";

    private static final String DEFAULT_FAX = "AAAAAAAAAA";
    private static final String UPDATED_FAX = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL = "AAAAAAAAAA";
    private static final String UPDATED_MAIL = "BBBBBBBBBB";

    @Autowired
    private DepRepository depRepository;

    @Autowired
    private DepMapper depMapper;

    @Autowired
    private DepService depService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restDepMockMvc;

    private Dep dep;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DepResource depResource = new DepResource(depService);
        this.restDepMockMvc = MockMvcBuilders.standaloneSetup(depResource)
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
    public static Dep createEntity(EntityManager em) {
        Dep dep = new Dep()
            .name(DEFAULT_NAME)
            .code(DEFAULT_CODE)
            .tel(DEFAULT_TEL)
            .fax(DEFAULT_FAX)
            .mail(DEFAULT_MAIL);
        return dep;
    }

    @Before
    public void initTest() {
        dep = createEntity(em);
    }

    @Test
    @Transactional
    public void createDep() throws Exception {
        int databaseSizeBeforeCreate = depRepository.findAll().size();

        // Create the Dep
        DepDTO depDTO = depMapper.toDto(dep);
        restDepMockMvc.perform(post("/api/deps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(depDTO)))
            .andExpect(status().isCreated());

        // Validate the Dep in the database
        List<Dep> depList = depRepository.findAll();
        assertThat(depList).hasSize(databaseSizeBeforeCreate + 1);
        Dep testDep = depList.get(depList.size() - 1);
        assertThat(testDep.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testDep.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testDep.getTel()).isEqualTo(DEFAULT_TEL);
        assertThat(testDep.getFax()).isEqualTo(DEFAULT_FAX);
        assertThat(testDep.getMail()).isEqualTo(DEFAULT_MAIL);
    }

    @Test
    @Transactional
    public void createDepWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = depRepository.findAll().size();

        // Create the Dep with an existing ID
        dep.setId(1L);
        DepDTO depDTO = depMapper.toDto(dep);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDepMockMvc.perform(post("/api/deps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(depDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<Dep> depList = depRepository.findAll();
        assertThat(depList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllDeps() throws Exception {
        // Initialize the database
        depRepository.saveAndFlush(dep);

        // Get all the depList
        restDepMockMvc.perform(get("/api/deps?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dep.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.toString())))
            .andExpect(jsonPath("$.[*].tel").value(hasItem(DEFAULT_TEL.toString())))
            .andExpect(jsonPath("$.[*].fax").value(hasItem(DEFAULT_FAX.toString())))
            .andExpect(jsonPath("$.[*].mail").value(hasItem(DEFAULT_MAIL.toString())));
    }

    @Test
    @Transactional
    public void getDep() throws Exception {
        // Initialize the database
        depRepository.saveAndFlush(dep);

        // Get the dep
        restDepMockMvc.perform(get("/api/deps/{id}", dep.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(dep.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.toString()))
            .andExpect(jsonPath("$.tel").value(DEFAULT_TEL.toString()))
            .andExpect(jsonPath("$.fax").value(DEFAULT_FAX.toString()))
            .andExpect(jsonPath("$.mail").value(DEFAULT_MAIL.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingDep() throws Exception {
        // Get the dep
        restDepMockMvc.perform(get("/api/deps/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDep() throws Exception {
        // Initialize the database
        depRepository.saveAndFlush(dep);
        int databaseSizeBeforeUpdate = depRepository.findAll().size();

        // Update the dep
        Dep updatedDep = depRepository.findOne(dep.getId());
        updatedDep
            .name(UPDATED_NAME)
            .code(UPDATED_CODE)
            .tel(UPDATED_TEL)
            .fax(UPDATED_FAX)
            .mail(UPDATED_MAIL);
        DepDTO depDTO = depMapper.toDto(updatedDep);

        restDepMockMvc.perform(put("/api/deps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(depDTO)))
            .andExpect(status().isOk());

        // Validate the Dep in the database
        List<Dep> depList = depRepository.findAll();
        assertThat(depList).hasSize(databaseSizeBeforeUpdate);
        Dep testDep = depList.get(depList.size() - 1);
        assertThat(testDep.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testDep.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testDep.getTel()).isEqualTo(UPDATED_TEL);
        assertThat(testDep.getFax()).isEqualTo(UPDATED_FAX);
        assertThat(testDep.getMail()).isEqualTo(UPDATED_MAIL);
    }

    @Test
    @Transactional
    public void updateNonExistingDep() throws Exception {
        int databaseSizeBeforeUpdate = depRepository.findAll().size();

        // Create the Dep
        DepDTO depDTO = depMapper.toDto(dep);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restDepMockMvc.perform(put("/api/deps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(depDTO)))
            .andExpect(status().isCreated());

        // Validate the Dep in the database
        List<Dep> depList = depRepository.findAll();
        assertThat(depList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteDep() throws Exception {
        // Initialize the database
        depRepository.saveAndFlush(dep);
        int databaseSizeBeforeDelete = depRepository.findAll().size();

        // Get the dep
        restDepMockMvc.perform(delete("/api/deps/{id}", dep.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Dep> depList = depRepository.findAll();
        assertThat(depList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Dep.class);
        Dep dep1 = new Dep();
        dep1.setId(1L);
        Dep dep2 = new Dep();
        dep2.setId(dep1.getId());
        assertThat(dep1).isEqualTo(dep2);
        dep2.setId(2L);
        assertThat(dep1).isNotEqualTo(dep2);
        dep1.setId(null);
        assertThat(dep1).isNotEqualTo(dep2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DepDTO.class);
        DepDTO depDTO1 = new DepDTO();
        depDTO1.setId(1L);
        DepDTO depDTO2 = new DepDTO();
        assertThat(depDTO1).isNotEqualTo(depDTO2);
        depDTO2.setId(depDTO1.getId());
        assertThat(depDTO1).isEqualTo(depDTO2);
        depDTO2.setId(2L);
        assertThat(depDTO1).isNotEqualTo(depDTO2);
        depDTO1.setId(null);
        assertThat(depDTO1).isNotEqualTo(depDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(depMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(depMapper.fromId(null)).isNull();
    }
}
