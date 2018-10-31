package com.mycompany.myapp.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ARightUser entity.
 */
public class ARightUserDTO implements Serializable {

    private Long id;

    @Size(max = 640)
    private String userPassword;

    @Size(max = 640)
    private String processPassword;

    private String userSort;

    private Long userPasswordValiinstantTimes;

    private String userPasswordLockFlag;

    private Long procPasswordValiinstantTimes;

    private String procPasswordLockFlag;

    private String userProp;

    private String by01;

    private String by02;

    private String by03;

    private String by04;

    private String by05;

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getProcessPassword() {
        return processPassword;
    }

    public void setProcessPassword(String processPassword) {
        this.processPassword = processPassword;
    }

    public String getUserSort() {
        return userSort;
    }

    public void setUserSort(String userSort) {
        this.userSort = userSort;
    }

    public Long getUserPasswordValiinstantTimes() {
        return userPasswordValiinstantTimes;
    }

    public void setUserPasswordValiinstantTimes(Long userPasswordValiinstantTimes) {
        this.userPasswordValiinstantTimes = userPasswordValiinstantTimes;
    }

    public String getUserPasswordLockFlag() {
        return userPasswordLockFlag;
    }

    public void setUserPasswordLockFlag(String userPasswordLockFlag) {
        this.userPasswordLockFlag = userPasswordLockFlag;
    }

    public Long getProcPasswordValiinstantTimes() {
        return procPasswordValiinstantTimes;
    }

    public void setProcPasswordValiinstantTimes(Long procPasswordValiinstantTimes) {
        this.procPasswordValiinstantTimes = procPasswordValiinstantTimes;
    }

    public String getProcPasswordLockFlag() {
        return procPasswordLockFlag;
    }

    public void setProcPasswordLockFlag(String procPasswordLockFlag) {
        this.procPasswordLockFlag = procPasswordLockFlag;
    }

    public String getUserProp() {
        return userProp;
    }

    public void setUserProp(String userProp) {
        this.userProp = userProp;
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

        ARightUserDTO aRightUserDTO = (ARightUserDTO) o;
        if(aRightUserDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), aRightUserDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ARightUserDTO{" +
            "id=" + getId() +
            ", userPassword='" + getUserPassword() + "'" +
            ", processPassword='" + getProcessPassword() + "'" +
            ", userSort='" + getUserSort() + "'" +
            ", userPasswordValiinstantTimes='" + getUserPasswordValiinstantTimes() + "'" +
            ", userPasswordLockFlag='" + getUserPasswordLockFlag() + "'" +
            ", procPasswordValiinstantTimes='" + getProcPasswordValiinstantTimes() + "'" +
            ", procPasswordLockFlag='" + getProcPasswordLockFlag() + "'" +
            ", userProp='" + getUserProp() + "'" +
            ", by01='" + getBy01() + "'" +
            ", by02='" + getBy02() + "'" +
            ", by03='" + getBy03() + "'" +
            ", by04='" + getBy04() + "'" +
            ", by05='" + getBy05() + "'" +
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
