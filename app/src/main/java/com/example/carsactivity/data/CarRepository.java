package com.example.carsactivity.data;

import androidx.annotation.NonNull;

import com.example.carsactivity.data.model.VehiclesAvailable;
import com.example.carsactivity.interfaces.CarDataSource;

import java.util.List;

public class CarRepository implements CarDataSource {

    private static CarRepository INSTANCE = null;

    private final CarDataSource mCarsRemoteDataSource;
    private final CarDataSource mCarsLocalDataSource;

    // Prevent direct instantiation.
    private CarRepository(@NonNull CarDataSource tasksRemoteDataSource, @NonNull CarDataSource tasksLocalDataSource) {
        mCarsRemoteDataSource = tasksRemoteDataSource;
        mCarsLocalDataSource = tasksLocalDataSource;
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param tasksRemoteDataSource the backend data source
     * @param tasksLocalDataSource  the device storage data source
     * @return the {@link CarDataSource} instance
     */
    public static CarRepository getInstance(CarDataSource tasksRemoteDataSource, CarDataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new CarRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    /**
     * Used to force {@link #getInstance(CarDataSource, CarDataSource)} to create a new instance
     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getAllRentals(final GetRentalsCallback getRentalsCallback) {
        mCarsRemoteDataSource.getAllRentals(getRentalsCallback);
    }

    @Override
    public void getSearchResults(List<VehiclesAvailable> vehiclesAvailable, GetSearchResultsCallback getSearchResultsCallback) {
        mCarsLocalDataSource.getSearchResults(vehiclesAvailable, getSearchResultsCallback);
    }
}
