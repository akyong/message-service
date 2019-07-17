package message.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "reseller")
public class DompetResellers {

    public DompetResellers(){}

    public DompetResellers(@NotNull String resellerCode, @NotNull Long resellerId, @NotNull String type_r, @NotNull Long total, @NotNull String refDb, @NotNull String refTable, @NotNull Long refId, @NotNull Long createdBy, @NotNull Long totalSaldo, @NotNull boolean isPending){
        this.resellerCode = resellerCode;
        this.resellerId = resellerId;
        this.type_r = type_r;
        this.total = total;
        this.refDb = refDb;
        this.refTable = refTable;
        this.refId = refId;
        this.createdBy = createdBy;
        this.createdAt = new Date();
        this.totalSaldo = totalSaldo;
        this.isPending = isPending;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private Long version;

    @Column(name = "reseller_code",nullable = false, unique = true)
    private String resellerCode;

    @Column(name = "reseller_id")
    private Long resellerId;

    @Column(name = "type")
    private String type_r;

    @Column(name = "total")
    private Long total;

    @Column (name = "ref_db")
    private String refDb;

    @Column (name = "ref_table")
    private String refTable;

    @Column (name = "ref_id")
    private Long refId;

//    @JsonIgnore
//    @Convert(converter = JpaConverterJson.class)
//    @Column(name = "ref_data", columnDefinition = "json")
//    private Map<String, Object> refData;

    @Column (name = "ref_data", columnDefinition = "json")
    private String refData;

    @JsonIgnore
    @Column(name = "is_pending")
    private boolean isPending = false;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

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
    @Column (name = "deleted_by")
    private Long deletedBy;

    @JsonIgnore
    @Column(name = "deleted_at")
    private Date deletedAt;

    @JsonIgnore
    @Column (name = "total_saldo")
    private Long totalSaldo;

//    @OneToMany(mappedBy = "dompetResellers")
//    private List<HistoryTransaksi> historyTransaksiList = new ArrayList<>();

    @JsonIgnore
    @JsonProperty("ref_data")
    public String getRefData() { return refData;}
    public void setRefData(String refData) {
        this.refData = refData;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonIgnore
    @JsonProperty("version")
    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }

    @JsonProperty("reseller_code")
    public String getResellerCode() {
        return resellerCode;
    }
    public void setResellerCode(String resellerCode) {
        this.resellerCode = resellerCode;
    }


    @JsonProperty("reseller_id")
    public Long getResellerId() {
        return resellerId;
    }
    public void setResellerId(Long resellerId) {
        this.resellerId = resellerId;
    }

    @JsonProperty("type")
    public String getType_r() {
        return type_r;
    }
    public void setType_r(String type_r) {
        this.type_r = type_r;
    }

    @JsonProperty("total")
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }

    @JsonIgnore
    @JsonProperty("ref_db")
    public String getRefDb() {
        return refDb;
    }
    public void setRefDb(String refDb) {
        this.refDb = refDb;
    }

    @JsonIgnore
    @JsonProperty("ref_table")
    public String getRefTable() {
        return refTable;
    }
    public void setRefTable(String refTable) {
        this.refTable = refTable;
    }

    @JsonIgnore
    @JsonProperty("ref_id")
    public Long getRefId() {
        return refId;
    }
    public void setRefId(Long refId) {
        this.refId = refId;
    }


    @JsonProperty("total_saldo")
    public Long getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(Long totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

//    @JsonIgnore
//    @JsonProperty("ref_data")
//    public Map<String, Object> getRefData() {
//        return refData;
//    }
//
//    public void setRefData(Map<String, Object> refData) {
//        this.refData = refData;
//    }

    @JsonProperty("is_pending")
    public boolean getIsPending() {
        return isPending;
    }
    public void setIsPending(boolean pending) {
        isPending = pending;
    }


    @JsonIgnore
    @JsonProperty("is_deleted")
    public boolean getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(boolean deleted) {
        isDeleted = deleted;
    }


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
    public Long getDeletedBy() {
        return deletedBy;
    }
    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    @JsonIgnore
    @JsonProperty("deleted_at")
    public Date getDeletedAt() { return deletedAt; }
    public void setDeletedAt(Date deletedAt) { this.deletedAt = deletedAt; }

//    public List<HistoryTransaksi> getHistoryTransaksiList() {
//        return historyTransaksiList;
//    }
//    public void setHistoryTransaksiList(List<HistoryTransaksi> historyTransaksiList) {
//        this.historyTransaksiList = historyTransaksiList;
//    }

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