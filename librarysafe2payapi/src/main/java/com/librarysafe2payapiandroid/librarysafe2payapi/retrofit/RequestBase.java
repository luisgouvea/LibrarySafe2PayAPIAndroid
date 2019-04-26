package com.librarysafe2payapiandroid.librarysafe2payapi.retrofit;

import com.librarysafe2payapiandroid.librarysafe2payapi.models.util.ResponseAPI;

import retrofit2.Call;
import retrofit2.Callback;

public class RequestBase {

    private Call<ResponseAPI> call;
    private RequestBaseInterface requestBaseInterface;

    protected void executeRequestBase(Call<ResponseAPI> call, final RequestBaseInterface requestBaseInterface) {
        this.call = call;
        this.requestBaseInterface = requestBaseInterface;
        addEnqueue();
    }

    private void addEnqueue() {
        call.enqueue(new Callback<ResponseAPI>() {
            @Override
            public void onResponse(Call<ResponseAPI> call, retrofit2.Response<ResponseAPI> response) {
                findResponse(response, null);
            }

            @Override
            public void onFailure(Call<ResponseAPI> call, Throwable t) {
                findResponse(null, t);
            }
        });
    }

    private void findResponse(retrofit2.Response<ResponseAPI> response, Throwable throwable) {
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