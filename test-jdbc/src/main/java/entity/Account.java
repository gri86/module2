package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    @JsonProperty
    private String id;

    @JsonProperty("credential_id")
    private String credentialId;

    @JsonProperty
    private String number;

    @JsonProperty
    private String holder;

    @JsonProperty
    private Double amount;


    public Account(){}

    public Account(String id, String credentialId, String number, String holder, Double amount) {
        this.id = id;
        this.credentialId = credentialId;
        this.number = number;
        this.holder = holder;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(String credentialId) {
        this.credentialId = credentialId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
