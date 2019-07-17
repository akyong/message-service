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
@Table(name = "referral_group")
public class ReferralGroup {

    public ReferralGroup(){}

    public ReferralGroup(@NotNull String groupName, String description, @NotNull boolean isActive, @NotNull Long createdBy, @NotNull Date createdAt){
        this.groupName = groupName;
        this.description = description;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @NotNull
    @JsonIgnore
    @Column(name = "name")
    private String groupName;

    @NotNull
    @JsonIgnore
    @Column(name = "info")
    private String description;

    @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive = true;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @JsonIgnore
    @NotNull
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
    @OneToMany(mappedBy = "referralGroup")
    private List<FormulaHeader> formulaHeaderList;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setVersion(int version) { this.version = version; }
    @JsonIgnore
    @JsonProperty("version")
    public int getVersion() { return version; }

    public void setGroupName(String groupName) { this.groupName = groupName; }
    @JsonProperty("group_name")
    public String getGroupName() { return groupName; }

    public void setDescription(String description) { this.description = description; }
    @JsonProperty("description")
    public String getDescription() { return description; }

    public void setIsActive(boolean active) { isActive = active; }
    @JsonIgnore
    @JsonProperty("is_active")
    public boolean getIsActive() { return isActive; }

    public void setDeleted(boolean deleted) { isDeleted = deleted; }
    @JsonProperty("is_deleted")
    public boolean isDeleted() { return isDeleted; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    @JsonIgnore
    @JsonProperty("created_at")
    public Date getCreatedAt() { return createdAt; }

    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }
    @JsonIgnore
    @JsonProperty("created_by")
    public Long getCreatedBy() { return createdBy; }

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

    public void setFormulaHeaderList(List<FormulaHeader> formulaHeaderList) { this.formulaHeaderList = formulaHeaderList; }
    public List<FormulaHeader> getFormulaHeaderList() { return formulaHeaderList; }

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
