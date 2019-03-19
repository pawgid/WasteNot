package com.example.wastenot.network;

import com.example.wastenot.model.RetroList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroList>> getAllPhotos();
}
