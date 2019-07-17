package message.service.jackson;

public class ProductDetail {

    public ProductDetail(){}

    private Long id;
    private String productCode;
    private Integer supplierId;
    private Integer sub_menu_id;
    private Integer sub_menucategory_id;
    private Object qty;
    private int price;
    private Long product_detail_id;
    private String product_name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public Integer getSupplierId() { return supplierId; }
    public void setSupplierId(Integer supplierId) { this.supplierId = supplierId; }

    public Integer getSub_menu_id() { return sub_menu_id; }
    public void setSub_menu_id(Integer sub_menu_id) { this.sub_menu_id = sub_menu_id; }

    public Integer getSub_menucategory_id() { return sub_menucategory_id; }
    public void setSub_menucategory_id(Integer sub_menucategory_id) { this.sub_menucategory_id = sub_menucategory_id; }

    public Object getQty() { return qty; }
    public void setQty(Object qty) { this.qty = qty; }

    public int getPrice() { return price; }
    public int setPrice(int price) { this.price = price;
        return price;
    }

    public Long getProduct_detail_id() { return product_detail_id; }
    public void setProduct_detail_id(Long product_detail_id) { this.product_detail_id = product_detail_id; }

    public String getProduct_name() { return product_name; }
    public void setProduct_name(String product_name) { this.product_name = product_name; }

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
