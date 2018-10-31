package com.mycompany.myapp.service.dto;


import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ARightPerson entity.
 */
public class ARightPersonDTO implements Serializable {

    private Long id;

    private String personName;

    private String firstName;

    private String jobId;

    private String lastName;

    private String otherName;

    private String sex;

    private Instant birthday;

    private String pic;

    private String icon;

    private String mobile;

    private String depId;

    private String depAddress;

    private String depCode;

    private String dutyId;

    private String dimissionFlag;

    private String headerFlag;

    private String satrapFlag;

    private String leaderFlag;

    private String postFlag1;

    private String postFlag2;

    private String postFlag3;

    private String officeTel;

    private String fax;

    private String mail1;

    private String mail2;

    private String familyTel;

    private String familyAdd;

    private String familyCode;

    private String personDescribe;

    private String idCode;

    private String pop3;

    private String smtp;

    private String mailUsername;

    private String mailPassword;

    private String mailKeepFlag;

    private String personSort;

    private Long levelNum;

    private String personStateId;

    private String by01;

    private String by02;

    private String by03;

    private String by04;

    private String by05;

    private String by06;

    private String by07;

    private String by08;

    private String by09;

    private String by10;

    private String validType;

    private Instant validBegin;

    private Instant validEnd;

    private String insertUserId;

    private String insertPersonId;

    private Instant insertTime;

    private String upinstantUserId;

    private String upinstantPersonId;

    private Instant upinstantTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepAddress() {
        return depAddress;
    }

    public void setDepAddress(String depAddress) {
        this.depAddress = depAddress;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
    }

    public String getDimissionFlag() {
        return dimissionFlag;
    }

    public void setDimissionFlag(String dimissionFlag) {
        this.dimissionFlag = dimissionFlag;
    }

    public String getHeaderFlag() {
        return headerFlag;
    }

    public void setHeaderFlag(String headerFlag) {
        this.headerFlag = headerFlag;
    }

    public String getSatrapFlag() {
        return satrapFlag;
    }

    public void setSatrapFlag(String satrapFlag) {
        this.satrapFlag = satrapFlag;
    }

    public String getLeaderFlag() {
        return leaderFlag;
    }

    public void setLeaderFlag(String leaderFlag) {
        this.leaderFlag = leaderFlag;
    }

    public String getPostFlag1() {
        return postFlag1;
    }

    public void setPostFlag1(String postFlag1) {
        this.postFlag1 = postFlag1;
    }

    public String getPostFlag2() {
        return postFlag2;
    }

    public void setPostFlag2(String postFlag2) {
        this.postFlag2 = postFlag2;
    }

    public String getPostFlag3() {
        return postFlag3;
    }

    public void setPostFlag3(String postFlag3) {
        this.postFlag3 = postFlag3;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail1() {
        return mail1;
    }

    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    public String getFamilyTel() {
        return familyTel;
    }

    public void setFamilyTel(String familyTel) {
        this.familyTel = familyTel;
    }

    public String getFamilyAdd() {
        return familyAdd;
    }

    public void setFamilyAdd(String familyAdd) {
        this.familyAdd = familyAdd;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    public String getPersonDescribe() {
        return personDescribe;
    }

    public void setPersonDescribe(String personDescribe) {
        this.personDescribe = personDescribe;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getPop3() {
        return pop3;
    }

    public void setPop3(String pop3) {
        this.pop3 = pop3;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getMailUsername() {
        return mailUsername;
    }

    public void setMailUsername(String mailUsername) {
        this.mailUsername = mailUsername;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public String getMailKeepFlag() {
        return mailKeepFlag;
    }

    public void setMailKeepFlag(String mailKeepFlag) {
        this.mailKeepFlag = mailKeepFlag;
    }

    public String getPersonSort() {
        return personSort;
    }

    public void setPersonSort(String personSort) {
        this.personSort = personSort;
    }

    public Long getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(Long levelNum) {
        this.levelNum = levelNum;
    }

    public String getPersonStateId() {
        return personStateId;
    }

    public void setPersonStateId(String personStateId) {
        this.personStateId = personStateId;
    }

    public String getBy01() {
        return by01;
    }

    public void setBy01(String by01) {
        this.by01 = by01;
    }

    public String getBy02() {
        return by02;
    }

    public void setBy02(String by02) {
        this.by02 = by02;
    }

    public String getBy03() {
        return by03;
    }

    public void setBy03(String by03) {
        this.by03 = by03;
    }

    public String getBy04() {
        return by04;
    }

    public void setBy04(String by04) {
        this.by04 = by04;
    }

    public String getBy05() {
        return by05;
    }

    public void setBy05(String by05) {
        this.by05 = by05;
    }

    public String getBy06() {
        return by06;
    }

    public void setBy06(String by06) {
        this.by06 = by06;
    }

    public String getBy07() {
        return by07;
    }

    public void setBy07(String by07) {
        this.by07 = by07;
    }

    public String getBy08() {
        return by08;
    }

    public void setBy08(String by08) {
        this.by08 = by08;
    }

    public String getBy09() {
        return by09;
    }

    public void setBy09(String by09) {
        this.by09 = by09;
    }

    public String getBy10() {
        return by10;
    }

    public void setBy10(String by10) {
        this.by10 = by10;
    }

    public String getValidType() {
        return validType;
    }

    public void setValidType(String validType) {
        this.validType = validType;
    }

    public Instant getValidBegin() {
        return validBegin;
    }

    public void setValidBegin(Instant validBegin) {
        this.validBegin = validBegin;
    }

    public Instant getValidEnd() {
        return validEnd;
    }

    public void setValidEnd(Instant validEnd) {
        this.validEnd = validEnd;
    }

    public String getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    public String getInsertPersonId() {
        return insertPersonId;
    }

    public void setInsertPersonId(String insertPersonId) {
        this.insertPersonId = insertPersonId;
    }

    public Instant getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Instant insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpinstantUserId() {
        return upinstantUserId;
    }

    public void setUpinstantUserId(String upinstantUserId) {
        this.upinstantUserId = upinstantUserId;
    }

    public String getUpinstantPersonId() {
        return upinstantPersonId;
    }

    public void setUpinstantPersonId(String upinstantPersonId) {
        this.upinstantPersonId = upinstantPersonId;
    }

    public Instant getUpinstantTime() {
        return upinstantTime;
    }

    public void setUpinstantTime(Instant upinstantTime) {
        this.upinstantTime = upinstantTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ARightPersonDTO aRightPersonDTO = (ARightPersonDTO) o;
        if(aRightPersonDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), aRightPersonDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ARightPersonDTO{" +
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
