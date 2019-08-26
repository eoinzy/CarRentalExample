package com.example.carsactivity.data;

import com.example.carsactivity.data.model.AvailableVehicle;
import com.example.carsactivity.data.model.SearchResult;
import com.example.carsactivity.data.model.VehicleRental;
import com.example.carsactivity.data.model.VehiclesAvailable;
import com.example.carsactivity.data.model.VendorAvailability;
import com.example.carsactivity.interfaces.CarDataSource;
import com.example.carsactivity.utills.ListSorter;

import java.util.ArrayList;
import java.util.List;

public class CarsLocalDataSource implements CarDataSource {

    private static volatile CarsLocalDataSource INSTANCE;

    private CarsLocalDataSource() {
    }

    public static CarsLocalDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (CarsLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CarsLocalDataSource();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void getAllRentals(GetRentalsCallback getRentalsCallback) {
        //unused. Could be used if data is persisted locally in a DB etc...
    }

    @Override
    public void getSearchResults(List<VehiclesAvailable> vehiclesAvailable, GetSearchResultsCallback getSearchResultsCallback) {
        //Convert VehiclesAvailable.class to SearchResult.class
        //Should be pulling data from a DB but just do a dirty conversion here for brevity

        List<SearchResult> results = new ArrayList<>();
        for (VehiclesAvailable vehicleAvailable : vehiclesAvailable) {
            VehicleRental rentals = vehicleAvailable.getVehicleRental();

            List<VendorAvailability> listRentals = rentals.getVendorAvailabilities();

            SearchResult result;
            for (VendorAvailability vendorAvailability : listRentals) {
                for (AvailableVehicle availableVehicle : vendorAvailability.getAvailableVehicles()) {
                    result = new SearchResult();
                    result.setVehicleRentalInfo(rentals.getVehicleRentalInfo());
                    result.setVendor(vendorAvailability.getVendor());
                    result.setStatus(availableVehicle.getStatus());
                    result.setVehicle(availableVehicle.getVehicle());
                    result.setTotalCharge(availableVehicle.getTotalCharge());
                    results.add(result);
                }
            }
        }

        //Sort by Price
        ListSorter.sortListByPrice(results); //If using a DB, this would obviously be easier.

        getSearchResultsCallback.onRentalsRetrieved(results);
    }
}
