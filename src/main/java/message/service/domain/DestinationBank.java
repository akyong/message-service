package message.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "destination_bank")
public class DestinationBank {
    public DestinationBank(){}

    public DestinationBank(String nameBank, String name, Long resellerId, Character typeBank, Long kodeRek, Long createdBy){
        this.nameBank = nameBank;
        this.name = name;
        this.resellerId = resellerId;
        this.typeBank = typeBank;
        this.kodeRek = kodeRek;
        this.createdBy = createdBy;
        this.createdAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @Version
    private int version;

    @JsonIgnore
    @Column (name = "resellerId")
    private Long resellerId;

    @JsonIgnore
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Column(name = "name_bank")
    private String nameBank;

    @JsonIgnore
    @Column(name = "type_bank", length = 1)
    private Character typeBank;

    @JsonIgnore
    @Column(name = "kode_rek", unique = true)
    private Long kodeRek;

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

//    @OneToMany(mappedBy = "destinationBank")
//    private List<HistoryTransaksi> historyTransaksiList = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public void setResellerId(Long resellerId) {
        this.resellerId = resellerId;
    }
    @JsonProperty("reseller_id")
    public Long getResellerId() {
        return resellerId;
    }


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @JsonProperty("version")
    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }

    @JsonProperty("name_bank")
    public String getNameBank() { return nameBank; }
    public void setNameBank(String nameBank) { this.nameBank = nameBank; }


    public Character getTypeBank() { return typeBank; }
    public void setTypeBank(Character typeBank) { this.typeBank = typeBank; }

    @JsonProperty("code_rek")
    public Long getKodeRek() { return kodeRek; }
    public void setKodeRek(Long kodeRek) { this.kodeRek = kodeRek; }

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

//    public List<HistoryTransaksi> getHistoryTransaksiList() { return historyTransaksiList; }
//    public void setHistoryTransaksiList(List<HistoryTransaksi> historyTransaksiList) { this.historyTransaksiList = historyTransaksiList; }

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
