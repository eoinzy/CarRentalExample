package com.example.carsactivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carsactivity.data.CarRepository;
import com.example.carsactivity.data.CarsLocalDataSource;
import com.example.carsactivity.data.CarsRemoteDataSource;
import com.example.carsactivity.data.model.SearchResult;
import com.example.carsactivity.fragment.CarsFragment;
import com.example.carsactivity.interfaces.CarContract;
import com.example.carsactivity.utills.FragmentUtils;

public class MainActivity extends AppCompatActivity implements CarContract.DetailViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarsFragment rentalFragment = (CarsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (rentalFragment == null) {
            // Create the fragment
            rentalFragment = CarsFragment.newInstance();
            FragmentUtils.addFragmentToActivity(getSupportFragmentManager(), rentalFragment, R.id.fragment);
        }

        //Presenter gets attached to fragment via composition
        CarsPresenter mCarsPresenter = new CarsPresenter(getDataSource(), rentalFragment);
        mCarsPresenter.setDetailsViewListener(this);
    }

    private CarRepository getDataSource() {
        return CarRepository.getInstance(CarsRemoteDataSource.getInstance(), CarsLocalDataSource.getInstance());
    }

    @Override
    public void showDetailsView(SearchResult result) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(DetailActivity.EXTRA_RESULT, result);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, findViewById(R.id.list_image_vehicle), "transition");
        startActivity(i);
    }
}
