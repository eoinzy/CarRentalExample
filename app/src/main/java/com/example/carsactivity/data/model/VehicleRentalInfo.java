package com.example.carsactivity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehicleRentalInfo implements Serializable {

    @SerializedName("@PickUpDateTime")
    @Expose
    private String pickUpDateTime;
    @SerializedName("@ReturnDateTime")
    @Expose
    private String returnDateTime;
    @SerializedName("PickUpLocation")
    @Expose
    private Location pickupLocation;
    @SerializedName("ReturnLocation")
    @Expose
    private Location returnLocation;

    public String getPickUpDateTime() {
        return pickUpDateTime;
    }

    public void setPickUpDateTime(String pickUpDateTime) {
        this.pickUpDateTime = pickUpDateTime;
    }

    public String getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(String returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(Location returnLocation) {
        this.returnLocation = returnLocation;
    }
}