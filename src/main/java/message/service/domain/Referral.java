/**
 * Copyright (c) 2019. PT. Distributor Indonesia Unggul. All rights reserverd.
 *
 * This source code is an unpublished work and the use of  a copyright  notice
 * does not imply otherwise. This source  code  contains  confidential,  trade
 * secret material of PT. Distributor Indonesia Unggul.
 * Any attempt or participation in deciphering, decoding, reverse  engineering
 * or in any way altering the source code is strictly  prohibited, unless  the
 * prior  written consent of Distributor Indonesia Unggul. is obtained.
 *
 * Unless  required  by  applicable  law  or  agreed  to  in writing, software
 * distributed under the License is distributed on an "AS IS"  BASIS,  WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or  implied.  See  the
 * License for the specific  language  governing  permissions  and limitations
 * under the License.
 *
 * Author : Bobby
 */

package message.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "codes")
public class Referral {

    public Referral(){}

    public Referral(@NotNull String codeReferral, Long resellerId, String resellerCode, @NotNull boolean isActive, Long assignedBy, Date assignedAt, Long createdBy, Date createdAt){
        this.codeReferral = codeReferral;
        this.resellerId = resellerId;
        this.resellerCode = resellerCode;
        this.isActive = isActive;
        this.assignedBy = assignedBy;
        this.assignedAt = assignedAt;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @NotNull
    @Column(name = "ref_code")
    private String codeReferral;

    @JsonIgnore
    @Column(name = "reseller_id")
    private Long resellerId;

    @JsonIgnore
    @Column(name = "reseller_code")
    private String resellerCode;

    @JsonIgnore
    @Column(name = "total_member")
    private Long totalMember;

    @JsonIgnore
    @Column(name = "total_saldo")
    private Long totalShare;

    @JsonIgnore
    @NotNull
    @Column(name = "is_active")
    private boolean isActive = true;

    @JsonIgnore
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @JsonIgnore
    @Column(name = "assigned_by")
    private Long assignedBy;

    @JsonIgnore
    @Column(name = "assigned_at")
    private Date assignedAt;

    @JsonIgnore
    @Column(name = "created_by")
    private Long createdBy;

    @JsonIgnore
    @Column(name = "created_at")
    private Date createdAt;

    @JsonIgnore
    @Column(name = "updated_by")
    private Long updatedBy;

    @JsonIgnore
    @Column(name = "updated_at")
    private Date updatedAt;

    @JsonIgnore
    @Column(name = "deleted_by")
    private Long deletedBy;

    @JsonIgnore
    @Column(name = "deleted_at")
    private Date deletedAt;

    @JsonIgnore
    @Column(name = "token")
    private String token;

    /**
     * @return as List Member
     */

    @JsonIgnore
    @OneToMany(mappedBy = "referral")
    private List<ReferralMember> referralMemberList;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setCodeReferral(String codeReferral) { this.codeReferral = codeReferral; }
    @JsonProperty("code_referral")
    public String getCodeReferral() { return codeReferral; }

    public void setResellerId(Long resellerId) { this.resellerId = resellerId; }
    @JsonProperty("reseller_id")
    public Long getResellerId() { return resellerId; }

    public void setResellerCode(String resellerCode) { this.resellerCode = resellerCode; }
    @JsonProperty("reseller_code")
    public String getResellerCode() { return resellerCode; }

    public void setTotalMember(Long totalMember) { this.totalMember = totalMember; }
    @JsonProperty("total_member")
    public Long getTotalMember() { return totalMember; }

    public void setTotalShare(Long totalShare) { this.totalShare = totalShare; }
    @JsonProperty("total_share")
    public Long getTotalShare() { return totalShare; }

    public void setIsActive(boolean isActive) {this.isActive = isActive; }
    @JsonIgnore
    @JsonProperty("is_active")
    public boolean getIsActive() { return isActive; }

    public void setDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }
    @JsonIgnore
    @JsonProperty("is_deleted")
    public Boolean isDeleted() { return isDeleted; }

    public void setAssignedBy(Long assignedBy) { this.assignedBy = assignedBy; }
    @JsonIgnore
    @JsonProperty("assigned_by")
    public Long getAssignedBy() { return assignedBy; }

    public void setAssignedAt(Date assignedAt) { this.assignedAt = assignedAt; }
    @JsonIgnore
    @JsonProperty("assigned_at")
    public Date getAssignedAt() { return assignedAt; }

    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
    @JsonIgnore
    @JsonProperty("created_by")
    public Long getCreatedBy() { return createdBy; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    @JsonIgnore
    @JsonProperty("created_at")
    public Date getCreatedAt() { return createdAt; }

    public void setUpdatedBy(Long updatedBy) { this.updatedBy = updatedBy; }
    @JsonIgnore
    @JsonProperty("updated_by")
    public Long getUpdatedBy() { return updatedBy; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    @JsonIgnore
    @JsonProperty("updated_at")
    public Date getUpdatedAt() { return updatedAt; }

    public void setDeletedBy(Long deletedBy) { this.deletedBy = deletedBy; }
    @JsonIgnore
    @JsonProperty("deleted_by")
    public Long getDeletedBy() { return deletedBy; }

    public void setDeletedAt(Date deletedAt) { this.deletedAt = deletedAt; }
    @JsonIgnore
    @JsonProperty("deleted_at")
    public Date getDeletedAt() { return deletedAt; }

    public void setReferralMemberList(List<ReferralMember> referralMemberList) { this.referralMemberList = referralMemberList; }
    public List<ReferralMember> getReferralMemberList() { return referralMemberList; }

    public void setToken(String token) { this.token = token; }
    @JsonIgnore
    @JsonProperty("token")
    public String getToken() { return token; }

    @Override
    public String toString() {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

