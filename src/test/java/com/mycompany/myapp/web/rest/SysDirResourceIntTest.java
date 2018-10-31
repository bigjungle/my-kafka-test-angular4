package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterApp;

import com.mycompany.myapp.domain.SysDir;
import com.mycompany.myapp.domain.Department;
import com.mycompany.myapp.repository.SysDirRepository;
import com.mycompany.myapp.service.SysDirService;
import com.mycompany.myapp.service.dto.SysDirDTO;
import com.mycompany.myapp.service.mapper.SysDirMapper;
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
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the SysDirResource REST controller.
 *
 * @see SysDirResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterApp.class)
public class SysDirResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ASSET_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_ASSET_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_IPV_4 = "AAAAAAAAAA";
    private static final String UPDATED_IPV_4 = "BBBBBBBBBB";

    private static final String DEFAULT_IPV_6 = "AAAAAAAAAA";
    private static final String UPDATED_IPV_6 = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL = "AAAAAAAAAA";
    private static final String UPDATED_MODEL = "BBBBBBBBBB";

    private static final String DEFAULT_CONFIG = "AAAAAAAAAA";
    private static final String UPDATED_CONFIG = "BBBBBBBBBB";

    private static final String DEFAULT_USES = "AAAAAAAAAA";
    private static final String UPDATED_USES = "BBBBBBBBBB";

    private static final String DEFAULT_DEVELOPER = "AAAAAAAAAA";
    private static final String UPDATED_DEVELOPER = "BBBBBBBBBB";

    private static final String DEFAULT_VERSION = "AAAAAAAAAA";
    private static final String UPDATED_VERSION = "BBBBBBBBBB";

    private static final Instant DEFAULT_PROD_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_PROD_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_DEPLOY_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DEPLOY_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_SERVICE_LIFE = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_LIFE = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_CONFIDENT_LEVEL = "AAAAAAAAAA";
    private static final String UPDATED_CONFIDENT_LEVEL = "BBBBBBBBBB";

    @Autowired
    private SysDirRepository sysDirRepository;

    @Autowired
    private SysDirMapper sysDirMapper;

    @Autowired
    private SysDirService sysDirService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSysDirMockMvc;

    private SysDir sysDir;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SysDirResource sysDirResource = new SysDirResource(sysDirService);
        this.restSysDirMockMvc = MockMvcBuilders.standaloneSetup(sysDirResource)
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
    public static SysDir createEntity(EntityManager em) {
        SysDir sysDir = new SysDir()
            .name(DEFAULT_NAME)
            .type(DEFAULT_TYPE)
            .code(DEFAULT_CODE)
            .assetNumber(DEFAULT_ASSET_NUMBER)
            .ipv4(DEFAULT_IPV_4)
            .ipv6(DEFAULT_IPV_6)
            .model(DEFAULT_MODEL)
            .config(DEFAULT_CONFIG)
            .uses(DEFAULT_USES)
            .developer(DEFAULT_DEVELOPER)
            .version(DEFAULT_VERSION)
            .prodDate(DEFAULT_PROD_DATE)
            .deployDate(DEFAULT_DEPLOY_DATE)
            .serviceLife(DEFAULT_SERVICE_LIFE)
            .status(DEFAULT_STATUS)
            .confidentLevel(DEFAULT_CONFIDENT_LEVEL);
        // Add required entity
        Department department = DepartmentResourceIntTest.createEntity(em);
        em.persist(department);
        em.flush();
        sysDir.setDepartment(department);
        return sysDir;
    }

    @Before
    public void initTest() {
        sysDir = createEntity(em);
    }

    @Test
    @Transactional
    public void createSysDir() throws Exception {
        int databaseSizeBeforeCreate = sysDirRepository.findAll().size();

        // Create the SysDir
        SysDirDTO sysDirDTO = sysDirMapper.toDto(sysDir);
        restSysDirMockMvc.perform(post("/api/sys-dirs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sysDirDTO)))
            .andExpect(status().isCreated());

        // Validate the SysDir in the database
        List<SysDir> sysDirList = sysDirRepository.findAll();
        assertThat(sysDirList).hasSize(databaseSizeBeforeCreate + 1);
        SysDir testSysDir = sysDirList.get(sysDirList.size() - 1);
        assertThat(testSysDir.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testSysDir.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testSysDir.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(testSysDir.getAssetNumber()).isEqualTo(DEFAULT_ASSET_NUMBER);
        assertThat(testSysDir.getIpv4()).isEqualTo(DEFAULT_IPV_4);
        assertThat(testSysDir.getIpv6()).isEqualTo(DEFAULT_IPV_6);
        assertThat(testSysDir.getModel()).isEqualTo(DEFAULT_MODEL);
        assertThat(testSysDir.getConfig()).isEqualTo(DEFAULT_CONFIG);
        assertThat(testSysDir.getUses()).isEqualTo(DEFAULT_USES);
        assertThat(testSysDir.getDeveloper()).isEqualTo(DEFAULT_DEVELOPER);
        assertThat(testSysDir.getVersion()).isEqualTo(DEFAULT_VERSION);
        assertThat(testSysDir.getProdDate()).isEqualTo(DEFAULT_PROD_DATE);
        assertThat(testSysDir.getDeployDate()).isEqualTo(DEFAULT_DEPLOY_DATE);
        assertThat(testSysDir.getServiceLife()).isEqualTo(DEFAULT_SERVICE_LIFE);
        assertThat(testSysDir.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSysDir.getConfidentLevel()).isEqualTo(DEFAULT_CONFIDENT_LEVEL);
    }

    @Test
    @Transactional
    public void createSysDirWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sysDirRepository.findAll().size();

        // Create the SysDir with an existing ID
        sysDir.setId(1L);
        SysDirDTO sysDirDTO = sysDirMapper.toDto(sysDir);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSysDirMockMvc.perform(post("/api/sys-dirs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sysDirDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<SysDir> sysDirList = sysDirRepository.findAll();
        assertThat(sysDirList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllSysDirs() throws Exception {
        // Initialize the database
        sysDirRepository.saveAndFlush(sysDir);

        // Get all the sysDirList
        restSysDirMockMvc.perform(get("/api/sys-dirs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sysDir.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE.toString())))
            .andExpect(jsonPath("$.[*].assetNumber").value(hasItem(DEFAULT_ASSET_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].ipv4").value(hasItem(DEFAULT_IPV_4.toString())))
            .andExpect(jsonPath("$.[*].ipv6").value(hasItem(DEFAULT_IPV_6.toString())))
            .andExpect(jsonPath("$.[*].model").value(hasItem(DEFAULT_MODEL.toString())))
            .andExpect(jsonPath("$.[*].config").value(hasItem(DEFAULT_CONFIG.toString())))
            .andExpect(jsonPath("$.[*].uses").value(hasItem(DEFAULT_USES.toString())))
            .andExpect(jsonPath("$.[*].developer").value(hasItem(DEFAULT_DEVELOPER.toString())))
            .andExpect(jsonPath("$.[*].version").value(hasItem(DEFAULT_VERSION.toString())))
            .andExpect(jsonPath("$.[*].prodDate").value(hasItem(DEFAULT_PROD_DATE.toString())))
            .andExpect(jsonPath("$.[*].deployDate").value(hasItem(DEFAULT_DEPLOY_DATE.toString())))
            .andExpect(jsonPath("$.[*].serviceLife").value(hasItem(DEFAULT_SERVICE_LIFE.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].confidentLevel").value(hasItem(DEFAULT_CONFIDENT_LEVEL.toString())));
    }

    @Test
    @Transactional
    public void getSysDir() throws Exception {
        // Initialize the database
        sysDirRepository.saveAndFlush(sysDir);

        // Get the sysDir
        restSysDirMockMvc.perform(get("/api/sys-dirs/{id}", sysDir.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(sysDir.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE.toString()))
            .andExpect(jsonPath("$.assetNumber").value(DEFAULT_ASSET_NUMBER.toString()))
            .andExpect(jsonPath("$.ipv4").value(DEFAULT_IPV_4.toString()))
            .andExpect(jsonPath("$.ipv6").value(DEFAULT_IPV_6.toString()))
            .andExpect(jsonPath("$.model").value(DEFAULT_MODEL.toString()))
            .andExpect(jsonPath("$.config").value(DEFAULT_CONFIG.toString()))
            .andExpect(jsonPath("$.uses").value(DEFAULT_USES.toString()))
            .andExpect(jsonPath("$.developer").value(DEFAULT_DEVELOPER.toString()))
            .andExpect(jsonPath("$.version").value(DEFAULT_VERSION.toString()))
            .andExpect(jsonPath("$.prodDate").value(DEFAULT_PROD_DATE.toString()))
            .andExpect(jsonPath("$.deployDate").value(DEFAULT_DEPLOY_DATE.toString()))
            .andExpect(jsonPath("$.serviceLife").value(DEFAULT_SERVICE_LIFE.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.confidentLevel").value(DEFAULT_CONFIDENT_LEVEL.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingSysDir() throws Exception {
        // Get the sysDir
        restSysDirMockMvc.perform(get("/api/sys-dirs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSysDir() throws Exception {
        // Initialize the database
        sysDirRepository.saveAndFlush(sysDir);
        int databaseSizeBeforeUpdate = sysDirRepository.findAll().size();

        // Update the sysDir
        SysDir updatedSysDir = sysDirRepository.findOne(sysDir.getId());
        updatedSysDir
            .name(UPDATED_NAME)
            .type(UPDATED_TYPE)
            .code(UPDATED_CODE)
            .assetNumber(UPDATED_ASSET_NUMBER)
            .ipv4(UPDATED_IPV_4)
            .ipv6(UPDATED_IPV_6)
            .model(UPDATED_MODEL)
            .config(UPDATED_CONFIG)
            .uses(UPDATED_USES)
            .developer(UPDATED_DEVELOPER)
            .version(UPDATED_VERSION)
            .prodDate(UPDATED_PROD_DATE)
            .deployDate(UPDATED_DEPLOY_DATE)
            .serviceLife(UPDATED_SERVICE_LIFE)
            .status(UPDATED_STATUS)
            .confidentLevel(UPDATED_CONFIDENT_LEVEL);
        SysDirDTO sysDirDTO = sysDirMapper.toDto(updatedSysDir);

        restSysDirMockMvc.perform(put("/api/sys-dirs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sysDirDTO)))
            .andExpect(status().isOk());

        // Validate the SysDir in the database
        List<SysDir> sysDirList = sysDirRepository.findAll();
        assertThat(sysDirList).hasSize(databaseSizeBeforeUpdate);
        SysDir testSysDir = sysDirList.get(sysDirList.size() - 1);
        assertThat(testSysDir.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testSysDir.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testSysDir.getCode()).isEqualTo(UPDATED_CODE);
        assertThat(testSysDir.getAssetNumber()).isEqualTo(UPDATED_ASSET_NUMBER);
        assertThat(testSysDir.getIpv4()).isEqualTo(UPDATED_IPV_4);
        assertThat(testSysDir.getIpv6()).isEqualTo(UPDATED_IPV_6);
        assertThat(testSysDir.getModel()).isEqualTo(UPDATED_MODEL);
        assertThat(testSysDir.getConfig()).isEqualTo(UPDATED_CONFIG);
        assertThat(testSysDir.getUses()).isEqualTo(UPDATED_USES);
        assertThat(testSysDir.getDeveloper()).isEqualTo(UPDATED_DEVELOPER);
        assertThat(testSysDir.getVersion()).isEqualTo(UPDATED_VERSION);
        assertThat(testSysDir.getProdDate()).isEqualTo(UPDATED_PROD_DATE);
        assertThat(testSysDir.getDeployDate()).isEqualTo(UPDATED_DEPLOY_DATE);
        assertThat(testSysDir.getServiceLife()).isEqualTo(UPDATED_SERVICE_LIFE);
        assertThat(testSysDir.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSysDir.getConfidentLevel()).isEqualTo(UPDATED_CONFIDENT_LEVEL);
    }

    @Test
    @Transactional
    public void updateNonExistingSysDir() throws Exception {
        int databaseSizeBeforeUpdate = sysDirRepository.findAll().size();

        // Create the SysDir
        SysDirDTO sysDirDTO = sysDirMapper.toDto(sysDir);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restSysDirMockMvc.perform(put("/api/sys-dirs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sysDirDTO)))
            .andExpect(status().isCreated());

        // Validate the SysDir in the database
        List<SysDir> sysDirList = sysDirRepository.findAll();
        assertThat(sysDirList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteSysDir() throws Exception {
        // Initialize the database
        sysDirRepository.saveAndFlush(sysDir);
        int databaseSizeBeforeDelete = sysDirRepository.findAll().size();

        // Get the sysDir
        restSysDirMockMvc.perform(delete("/api/sys-dirs/{id}", sysDir.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<SysDir> sysDirList = sysDirRepository.findAll();
        assertThat(sysDirList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysDir.class);
        SysDir sysDir1 = new SysDir();
        sysDir1.setId(1L);
        SysDir sysDir2 = new SysDir();
        sysDir2.setId(sysDir1.getId());
        assertThat(sysDir1).isEqualTo(sysDir2);
        sysDir2.setId(2L);
        assertThat(sysDir1).isNotEqualTo(sysDir2);
        sysDir1.setId(null);
        assertThat(sysDir1).isNotEqualTo(sysDir2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysDirDTO.class);
        SysDirDTO sysDirDTO1 = new SysDirDTO();
        sysDirDTO1.setId(1L);
        SysDirDTO sysDirDTO2 = new SysDirDTO();
        assertThat(sysDirDTO1).isNotEqualTo(sysDirDTO2);
        sysDirDTO2.setId(sysDirDTO1.getId());
        assertThat(sysDirDTO1).isEqualTo(sysDirDTO2);
        sysDirDTO2.setId(2L);
        assertThat(sysDirDTO1).isNotEqualTo(sysDirDTO2);
        sysDirDTO1.setId(null);
        assertThat(sysDirDTO1).isNotEqualTo(sysDirDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(sysDirMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(sysDirMapper.fromId(null)).isNull();
    }
}
