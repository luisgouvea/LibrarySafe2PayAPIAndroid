package com.librarysafe2payapiandroid.librarysafe2payapi;

import com.librarysafe2payapiandroid.librarysafe2payapi.ResponseAPIModel;

import retrofit2.Call;

public interface RequestBaseInterfaceRetrofit {
    void requestDoInBackground();
    void requestPostExecute(Call<ResponseAPIModel> call, retrofit2.Response<ResponseAPIModel> response, Throwable t);
}
