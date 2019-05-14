package com.librarysafe2payapiandroid.librarysafe2payapi;

import retrofit2.Call;
import retrofit2.Callback;

public class RequestBaseRetrofit {

    private Call<ResponseAPIModel> call;
    private RequestBaseInterfaceRetrofit requestBaseInterface;

    protected void executeRequestBase(Call<ResponseAPIModel> call, final RequestBaseInterfaceRetrofit requestBaseInterface) {
        this.call = call;
        this.requestBaseInterface = requestBaseInterface;
        addEnqueue();
    }

    protected void addEnqueue() {
        call.enqueue(new Callback<ResponseAPIModel>() {
            @Override
            public void onResponse(Call<ResponseAPIModel> call, retrofit2.Response<ResponseAPIModel> response) {
                findResponse(response, null);
            }

            @Override
            public void onFailure(Call<ResponseAPIModel> call, Throwable t) {
                findResponse(null, t);
            }
        });
    }

    protected void findResponse(retrofit2.Response<ResponseAPIModel> response, Throwable throwable) {
        if (response != null) {
            if (response.code() == 200) {
                requestBaseInterface.requestPostExecute(call, response, null);
            } else {
                requestBaseInterface.requestPostExecute(call, null, throwable);
            }
        } else {
            requestBaseInterface.requestPostExecute(call, null, throwable);
        }
    }
}