package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterApp;

import com.mycompany.myapp.domain.ARightUser;
import com.mycompany.myapp.repository.ARightUserRepository;
import com.mycompany.myapp.service.ARightUserService;
import com.mycompany.myapp.service.dto.ARightUserDTO;
import com.mycompany.myapp.service.mapper.ARightUserMapper;
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
 * Test class for the ARightUserResource REST controller.
 *
 * @see ARightUserResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterApp.class)
public class ARightUserResourceIntTest {

    private static final String DEFAULT_USER_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_USER_PASSWORD = "BBBBBBBBBB";

    private static final String DEFAULT_PROCESS_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PROCESS_PASSWORD = "BBBBBBBBBB";

    private static final String DEFAULT_USER_SORT = "AAAAAAAAAA";
    private static final String UPDATED_USER_SORT = "BBBBBBBBBB";

    private static final Long DEFAULT_USER_PASSWORD_VALIINSTANT_TIMES = 1L;
    private static final Long UPDATED_USER_PASSWORD_VALIINSTANT_TIMES = 2L;

    private static final String DEFAULT_USER_PASSWORD_LOCK_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_USER_PASSWORD_LOCK_FLAG = "BBBBBBBBBB";

    private static final Long DEFAULT_PROC_PASSWORD_VALIINSTANT_TIMES = 1L;
    private static final Long UPDATED_PROC_PASSWORD_VALIINSTANT_TIMES = 2L;

    private static final String DEFAULT_PROC_PASSWORD_LOCK_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_PROC_PASSWORD_LOCK_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_USER_PROP = "AAAAAAAAAA";
    private static final String UPDATED_USER_PROP = "BBBBBBBBBB";

    private static final String DEFAULT_BY_01 = "AAAAAAAAAA";
    private static final String UPDATED_BY_01 = "BBBBBBBBBB";

    private static final String DEFAULT_BY_02 = "AAAAAAAAAA";
    private static final String UPDATED_BY_02 = "BBBBBBBBBB";

    private static final String DEFAULT_BY_03 = "AAAAAAAAAA";
    private static final String UPDATED_BY_03 = "BBBBBBBBBB";

    private static final String DEFAULT_BY_04 = "AAAAAAAAAA";
    private static final String UPDATED_BY_04 = "BBBBBBBBBB";

    private static final String DEFAULT_BY_05 = "AAAAAAAAAA";
    private static final String UPDATED_BY_05 = "BBBBBBBBBB";

    private static final String DEFAULT_VALID_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_VALID_TYPE = "BBBBBBBBBB";

    private static final Instant DEFAULT_VALID_BEGIN = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VALID_BEGIN = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_VALID_END = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VALID_END = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_INSERT_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_INSERT_USER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_INSERT_PERSON_ID = "AAAAAAAAAA";
    private static final String UPDATED_INSERT_PERSON_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_INSERT_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSERT_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPINSTANT_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_UPINSTANT_USER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_UPINSTANT_PERSON_ID = "AAAAAAAAAA";
    private static final String UPDATED_UPINSTANT_PERSON_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPINSTANT_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPINSTANT_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private ARightUserRepository aRightUserRepository;

    @Autowired
    private ARightUserMapper aRightUserMapper;

    @Autowired
    private ARightUserService aRightUserService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restARightUserMockMvc;

    private ARightUser aRightUser;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ARightUserResource aRightUserResource = new ARightUserResource(aRightUserService);
        this.restARightUserMockMvc = MockMvcBuilders.standaloneSetup(aRightUserResource)
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
    public static ARightUser createEntity(EntityManager em) {
        ARightUser aRightUser = new ARightUser()
            .userPassword(DEFAULT_USER_PASSWORD)
            .processPassword(DEFAULT_PROCESS_PASSWORD)
            .userSort(DEFAULT_USER_SORT)
            .userPasswordValiinstantTimes(DEFAULT_USER_PASSWORD_VALIINSTANT_TIMES)
            .userPasswordLockFlag(DEFAULT_USER_PASSWORD_LOCK_FLAG)
            .procPasswordValiinstantTimes(DEFAULT_PROC_PASSWORD_VALIINSTANT_TIMES)
            .procPasswordLockFlag(DEFAULT_PROC_PASSWORD_LOCK_FLAG)
            .userProp(DEFAULT_USER_PROP)
            .by01(DEFAULT_BY_01)
            .by02(DEFAULT_BY_02)
            .by03(DEFAULT_BY_03)
            .by04(DEFAULT_BY_04)
            .by05(DEFAULT_BY_05)
            .validType(DEFAULT_VALID_TYPE)
            .validBegin(DEFAULT_VALID_BEGIN)
            .validEnd(DEFAULT_VALID_END)
            .insertUserId(DEFAULT_INSERT_USER_ID)
            .insertPersonId(DEFAULT_INSERT_PERSON_ID)
            .insertTime(DEFAULT_INSERT_TIME)
            .upinstantUserId(DEFAULT_UPINSTANT_USER_ID)
            .upinstantPersonId(DEFAULT_UPINSTANT_PERSON_ID)
            .upinstantTime(DEFAULT_UPINSTANT_TIME);
        return aRightUser;
    }

    @Before
    public void initTest() {
        aRightUser = createEntity(em);
    }

    @Test
    @Transactional
    public void createARightUser() throws Exception {
        int databaseSizeBeforeCreate = aRightUserRepository.findAll().size();

        // Create the ARightUser
        ARightUserDTO aRightUserDTO = aRightUserMapper.toDto(aRightUser);
        restARightUserMockMvc.perform(post("/api/a-right-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aRightUserDTO)))
            .andExpect(status().isCreated());

        // Validate the ARightUser in the database
        List<ARightUser> aRightUserList = aRightUserRepository.findAll();
        assertThat(aRightUserList).hasSize(databaseSizeBeforeCreate + 1);
        ARightUser testARightUser = aRightUserList.get(aRightUserList.size() - 1);
        assertThat(testARightUser.getUserPassword()).isEqualTo(DEFAULT_USER_PASSWORD);
        assertThat(testARightUser.getProcessPassword()).isEqualTo(DEFAULT_PROCESS_PASSWORD);
        assertThat(testARightUser.getUserSort()).isEqualTo(DEFAULT_USER_SORT);
        assertThat(testARightUser.getUserPasswordValiinstantTimes()).isEqualTo(DEFAULT_USER_PASSWORD_VALIINSTANT_TIMES);
        assertThat(testARightUser.getUserPasswordLockFlag()).isEqualTo(DEFAULT_USER_PASSWORD_LOCK_FLAG);
        assertThat(testARightUser.getProcPasswordValiinstantTimes()).isEqualTo(DEFAULT_PROC_PASSWORD_VALIINSTANT_TIMES);
        assertThat(testARightUser.getProcPasswordLockFlag()).isEqualTo(DEFAULT_PROC_PASSWORD_LOCK_FLAG);
        assertThat(testARightUser.getUserProp()).isEqualTo(DEFAULT_USER_PROP);
        assertThat(testARightUser.getBy01()).isEqualTo(DEFAULT_BY_01);
        assertThat(testARightUser.getBy02()).isEqualTo(DEFAULT_BY_02);
        assertThat(testARightUser.getBy03()).isEqualTo(DEFAULT_BY_03);
        assertThat(testARightUser.getBy04()).isEqualTo(DEFAULT_BY_04);
        assertThat(testARightUser.getBy05()).isEqualTo(DEFAULT_BY_05);
        assertThat(testARightUser.getValidType()).isEqualTo(DEFAULT_VALID_TYPE);
        assertThat(testARightUser.getValidBegin()).isEqualTo(DEFAULT_VALID_BEGIN);
        assertThat(testARightUser.getValidEnd()).isEqualTo(DEFAULT_VALID_END);
        assertThat(testARightUser.getInsertUserId()).isEqualTo(DEFAULT_INSERT_USER_ID);
        assertThat(testARightUser.getInsertPersonId()).isEqualTo(DEFAULT_INSERT_PERSON_ID);
        assertThat(testARightUser.getInsertTime()).isEqualTo(DEFAULT_INSERT_TIME);
        assertThat(testARightUser.getUpinstantUserId()).isEqualTo(DEFAULT_UPINSTANT_USER_ID);
        assertThat(testARightUser.getUpinstantPersonId()).isEqualTo(DEFAULT_UPINSTANT_PERSON_ID);
        assertThat(testARightUser.getUpinstantTime()).isEqualTo(DEFAULT_UPINSTANT_TIME);
    }

    @Test
    @Transactional
    public void createARightUserWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = aRightUserRepository.findAll().size();

        // Create the ARightUser with an existing ID
        aRightUser.setId(1L);
        ARightUserDTO aRightUserDTO = aRightUserMapper.toDto(aRightUser);

        // An entity with an existing ID cannot be created, so this API call must fail
        restARightUserMockMvc.perform(post("/api/a-right-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aRightUserDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<ARightUser> aRightUserList = aRightUserRepository.findAll();
        assertThat(aRightUserList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllARightUsers() throws Exception {
        // Initialize the database
        aRightUserRepository.saveAndFlush(aRightUser);

        // Get all the aRightUserList
        restARightUserMockMvc.perform(get("/api/a-right-users?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(aRightUser.getId().intValue())))
            .andExpect(jsonPath("$.[*].userPassword").value(hasItem(DEFAULT_USER_PASSWORD.toString())))
            .andExpect(jsonPath("$.[*].processPassword").value(hasItem(DEFAULT_PROCESS_PASSWORD.toString())))
            .andExpect(jsonPath("$.[*].userSort").value(hasItem(DEFAULT_USER_SORT.toString())))
            .andExpect(jsonPath("$.[*].userPasswordValiinstantTimes").value(hasItem(DEFAULT_USER_PASSWORD_VALIINSTANT_TIMES.intValue())))
            .andExpect(jsonPath("$.[*].userPasswordLockFlag").value(hasItem(DEFAULT_USER_PASSWORD_LOCK_FLAG.toString())))
            .andExpect(jsonPath("$.[*].procPasswordValiinstantTimes").value(hasItem(DEFAULT_PROC_PASSWORD_VALIINSTANT_TIMES.intValue())))
            .andExpect(jsonPath("$.[*].procPasswordLockFlag").value(hasItem(DEFAULT_PROC_PASSWORD_LOCK_FLAG.toString())))
            .andExpect(jsonPath("$.[*].userProp").value(hasItem(DEFAULT_USER_PROP.toString())))
            .andExpect(jsonPath("$.[*].by01").value(hasItem(DEFAULT_BY_01.toString())))
            .andExpect(jsonPath("$.[*].by02").value(hasItem(DEFAULT_BY_02.toString())))
            .andExpect(jsonPath("$.[*].by03").value(hasItem(DEFAULT_BY_03.toString())))
            .andExpect(jsonPath("$.[*].by04").value(hasItem(DEFAULT_BY_04.toString())))
            .andExpect(jsonPath("$.[*].by05").value(hasItem(DEFAULT_BY_05.toString())))
            .andExpect(jsonPath("$.[*].validType").value(hasItem(DEFAULT_VALID_TYPE.toString())))
            .andExpect(jsonPath("$.[*].validBegin").value(hasItem(DEFAULT_VALID_BEGIN.toString())))
            .andExpect(jsonPath("$.[*].validEnd").value(hasItem(DEFAULT_VALID_END.toString())))
            .andExpect(jsonPath("$.[*].insertUserId").value(hasItem(DEFAULT_INSERT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].insertPersonId").value(hasItem(DEFAULT_INSERT_PERSON_ID.toString())))
            .andExpect(jsonPath("$.[*].insertTime").value(hasItem(DEFAULT_INSERT_TIME.toString())))
            .andExpect(jsonPath("$.[*].upinstantUserId").value(hasItem(DEFAULT_UPINSTANT_USER_ID.toString())))
            .andExpect(jsonPath("$.[*].upinstantPersonId").value(hasItem(DEFAULT_UPINSTANT_PERSON_ID.toString())))
            .andExpect(jsonPath("$.[*].upinstantTime").value(hasItem(DEFAULT_UPINSTANT_TIME.toString())));
    }

    @Test
    @Transactional
    public void getARightUser() throws Exception {
        // Initialize the database
        aRightUserRepository.saveAndFlush(aRightUser);

        // Get the aRightUser
        restARightUserMockMvc.perform(get("/api/a-right-users/{id}", aRightUser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(aRightUser.getId().intValue()))
            .andExpect(jsonPath("$.userPassword").value(DEFAULT_USER_PASSWORD.toString()))
            .andExpect(jsonPath("$.processPassword").value(DEFAULT_PROCESS_PASSWORD.toString()))
            .andExpect(jsonPath("$.userSort").value(DEFAULT_USER_SORT.toString()))
            .andExpect(jsonPath("$.userPasswordValiinstantTimes").value(DEFAULT_USER_PASSWORD_VALIINSTANT_TIMES.intValue()))
            .andExpect(jsonPath("$.userPasswordLockFlag").value(DEFAULT_USER_PASSWORD_LOCK_FLAG.toString()))
            .andExpect(jsonPath("$.procPasswordValiinstantTimes").value(DEFAULT_PROC_PASSWORD_VALIINSTANT_TIMES.intValue()))
            .andExpect(jsonPath("$.procPasswordLockFlag").value(DEFAULT_PROC_PASSWORD_LOCK_FLAG.toString()))
            .andExpect(jsonPath("$.userProp").value(DEFAULT_USER_PROP.toString()))
            .andExpect(jsonPath("$.by01").value(DEFAULT_BY_01.toString()))
            .andExpect(jsonPath("$.by02").value(DEFAULT_BY_02.toString()))
            .andExpect(jsonPath("$.by03").value(DEFAULT_BY_03.toString()))
            .andExpect(jsonPath("$.by04").value(DEFAULT_BY_04.toString()))
            .andExpect(jsonPath("$.by05").value(DEFAULT_BY_05.toString()))
            .andExpect(jsonPath("$.validType").value(DEFAULT_VALID_TYPE.toString()))
            .andExpect(jsonPath("$.validBegin").value(DEFAULT_VALID_BEGIN.toString()))
            .andExpect(jsonPath("$.validEnd").value(DEFAULT_VALID_END.toString()))
            .andExpect(jsonPath("$.insertUserId").value(DEFAULT_INSERT_USER_ID.toString()))
            .andExpect(jsonPath("$.insertPersonId").value(DEFAULT_INSERT_PERSON_ID.toString()))
            .andExpect(jsonPath("$.insertTime").value(DEFAULT_INSERT_TIME.toString()))
            .andExpect(jsonPath("$.upinstantUserId").value(DEFAULT_UPINSTANT_USER_ID.toString()))
            .andExpect(jsonPath("$.upinstantPersonId").value(DEFAULT_UPINSTANT_PERSON_ID.toString()))
            .andExpect(jsonPath("$.upinstantTime").value(DEFAULT_UPINSTANT_TIME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingARightUser() throws Exception {
        // Get the aRightUser
        restARightUserMockMvc.perform(get("/api/a-right-users/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateARightUser() throws Exception {
        // Initialize the database
        aRightUserRepository.saveAndFlush(aRightUser);
        int databaseSizeBeforeUpdate = aRightUserRepository.findAll().size();

        // Update the aRightUser
        ARightUser updatedARightUser = aRightUserRepository.findOne(aRightUser.getId());
        updatedARightUser
            .userPassword(UPDATED_USER_PASSWORD)
            .processPassword(UPDATED_PROCESS_PASSWORD)
            .userSort(UPDATED_USER_SORT)
            .userPasswordValiinstantTimes(UPDATED_USER_PASSWORD_VALIINSTANT_TIMES)
            .userPasswordLockFlag(UPDATED_USER_PASSWORD_LOCK_FLAG)
            .procPasswordValiinstantTimes(UPDATED_PROC_PASSWORD_VALIINSTANT_TIMES)
            .procPasswordLockFlag(UPDATED_PROC_PASSWORD_LOCK_FLAG)
            .userProp(UPDATED_USER_PROP)
            .by01(UPDATED_BY_01)
            .by02(UPDATED_BY_02)
            .by03(UPDATED_BY_03)
            .by04(UPDATED_BY_04)
            .by05(UPDATED_BY_05)
            .validType(UPDATED_VALID_TYPE)
            .validBegin(UPDATED_VALID_BEGIN)
            .validEnd(UPDATED_VALID_END)
            .insertUserId(UPDATED_INSERT_USER_ID)
            .insertPersonId(UPDATED_INSERT_PERSON_ID)
            .insertTime(UPDATED_INSERT_TIME)
            .upinstantUserId(UPDATED_UPINSTANT_USER_ID)
            .upinstantPersonId(UPDATED_UPINSTANT_PERSON_ID)
            .upinstantTime(UPDATED_UPINSTANT_TIME);
        ARightUserDTO aRightUserDTO = aRightUserMapper.toDto(updatedARightUser);

        restARightUserMockMvc.perform(put("/api/a-right-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aRightUserDTO)))
            .andExpect(status().isOk());

        // Validate the ARightUser in the database
        List<ARightUser> aRightUserList = aRightUserRepository.findAll();
        assertThat(aRightUserList).hasSize(databaseSizeBeforeUpdate);
        ARightUser testARightUser = aRightUserList.get(aRightUserList.size() - 1);
        assertThat(testARightUser.getUserPassword()).isEqualTo(UPDATED_USER_PASSWORD);
        assertThat(testARightUser.getProcessPassword()).isEqualTo(UPDATED_PROCESS_PASSWORD);
        assertThat(testARightUser.getUserSort()).isEqualTo(UPDATED_USER_SORT);
        assertThat(testARightUser.getUserPasswordValiinstantTimes()).isEqualTo(UPDATED_USER_PASSWORD_VALIINSTANT_TIMES);
        assertThat(testARightUser.getUserPasswordLockFlag()).isEqualTo(UPDATED_USER_PASSWORD_LOCK_FLAG);
        assertThat(testARightUser.getProcPasswordValiinstantTimes()).isEqualTo(UPDATED_PROC_PASSWORD_VALIINSTANT_TIMES);
        assertThat(testARightUser.getProcPasswordLockFlag()).isEqualTo(UPDATED_PROC_PASSWORD_LOCK_FLAG);
        assertThat(testARightUser.getUserProp()).isEqualTo(UPDATED_USER_PROP);
        assertThat(testARightUser.getBy01()).isEqualTo(UPDATED_BY_01);
        assertThat(testARightUser.getBy02()).isEqualTo(UPDATED_BY_02);
        assertThat(testARightUser.getBy03()).isEqualTo(UPDATED_BY_03);
        assertThat(testARightUser.getBy04()).isEqualTo(UPDATED_BY_04);
        assertThat(testARightUser.getBy05()).isEqualTo(UPDATED_BY_05);
        assertThat(testARightUser.getValidType()).isEqualTo(UPDATED_VALID_TYPE);
        assertThat(testARightUser.getValidBegin()).isEqualTo(UPDATED_VALID_BEGIN);
        assertThat(testARightUser.getValidEnd()).isEqualTo(UPDATED_VALID_END);
        assertThat(testARightUser.getInsertUserId()).isEqualTo(UPDATED_INSERT_USER_ID);
        assertThat(testARightUser.getInsertPersonId()).isEqualTo(UPDATED_INSERT_PERSON_ID);
        assertThat(testARightUser.getInsertTime()).isEqualTo(UPDATED_INSERT_TIME);
        assertThat(testARightUser.getUpinstantUserId()).isEqualTo(UPDATED_UPINSTANT_USER_ID);
        assertThat(testARightUser.getUpinstantPersonId()).isEqualTo(UPDATED_UPINSTANT_PERSON_ID);
        assertThat(testARightUser.getUpinstantTime()).isEqualTo(UPDATED_UPINSTANT_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingARightUser() throws Exception {
        int databaseSizeBeforeUpdate = aRightUserRepository.findAll().size();

        // Create the ARightUser
        ARightUserDTO aRightUserDTO = aRightUserMapper.toDto(aRightUser);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restARightUserMockMvc.perform(put("/api/a-right-users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aRightUserDTO)))
            .andExpect(status().isCreated());

        // Validate the ARightUser in the database
        List<ARightUser> aRightUserList = aRightUserRepository.findAll();
        assertThat(aRightUserList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteARightUser() throws Exception {
        // Initialize the database
        aRightUserRepository.saveAndFlush(aRightUser);
        int databaseSizeBeforeDelete = aRightUserRepository.findAll().size();

        // Get the aRightUser
        restARightUserMockMvc.perform(delete("/api/a-right-users/{id}", aRightUser.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ARightUser> aRightUserList = aRightUserRepository.findAll();
        assertThat(aRightUserList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ARightUser.class);
        ARightUser aRightUser1 = new ARightUser();
        aRightUser1.setId(1L);
        ARightUser aRightUser2 = new ARightUser();
        aRightUser2.setId(aRightUser1.getId());
        assertThat(aRightUser1).isEqualTo(aRightUser2);
        aRightUser2.setId(2L);
        assertThat(aRightUser1).isNotEqualTo(aRightUser2);
        aRightUser1.setId(null);
        assertThat(aRightUser1).isNotEqualTo(aRightUser2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ARightUserDTO.class);
        ARightUserDTO aRightUserDTO1 = new ARightUserDTO();
        aRightUserDTO1.setId(1L);
        ARightUserDTO aRightUserDTO2 = new ARightUserDTO();
        assertThat(aRightUserDTO1).isNotEqualTo(aRightUserDTO2);
        aRightUserDTO2.setId(aRightUserDTO1.getId());
        assertThat(aRightUserDTO1).isEqualTo(aRightUserDTO2);
        aRightUserDTO2.setId(2L);
        assertThat(aRightUserDTO1).isNotEqualTo(aRightUserDTO2);
        aRightUserDTO1.setId(null);
        assertThat(aRightUserDTO1).isNotEqualTo(aRightUserDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(aRightUserMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(aRightUserMapper.fromId(null)).isNull();
    }
}
