package message.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "amount_saldo")
public class TotalSaldo {
    public TotalSaldo(){}

    public TotalSaldo(Long totalSaldo, Long createdBy){
        this.totalSaldo = totalSaldo;
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
    @Column(name = "total_saldo")
    private Long totalSaldo;

    @JsonIgnore
    @Column(name = "created_by")
    private Long createdBy;

    @JsonIgnore
    @Column(name = "created_at")
    private Date createdAt;

//    @JsonIgnore
//    @Column(name = "is_deleted")
//    private boolean isDeleted;
//
//    @JsonIgnore
//    @Column(name = "deleted_by")
//    private Long deletedBy;
//
//    @JsonIgnore
//    @Column(name = "deleted_at")
//    private Date deletedAt;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonIgnore
    @JsonProperty("version")
    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }

    @JsonProperty("total_saldo")
    public Long getTotalSaldo() { return totalSaldo; }
    public void setTotalSaldo(Long totalSaldo) { this.totalSaldo = totalSaldo; }

    @JsonIgnore
    @JsonProperty("created_by")
    public Long getCreatedBy() { return createdBy; }
    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }

    @JsonIgnore
    @JsonProperty("created_at")
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

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
