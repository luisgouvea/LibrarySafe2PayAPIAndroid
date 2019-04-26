package com.librarysafe2payapiandroid.librarysafe2payapi.retrofit;

import com.librarysafe2payapiandroid.librarysafe2payapi.models.util.ResponseAPI;

import retrofit2.Call;

public interface RequestBaseInterface {
    void requestDoInBackground();
    void requestPostExecute(Call<ResponseAPI> call, retrofit2.Response<ResponseAPI> response, Throwable t);
}
