package message.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "withdraw_dana")
public class WithdrawDana {
    public WithdrawDana(){}

    public WithdrawDana(Long withdrawFunds, Long withdrawBy){
        this.withdrawFunds = withdrawFunds;
        this.withdrawBy = withdrawBy;
        this.withdrawAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @JsonIgnore
    @Column(name = "withdraw_funds")
    private Long withdrawFunds;

//    @JsonIgnore
//    @NotNull
//    @Column(name = "history_id")
//    private int historyId;
//
//    @JsonIgnore
//    @NotNull
//    @Column(name = "bank_id")
//    private float bankId;

    @JsonIgnore
    @Column(name = "withdraw_by")
    private Long withdrawBy;

    @JsonIgnore
    @Column(name = "withdraw_at")
    private Date withdrawAt;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @JsonIgnore
    @Column(name = "deleted_by")
    private Long deletedBy;

    @JsonIgnore
    @Column(name = "deleted_at")
    private Date deletedAt;

    @JsonIgnore
    @Column(name = "updated_by")
    private Long updatedBy;

    @JsonIgnore
    @Column(name = "updated_at")
    private Date updatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonIgnore
    @JsonProperty("version")
    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }

    @JsonProperty("withdraw_funds")
    public Long getWithdrawFunds() { return withdrawFunds; }
    public void setWithdrawFunds(Long withdrawFunds) { this.withdrawFunds = withdrawFunds; }

    @JsonIgnore
    @JsonProperty("withdraw_by")
    public Long getWithdrawBy() { return withdrawBy; }
    public void setWithdrawBy(Long withdrawBy) { this.withdrawBy = withdrawBy; }

    @JsonIgnore
    @JsonProperty("withdraw_at")
    public Date getWithdrawAt() { return withdrawAt; }
    public void setWithdrawAt(Date withdrawAt) { this.withdrawAt = withdrawAt; }

    @JsonIgnore
    @JsonProperty("is_deleted")
    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean deleted) { isDeleted = deleted; }

    @JsonIgnore
    @JsonProperty("deleted_by")
    public Long getDeletedBy() { return deletedBy; }
    public void setDeletedBy(Long deletedBy) { this.deletedBy = deletedBy; }

    @JsonIgnore
    @JsonProperty("updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    @JsonProperty("updated_by")
    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

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
