package com.example.carsactivity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TotalCharge implements Serializable {

    @SerializedName("@RateTotalAmount")
    @Expose
    private String rateTotalAmount;
    @SerializedName("@EstimatedTotalAmount")
    @Expose
    private String estimatedTotalAmount;
    @SerializedName("@CurrencyCode")
    @Expose
    private String currencyCode;

    public String getRateTotalAmount() {
        return rateTotalAmount;
    }

    public void setRateTotalAmount(String rateTotalAmount) {
        this.rateTotalAmount = rateTotalAmount;
    }

    public String getEstimatedTotalAmount() {
        return estimatedTotalAmount;
    }

    public void setEstimatedTotalAmount(String estimatedTotalAmount) {
        this.estimatedTotalAmount = estimatedTotalAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}