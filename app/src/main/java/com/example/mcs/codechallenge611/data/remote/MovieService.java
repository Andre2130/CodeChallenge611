package com.example.mcs.codechallenge611.data.remote;

import com.example.mcs.codechallenge611.data.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("api/movies")
    Call<Data> getData();
}
