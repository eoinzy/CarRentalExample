package com.example.carsactivity.data;

import androidx.annotation.NonNull;

import com.example.carsactivity.data.model.VehiclesAvailable;
import com.example.carsactivity.interfaces.CarDataSource;
import com.example.carsactivity.network.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarsRemoteDataSource implements CarDataSource {

    private static volatile CarsRemoteDataSource INSTANCE;

    private CarsRemoteDataSource() {
    }

    public static CarsRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (CarsRemoteDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CarsRemoteDataSource();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void getAllRentals(final GetRentalsCallback getRentalsCallback) {
        Call<List<VehiclesAvailable>> call = RestClient.get().getCars();
        call.enqueue(new Callback<List<VehiclesAvailable>>() {
            @Override
            public void onResponse(@NonNull Call<List<VehiclesAvailable>> call, @NonNull Response<List<VehiclesAvailable>> response) {
                if (response.isSuccessful()) {
                    getRentalsCallback.onRentalsRetrieved(response.body());
                } else {
                    getRentalsCallback.onDataNotAvailable("Network error");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<VehiclesAvailable>> call, @NonNull Throwable t) {
                getRentalsCallback.onDataNotAvailable(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getSearchResults(List<VehiclesAvailable> vehiclesAvailable, GetSearchResultsCallback getSearchResultsCallback) {
        //unused. Could be used if data is persisted remotely in a DB etc...
    }

}
