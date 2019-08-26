package com.example.carsactivity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carsactivity.R;
import com.example.carsactivity.data.model.SearchResult;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class RentalListAdapter extends RecyclerView.Adapter<RentalListAdapter.RentalViewHolder> {

    private Context context;
    private List<SearchResult> mRentalData;

    private LayoutInflater mInflater;
    private RentalSelectListener mClickListener;

    // data is passed into the constructor
    public RentalListAdapter(Context context, List<SearchResult> rentalData) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mRentalData = rentalData;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public RentalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rental_list_row, parent, false);
        return new RentalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RentalViewHolder holder, int position) {
        SearchResult result = mRentalData.get(position);

        Picasso.get().load(result.getVehicle().getPictureURL()).into(holder.carImage);
        holder.txtVendorName.setText(result.getVendor().getName());
        holder.txtMakeModel.setText(result.getVehicle().getVehicleMakeModel().getName());
        holder.txtPrice.setText(String.format(Locale.ENGLISH, context.getString(R.string.rental_price), result.getTotalCharge().getRateTotalAmount()));
        holder.txtNumDoors.setText(String.format(Locale.ENGLISH, context.getString(R.string.rental_num_doors), result.getVehicle().getDoorCount()));
        holder.txtTransmission.setText(result.getVehicle().getTransmissionType());
        holder.txtFuelType.setText(result.getVehicle().getFuelType());
        holder.txtNumPassengers.setText(String.format(Locale.ENGLISH, context.getString(R.string.rental_num_seats), result.getVehicle().getPassengerQuantity()));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mRentalData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class RentalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView carImage;
        TextView txtVendorName;
        TextView txtMakeModel;
        TextView txtPrice;
        TextView txtNumDoors;
        TextView txtTransmission;
        TextView txtFuelType;
        TextView txtNumPassengers;

        RentalViewHolder(View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.list_image_vehicle);
            txtVendorName = itemView.findViewById(R.id.list_text_vendor);
            txtMakeModel = itemView.findViewById(R.id.list_text_make_model);
            txtPrice = itemView.findViewById(R.id.list_text_price);
            txtNumDoors = itemView.findViewById(R.id.list_text_num_doors);
            txtTransmission = itemView.findViewById(R.id.list_text_transmission);
            txtFuelType = itemView.findViewById(R.id.list_text_fuel_type);
            txtNumPassengers = itemView.findViewById(R.id.list_text_passenger_count);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(mRentalData.get(getAdapterPosition()));
            }
        }
    }

    // allows clicks events to be caught
    public void setClickListener(RentalSelectListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface RentalSelectListener {
        void onItemClick(SearchResult result);
    }
}