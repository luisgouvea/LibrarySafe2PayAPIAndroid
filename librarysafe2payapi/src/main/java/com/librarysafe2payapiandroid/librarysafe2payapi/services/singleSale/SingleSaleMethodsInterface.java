package com.librarysafe2payapiandroid.librarysafe2payapi.services.singleSale;

import com.librarysafe2payapiandroid.librarysafe2payapi.models.singleSale.SingleSale;
import com.librarysafe2payapiandroid.librarysafe2payapi.models.util.ResponseAPI;
import com.librarysafe2payapiandroid.librarysafe2payapi.services.ServicesURL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SingleSaleMethodsInterface {
    @POST(ServicesURL.SINGLE_SALE_ADD)
    Call<ResponseAPI> addSingleSale(@Body SingleSale singleSale);
}
