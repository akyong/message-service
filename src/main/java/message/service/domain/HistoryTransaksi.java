package message.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history_transaksi")
public class HistoryTransaksi {
    public HistoryTransaksi(){}

    public HistoryTransaksi(DestinationBank destinationBank, DompetResellers dompetResellers, Long createdBy, String name){
        this.destinationBank = destinationBank;
        this.dompetResellers = dompetResellers;
        this.createdBy = createdBy;
        this.createdAt = new Date();
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "destination_bank_id")
    private DestinationBank destinationBank;

    @JsonIgnore
    @ManyToOne
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "dompet_resellers_id")
    private DompetResellers dompetResellers;

    @Column(name = "name")
    private String name;

    @Column(name = "created_by")
    private Long createdBy;

    @JsonIgnore
    @Column(name = "created_at")
    private Date createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("destinationBank")
    public DestinationBank getDestinationBank() { return destinationBank; }
    public void setDestinationBank(DestinationBank destinationBank) { this.destinationBank = destinationBank; }

    @JsonProperty("dompetResellers")
    public DompetResellers getDompetResellers() {
        return dompetResellers;
    }

    public void setDompetResellers(DompetResellers dompetResellers) {
        this.dompetResellers = dompetResellers;
    }

    @JsonIgnore
    @JsonProperty("created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("created_by")
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
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
