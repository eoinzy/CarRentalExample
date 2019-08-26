package com.example.carsactivity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SearchResult implements Serializable {
    @SerializedName("VehRentalCore")
    @Expose
    private VehicleRentalInfo vehicleRentalInfo;
    @SerializedName("@Name")
    @Expose
    private Vendor vendor;
    @SerializedName("@Status")
    @Expose
    private String status;
    @SerializedName("Vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("TotalCharge")
    @Expose
    private TotalCharge totalCharge;

    public VehicleRentalInfo getVehicleRentalInfo() {
        return vehicleRentalInfo;
    }

    public void setVehicleRentalInfo(VehicleRentalInfo vehicleRentalInfo) {
        this.vehicleRentalInfo = vehicleRentalInfo;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

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
