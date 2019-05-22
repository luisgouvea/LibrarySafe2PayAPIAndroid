package com.librarysafe2payapiandroid.librarysafe2payapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TransactionMethodsInterface {

    @GET(ServicesURL.GET_TRANSACTION)
    Call<ResponseAPIModel> getTransaction(int idTransaction);
}
