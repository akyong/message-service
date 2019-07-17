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
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "formula_header")
public class FormulaHeader {
    public FormulaHeader(){}

    public FormulaHeader(@NotNull String name,@NotNull String description, @NotNull int maxLevelNumber, @NotNull int maxLevelPrice, @NotNull Long createdBy, @NotNull Date createdAt, ReferralGroup referralGroup){
        this.name = name;
        this.description = description;
        this.maxLevelNumber = maxLevelNumber;
        this.maxLevelPrice = maxLevelPrice;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.referralGroup = referralGroup;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @JsonIgnore
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @Column(name = "max_lv_number")
    private int maxLevelNumber;

    @JsonIgnore
    @Column(name = "max_lv_price")
    private int maxLevelPrice;

    @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive = true;

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

    @OneToMany(mappedBy = "formulaHeader",cascade = CascadeType.ALL)
    @Where(clause = "is_deleted = false")
    private List<FormulaDetailPrice> formulaDetailPriceList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "formulaHeader",cascade = CascadeType.ALL)
    private List<Permission> permissionList;

    @ManyToOne
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "group_id")
    private ReferralGroup referralGroup;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setVersion(int version) { this.version = version; }
    @JsonIgnore
    @JsonProperty("version")
    public int getVersion() { return version; }

    public void setName(String name) { this.name = name; }
    @JsonProperty("name")
    public String getName() { return name; }

    public void setDescription(String description) { this.description = description; }
    @JsonProperty("description")
    public String getDescription() { return description; }

    public void setMaxLevelNumber(int maxLevelNumber) { this.maxLevelNumber = maxLevelNumber; }
    @JsonProperty("max_lv_number")
    public int getMaxLevelNumber() { return maxLevelNumber; }

    public void setMaxLevelPrice(int maxLevelPrice) { this.maxLevelPrice = maxLevelPrice; }
    @JsonProperty("max_lv_price")
    public int getMaxLevelPrice() { return maxLevelPrice; }

    public void setActive(boolean active) { isActive = active; }
    @JsonIgnore
    @JsonProperty("is_active")
    public boolean isActive() { return isActive; }

    public void setIsDeleted(boolean isDeleted) { this.isDeleted = isDeleted; }
    @JsonIgnore
    @JsonProperty("is_deleted")
    public boolean isDeleted() { return isDeleted; }


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

    public void setReferralGroup(ReferralGroup referralGroup) { this.referralGroup = referralGroup; }
    @JsonProperty("group_id")
    public ReferralGroup getReferralGroup() { return referralGroup; }


    public void setFormulaDetailPriceList(List<FormulaDetailPrice> formulaDetailPriceList) { this.formulaDetailPriceList = formulaDetailPriceList; }
    @JsonProperty("formula_detail_price_list")
    public List<FormulaDetailPrice> getFormulaDetailPriceList() { return formulaDetailPriceList; }

    public List<Permission> getPermissionList() { return permissionList; }
    public void setPermissionList(List<Permission> permissionList) { this.permissionList = permissionList; }

    public void addFormulaDetailPrice(FormulaDetailPrice formulaDetailPrice) {
        formulaDetailPriceList.add(formulaDetailPrice);
        formulaDetailPrice.setFormulaHeader(this);
    }

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
