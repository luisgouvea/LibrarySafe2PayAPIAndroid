package com.librarysafe2payapiandroid.librarysafe2payapi.retrofit;

import com.librarysafe2payapiandroid.librarysafe2payapi.services.ServicesURL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitialRetrofit {

    private static Retrofit.Builder builderAuth =
            new Retrofit.Builder()
                    .baseUrl(ServicesURL.DOMAIN_BASE_AUTH)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit.Builder builderFeature =
            new Retrofit.Builder()
                    .baseUrl(ServicesURL.DOMAIN_BASE_FEATURES)
                    .addConverterFactory(GsonConverterFactory.create());


    private static Retrofit retrofitAuth = builderAuth.build();

    private static Retrofit retrofiFeature = builderFeature.build();

    public static Retrofit getRetrofitAuth() {
        return retrofitAuth;
    }

    public static Retrofit getRetrofitFeature() {
        return retrofiFeature;
    }
}
