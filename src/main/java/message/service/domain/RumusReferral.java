package message.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "rumus")
public class RumusReferral {

    public RumusReferral(){}

    public RumusReferral(@NotNull int commissionType, @NotNull String formula, @NotNull Long createdBy){
        this.commissionType = commissionType;
        this.formula = formula;
        this.createdBy = createdBy;
        this.createdAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private Long version;

    @JsonIgnore
    @Column(name = "commission_type")
    private int commissionType;

    @JsonIgnore
    @Column(name = "formula")
    private String formula;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonIgnore
    @JsonProperty("version")
    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }

    @JsonProperty("commision_type")
    public int getCommissionType() { return commissionType; }
    public void setCommissionType(int commissionType) { this.commissionType = commissionType; }

    @JsonProperty("formula")
    public String getFormula() { return formula; }
    public void setFormula(String formula) { this.formula = formula; }

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
