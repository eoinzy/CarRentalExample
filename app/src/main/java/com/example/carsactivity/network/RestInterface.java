package com.example.carsactivity.network;

import com.example.carsactivity.BuildConfig;
import com.example.carsactivity.data.model.VehiclesAvailable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Class defining REST endpoints.
 */
public interface RestInterface {

    @GET(BuildConfig.JSON_FILE_PATH)
    Call<List<VehiclesAvailable>> getCars();

}