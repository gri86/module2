package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtmVolume {
    @JsonProperty
    private String id;

    @JsonProperty("atm_id")
    private String atmId;

    @JsonProperty
    private Integer rate;

    @JsonProperty
    private Integer amount;

    public AtmVolume(){}

    public AtmVolume(String id, String atmId, Integer rate, Integer amount) {
        this.id = id;
        this.atmId = atmId;
        this.rate = rate;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
