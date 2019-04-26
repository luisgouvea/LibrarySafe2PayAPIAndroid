package com.librarysafe2payapiandroid.librarysafe2payapi.services.singleSale.add;

import com.librarysafe2payapiandroid.librarysafe2payapi.models.singleSale.SingleSale;
import com.librarysafe2payapiandroid.librarysafe2payapi.models.util.ResponseAPI;
import com.librarysafe2payapiandroid.librarysafe2payapi.retrofit.InitialRetrofit;
import com.librarysafe2payapiandroid.librarysafe2payapi.retrofit.RequestBase;
import com.librarysafe2payapiandroid.librarysafe2payapi.retrofit.RequestBaseInterface;
import com.librarysafe2payapiandroid.librarysafe2payapi.services.singleSale.SingleSaleMethodsInterface;
import com.librarysafe2payapiandroid.librarysafe2payapi.util.LibraryUtil;

import retrofit2.Call;
import retrofit2.Response;

public class SingleSaleAddRequest extends RequestBase implements RequestBaseInterface {
    private SingleSaleAddCallback singleSaleAddCallbackReceive;
    private SingleSale singleSale;

    public SingleSaleAddRequest(SingleSaleAddCallback singleSaleAddCallback) {
        this.singleSaleAddCallbackReceive = singleSaleAddCallback;
    }

    public void addSingleSale(double amount, int status) {
        createObject(amount, status);
        this.requestDoInBackground();
    }

    private void createObject(double amount, int status) {
        singleSale = new SingleSale();
        if (LibraryUtil.doubleIsNull(amount)) {
            singleSale.amount = amount;
        }

        if (LibraryUtil.intIsNull(status)) {
            singleSale.status = status;
        }
    }

    @Override
    public void requestDoInBackground() {
        SingleSaleMethodsInterface singleSaleMethodsInterface = InitialRetrofit.getRetrofitFeature().create(SingleSaleMethodsInterface.class);
        Call<ResponseAPI> call = singleSaleMethodsInterface.addSingleSale(singleSale);
        executeRequestBase(call, this);
    }

    @Override
    public void requestPostExecute(Call<ResponseAPI> call, Response<ResponseAPI> responseRetrofit, Throwable t) {
        Object object = LibraryUtil.parseResponseAPI(responseRetrofit, SingleSale.class); // Response API ou SingleSale
        if (LibraryUtil.checkTypeResponseAPI(object)) {
            SingleSale singleSaleAdd = LibraryUtil.parseObjectToOtherObject(object, SingleSale.class);
            singleSaleAddCallbackReceive.requestSingleSaleAddSuccess(singleSaleAdd);
        } else {
            ResponseAPI responseAPI = LibraryUtil.parseObjectToOtherObject(object, ResponseAPI.class);
            singleSaleAddCallbackReceive.requestSingleSaleAddFailed(responseAPI);
        }
    }
}