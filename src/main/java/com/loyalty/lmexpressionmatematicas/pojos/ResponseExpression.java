package com.loyalty.lmexpressionmatematicas.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "INFIX_EXPRESSION",
        "POSTFIX_EXPRESSION",
        "VALUE"
})
public class ResponseExpression {

    @JsonProperty("INFIX_EXPRESSION")
    private String iNFIXEXPRESSION;
    @JsonProperty("POSTFIX_EXPRESSION")
    private String pOSTFIXEXPRESSION;
    @JsonProperty("VALUE")
    private String vALUE;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseExpression() {
    }

    /**
     *
     * @param pOSTFIXEXPRESSION
     * @param iNFIXEXPRESSION
     * @param vALUE
     */
    public ResponseExpression(String iNFIXEXPRESSION, String pOSTFIXEXPRESSION, String vALUE) {
        super();
        this.iNFIXEXPRESSION = iNFIXEXPRESSION;
        this.pOSTFIXEXPRESSION = pOSTFIXEXPRESSION;
        this.vALUE = vALUE;
    }

    @JsonProperty("INFIX_EXPRESSION")
    public String getINFIXEXPRESSION() {
        return iNFIXEXPRESSION;
    }

    @JsonProperty("INFIX_EXPRESSION")
    public void setINFIXEXPRESSION(String iNFIXEXPRESSION) {
        this.iNFIXEXPRESSION = iNFIXEXPRESSION;
    }

    @JsonProperty("POSTFIX_EXPRESSION")
    public String getPOSTFIXEXPRESSION() {
        return pOSTFIXEXPRESSION;
    }

    @JsonProperty("POSTFIX_EXPRESSION")
    public void setPOSTFIXEXPRESSION(String pOSTFIXEXPRESSION) {
        this.pOSTFIXEXPRESSION = pOSTFIXEXPRESSION;
    }

    @JsonProperty("VALUE")
    public String getVALUE() {
        return vALUE;
    }

    @JsonProperty("VALUE")
    public void setVALUE(String vALUE) {
        this.vALUE = vALUE;
    }

}
