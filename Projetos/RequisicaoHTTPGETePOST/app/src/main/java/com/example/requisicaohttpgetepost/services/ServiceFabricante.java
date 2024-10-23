package com.example.requisicaohttpgetepost.services;

import com.example.requisicaohttpgetepost.model.Fabricante;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceFabricante {

    @Headers("Accept: application/json")
    @POST("/fabricante")
    Call<Fabricante> postFabricante(@Body Fabricante fab);

    @Headers("Accept: application/json")
    @GET("/fabricante")
    Call<List<Fabricante>> getFabricante();
}
