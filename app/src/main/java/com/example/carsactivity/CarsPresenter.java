package com.example.carsactivity;

import androidx.annotation.NonNull;

import com.example.carsactivity.data.CarRepository;
import com.example.carsactivity.data.model.SearchResult;
import com.example.carsactivity.data.model.VehiclesAvailable;
import com.example.carsactivity.interfaces.CarContract;
import com.example.carsactivity.interfaces.CarDataSource;

import java.util.List;

public class CarsPresenter implements CarContract.Presenter {

    private final CarRepository mCarsRepository;

    private final CarContract.View mCarsView;

    private CarContract.DetailViewListener detailViewListener;

    public CarsPresenter(@NonNull CarRepository carsRepository, @NonNull CarContract.View carView) {
        mCarsRepository = carsRepository;
        mCarsView = carView;

        mCarsView.setPresenter(this);
    }

    @Override
    public void start() {
        // Get data from repository
        retrieveAllRentals();
    }

    @Override
    public void retrieveAllRentals() {
        mCarsRepository.getAllRentals(new CarDataSource.GetRentalsCallback() {
            @Override
            public void onRentalsRetrieved(List<VehiclesAvailable> vehiclesAvailable) {
                getSearchResults(vehiclesAvailable);
            }

            @Override
            public void onDataNotAvailable(String error) {
                mCarsView.showError(error);
            }
        });
    }

    private void getSearchResults(List<VehiclesAvailable> vehiclesAvailable) {
        mCarsRepository.getSearchResults(vehiclesAvailable, new CarDataSource.GetSearchResultsCallback() {
            @Override
            public void onRentalsRetrieved(List<SearchResult> searchResult) {
                mCarsView.showRentals(searchResult);
            }

            @Override
            public void onDataNotAvailable(String error) {
                mCarsView.showError(error);
            }
        });
    }

    @Override
    public void showRental(SearchResult result) {
        if (null != detailViewListener) {
            detailViewListener.showDetailsView(result);
        }
    }

    @Override
    public void setDetailsViewListener(CarContract.DetailViewListener detailsViewListener) {
        this.detailViewListener = detailsViewListener;
    }

}
