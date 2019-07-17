package message.service.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceDetail {
    public PriceDetail(){

    }
    @JsonProperty("qty")
    private int qty;

    @JsonProperty("markup_price")
    private int markupPrice;

//    @JsonProperty("master_agent_commision")
//    private int masterAgentCommision;

    @JsonProperty("agent_commision")
    private int agentCommision;

    @JsonProperty("discount_member")
    private int discountMember;

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

//    public void setMasterAgentCommision(int masterAgentCommision) {
//        this.masterAgentCommision = masterAgentCommision;
//    }
//    public int getMasterAgentCommision() {
//        return masterAgentCommision;
//    }

    public void setAgentCommision(int agentCommision) {
        this.agentCommision = agentCommision;
    }

    public int getAgentCommision() {
        return agentCommision;
    }

    public void setDiscountMember(int discountMember) {
        this.discountMember = discountMember;
    }

    public int getDiscountMember() {
        return discountMember;
    }

    public void setMarkupPrice(int markupPrice) {
        this.markupPrice = markupPrice;
    }

    public int getMarkupPrice() {
        return markupPrice;
    }
}
