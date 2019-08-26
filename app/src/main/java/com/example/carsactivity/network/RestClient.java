package com.example.carsactivity.network;

import com.example.carsactivity.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * REST client setup class.
 */
public class RestClient {
    private static RestInterface REST_CLIENT;
    private static final String API_BASE_URL = BuildConfig.JSON_DOMAIN;

    static {
        setupRestClient();
    }

    private RestClient() {
    }

    public static RestInterface get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(60, TimeUnit.SECONDS);
        httpClient.connectTimeout(60, TimeUnit.SECONDS);

        Retrofit builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(httpClient.build())
//                .setClient(new Ok3Client(httpClient.build()))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        REST_CLIENT = builder.create(RestInterface.class);
    }
}