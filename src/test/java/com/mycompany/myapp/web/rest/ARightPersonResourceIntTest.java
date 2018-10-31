package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterApp;

import com.mycompany.myapp.domain.ARightPerson;
import com.mycompany.myapp.repository.ARightPersonRepository;
import com.mycompany.myapp.service.ARightPersonService;
import com.mycompany.myapp.service.dto.ARightPersonDTO;
import com.mycompany.myapp.service.mapper.ARightPersonMapper;
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
 * Test class for the ARightPersonResource REST controller.
 *
 * @see ARightPersonResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterApp.class)
public class ARightPersonResourceIntTest {

    private static final String DEFAULT_PERSON_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_JOB_ID = "AAAAAAAAAA";
    private static final String UPDATED_JOB_ID = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_OTHER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_OTHER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SEX = "AAAAAAAAAA";
    private static final String UPDATED_SEX = "BBBBBBBBBB";

    private static final Instant DEFAULT_BIRTHDAY = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_BIRTHDAY = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_PIC = "AAAAAAAAAA";
    private static final String UPDATED_PIC = "BBBBBBBBBB";

    private static final String DEFAULT_ICON = "AAAAAAAAAA";
    private static final String UPDATED_ICON = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE = "BBBBBBBBBB";

    private static final String DEFAULT_DEP_ID = "AAAAAAAAAA";
    private static final String UPDATED_DEP_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DEP_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_DEP_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_DEP_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEP_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DUTY_ID = "AAAAAAAAAA";
    private static final String UPDATED_DUTY_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DIMISSION_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_DIMISSION_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_HEADER_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_HEADER_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_SATRAP_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_SATRAP_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_LEADER_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_LEADER_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_POST_FLAG_1 = "AAAAAAAAAA";
    private static final String UPDATED_POST_FLAG_1 = "BBBBBBBBBB";

    private static final String DEFAULT_POST_FLAG_2 = "AAAAAAAAAA";
    private static final String UPDATED_POST_FLAG_2 = "BBBBBBBBBB";

    private static final String DEFAULT_POST_FLAG_3 = "AAAAAAAAAA";
    private static final String UPDATED_POST_FLAG_3 = "BBBBBBBBBB";

    private static final String DEFAULT_OFFICE_TEL = "AAAAAAAAAA";
    private static final String UPDATED_OFFICE_TEL = "BBBBBBBBBB";

    private static final String DEFAULT_FAX = "AAAAAAAAAA";
    private static final String UPDATED_FAX = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_1 = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_1 = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_2 = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FAMILY_TEL = "AAAAAAAAAA";
    private static final String UPDATED_FAMILY_TEL = "BBBBBBBBBB";

    private static final String DEFAULT_FAMILY_ADD = "AAAAAAAAAA";
    private static final String UPDATED_FAMILY_ADD = "BBBBBBBBBB";

    private static final String DEFAULT_FAMILY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_FAMILY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_DESCRIBE = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_DESCRIBE = "BBBBBBBBBB";

    private static final String DEFAULT_ID_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ID_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_POP_3 = "AAAAAAAAAA";
    private static final String UPDATED_POP_3 = "BBBBBBBBBB";

    private static final String DEFAULT_SMTP = "AAAAAAAAAA";
    private static final String UPDATED_SMTP = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_USERNAME = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_USERNAME = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_PASSWORD = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_KEEP_FLAG = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_KEEP_FLAG = "BBBBBBBBBB";

    private static final String DEFAULT_PERSON_SORT = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_SORT = "BBBBBBBBBB";

    private static final Long DEFAULT_LEVEL_NUM = 1L;
    private static final Long UPDATED_LEVEL_NUM = 2L;

    private static final String DEFAULT_PERSON_STATE_ID = "AAAAAAAAAA";
    private static final String UPDATED_PERSON_STATE_ID = "BBBBBBBBBB";

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

    private static final String DEFAULT_BY_06 = "AAAAAAAAAA";
    private static final String UPDATED_BY_06 = "BBBBBBBBBB";

    private static final String DEFAULT_BY_07 = "AAAAAAAAAA";
    private static final String UPDATED_BY_07 = "BBBBBBBBBB";

    private static final String DEFAULT_BY_08 = "AAAAAAAAAA";
    private static final String UPDATED_BY_08 = "BBBBBBBBBB";

    private static final String DEFAULT_BY_09 = "AAAAAAAAAA";
    private static final String UPDATED_BY_09 = "BBBBBBBBBB";

    private static final String DEFAULT_BY_10 = "AAAAAAAAAA";
    private static final String UPDATED_BY_10 = "BBBBBBBBBB";

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
    private ARightPersonRepository aRightPersonRepository;

    @Autowired
    private ARightPersonMapper aRightPersonMapper;

    @Autowired
    private ARightPersonService aRightPersonService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restARightPersonMockMvc;

    private ARightPerson aRightPerson;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ARightPersonResource aRightPersonResource = new ARightPersonResource(aRightPersonService);
        this.restARightPersonMockMvc = MockMvcBuilders.standaloneSetup(aRightPersonResource)
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
    public static ARightPerson createEntity(EntityManager em) {
        ARightPerson aRightPerson = new ARightPerson()
            .personName(DEFAULT_PERSON_NAME)
            .firstName(DEFAULT_FIRST_NAME)
            .jobId(DEFAULT_JOB_ID)
            .lastName(DEFAULT_LAST_NAME)
            .otherName(DEFAULT_OTHER_NAME)
            .sex(DEFAULT_SEX)
            .birthday(DEFAULT_BIRTHDAY)
            .pic(DEFAULT_PIC)
            .icon(DEFAULT_ICON)
            .mobile(DEFAULT_MOBILE)
            .depId(DEFAULT_DEP_ID)
            .depAddress(DEFAULT_DEP_ADDRESS)
            .depCode(DEFAULT_DEP_CODE)
            .dutyId(DEFAULT_DUTY_ID)
            .dimissionFlag(DEFAULT_DIMISSION_FLAG)
            .headerFlag(DEFAULT_HEADER_FLAG)
            .satrapFlag(DEFAULT_SATRAP_FLAG)
            .leaderFlag(DEFAULT_LEADER_FLAG)
            .postFlag1(DEFAULT_POST_FLAG_1)
            .postFlag2(DEFAULT_POST_FLAG_2)
            .postFlag3(DEFAULT_POST_FLAG_3)
            .officeTel(DEFAULT_OFFICE_TEL)
            .fax(DEFAULT_FAX)
            .mail1(DEFAULT_MAIL_1)
            .mail2(DEFAULT_MAIL_2)
            .familyTel(DEFAULT_FAMILY_TEL)
            .familyAdd(DEFAULT_FAMILY_ADD)
            .familyCode(DEFAULT_FAMILY_CODE)
            .personDescribe(DEFAULT_PERSON_DESCRIBE)
            .idCode(DEFAULT_ID_CODE)
            .pop3(DEFAULT_POP_3)
            .smtp(DEFAULT_SMTP)
            .mailUsername(DEFAULT_MAIL_USERNAME)
            .mailPassword(DEFAULT_MAIL_PASSWORD)
            .mailKeepFlag(DEFAULT_MAIL_KEEP_FLAG)
            .personSort(DEFAULT_PERSON_SORT)
            .levelNum(DEFAULT_LEVEL_NUM)
            .personStateId(DEFAULT_PERSON_STATE_ID)
            .by01(DEFAULT_BY_01)
            .by02(DEFAULT_BY_02)
            .by03(DEFAULT_BY_03)
            .by04(DEFAULT_BY_04)
            .by05(DEFAULT_BY_05)
            .by06(DEFAULT_BY_06)
            .by07(DEFAULT_BY_07)
            .by08(DEFAULT_BY_08)
            .by09(DEFAULT_BY_09)
            .by10(DEFAULT_BY_10)
            .validType(DEFAULT_VALID_TYPE)
            .validBegin(DEFAULT_VALID_BEGIN)
            .validEnd(DEFAULT_VALID_END)
            .insertUserId(DEFAULT_INSERT_USER_ID)
            .insertPersonId(DEFAULT_INSERT_PERSON_ID)
            .insertTime(DEFAULT_INSERT_TIME)
            .upinstantUserId(DEFAULT_UPINSTANT_USER_ID)
            .upinstantPersonId(DEFAULT_UPINSTANT_PERSON_ID)
            .upinstantTime(DEFAULT_UPINSTANT_TIME);
        return aRightPerson;
    }

    @Before
    public void initTest() {
        aRightPerson = createEntity(em);
    }

    @Test
    @Transactional
    public void createARightPerson() throws Exception {
        int databaseSizeBeforeCreate = aRightPersonRepository.findAll().size();

        // Create the ARightPerson
        ARightPersonDTO aRightPersonDTO = aRightPersonMapper.toDto(aRightPerson);
        restARightPersonMockMvc.perform(post("/api/a-right-people")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aRightPersonDTO)))
            .andExpect(status().isCreated());

        // Validate the ARightPerson in the database
        List<ARightPerson> aRightPersonList = aRightPersonRepository.findAll();
        assertThat(aRightPersonList).hasSize(databaseSizeBeforeCreate + 1);
        ARightPerson testARightPerson = aRightPersonList.get(aRightPersonList.size() - 1);
        assertThat(testARightPerson.getPersonName()).isEqualTo(DEFAULT_PERSON_NAME);
        assertThat(testARightPerson.getFirstName()).isEqualTo(DEFAULT_FIRST_NAME);
        assertThat(testARightPerson.getJobId()).isEqualTo(DEFAULT_JOB_ID);
        assertThat(testARightPerson.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testARightPerson.getOtherName()).isEqualTo(DEFAULT_OTHER_NAME);
        assertThat(testARightPerson.getSex()).isEqualTo(DEFAULT_SEX);
        assertThat(testARightPerson.getBirthday()).isEqualTo(DEFAULT_BIRTHDAY);
        assertThat(testARightPerson.getPic()).isEqualTo(DEFAULT_PIC);
        assertThat(testARightPerson.getIcon()).isEqualTo(DEFAULT_ICON);
        assertThat(testARightPerson.getMobile()).isEqualTo(DEFAULT_MOBILE);
        assertThat(testARightPerson.getDepId()).isEqualTo(DEFAULT_DEP_ID);
        assertThat(testARightPerson.getDepAddress()).isEqualTo(DEFAULT_DEP_ADDRESS);
        assertThat(testARightPerson.getDepCode()).isEqualTo(DEFAULT_DEP_CODE);
        assertThat(testARightPerson.getDutyId()).isEqualTo(DEFAULT_DUTY_ID);
        assertThat(testARightPerson.getDimissionFlag()).isEqualTo(DEFAULT_DIMISSION_FLAG);
        assertThat(testARightPerson.getHeaderFlag()).isEqualTo(DEFAULT_HEADER_FLAG);
        assertThat(testARightPerson.getSatrapFlag()).isEqualTo(DEFAULT_SATRAP_FLAG);
        assertThat(testARightPerson.getLeaderFlag()).isEqualTo(DEFAULT_LEADER_FLAG);
        assertThat(testARightPerson.getPostFlag1()).isEqualTo(DEFAULT_POST_FLAG_1);
        assertThat(testARightPerson.getPostFlag2()).isEqualTo(DEFAULT_POST_FLAG_2);
        assertThat(testARightPerson.getPostFlag3()).isEqualTo(DEFAULT_POST_FLAG_3);
        assertThat(testARightPerson.getOfficeTel()).isEqualTo(DEFAULT_OFFICE_TEL);
        assertThat(testARightPerson.getFax()).isEqualTo(DEFAULT_FAX);
        assertThat(testARightPerson.getMail1()).isEqualTo(DEFAULT_MAIL_1);
        assertThat(testARightPerson.getMail2()).isEqualTo(DEFAULT_MAIL_2);
        assertThat(testARightPerson.getFamilyTel()).isEqualTo(DEFAULT_FAMILY_TEL);
        assertThat(testARightPerson.getFamilyAdd()).isEqualTo(DEFAULT_FAMILY_ADD);
        assertThat(testARightPerson.getFamilyCode()).isEqualTo(DEFAULT_FAMILY_CODE);
        assertThat(testARightPerson.getPersonDescribe()).isEqualTo(DEFAULT_PERSON_DESCRIBE);
        assertThat(testARightPerson.getIdCode()).isEqualTo(DEFAULT_ID_CODE);
        assertThat(testARightPerson.getPop3()).isEqualTo(DEFAULT_POP_3);
        assertThat(testARightPerson.getSmtp()).isEqualTo(DEFAULT_SMTP);
        assertThat(testARightPerson.getMailUsername()).isEqualTo(DEFAULT_MAIL_USERNAME);
        assertThat(testARightPerson.getMailPassword()).isEqualTo(DEFAULT_MAIL_PASSWORD);
        assertThat(testARightPerson.getMailKeepFlag()).isEqualTo(DEFAULT_MAIL_KEEP_FLAG);
        assertThat(testARightPerson.getPersonSort()).isEqualTo(DEFAULT_PERSON_SORT);
        assertThat(testARightPerson.getLevelNum()).isEqualTo(DEFAULT_LEVEL_NUM);
        assertThat(testARightPerson.getPersonStateId()).isEqualTo(DEFAULT_PERSON_STATE_ID);
        assertThat(testARightPerson.getBy01()).isEqualTo(DEFAULT_BY_01);
        assertThat(testARightPerson.getBy02()).isEqualTo(DEFAULT_BY_02);
        assertThat(testARightPerson.getBy03()).isEqualTo(DEFAULT_BY_03);
        assertThat(testARightPerson.getBy04()).isEqualTo(DEFAULT_BY_04);
        assertThat(testARightPerson.getBy05()).isEqualTo(DEFAULT_BY_05);
        assertThat(testARightPerson.getBy06()).isEqualTo(DEFAULT_BY_06);
        assertThat(testARightPerson.getBy07()).isEqualTo(DEFAULT_BY_07);
        assertThat(testARightPerson.getBy08()).isEqualTo(DEFAULT_BY_08);
        assertThat(testARightPerson.getBy09()).isEqualTo(DEFAULT_BY_09);
        assertThat(testARightPerson.getBy10()).isEqualTo(DEFAULT_BY_10);
        assertThat(testARightPerson.getValidType()).isEqualTo(DEFAULT_VALID_TYPE);
        assertThat(testARightPerson.getValidBegin()).isEqualTo(DEFAULT_VALID_BEGIN);
        assertThat(testARightPerson.getValidEnd()).isEqualTo(DEFAULT_VALID_END);
        assertThat(testARightPerson.getInsertUserId()).isEqualTo(DEFAULT_INSERT_USER_ID);
        assertThat(testARightPerson.getInsertPersonId()).isEqualTo(DEFAULT_INSERT_PERSON_ID);
        assertThat(testARightPerson.getInsertTime()).isEqualTo(DEFAULT_INSERT_TIME);
        assertThat(testARightPerson.getUpinstantUserId()).isEqualTo(DEFAULT_UPINSTANT_USER_ID);
        assertThat(testARightPerson.getUpinstantPersonId()).isEqualTo(DEFAULT_UPINSTANT_PERSON_ID);
        assertThat(testARightPerson.getUpinstantTime()).isEqualTo(DEFAULT_UPINSTANT_TIME);
    }

    @Test
    @Transactional
    public void createARightPersonWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = aRightPersonRepository.findAll().size();

        // Create the ARightPerson with an existing ID
        aRightPerson.setId(1L);
        ARightPersonDTO aRightPersonDTO = aRightPersonMapper.toDto(aRightPerson);

        // An entity with an existing ID cannot be created, so this API call must fail
        restARightPersonMockMvc.perform(post("/api/a-right-people")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aRightPersonDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Alice in the database
        List<ARightPerson> aRightPersonList = aRightPersonRepository.findAll();
        assertThat(aRightPersonList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllARightPeople() throws Exception {
        // Initialize the database
        aRightPersonRepository.saveAndFlush(aRightPerson);

        // Get all the aRightPersonList
        restARightPersonMockMvc.perform(get("/api/a-right-people?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(aRightPerson.getId().intValue())))
            .andExpect(jsonPath("$.[*].personName").value(hasItem(DEFAULT_PERSON_NAME.toString())))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME.toString())))
            .andExpect(jsonPath("$.[*].jobId").value(hasItem(DEFAULT_JOB_ID.toString())))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME.toString())))
            .andExpect(jsonPath("$.[*].otherName").value(hasItem(DEFAULT_OTHER_NAME.toString())))
            .andExpect(jsonPath("$.[*].sex").value(hasItem(DEFAULT_SEX.toString())))
            .andExpect(jsonPath("$.[*].birthday").value(hasItem(DEFAULT_BIRTHDAY.toString())))
            .andExpect(jsonPath("$.[*].pic").value(hasItem(DEFAULT_PIC.toString())))
            .andExpect(jsonPath("$.[*].icon").value(hasItem(DEFAULT_ICON.toString())))
            .andExpect(jsonPath("$.[*].mobile").value(hasItem(DEFAULT_MOBILE.toString())))
            .andExpect(jsonPath("$.[*].depId").value(hasItem(DEFAULT_DEP_ID.toString())))
            .andExpect(jsonPath("$.[*].depAddress").value(hasItem(DEFAULT_DEP_ADDRESS.toString())))
            .andExpect(jsonPath("$.[*].depCode").value(hasItem(DEFAULT_DEP_CODE.toString())))
            .andExpect(jsonPath("$.[*].dutyId").value(hasItem(DEFAULT_DUTY_ID.toString())))
            .andExpect(jsonPath("$.[*].dimissionFlag").value(hasItem(DEFAULT_DIMISSION_FLAG.toString())))
            .andExpect(jsonPath("$.[*].headerFlag").value(hasItem(DEFAULT_HEADER_FLAG.toString())))
            .andExpect(jsonPath("$.[*].satrapFlag").value(hasItem(DEFAULT_SATRAP_FLAG.toString())))
            .andExpect(jsonPath("$.[*].leaderFlag").value(hasItem(DEFAULT_LEADER_FLAG.toString())))
            .andExpect(jsonPath("$.[*].postFlag1").value(hasItem(DEFAULT_POST_FLAG_1.toString())))
            .andExpect(jsonPath("$.[*].postFlag2").value(hasItem(DEFAULT_POST_FLAG_2.toString())))
            .andExpect(jsonPath("$.[*].postFlag3").value(hasItem(DEFAULT_POST_FLAG_3.toString())))
            .andExpect(jsonPath("$.[*].officeTel").value(hasItem(DEFAULT_OFFICE_TEL.toString())))
            .andExpect(jsonPath("$.[*].fax").value(hasItem(DEFAULT_FAX.toString())))
            .andExpect(jsonPath("$.[*].mail1").value(hasItem(DEFAULT_MAIL_1.toString())))
            .andExpect(jsonPath("$.[*].mail2").value(hasItem(DEFAULT_MAIL_2.toString())))
            .andExpect(jsonPath("$.[*].familyTel").value(hasItem(DEFAULT_FAMILY_TEL.toString())))
            .andExpect(jsonPath("$.[*].familyAdd").value(hasItem(DEFAULT_FAMILY_ADD.toString())))
            .andExpect(jsonPath("$.[*].familyCode").value(hasItem(DEFAULT_FAMILY_CODE.toString())))
            .andExpect(jsonPath("$.[*].personDescribe").value(hasItem(DEFAULT_PERSON_DESCRIBE.toString())))
            .andExpect(jsonPath("$.[*].idCode").value(hasItem(DEFAULT_ID_CODE.toString())))
            .andExpect(jsonPath("$.[*].pop3").value(hasItem(DEFAULT_POP_3.toString())))
            .andExpect(jsonPath("$.[*].smtp").value(hasItem(DEFAULT_SMTP.toString())))
            .andExpect(jsonPath("$.[*].mailUsername").value(hasItem(DEFAULT_MAIL_USERNAME.toString())))
            .andExpect(jsonPath("$.[*].mailPassword").value(hasItem(DEFAULT_MAIL_PASSWORD.toString())))
            .andExpect(jsonPath("$.[*].mailKeepFlag").value(hasItem(DEFAULT_MAIL_KEEP_FLAG.toString())))
            .andExpect(jsonPath("$.[*].personSort").value(hasItem(DEFAULT_PERSON_SORT.toString())))
            .andExpect(jsonPath("$.[*].levelNum").value(hasItem(DEFAULT_LEVEL_NUM.intValue())))
            .andExpect(jsonPath("$.[*].personStateId").value(hasItem(DEFAULT_PERSON_STATE_ID.toString())))
            .andExpect(jsonPath("$.[*].by01").value(hasItem(DEFAULT_BY_01.toString())))
            .andExpect(jsonPath("$.[*].by02").value(hasItem(DEFAULT_BY_02.toString())))
            .andExpect(jsonPath("$.[*].by03").value(hasItem(DEFAULT_BY_03.toString())))
            .andExpect(jsonPath("$.[*].by04").value(hasItem(DEFAULT_BY_04.toString())))
            .andExpect(jsonPath("$.[*].by05").value(hasItem(DEFAULT_BY_05.toString())))
            .andExpect(jsonPath("$.[*].by06").value(hasItem(DEFAULT_BY_06.toString())))
            .andExpect(jsonPath("$.[*].by07").value(hasItem(DEFAULT_BY_07.toString())))
            .andExpect(jsonPath("$.[*].by08").value(hasItem(DEFAULT_BY_08.toString())))
            .andExpect(jsonPath("$.[*].by09").value(hasItem(DEFAULT_BY_09.toString())))
            .andExpect(jsonPath("$.[*].by10").value(hasItem(DEFAULT_BY_10.toString())))
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
    public void getARightPerson() throws Exception {
        // Initialize the database
        aRightPersonRepository.saveAndFlush(aRightPerson);

        // Get the aRightPerson
        restARightPersonMockMvc.perform(get("/api/a-right-people/{id}", aRightPerson.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(aRightPerson.getId().intValue()))
            .andExpect(jsonPath("$.personName").value(DEFAULT_PERSON_NAME.toString()))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME.toString()))
            .andExpect(jsonPath("$.jobId").value(DEFAULT_JOB_ID.toString()))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME.toString()))
            .andExpect(jsonPath("$.otherName").value(DEFAULT_OTHER_NAME.toString()))
            .andExpect(jsonPath("$.sex").value(DEFAULT_SEX.toString()))
            .andExpect(jsonPath("$.birthday").value(DEFAULT_BIRTHDAY.toString()))
            .andExpect(jsonPath("$.pic").value(DEFAULT_PIC.toString()))
            .andExpect(jsonPath("$.icon").value(DEFAULT_ICON.toString()))
            .andExpect(jsonPath("$.mobile").value(DEFAULT_MOBILE.toString()))
            .andExpect(jsonPath("$.depId").value(DEFAULT_DEP_ID.toString()))
            .andExpect(jsonPath("$.depAddress").value(DEFAULT_DEP_ADDRESS.toString()))
            .andExpect(jsonPath("$.depCode").value(DEFAULT_DEP_CODE.toString()))
            .andExpect(jsonPath("$.dutyId").value(DEFAULT_DUTY_ID.toString()))
            .andExpect(jsonPath("$.dimissionFlag").value(DEFAULT_DIMISSION_FLAG.toString()))
            .andExpect(jsonPath("$.headerFlag").value(DEFAULT_HEADER_FLAG.toString()))
            .andExpect(jsonPath("$.satrapFlag").value(DEFAULT_SATRAP_FLAG.toString()))
            .andExpect(jsonPath("$.leaderFlag").value(DEFAULT_LEADER_FLAG.toString()))
            .andExpect(jsonPath("$.postFlag1").value(DEFAULT_POST_FLAG_1.toString()))
            .andExpect(jsonPath("$.postFlag2").value(DEFAULT_POST_FLAG_2.toString()))
            .andExpect(jsonPath("$.postFlag3").value(DEFAULT_POST_FLAG_3.toString()))
            .andExpect(jsonPath("$.officeTel").value(DEFAULT_OFFICE_TEL.toString()))
            .andExpect(jsonPath("$.fax").value(DEFAULT_FAX.toString()))
            .andExpect(jsonPath("$.mail1").value(DEFAULT_MAIL_1.toString()))
            .andExpect(jsonPath("$.mail2").value(DEFAULT_MAIL_2.toString()))
            .andExpect(jsonPath("$.familyTel").value(DEFAULT_FAMILY_TEL.toString()))
            .andExpect(jsonPath("$.familyAdd").value(DEFAULT_FAMILY_ADD.toString()))
            .andExpect(jsonPath("$.familyCode").value(DEFAULT_FAMILY_CODE.toString()))
            .andExpect(jsonPath("$.personDescribe").value(DEFAULT_PERSON_DESCRIBE.toString()))
            .andExpect(jsonPath("$.idCode").value(DEFAULT_ID_CODE.toString()))
            .andExpect(jsonPath("$.pop3").value(DEFAULT_POP_3.toString()))
            .andExpect(jsonPath("$.smtp").value(DEFAULT_SMTP.toString()))
            .andExpect(jsonPath("$.mailUsername").value(DEFAULT_MAIL_USERNAME.toString()))
            .andExpect(jsonPath("$.mailPassword").value(DEFAULT_MAIL_PASSWORD.toString()))
            .andExpect(jsonPath("$.mailKeepFlag").value(DEFAULT_MAIL_KEEP_FLAG.toString()))
            .andExpect(jsonPath("$.personSort").value(DEFAULT_PERSON_SORT.toString()))
            .andExpect(jsonPath("$.levelNum").value(DEFAULT_LEVEL_NUM.intValue()))
            .andExpect(jsonPath("$.personStateId").value(DEFAULT_PERSON_STATE_ID.toString()))
            .andExpect(jsonPath("$.by01").value(DEFAULT_BY_01.toString()))
            .andExpect(jsonPath("$.by02").value(DEFAULT_BY_02.toString()))
            .andExpect(jsonPath("$.by03").value(DEFAULT_BY_03.toString()))
            .andExpect(jsonPath("$.by04").value(DEFAULT_BY_04.toString()))
            .andExpect(jsonPath("$.by05").value(DEFAULT_BY_05.toString()))
            .andExpect(jsonPath("$.by06").value(DEFAULT_BY_06.toString()))
            .andExpect(jsonPath("$.by07").value(DEFAULT_BY_07.toString()))
            .andExpect(jsonPath("$.by08").value(DEFAULT_BY_08.toString()))
            .andExpect(jsonPath("$.by09").value(DEFAULT_BY_09.toString()))
            .andExpect(jsonPath("$.by10").value(DEFAULT_BY_10.toString()))
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
    public void getNonExistingARightPerson() throws Exception {
        // Get the aRightPerson
        restARightPersonMockMvc.perform(get("/api/a-right-people/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateARightPerson() throws Exception {
        // Initialize the database
        aRightPersonRepository.saveAndFlush(aRightPerson);
        int databaseSizeBeforeUpdate = aRightPersonRepository.findAll().size();

        // Update the aRightPerson
        ARightPerson updatedARightPerson = aRightPersonRepository.findOne(aRightPerson.getId());
        updatedARightPerson
            .personName(UPDATED_PERSON_NAME)
            .firstName(UPDATED_FIRST_NAME)
            .jobId(UPDATED_JOB_ID)
            .lastName(UPDATED_LAST_NAME)
            .otherName(UPDATED_OTHER_NAME)
            .sex(UPDATED_SEX)
            .birthday(UPDATED_BIRTHDAY)
            .pic(UPDATED_PIC)
            .icon(UPDATED_ICON)
            .mobile(UPDATED_MOBILE)
            .depId(UPDATED_DEP_ID)
            .depAddress(UPDATED_DEP_ADDRESS)
            .depCode(UPDATED_DEP_CODE)
            .dutyId(UPDATED_DUTY_ID)
            .dimissionFlag(UPDATED_DIMISSION_FLAG)
            .headerFlag(UPDATED_HEADER_FLAG)
            .satrapFlag(UPDATED_SATRAP_FLAG)
            .leaderFlag(UPDATED_LEADER_FLAG)
            .postFlag1(UPDATED_POST_FLAG_1)
            .postFlag2(UPDATED_POST_FLAG_2)
            .postFlag3(UPDATED_POST_FLAG_3)
            .officeTel(UPDATED_OFFICE_TEL)
            .fax(UPDATED_FAX)
            .mail1(UPDATED_MAIL_1)
            .mail2(UPDATED_MAIL_2)
            .familyTel(UPDATED_FAMILY_TEL)
            .familyAdd(UPDATED_FAMILY_ADD)
            .familyCode(UPDATED_FAMILY_CODE)
            .personDescribe(UPDATED_PERSON_DESCRIBE)
            .idCode(UPDATED_ID_CODE)
            .pop3(UPDATED_POP_3)
            .smtp(UPDATED_SMTP)
            .mailUsername(UPDATED_MAIL_USERNAME)
            .mailPassword(UPDATED_MAIL_PASSWORD)
            .mailKeepFlag(UPDATED_MAIL_KEEP_FLAG)
            .personSort(UPDATED_PERSON_SORT)
            .levelNum(UPDATED_LEVEL_NUM)
            .personStateId(UPDATED_PERSON_STATE_ID)
            .by01(UPDATED_BY_01)
            .by02(UPDATED_BY_02)
            .by03(UPDATED_BY_03)
            .by04(UPDATED_BY_04)
            .by05(UPDATED_BY_05)
            .by06(UPDATED_BY_06)
            .by07(UPDATED_BY_07)
            .by08(UPDATED_BY_08)
            .by09(UPDATED_BY_09)
            .by10(UPDATED_BY_10)
            .validType(UPDATED_VALID_TYPE)
            .validBegin(UPDATED_VALID_BEGIN)
            .validEnd(UPDATED_VALID_END)
            .insertUserId(UPDATED_INSERT_USER_ID)
            .insertPersonId(UPDATED_INSERT_PERSON_ID)
            .insertTime(UPDATED_INSERT_TIME)
            .upinstantUserId(UPDATED_UPINSTANT_USER_ID)
            .upinstantPersonId(UPDATED_UPINSTANT_PERSON_ID)
            .upinstantTime(UPDATED_UPINSTANT_TIME);
        ARightPersonDTO aRightPersonDTO = aRightPersonMapper.toDto(updatedARightPerson);

        restARightPersonMockMvc.perform(put("/api/a-right-people")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aRightPersonDTO)))
            .andExpect(status().isOk());

        // Validate the ARightPerson in the database
        List<ARightPerson> aRightPersonList = aRightPersonRepository.findAll();
        assertThat(aRightPersonList).hasSize(databaseSizeBeforeUpdate);
        ARightPerson testARightPerson = aRightPersonList.get(aRightPersonList.size() - 1);
        assertThat(testARightPerson.getPersonName()).isEqualTo(UPDATED_PERSON_NAME);
        assertThat(testARightPerson.getFirstName()).isEqualTo(UPDATED_FIRST_NAME);
        assertThat(testARightPerson.getJobId()).isEqualTo(UPDATED_JOB_ID);
        assertThat(testARightPerson.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testARightPerson.getOtherName()).isEqualTo(UPDATED_OTHER_NAME);
        assertThat(testARightPerson.getSex()).isEqualTo(UPDATED_SEX);
        assertThat(testARightPerson.getBirthday()).isEqualTo(UPDATED_BIRTHDAY);
        assertThat(testARightPerson.getPic()).isEqualTo(UPDATED_PIC);
        assertThat(testARightPerson.getIcon()).isEqualTo(UPDATED_ICON);
        assertThat(testARightPerson.getMobile()).isEqualTo(UPDATED_MOBILE);
        assertThat(testARightPerson.getDepId()).isEqualTo(UPDATED_DEP_ID);
        assertThat(testARightPerson.getDepAddress()).isEqualTo(UPDATED_DEP_ADDRESS);
        assertThat(testARightPerson.getDepCode()).isEqualTo(UPDATED_DEP_CODE);
        assertThat(testARightPerson.getDutyId()).isEqualTo(UPDATED_DUTY_ID);
        assertThat(testARightPerson.getDimissionFlag()).isEqualTo(UPDATED_DIMISSION_FLAG);
        assertThat(testARightPerson.getHeaderFlag()).isEqualTo(UPDATED_HEADER_FLAG);
        assertThat(testARightPerson.getSatrapFlag()).isEqualTo(UPDATED_SATRAP_FLAG);
        assertThat(testARightPerson.getLeaderFlag()).isEqualTo(UPDATED_LEADER_FLAG);
        assertThat(testARightPerson.getPostFlag1()).isEqualTo(UPDATED_POST_FLAG_1);
        assertThat(testARightPerson.getPostFlag2()).isEqualTo(UPDATED_POST_FLAG_2);
        assertThat(testARightPerson.getPostFlag3()).isEqualTo(UPDATED_POST_FLAG_3);
        assertThat(testARightPerson.getOfficeTel()).isEqualTo(UPDATED_OFFICE_TEL);
        assertThat(testARightPerson.getFax()).isEqualTo(UPDATED_FAX);
        assertThat(testARightPerson.getMail1()).isEqualTo(UPDATED_MAIL_1);
        assertThat(testARightPerson.getMail2()).isEqualTo(UPDATED_MAIL_2);
        assertThat(testARightPerson.getFamilyTel()).isEqualTo(UPDATED_FAMILY_TEL);
        assertThat(testARightPerson.getFamilyAdd()).isEqualTo(UPDATED_FAMILY_ADD);
        assertThat(testARightPerson.getFamilyCode()).isEqualTo(UPDATED_FAMILY_CODE);
        assertThat(testARightPerson.getPersonDescribe()).isEqualTo(UPDATED_PERSON_DESCRIBE);
        assertThat(testARightPerson.getIdCode()).isEqualTo(UPDATED_ID_CODE);
        assertThat(testARightPerson.getPop3()).isEqualTo(UPDATED_POP_3);
        assertThat(testARightPerson.getSmtp()).isEqualTo(UPDATED_SMTP);
        assertThat(testARightPerson.getMailUsername()).isEqualTo(UPDATED_MAIL_USERNAME);
        assertThat(testARightPerson.getMailPassword()).isEqualTo(UPDATED_MAIL_PASSWORD);
        assertThat(testARightPerson.getMailKeepFlag()).isEqualTo(UPDATED_MAIL_KEEP_FLAG);
        assertThat(testARightPerson.getPersonSort()).isEqualTo(UPDATED_PERSON_SORT);
        assertThat(testARightPerson.getLevelNum()).isEqualTo(UPDATED_LEVEL_NUM);
        assertThat(testARightPerson.getPersonStateId()).isEqualTo(UPDATED_PERSON_STATE_ID);
        assertThat(testARightPerson.getBy01()).isEqualTo(UPDATED_BY_01);
        assertThat(testARightPerson.getBy02()).isEqualTo(UPDATED_BY_02);
        assertThat(testARightPerson.getBy03()).isEqualTo(UPDATED_BY_03);
        assertThat(testARightPerson.getBy04()).isEqualTo(UPDATED_BY_04);
        assertThat(testARightPerson.getBy05()).isEqualTo(UPDATED_BY_05);
        assertThat(testARightPerson.getBy06()).isEqualTo(UPDATED_BY_06);
        assertThat(testARightPerson.getBy07()).isEqualTo(UPDATED_BY_07);
        assertThat(testARightPerson.getBy08()).isEqualTo(UPDATED_BY_08);
        assertThat(testARightPerson.getBy09()).isEqualTo(UPDATED_BY_09);
        assertThat(testARightPerson.getBy10()).isEqualTo(UPDATED_BY_10);
        assertThat(testARightPerson.getValidType()).isEqualTo(UPDATED_VALID_TYPE);
        assertThat(testARightPerson.getValidBegin()).isEqualTo(UPDATED_VALID_BEGIN);
        assertThat(testARightPerson.getValidEnd()).isEqualTo(UPDATED_VALID_END);
        assertThat(testARightPerson.getInsertUserId()).isEqualTo(UPDATED_INSERT_USER_ID);
        assertThat(testARightPerson.getInsertPersonId()).isEqualTo(UPDATED_INSERT_PERSON_ID);
        assertThat(testARightPerson.getInsertTime()).isEqualTo(UPDATED_INSERT_TIME);
        assertThat(testARightPerson.getUpinstantUserId()).isEqualTo(UPDATED_UPINSTANT_USER_ID);
        assertThat(testARightPerson.getUpinstantPersonId()).isEqualTo(UPDATED_UPINSTANT_PERSON_ID);
        assertThat(testARightPerson.getUpinstantTime()).isEqualTo(UPDATED_UPINSTANT_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingARightPerson() throws Exception {
        int databaseSizeBeforeUpdate = aRightPersonRepository.findAll().size();

        // Create the ARightPerson
        ARightPersonDTO aRightPersonDTO = aRightPersonMapper.toDto(aRightPerson);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restARightPersonMockMvc.perform(put("/api/a-right-people")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aRightPersonDTO)))
            .andExpect(status().isCreated());

        // Validate the ARightPerson in the database
        List<ARightPerson> aRightPersonList = aRightPersonRepository.findAll();
        assertThat(aRightPersonList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteARightPerson() throws Exception {
        // Initialize the database
        aRightPersonRepository.saveAndFlush(aRightPerson);
        int databaseSizeBeforeDelete = aRightPersonRepository.findAll().size();

        // Get the aRightPerson
        restARightPersonMockMvc.perform(delete("/api/a-right-people/{id}", aRightPerson.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ARightPerson> aRightPersonList = aRightPersonRepository.findAll();
        assertThat(aRightPersonList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ARightPerson.class);
        ARightPerson aRightPerson1 = new ARightPerson();
        aRightPerson1.setId(1L);
        ARightPerson aRightPerson2 = new ARightPerson();
        aRightPerson2.setId(aRightPerson1.getId());
        assertThat(aRightPerson1).isEqualTo(aRightPerson2);
        aRightPerson2.setId(2L);
        assertThat(aRightPerson1).isNotEqualTo(aRightPerson2);
        aRightPerson1.setId(null);
        assertThat(aRightPerson1).isNotEqualTo(aRightPerson2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ARightPersonDTO.class);
        ARightPersonDTO aRightPersonDTO1 = new ARightPersonDTO();
        aRightPersonDTO1.setId(1L);
        ARightPersonDTO aRightPersonDTO2 = new ARightPersonDTO();
        assertThat(aRightPersonDTO1).isNotEqualTo(aRightPersonDTO2);
        aRightPersonDTO2.setId(aRightPersonDTO1.getId());
        assertThat(aRightPersonDTO1).isEqualTo(aRightPersonDTO2);
        aRightPersonDTO2.setId(2L);
        assertThat(aRightPersonDTO1).isNotEqualTo(aRightPersonDTO2);
        aRightPersonDTO1.setId(null);
        assertThat(aRightPersonDTO1).isNotEqualTo(aRightPersonDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(aRightPersonMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(aRightPersonMapper.fromId(null)).isNull();
    }
}
