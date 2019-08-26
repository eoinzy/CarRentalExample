package com.example.carsactivity.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorAvailability {

    @SerializedName("Vendor")
    @Expose
    private Vendor vendor;
    @SerializedName("VehAvails")
    @Expose
    private List<AvailableVehicle> availableVehicles = null;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<AvailableVehicle> getAvailableVehicles() {
        return availableVehicles;
    }

    public void setAvailableVehicles(List<AvailableVehicle> availableVehicles) {
        this.availableVehicles = availableVehicles;
    }

}