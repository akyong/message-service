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

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "referral_member")
public class ReferralMember {

    public ReferralMember(){}

    public ReferralMember(Long memberId, String memberCode, Long createdBy, Referral referral, String memberName, Date joinDate){
        this.memberId = memberId;
        this.memberCode = memberCode;
        this.createdBy = createdBy;
        this.referral = referral;
        this.createdAt = new Date();
        this.komisi = 0;
        this.memberName = memberName;
        this.joinDate = joinDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private Long version;

    @JsonIgnore
    @Column(name = "member_id")
    private Long memberId;

    @JsonIgnore
    @Column(name = "member_code")
    private String memberCode;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @JsonIgnore
    @Column(name = "created_by")
    private Long createdBy;

    @JsonIgnore
    @Column(name = "created_at")
    private Date createdAt;

    @JsonIgnore
    @Column(name = "updated_at")
    private Date updatedAt;

    @JsonIgnore
    @Column(name = "updated_by")
    private Long updatedBy;

    @JsonIgnore
    @Column(name = "deleted_at")
    private Date deletedAt;

    @JsonIgnore
    @Column(name = "deleted_by")
    private Long deletedBy;

    @JsonIgnore
    @Column(name = "commission")
    private int komisi;

    @JsonIgnore
    @Column(name = "member_name")
    private String memberName;

    @JsonIgnore
    @Column(name = "join_date")
    private Date joinDate;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "referral_id")
    private Referral referral;

    public void setKomisi(int komisi) {
        this.komisi = komisi;
    }
    @JsonProperty("commission")
    public int getKomisi() {
        return komisi;
    }

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setVersion(Long version) { this.version = version; }
    @JsonIgnore
    public Long getVersion() { return version; }

    public void setMemberId(Long memberId) { this.memberId = memberId; }
    @JsonProperty("member_id")
    public Long getMemberId() { return memberId; }

    public void setMemberCode(String memberCode) { this.memberCode = memberCode; }
    @JsonProperty("member_code")
    public String getMemberCode() { return memberCode; }

    @JsonIgnore
    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean deleted) { isDeleted = deleted; }

    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
    @JsonIgnore
    public Long getCreatedBy() { return createdBy; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    @JsonIgnore
    @JsonProperty("created_at")
    public Date getCreatedAt() { return createdAt; }


    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    @JsonIgnore
    @JsonProperty("updated_by")
    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    @JsonIgnore
    @JsonProperty("updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @JsonIgnore
    public Long getDeletedBy() { return deletedBy; }
    public void setDeletedBy(Long deletedBy) { this.deletedBy = deletedBy; }

    @JsonIgnore
    public Date getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Date deletedAt) { this.deletedAt = deletedAt; }

    public void setReferral(Referral referral) { this.referral = referral; }
    @JsonProperty("referra_id")
    public Referral getReferral() { return referral; }

    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }
    @JsonProperty("join_date")
    public Date getJoinDate() { return joinDate; }

    public void setMemberName(String memberName) { this.memberName = memberName; }
    @JsonProperty("member_name")
    public String getMemberName() { return memberName; }

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
