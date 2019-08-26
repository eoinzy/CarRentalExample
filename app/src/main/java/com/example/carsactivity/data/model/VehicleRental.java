package com.example.carsactivity.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleRental {

    @SerializedName("VehRentalCore")
    @Expose
    private VehicleRentalInfo vehicleRentalInfo;
    @SerializedName("VehVendorAvails")
    @Expose
    private List<VendorAvailability> vendorAvailabilities = null;

    public VehicleRentalInfo getVehicleRentalInfo() {
        return vehicleRentalInfo;
    }

    public void setVehicleRentalInfo(VehicleRentalInfo vehicleRentalInfo) {
        this.vehicleRentalInfo = vehicleRentalInfo;
    }

    public List<VendorAvailability> getVendorAvailabilities() {
        return vendorAvailabilities;
    }

    public void setVendorAvailabilities(List<VendorAvailability> vendorAvailabilities) {
        this.vendorAvailabilities = vendorAvailabilities;
    }
}