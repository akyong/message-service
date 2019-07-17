package message.service.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ListPriceSupDetail{
    public ListPriceSupDetail(){

    }

    @JsonProperty("supplier_code")
    private String supplier_code;

    @JsonProperty("price")
    private List<PriceDetail> priceS = new ArrayList<>();

    public String getSupplier_code() {
        return supplier_code;
    }

    public void setSupplier_code(String supplier_code) {
        this.supplier_code = supplier_code;
    }

    public List<PriceDetail> getPrice() {
        return priceS;
    }

    public void setPrice(List<PriceDetail> priceS) {
        this.priceS = priceS;
    }

    public void addListPrice(PriceDetail priceDetail){
        priceS.add(priceDetail);
    }
}
