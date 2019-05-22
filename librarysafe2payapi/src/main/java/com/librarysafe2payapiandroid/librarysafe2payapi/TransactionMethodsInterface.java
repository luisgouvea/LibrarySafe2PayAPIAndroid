package com.librarysafe2payapiandroid.librarysafe2payapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TransactionMethodsInterface {

    @GET(ServicesURL.GET_TRANSACTION+"?id={aqui}")
    Call<ResponseAPIModel> getTransaction(@Path("aqui") int idTransaction);
}
