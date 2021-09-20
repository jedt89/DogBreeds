package com.example.dogbreeds.api;

import com.example.dogbreeds.model.DataModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    //Interface para EndPoint
    // https://dog.ceo/api/breeds/list/all
    @GET("breeds/list/all")
    Call<ArrayList<DataModel>> getListBreed();


    //https://dog.ceo/api/breeds/image/random
    @GET("breeds/image/random")
    Call<DataModel> getImgRandom();

}