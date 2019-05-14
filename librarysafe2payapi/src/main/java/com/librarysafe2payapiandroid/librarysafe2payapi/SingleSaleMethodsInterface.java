package com.librarysafe2payapiandroid.librarysafe2payapi;

import com.librarysafe2payapiandroid.librarysafe2payapi.SingleSaleModel;
import com.librarysafe2payapiandroid.librarysafe2payapi.ResponseAPIModel;
import com.librarysafe2payapiandroid.librarysafe2payapi.ServicesURL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SingleSaleMethodsInterface {
    @POST(ServicesURL.SINGLE_SALE_ADD)
    Call<ResponseAPIModel> addSingleSale(@Body SingleSaleModel singleSale);
}
