package com.example.carsactivity.utills;

import android.util.Log;

import com.example.carsactivity.fragment.CarsFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeDateUtils {

    /**
     * Convert an unfriendly verbose date string to a more human readable format.
     *
     * @param date The unfriendly verbose date
     * @return A more human readable date, or "N/A" if there's a parse error.
     */
    public static String getFriendlyDate(String date) {
        try {
            SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
            Date newDate = spf.parse(date);
            spf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);
            date = spf.format(newDate);
        } catch (Exception e) {
            Log.e(CarsFragment.class.getSimpleName(), "Error converting date", e);
            return "N/A";
        }

        return date;
    }
}
