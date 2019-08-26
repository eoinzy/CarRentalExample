package com.example.carsactivity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carsactivity.R;
import com.example.carsactivity.adapters.RentalListAdapter;
import com.example.carsactivity.data.model.SearchResult;
import com.example.carsactivity.data.model.VehicleRentalInfo;
import com.example.carsactivity.interfaces.CarContract;
import com.example.carsactivity.utills.TimeDateUtils;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarsFragment extends Fragment implements CarContract.View, RentalListAdapter.RentalSelectListener {

    private View rootView;
    private RecyclerView rentalListView;
    private CarContract.Presenter mPresenter;

    public CarsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment CarsFragment.
     */
    public static CarsFragment newInstance() {
        return new CarsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_cars, container, false);
        rentalListView = rootView.findViewById(R.id.rental_list);
        return rootView;
    }

    private void setupListAdapter(RecyclerView rentalListView, List<SearchResult> rentals) {
        rentalListView.setLayoutManager(new LinearLayoutManager(getContext()));
        RentalListAdapter adapter = new RentalListAdapter(getContext(), rentals);
        adapter.setClickListener(this);
        rentalListView.setAdapter(adapter);

        //Set Header
        VehicleRentalInfo vehRentalInfo = rentals.get(0).getVehicleRentalInfo(); //Just get first object. They all contain this info
        ((TextView) rootView.findViewById(R.id.pickup_location)).setText(vehRentalInfo.getPickupLocation().getName());
        ((TextView) rootView.findViewById(R.id.pickup_time)).setText(TimeDateUtils.getFriendlyDate(vehRentalInfo.getPickUpDateTime()));
        ((TextView) rootView.findViewById(R.id.dropoff_location)).setText(vehRentalInfo.getReturnLocation().getName());
        ((TextView) rootView.findViewById(R.id.dropoff_time)).setText(TimeDateUtils.getFriendlyDate(vehRentalInfo.getReturnDateTime()));
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(CarContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showRentals(List<SearchResult> rentals) {
        setupListAdapter(rentalListView, rentals);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(rootView, error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(SearchResult result) {
        mPresenter.showRental(result);
    }
}
