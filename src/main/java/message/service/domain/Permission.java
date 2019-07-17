package message.service.domain;

import com.fasterxml.jackson.annotation.*;
import message.service.helper.JpaConverterJson;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "permissions")
public class Permission {

    public Permission(){}

    public Permission(@NotNull boolean isSupplier, @NotNull List<Integer> subCategory, @NotNull String categoryName,  Long supplierId, String supplierCode, @NotNull Long createdBy, FormulaHeader formulaHeader){
        this.isSupplier = isSupplier;
        this.subCategory = subCategory;
        this.categoryName = categoryName;
        this.supplierId = supplierId;
        this.supplierCode = supplierCode;
        this.createdBy = createdBy;
        this.formulaHeader = formulaHeader;
        this.createdAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @JsonIgnore
    @Column(name = "is_supplier")
    private boolean isSupplier;


    @JsonIgnore
    @Convert(converter = JpaConverterJson.class)
    @Column(name = "sub_category", columnDefinition = "json")
    private List<Integer> subCategory = new ArrayList<>();

    @JsonIgnore
    @Column(name = "category_name")
    private String categoryName;

    @JsonIgnore
    @Column(name = "supplier_id", unique = true)
    private Long supplierId;

    @JsonIgnore
    @Column(name = "supplier_code", unique = true)
    private String supplierCode;

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

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "formula_id")
    private FormulaHeader formulaHeader;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonIgnore
    @JsonProperty("version")
    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }

    @JsonProperty("is_supplier")
    public boolean isSupplier() { return isSupplier; }
    public void setSupplier(boolean supplier) { isSupplier = supplier; }

    @JsonProperty("sub_category")
    public List<Integer> getSubCategory() { return subCategory; }
    public void setSubCategory(List<Integer> subCategory) { this.subCategory = subCategory; }

    @JsonProperty("category_name")
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    @JsonProperty("supplier_id")
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    @JsonProperty("supplier_code")
    public String getSupplierCode() { return supplierCode; }
    public void setSupplierCode(String supplierCode) { this.supplierCode = supplierCode; }

    @JsonIgnore
    @JsonProperty("is_active")
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @JsonIgnore
    @JsonProperty("is_deleted")
    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean deleted) { isDeleted = deleted; }

    @JsonIgnore
    @JsonProperty("created_by")
    public Long getCreatedBy() { return createdBy; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }

    @JsonIgnore
    @JsonProperty("created_at")
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    @JsonIgnore
    @JsonProperty("updated_by")
    public Long getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(Long updatedBy) { this.updatedBy = updatedBy; }

    @JsonIgnore
    @JsonProperty("updated_at")
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    @JsonIgnore
    @JsonProperty("deleted_by")
    public Long getDeletedBy() { return deletedBy; }
    public void setDeletedBy(Long deletedBy) { this.deletedBy = deletedBy; }

    @JsonIgnore
    @JsonProperty("deleted_at")
    public Date getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Date deletedAt) { this.deletedAt = deletedAt; }

    @JsonProperty("formula_header")
    public FormulaHeader getFormulaHeader() { return formulaHeader; }
    public void setFormulaHeader(FormulaHeader formulaHeader) { this.formulaHeader = formulaHeader; }


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
