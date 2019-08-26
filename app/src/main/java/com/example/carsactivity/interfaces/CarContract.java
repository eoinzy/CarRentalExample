package com.example.carsactivity.interfaces;

import com.example.carsactivity.data.model.SearchResult;

import java.util.List;

public class CarContract {

    public interface View extends BaseView<Presenter> {

        void showRentals(List<SearchResult> rentals);

        void showError(String error);

    }

    public interface Presenter extends BasePresenter {

        void retrieveAllRentals();

        void showRental(SearchResult result);

        void setDetailsViewListener(DetailViewListener detailsViewListener);

    }

    public interface DetailViewListener {
        void showDetailsView(SearchResult result);
    }
}