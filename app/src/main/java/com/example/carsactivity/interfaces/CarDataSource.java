package com.example.carsactivity.interfaces;

import com.example.carsactivity.data.model.SearchResult;
import com.example.carsactivity.data.model.VehiclesAvailable;

import java.util.List;

public interface CarDataSource {

    void getAllRentals(GetRentalsCallback getRentalsCallback);

    void getSearchResults(List<VehiclesAvailable> vehiclesAvailable, GetSearchResultsCallback getSearchResultsCallback);

    interface GetRentalsCallback {

        void onRentalsRetrieved(List<VehiclesAvailable> vehiclesAvailable);

        void onDataNotAvailable(String error);
    }

    interface GetSearchResultsCallback {

        void onRentalsRetrieved(List<SearchResult> searchResult);

        void onDataNotAvailable(String error);
    }
}
