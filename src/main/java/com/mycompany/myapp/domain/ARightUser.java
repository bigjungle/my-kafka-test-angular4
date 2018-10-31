package com.mycompany.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A ARightUser.
 */
@Entity
@Table(name = "a_right_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ARightUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 640)
    @Column(name = "user_password", length = 640)
    private String userPassword;

    @Size(max = 640)
    @Column(name = "process_password", length = 640)
    private String processPassword;

    @Column(name = "user_sort")
    private String userSort;

    @Column(name = "user_password_valiinstant_times")
    private Long userPasswordValiinstantTimes;

    @Column(name = "user_password_lock_flag")
    private String userPasswordLockFlag;

    @Column(name = "proc_password_valiinstant_times")
    private Long procPasswordValiinstantTimes;

    @Column(name = "proc_password_lock_flag")
    private String procPasswordLockFlag;

    @Column(name = "user_prop")
    private String userProp;

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

    public String getUserPassword() {
        return userPassword;
    }

    public ARightUser userPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getProcessPassword() {
        return processPassword;
    }

    public ARightUser processPassword(String processPassword) {
        this.processPassword = processPassword;
        return this;
    }

    public void setProcessPassword(String processPassword) {
        this.processPassword = processPassword;
    }

    public String getUserSort() {
        return userSort;
    }

    public ARightUser userSort(String userSort) {
        this.userSort = userSort;
        return this;
    }

    public void setUserSort(String userSort) {
        this.userSort = userSort;
    }

    public Long getUserPasswordValiinstantTimes() {
        return userPasswordValiinstantTimes;
    }

    public ARightUser userPasswordValiinstantTimes(Long userPasswordValiinstantTimes) {
        this.userPasswordValiinstantTimes = userPasswordValiinstantTimes;
        return this;
    }

    public void setUserPasswordValiinstantTimes(Long userPasswordValiinstantTimes) {
        this.userPasswordValiinstantTimes = userPasswordValiinstantTimes;
    }

    public String getUserPasswordLockFlag() {
        return userPasswordLockFlag;
    }

    public ARightUser userPasswordLockFlag(String userPasswordLockFlag) {
        this.userPasswordLockFlag = userPasswordLockFlag;
        return this;
    }

    public void setUserPasswordLockFlag(String userPasswordLockFlag) {
        this.userPasswordLockFlag = userPasswordLockFlag;
    }

    public Long getProcPasswordValiinstantTimes() {
        return procPasswordValiinstantTimes;
    }

    public ARightUser procPasswordValiinstantTimes(Long procPasswordValiinstantTimes) {
        this.procPasswordValiinstantTimes = procPasswordValiinstantTimes;
        return this;
    }

    public void setProcPasswordValiinstantTimes(Long procPasswordValiinstantTimes) {
        this.procPasswordValiinstantTimes = procPasswordValiinstantTimes;
    }

    public String getProcPasswordLockFlag() {
        return procPasswordLockFlag;
    }

    public ARightUser procPasswordLockFlag(String procPasswordLockFlag) {
        this.procPasswordLockFlag = procPasswordLockFlag;
        return this;
    }

    public void setProcPasswordLockFlag(String procPasswordLockFlag) {
        this.procPasswordLockFlag = procPasswordLockFlag;
    }

    public String getUserProp() {
        return userProp;
    }

    public ARightUser userProp(String userProp) {
        this.userProp = userProp;
        return this;
    }

    public void setUserProp(String userProp) {
        this.userProp = userProp;
    }

    public String getBy01() {
        return by01;
    }

    public ARightUser by01(String by01) {
        this.by01 = by01;
        return this;
    }

    public void setBy01(String by01) {
        this.by01 = by01;
    }

    public String getBy02() {
        return by02;
    }

    public ARightUser by02(String by02) {
        this.by02 = by02;
        return this;
    }

    public void setBy02(String by02) {
        this.by02 = by02;
    }

    public String getBy03() {
        return by03;
    }

    public ARightUser by03(String by03) {
        this.by03 = by03;
        return this;
    }

    public void setBy03(String by03) {
        this.by03 = by03;
    }

    public String getBy04() {
        return by04;
    }

    public ARightUser by04(String by04) {
        this.by04 = by04;
        return this;
    }

    public void setBy04(String by04) {
        this.by04 = by04;
    }

    public String getBy05() {
        return by05;
    }

    public ARightUser by05(String by05) {
        this.by05 = by05;
        return this;
    }

    public void setBy05(String by05) {
        this.by05 = by05;
    }

    public String getValidType() {
        return validType;
    }

    public ARightUser validType(String validType) {
        this.validType = validType;
        return this;
    }

    public void setValidType(String validType) {
        this.validType = validType;
    }

    public Instant getValidBegin() {
        return validBegin;
    }

    public ARightUser validBegin(Instant validBegin) {
        this.validBegin = validBegin;
        return this;
    }

    public void setValidBegin(Instant validBegin) {
        this.validBegin = validBegin;
    }

    public Instant getValidEnd() {
        return validEnd;
    }

    public ARightUser validEnd(Instant validEnd) {
        this.validEnd = validEnd;
        return this;
    }

    public void setValidEnd(Instant validEnd) {
        this.validEnd = validEnd;
    }

    public String getInsertUserId() {
        return insertUserId;
    }

    public ARightUser insertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
        return this;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    public String getInsertPersonId() {
        return insertPersonId;
    }

    public ARightUser insertPersonId(String insertPersonId) {
        this.insertPersonId = insertPersonId;
        return this;
    }

    public void setInsertPersonId(String insertPersonId) {
        this.insertPersonId = insertPersonId;
    }

    public Instant getInsertTime() {
        return insertTime;
    }

    public ARightUser insertTime(Instant insertTime) {
        this.insertTime = insertTime;
        return this;
    }

    public void setInsertTime(Instant insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpinstantUserId() {
        return upinstantUserId;
    }

    public ARightUser upinstantUserId(String upinstantUserId) {
        this.upinstantUserId = upinstantUserId;
        return this;
    }

    public void setUpinstantUserId(String upinstantUserId) {
        this.upinstantUserId = upinstantUserId;
    }

    public String getUpinstantPersonId() {
        return upinstantPersonId;
    }

    public ARightUser upinstantPersonId(String upinstantPersonId) {
        this.upinstantPersonId = upinstantPersonId;
        return this;
    }

    public void setUpinstantPersonId(String upinstantPersonId) {
        this.upinstantPersonId = upinstantPersonId;
    }

    public Instant getUpinstantTime() {
        return upinstantTime;
    }

    public ARightUser upinstantTime(Instant upinstantTime) {
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
        ARightUser aRightUser = (ARightUser) o;
        if (aRightUser.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), aRightUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ARightUser{" +
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
