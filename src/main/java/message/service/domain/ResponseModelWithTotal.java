package message.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.inject.Singleton;

@Singleton
public class ResponseModelWithTotal extends ResponseModel {
    @JsonProperty("total_count")
    private Long totalCount;

    public void setTotalCount(Long totalCount) { this.totalCount = totalCount; }

    public Long getTotalCount() { return totalCount; }

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
