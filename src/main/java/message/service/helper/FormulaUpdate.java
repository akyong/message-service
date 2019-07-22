package message.service.helper;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FormulaUpdate {

    String supplierCode;

    List<Integer> categoryId;

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setCategoryId(List<Integer> categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("categoryId")
    public List<Integer> getCategoryId() {
        return categoryId;
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
