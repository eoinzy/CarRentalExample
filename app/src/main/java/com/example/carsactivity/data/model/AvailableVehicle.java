package com.example.carsactivity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailableVehicle {

    @SerializedName("@Status")
    @Expose
    private String status;
    @SerializedName("Vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("TotalCharge")
    @Expose
    private TotalCharge totalCharge;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public TotalCharge getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(TotalCharge totalCharge) {
        this.totalCharge = totalCharge;
    }

}