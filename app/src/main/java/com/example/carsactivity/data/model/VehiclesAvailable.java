package com.example.carsactivity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehiclesAvailable {

    @SerializedName("VehAvailRSCore")
    @Expose
    private VehicleRental vehicleRental;

    public VehicleRental getVehicleRental() {
        return vehicleRental;
    }

    public void setVehicleRental(VehicleRental vehicleRental) {
        this.vehicleRental = vehicleRental;
    }
}