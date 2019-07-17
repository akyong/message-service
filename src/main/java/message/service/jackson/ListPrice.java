package message.service.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ListPrice {
    public ListPrice(){

    }
    @JsonProperty("price")
    private List<PriceDetail> price = new ArrayList<>();

    @JsonProperty("supplier")
    private List<ListPriceSupDetail> supplier = new ArrayList<>();

    public void setPrice(List<PriceDetail> price) {
        this.price = price;
    }

    public List<PriceDetail> getPrice() {
        return price;
    }

    public void setSupplier(List<ListPriceSupDetail> supplier) {
        this.supplier = supplier;
    }

    public List<ListPriceSupDetail> getSupplier() {
        return supplier;
    }

    public void addListPrice(PriceDetail priceDetail){
        price.add(priceDetail);
    }

    public void addListSupplier(ListPriceSupDetail listPriceSupDetail){
        supplier.add(listPriceSupDetail);
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
