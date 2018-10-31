package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A ARightPerson.
 */
@Entity
@Table(name = "a_right_person")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ARightPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "person_name")
    private String personName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "job_id")
    private String jobId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "other_name")
    private String otherName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private Instant birthday;

    @Column(name = "pic")
    private String pic;

    @Column(name = "icon")
    private String icon;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "dep_id")
    private String depId;

    @Column(name = "dep_address")
    private String depAddress;

    @Column(name = "dep_code")
    private String depCode;

    @Column(name = "duty_id")
    private String dutyId;

    @Column(name = "dimission_flag")
    private String dimissionFlag;

    @Column(name = "header_flag")
    private String headerFlag;

    @Column(name = "satrap_flag")
    private String satrapFlag;

    @Column(name = "leader_flag")
    private String leaderFlag;

    @Column(name = "post_flag_1")
    private String postFlag1;

    @Column(name = "post_flag_2")
    private String postFlag2;

    @Column(name = "post_flag_3")
    private String postFlag3;

    @Column(name = "office_tel")
    private String officeTel;

    @Column(name = "fax")
    private String fax;

    @Column(name = "mail_1")
    private String mail1;

    @Column(name = "mail_2")
    private String mail2;

    @Column(name = "family_tel")
    private String familyTel;

    @Column(name = "family_add")
    private String familyAdd;

    @Column(name = "family_code")
    private String familyCode;

    @Column(name = "person_describe")
    private String personDescribe;

    @Column(name = "id_code")
    private String idCode;

    @Column(name = "pop_3")
    private String pop3;

    @Column(name = "smtp")
    private String smtp;

    @Column(name = "mail_username")
    private String mailUsername;

    @Column(name = "mail_password")
    private String mailPassword;

    @Column(name = "mail_keep_flag")
    private String mailKeepFlag;

    @Column(name = "person_sort")
    private String personSort;

    @Column(name = "level_num")
    private Long levelNum;

    @Column(name = "person_state_id")
    private String personStateId;

    @Column(name = "by_01")
    private String by01;

    @Column(name = "by_02")
    private String by02;

    @Column(name = "by_03")
    private String by03;

    @Column(name = "by_04")
    private String by04;

    @Column(name = "by_05")
    private String by05;

    @Column(name = "by_06")
    private String by06;

    @Column(name = "by_07")
    private String by07;

    @Column(name = "by_08")
    private String by08;

    @Column(name = "by_09")
    private String by09;

    @Column(name = "by_10")
    private String by10;

    @Column(name = "valid_type")
    private String validType;

    @Column(name = "valid_begin")
    private Instant validBegin;

    @Column(name = "valid_end")
    private Instant validEnd;

    @Column(name = "insert_user_id")
    private String insertUserId;

    @Column(name = "insert_person_id")
    private String insertPersonId;

    @Column(name = "insert_time")
    private Instant insertTime;

    @Column(name = "upinstant_user_id")
    private String upinstantUserId;

    @Column(name = "upinstant_person_id")
    private String upinstantPersonId;

    @Column(name = "upinstant_time")
    private Instant upinstantTime;

    // jhipster-needle-entity-add-field - Jhipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public ARightPerson personName(String personName) {
        this.personName = personName;
        return this;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getFirstName() {
        return firstName;
    }

    public ARightPerson firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJobId() {
        return jobId;
    }

    public ARightPerson jobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getLastName() {
        return lastName;
    }

    public ARightPerson lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public ARightPerson otherName(String otherName) {
        this.otherName = otherName;
        return this;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getSex() {
        return sex;
    }

    public ARightPerson sex(String sex) {
        this.sex = sex;
        return this;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public ARightPerson birthday(Instant birthday) {
        this.birthday = birthday;
        return this;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getPic() {
        return pic;
    }

    public ARightPerson pic(String pic) {
        this.pic = pic;
        return this;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIcon() {
        return icon;
    }

    public ARightPerson icon(String icon) {
        this.icon = icon;
        return this;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMobile() {
        return mobile;
    }

    public ARightPerson mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepId() {
        return depId;
    }

    public ARightPerson depId(String depId) {
        this.depId = depId;
        return this;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepAddress() {
        return depAddress;
    }

    public ARightPerson depAddress(String depAddress) {
        this.depAddress = depAddress;
        return this;
    }

    public void setDepAddress(String depAddress) {
        this.depAddress = depAddress;
    }

    public String getDepCode() {
        return depCode;
    }

    public ARightPerson depCode(String depCode) {
        this.depCode = depCode;
        return this;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDutyId() {
        return dutyId;
    }

    public ARightPerson dutyId(String dutyId) {
        this.dutyId = dutyId;
        return this;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
    }

    public String getDimissionFlag() {
        return dimissionFlag;
    }

    public ARightPerson dimissionFlag(String dimissionFlag) {
        this.dimissionFlag = dimissionFlag;
        return this;
    }

    public void setDimissionFlag(String dimissionFlag) {
        this.dimissionFlag = dimissionFlag;
    }

    public String getHeaderFlag() {
        return headerFlag;
    }

    public ARightPerson headerFlag(String headerFlag) {
        this.headerFlag = headerFlag;
        return this;
    }

    public void setHeaderFlag(String headerFlag) {
        this.headerFlag = headerFlag;
    }

    public String getSatrapFlag() {
        return satrapFlag;
    }

    public ARightPerson satrapFlag(String satrapFlag) {
        this.satrapFlag = satrapFlag;
        return this;
    }

    public void setSatrapFlag(String satrapFlag) {
        this.satrapFlag = satrapFlag;
    }

    public String getLeaderFlag() {
        return leaderFlag;
    }

    public ARightPerson leaderFlag(String leaderFlag) {
        this.leaderFlag = leaderFlag;
        return this;
    }

    public void setLeaderFlag(String leaderFlag) {
        this.leaderFlag = leaderFlag;
    }

    public String getPostFlag1() {
        return postFlag1;
    }

    public ARightPerson postFlag1(String postFlag1) {
        this.postFlag1 = postFlag1;
        return this;
    }

    public void setPostFlag1(String postFlag1) {
        this.postFlag1 = postFlag1;
    }

    public String getPostFlag2() {
        return postFlag2;
    }

    public ARightPerson postFlag2(String postFlag2) {
        this.postFlag2 = postFlag2;
        return this;
    }

    public void setPostFlag2(String postFlag2) {
        this.postFlag2 = postFlag2;
    }

    public String getPostFlag3() {
        return postFlag3;
    }

    public ARightPerson postFlag3(String postFlag3) {
        this.postFlag3 = postFlag3;
        return this;
    }

    public void setPostFlag3(String postFlag3) {
        this.postFlag3 = postFlag3;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public ARightPerson officeTel(String officeTel) {
        this.officeTel = officeTel;
        return this;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getFax() {
        return fax;
    }

    public ARightPerson fax(String fax) {
        this.fax = fax;
        return this;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail1() {
        return mail1;
    }

    public ARightPerson mail1(String mail1) {
        this.mail1 = mail1;
        return this;
    }

    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public ARightPerson mail2(String mail2) {
        this.mail2 = mail2;
        return this;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    public String getFamilyTel() {
        return familyTel;
    }

    public ARightPerson familyTel(String familyTel) {
        this.familyTel = familyTel;
        return this;
    }

    public void setFamilyTel(String familyTel) {
        this.familyTel = familyTel;
    }

    public String getFamilyAdd() {
        return familyAdd;
    }

    public ARightPerson familyAdd(String familyAdd) {
        this.familyAdd = familyAdd;
        return this;
    }

    public void setFamilyAdd(String familyAdd) {
        this.familyAdd = familyAdd;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public ARightPerson familyCode(String familyCode) {
        this.familyCode = familyCode;
        return this;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public String getPersonDescribe() {
        return personDescribe;
    }

    public ARightPerson personDescribe(String personDescribe) {
        this.personDescribe = personDescribe;
        return this;
    }

    public void setPersonDescribe(String personDescribe) {
        this.personDescribe = personDescribe;
    }

    public String getIdCode() {
        return idCode;
    }

    public ARightPerson idCode(String idCode) {
        this.idCode = idCode;
        return this;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getPop3() {
        return pop3;
    }

    public ARightPerson pop3(String pop3) {
        this.pop3 = pop3;
        return this;
    }

    public void setPop3(String pop3) {
        this.pop3 = pop3;
    }

    public String getSmtp() {
        return smtp;
    }

    public ARightPerson smtp(String smtp) {
        this.smtp = smtp;
        return this;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getMailUsername() {
        return mailUsername;
    }

    public ARightPerson mailUsername(String mailUsername) {
        this.mailUsername = mailUsername;
        return this;
    }

    public void setMailUsername(String mailUsername) {
        this.mailUsername = mailUsername;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public ARightPerson mailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
        return this;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public String getMailKeepFlag() {
        return mailKeepFlag;
    }

    public ARightPerson mailKeepFlag(String mailKeepFlag) {
        this.mailKeepFlag = mailKeepFlag;
        return this;
    }

    public void setMailKeepFlag(String mailKeepFlag) {
        this.mailKeepFlag = mailKeepFlag;
    }

    public String getPersonSort() {
        return personSort;
    }

    public ARightPerson personSort(String personSort) {
        this.personSort = personSort;
        return this;
    }

    public void setPersonSort(String personSort) {
        this.personSort = personSort;
    }

    public Long getLevelNum() {
        return levelNum;
    }

    public ARightPerson levelNum(Long levelNum) {
        this.levelNum = levelNum;
        return this;
    }

    public void setLevelNum(Long levelNum) {
        this.levelNum = levelNum;
    }

    public String getPersonStateId() {
        return personStateId;
    }

    public ARightPerson personStateId(String personStateId) {
        this.personStateId = personStateId;
        return this;
    }

    public void setPersonStateId(String personStateId) {
        this.personStateId = personStateId;
    }

    public String getBy01() {
        return by01;
    }

    public ARightPerson by01(String by01) {
        this.by01 = by01;
        return this;
    }

    public void setBy01(String by01) {
        this.by01 = by01;
    }

    public String getBy02() {
        return by02;
    }

    public ARightPerson by02(String by02) {
        this.by02 = by02;
        return this;
    }

    public void setBy02(String by02) {
        this.by02 = by02;
    }

    public String getBy03() {
        return by03;
    }

    public ARightPerson by03(String by03) {
        this.by03 = by03;
        return this;
    }

    public void setBy03(String by03) {
        this.by03 = by03;
    }

    public String getBy04() {
        return by04;
    }

    public ARightPerson by04(String by04) {
        this.by04 = by04;
        return this;
    }

    public void setBy04(String by04) {
        this.by04 = by04;
    }

    public String getBy05() {
        return by05;
    }

    public ARightPerson by05(String by05) {
        this.by05 = by05;
        return this;
    }

    public void setBy05(String by05) {
        this.by05 = by05;
    }

    public String getBy06() {
        return by06;
    }

    public ARightPerson by06(String by06) {
        this.by06 = by06;
        return this;
    }

    public void setBy06(String by06) {
        this.by06 = by06;
    }

    public String getBy07() {
        return by07;
    }

    public ARightPerson by07(String by07) {
        this.by07 = by07;
        return this;
    }

    public void setBy07(String by07) {
        this.by07 = by07;
    }

    public String getBy08() {
        return by08;
    }

    public ARightPerson by08(String by08) {
        this.by08 = by08;
        return this;
    }

    public void setBy08(String by08) {
        this.by08 = by08;
    }

    public String getBy09() {
        return by09;
    }

    public ARightPerson by09(String by09) {
        this.by09 = by09;
        return this;
    }

    public void setBy09(String by09) {
        this.by09 = by09;
    }

    public String getBy10() {
        return by10;
    }

    public ARightPerson by10(String by10) {
        this.by10 = by10;
        return this;
    }

    public void setBy10(String by10) {
        this.by10 = by10;
    }

    public String getValidType() {
        return validType;
    }

    public ARightPerson validType(String validType) {
        this.validType = validType;
        return this;
    }

    public void setValidType(String validType) {
        this.validType = validType;
    }

    public Instant getValidBegin() {
        return validBegin;
    }

    public ARightPerson validBegin(Instant validBegin) {
        this.validBegin = validBegin;
        return this;
    }

    public void setValidBegin(Instant validBegin) {
        this.validBegin = validBegin;
    }

    public Instant getValidEnd() {
        return validEnd;
    }

    public ARightPerson validEnd(Instant validEnd) {
        this.validEnd = validEnd;
        return this;
    }

    public void setValidEnd(Instant validEnd) {
        this.validEnd = validEnd;
    }

    public String getInsertUserId() {
        return insertUserId;
    }

    public ARightPerson insertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
        return this;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    public String getInsertPersonId() {
        return insertPersonId;
    }

    public ARightPerson insertPersonId(String insertPersonId) {
        this.insertPersonId = insertPersonId;
        return this;
    }

    public void setInsertPersonId(String insertPersonId) {
        this.insertPersonId = insertPersonId;
    }

    public Instant getInsertTime() {
        return insertTime;
    }

    public ARightPerson insertTime(Instant insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public void setInsertTime(Instant insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpinstantUserId() {
        return upinstantUserId;
    }

    public ARightPerson upinstantUserId(String upinstantUserId) {
        this.upinstantUserId = upinstantUserId;
        return this;
    }

    public void setUpinstantUserId(String upinstantUserId) {
        this.upinstantUserId = upinstantUserId;
    }

    public String getUpinstantPersonId() {
        return upinstantPersonId;
    }

    public ARightPerson upinstantPersonId(String upinstantPersonId) {
        this.upinstantPersonId = upinstantPersonId;
        return this;
    }

    public void setUpinstantPersonId(String upinstantPersonId) {
        this.upinstantPersonId = upinstantPersonId;
    }

    public Instant getUpinstantTime() {
        return upinstantTime;
    }

    public ARightPerson upinstantTime(Instant upinstantTime) {
        this.upinstantTime = upinstantTime;
        return this;
    }

    public void setUpinstantTime(Instant upinstantTime) {
        this.upinstantTime = upinstantTime;
    }
    // jhipster-needle-entity-add-getters-setters - Jhipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ARightPerson aRightPerson = (ARightPerson) o;
        if (aRightPerson.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), aRightPerson.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ARightPerson{" +
            "id=" + getId() +
            ", personName='" + getPersonName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", jobId='" + getJobId() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", otherName='" + getOtherName() + "'" +
            ", sex='" + getSex() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", pic='" + getPic() + "'" +
            ", icon='" + getIcon() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", depId='" + getDepId() + "'" +
            ", depAddress='" + getDepAddress() + "'" +
            ", depCode='" + getDepCode() + "'" +
            ", dutyId='" + getDutyId() + "'" +
            ", dimissionFlag='" + getDimissionFlag() + "'" +
            ", headerFlag='" + getHeaderFlag() + "'" +
            ", satrapFlag='" + getSatrapFlag() + "'" +
            ", leaderFlag='" + getLeaderFlag() + "'" +
            ", postFlag1='" + getPostFlag1() + "'" +
            ", postFlag2='" + getPostFlag2() + "'" +
            ", postFlag3='" + getPostFlag3() + "'" +
            ", officeTel='" + getOfficeTel() + "'" +
            ", fax='" + getFax() + "'" +
            ", mail1='" + getMail1() + "'" +
            ", mail2='" + getMail2() + "'" +
            ", familyTel='" + getFamilyTel() + "'" +
            ", familyAdd='" + getFamilyAdd() + "'" +
            ", familyCode='" + getFamilyCode() + "'" +
            ", personDescribe='" + getPersonDescribe() + "'" +
            ", idCode='" + getIdCode() + "'" +
            ", pop3='" + getPop3() + "'" +
            ", smtp='" + getSmtp() + "'" +
            ", mailUsername='" + getMailUsername() + "'" +
            ", mailPassword='" + getMailPassword() + "'" +
            ", mailKeepFlag='" + getMailKeepFlag() + "'" +
            ", personSort='" + getPersonSort() + "'" +
            ", levelNum='" + getLevelNum() + "'" +
            ", personStateId='" + getPersonStateId() + "'" +
            ", by01='" + getBy01() + "'" +
            ", by02='" + getBy02() + "'" +
            ", by03='" + getBy03() + "'" +
            ", by04='" + getBy04() + "'" +
            ", by05='" + getBy05() + "'" +
            ", by06='" + getBy06() + "'" +
            ", by07='" + getBy07() + "'" +
            ", by08='" + getBy08() + "'" +
            ", by09='" + getBy09() + "'" +
            ", by10='" + getBy10() + "'" +
            ", validType='" + getValidType() + "'" +
            ", validBegin='" + getValidBegin() + "'" +
            ", validEnd='" + getValidEnd() + "'" +
            ", insertUserId='" + getInsertUserId() + "'" +
            ", insertPersonId='" + getInsertPersonId() + "'" +
            ", insertTime='" + getInsertTime() + "'" +
            ", upinstantUserId='" + getUpinstantUserId() + "'" +
            ", upinstantPersonId='" + getUpinstantPersonId() + "'" +
            ", upinstantTime='" + getUpinstantTime() + "'" +
            "}";
    }
}
