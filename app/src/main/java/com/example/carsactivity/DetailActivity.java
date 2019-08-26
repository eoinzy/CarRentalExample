package com.example.carsactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.carsactivity.data.model.SearchResult;
import com.example.carsactivity.data.model.Vehicle;
import com.example.carsactivity.utills.TimeDateUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SearchResult result = (SearchResult) getIntent().getSerializableExtra(EXTRA_RESULT);
        buildUI(result);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Car added to booking!", Snackbar.LENGTH_LONG)
                        .setAction("Dismiss", null).show();
            }
        });
    }

    private void buildUI(SearchResult result) {
        ImageView headerImage = findViewById(R.id.detail_header_image);
        Picasso.get().load(result.getVehicle().getPictureURL()).into(headerImage);

        getSupportActionBar().setTitle(result.getVehicle().getVehicleMakeModel().getName());

        //Set values
        ((TextView) findViewById(R.id.pickup_location)).setText(result.getVehicleRentalInfo().getPickupLocation().getName());
        ((TextView) findViewById(R.id.pickup_time)).setText(TimeDateUtils.getFriendlyDate(result.getVehicleRentalInfo().getPickUpDateTime()));
        ((TextView) findViewById(R.id.dropoff_location)).setText(result.getVehicleRentalInfo().getReturnLocation().getName());
        ((TextView) findViewById(R.id.dropoff_time)).setText(TimeDateUtils.getFriendlyDate(result.getVehicleRentalInfo().getReturnDateTime()));

        Vehicle vehicle = result.getVehicle();
        ((TextView) findViewById(R.id.detail_view_text_vendor)).setText(result.getVendor().getName());
        ((TextView) findViewById(R.id.detail_view_text_make_model)).setText(vehicle.getVehicleMakeModel().getName());
        ((TextView) findViewById(R.id.detail_view_text_transmission)).setText(vehicle.getTransmissionType());
        ((TextView) findViewById(R.id.detail_view_text_fuel_type)).setText(vehicle.getFuelType());
        ((TextView) findViewById(R.id.detail_view_text_passenger_count)).setText(String.format(Locale.ENGLISH, getString(R.string.rental_num_seats), vehicle.getPassengerQuantity()));
        ((TextView) findViewById(R.id.detail_view_text_num_doors)).setText(String.format(Locale.ENGLISH, getString(R.string.rental_num_doors), vehicle.getDoorCount()));
        TextView txtAirCon = findViewById(R.id.detail_view_text_aircon);
        txtAirCon.setVisibility(vehicle.getAirConditionInd().equals("true") ? View.VISIBLE : View.INVISIBLE);

        ((TextView) findViewById(R.id.detail_text_price)).setText(result.getTotalCharge().getRateTotalAmount());
    }
}
