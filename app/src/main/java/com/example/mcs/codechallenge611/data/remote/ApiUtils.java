package com.example.mcs.codechallenge611.data.remote;

public class ApiUtils {

    public static final String BASE_URL = "https://movies-sample.herokuapp.com/";

    public static MovieService getMovieService() {
        return RetrofitClient.getClient(BASE_URL).create(MovieService.class);
    }
}