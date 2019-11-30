package com.loyalty.lmexpressionmatematicas.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "exp"
})
public class RequestExpression {

    @JsonProperty("exp")
    private String exp;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestExpression() {
    }

    /**
     *
     * @param exp
     */
    public RequestExpression(String exp) {
        super();
        this.exp = exp;
    }

    @JsonProperty("exp")
    public String getExp() {
        return exp;
    }

    @JsonProperty("exp")
    public void setExp(String exp) {
        this.exp = exp;
    }

}
