package com.example.carsactivity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Vehicle implements Serializable {

    @SerializedName("@AirConditionInd")
    @Expose
    private String airConditionInd;
    @SerializedName("@TransmissionType")
    @Expose
    private String transmissionType;
    @SerializedName("@FuelType")
    @Expose
    private String fuelType;
    @SerializedName("@DriveType")
    @Expose
    private String driveType;
    @SerializedName("@PassengerQuantity")
    @Expose
    private String passengerQuantity;
    @SerializedName("@BaggageQuantity")
    @Expose
    private String baggageQuantity;
    @SerializedName("@Code")
    @Expose
    private String code;
    @SerializedName("@CodeContext")
    @Expose
    private String codeContext;
    @SerializedName("@DoorCount")
    @Expose
    private String doorCount;
    @SerializedName("VehMakeModel")
    @Expose
    private VehicleMakeModel vehicleMakeModel;
    @SerializedName("PictureURL")
    @Expose
    private String pictureURL;
    @SerializedName("@Size")
    @Expose
    private String size;

    public String getAirConditionInd() {
        return airConditionInd;
    }

    public void setAirConditionInd(String airConditionInd) {
        this.airConditionInd = airConditionInd;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getPassengerQuantity() {
        return passengerQuantity;
    }

    public void setPassengerQuantity(String passengerQuantity) {
        this.passengerQuantity = passengerQuantity;
    }

    public String getBaggageQuantity() {
        return baggageQuantity;
    }

    public void setBaggageQuantity(String baggageQuantity) {
        this.baggageQuantity = baggageQuantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeContext() {
        return codeContext;
    }

    public void setCodeContext(String codeContext) {
        this.codeContext = codeContext;
    }

    public String getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(String doorCount) {
        this.doorCount = doorCount;
    }

    public VehicleMakeModel getVehicleMakeModel() {
        return vehicleMakeModel;
    }

    public void setVehicleMakeModel(VehicleMakeModel vehicleMakeModel) {
        this.vehicleMakeModel = vehicleMakeModel;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}