package com.example.consultandoapicorreios.repository;

import com.example.consultandoapicorreios.datasource.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public WebService getCEPService() {
        return this.retrofit.create(WebService.class);
    }
}
