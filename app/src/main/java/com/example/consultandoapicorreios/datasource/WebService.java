package com.example.consultandoapicorreios.datasource;


import com.example.consultandoapicorreios.models.ModelConsult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {

    @GET("{cepInterface}/json/")
    Call<ModelConsult> buscarCEP (@Path("cepInterface") String cepInterface);
}
