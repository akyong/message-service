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
import java.util.Date;

@Entity
@Table(name = "formula_detail_qty")
public class FormulaDetailQty {

    public FormulaDetailQty(){}

    public FormulaDetailQty(@NotNull int minQty, @NotNull int maxQty, @NotNull float markupPrice, @NotNull float officialCommision, @NotNull float agentCommision, @NotNull float discountMember, FormulaDetailPrice formulaDetailPrice){
        this.minQty = minQty;
        this.maxQty = maxQty;
        this.markupPrice = markupPrice;
        this.officialCommision = officialCommision;
        this.agentCommision = agentCommision;
        this.discountMember = discountMember;
        this.formulaDetailPrice = formulaDetailPrice;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @JsonIgnore
    @NotNull
    @Column(name = "min_qty")
    private int minQty;

    @JsonIgnore
    @NotNull
    @Column(name = "max_qty")
    private int maxQty;

    @JsonIgnore
    @NotNull
    @Column(name = "markup_price")
    private float markupPrice;

    /**
     * @param
     * */
    @JsonIgnore
    @NotNull
    @Column(name = "official_commision")
    private float officialCommision;

    @JsonIgnore
    @NotNull
    @Column(name = "agent_commision")
    private float agentCommision;

    @JsonIgnore
    @NotNull
    @Column(name = "discount_member")
    private float discountMember;

    @JsonIgnore
    @Column(name = "updated_by")
    private Long updatedBy;

    @JsonIgnore
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "formula_detail_price_id")
    private FormulaDetailPrice formulaDetailPrice;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setVersion(int version) { this.version = version; }
    @JsonProperty("version")
    public int getVersion() { return version; }

    public void setMinQty(int minQty) { this.minQty = minQty; }
    @JsonProperty("min_qty")
    public int getMinQty() { return minQty; }

    public void setMaxQty(int maxQty) { this.maxQty = maxQty; }
    @JsonProperty("max_qty")
    public int getMaxQty() { return maxQty; }

    public void setMarkupPrice(float markupPrice) { this.markupPrice = markupPrice; }
    @JsonProperty("markup_price")
    public float getMarkupPrice() { return markupPrice; }

    public void setOfficialCommision(float officialCommision) { this.officialCommision = officialCommision; }
    @JsonProperty("official_commission")
    public float getOfficialCommision() { return officialCommision; }

    public void setAgentCommision(float agentCommision) { this.agentCommision = agentCommision; }
    @JsonProperty("agent_commission")
    public float getAgentCommision() { return agentCommision; }

    public void setDiscountMember(float discountMember) { this.discountMember = discountMember; }
    @JsonProperty("discount_member")
    public float getDiscountMember() { return discountMember; }

    public void setUpdatedBy(Long updatedBy) { this.updatedBy = updatedBy; }
    @JsonIgnore
    @JsonProperty("updated_by")
    public Long getUpdatedBy() { return updatedBy; }

    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    @JsonIgnore
    @JsonProperty("updated_at")
    public Date getUpdatedAt() { return updatedAt; }

    public void setFormulaDetailPrice(FormulaDetailPrice formulaDetailPrice) { this.formulaDetailPrice = formulaDetailPrice; }
    @JsonProperty("formula_detail_price")
    public FormulaDetailPrice getFormulaDetailPrice() { return formulaDetailPrice; }


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
