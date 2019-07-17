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
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "formula_detail_price")
public class FormulaDetailPrice {

    public FormulaDetailPrice(){}

    public FormulaDetailPrice(@NotNull Long priceFrom, @NotNull Long priceTo, @NotNull int maxQtyWholeSale, @NotNull float markupPrice, @NotNull float officialCommission, @NotNull float agentCommission, @NotNull float discountMember,@NotNull Long createdBy, @NotNull Date createdAt , @NotNull FormulaHeader formulaHeader){
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.maxQtyWholeSale = maxQtyWholeSale;
        this.markupPrice = markupPrice;
        this.officialCommission = officialCommission;
        this.agentCommission = agentCommission;
        this.discountMember = discountMember;
        this.createdBy = createdBy;
        this.createdAt =createdAt;
        this.formulaHeader = formulaHeader;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @JsonIgnore
    @Column(name = "price_from")
    private Long priceFrom;

    @JsonIgnore
    @Column(name = "price_to")
    private Long priceTo;

    @JsonIgnore
    @Column(name = "max_qty_whole_sale")
    private int maxQtyWholeSale;

    @JsonIgnore
    @Column(name = "markup_price")
    private float markupPrice;

    @JsonIgnore
    @Column(name = "official_commission")
    private float officialCommission;

    @JsonIgnore
    @Column(name = "agent_commission")
    private float agentCommission;

    @JsonIgnore
    @Column(name = "discount_member")
    private float discountMember;

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

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "formula_header_id")
    private FormulaHeader formulaHeader;

    @OneToMany(mappedBy = "formulaDetailPrice",cascade = CascadeType.ALL)
    List<FormulaDetailQty> formulaDetailQtyList = new ArrayList<>();

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setVersion(int version) { this.version = version; }
    @JsonIgnore
    @JsonProperty("version")
    public int getVersion() { return version; }

    public void setPriceFrom(Long priceFrom) { this.priceFrom = priceFrom; }
    @JsonProperty("price_from")
    public Long getPriceFrom() { return priceFrom; }

    public void setPriceTo(Long priceTo) { this.priceTo = priceTo; }
    @JsonProperty("price_to")
    public Long getPriceTo() { return priceTo; }

    public void setMaxQtyWholeSale(int maxQtyWholeSale) { this.maxQtyWholeSale = maxQtyWholeSale; }
    @JsonProperty("max_qty_whole_sale")
    public int getMaxQtyWholeSale() { return maxQtyWholeSale; }

    public void setMarkupPrice(float markupPrice) { this.markupPrice = markupPrice; }
    @JsonProperty("markup_price")
    public float getMarkupPrice() { return markupPrice; }

    public void setOfficialCommission(float officialCommission) { this.officialCommission = officialCommission; }
    @JsonProperty("official_commission")
    public float getOfficialCommission() { return officialCommission; }

    public void setAgentCommission(float agentCommission) { this.agentCommission = agentCommission; }
    @JsonProperty("agent_commission")
    public float getAgentCommission() { return agentCommission; }

    public void setDiscountMember(float discountMember) { this.discountMember = discountMember; }
    @JsonProperty("discount_member")
    public float getDiscountMember() { return discountMember; }

    public void setIsDeleted(boolean deleted) { isDeleted = deleted; }
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

    public void setFormulaDetailQtyList(List<FormulaDetailQty> formulaDetailQtyList) { this.formulaDetailQtyList = formulaDetailQtyList; }
    public List<FormulaDetailQty> getFormulaDetailQtyList() { return formulaDetailQtyList; }

    public void setFormulaHeader(FormulaHeader formulaHeader) { this.formulaHeader = formulaHeader; }
    @JsonProperty("formula_header")
    public FormulaHeader getFormulaHeader() { return formulaHeader; }

    public void addFormulaDetailQty(FormulaDetailQty formulaDetailQty) {
        formulaDetailQtyList.add(formulaDetailQty);
        formulaDetailQty.setFormulaDetailPrice(this);
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
