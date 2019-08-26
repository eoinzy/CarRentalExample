package com.example.carsactivity.utills;

import com.example.carsactivity.data.model.SearchResult;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorter {

    public static void sortListByPrice(List<SearchResult> results) {
        Comparator<SearchResult> compareByPrice = new Comparator<SearchResult>() {
            @Override
            public int compare(SearchResult o1, SearchResult o2) {
                return Double.valueOf(o1.getTotalCharge().getRateTotalAmount()).compareTo(Double.valueOf(o2.getTotalCharge().getRateTotalAmount()));
            }
        };

        Collections.sort(results, compareByPrice);
    }
}
