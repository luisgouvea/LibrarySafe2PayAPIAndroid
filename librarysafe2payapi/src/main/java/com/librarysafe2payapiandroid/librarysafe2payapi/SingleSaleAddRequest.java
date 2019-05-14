package com.librarysafe2payapiandroid.librarysafe2payapi;

import retrofit2.Call;
import retrofit2.Response;

public class SingleSaleAddRequest extends RequestBaseRetrofit implements RequestBaseInterfaceRetrofit {
    private SingleSaleAddCallback singleSaleAddCallbackReceive;
    private SingleSaleModel singleSale;

    public SingleSaleAddRequest(SingleSaleAddCallback singleSaleAddCallback) {
        this.singleSaleAddCallbackReceive = singleSaleAddCallback;
    }

    protected void addSingleSale(double amount, int status) {
        createObject(amount, status);
        this.requestDoInBackground();
    }

    private void createObject(double amount, int status) {
        singleSale = new SingleSaleModel();
        if (LibraryUtil.doubleIsNull(amount)) {
            singleSale.setAmount(amount);
        }

        if (LibraryUtil.intIsNull(status)) {
            singleSale.setStatus(status);
        }
    }

    @Override
    public void requestDoInBackground() {
        SingleSaleMethodsInterface singleSaleMethodsInterface = InitialRetrofit.getRetrofitFeature().create(SingleSaleMethodsInterface.class);
        Call<ResponseAPIModel> call = singleSaleMethodsInterface.addSingleSale(singleSale);
        executeRequestBase(call, this);
    }

    @Override
    public void requestPostExecute(Call<ResponseAPIModel> call, Response<ResponseAPIModel> responseRetrofit, Throwable t) {
        Object object = LibraryUtil.parseResponseAPI(responseRetrofit, SingleSaleModel.class); // Response API ou SingleSaleModel
        if (LibraryUtil.checkTypeResponseAPI(object)) {
            SingleSaleModel singleSaleAdd = LibraryUtil.parseObjectToOtherObject(object, SingleSaleModel.class);
            singleSaleAddCallbackReceive.requestSingleSaleAddSuccess(singleSaleAdd);
        } else {
            ResponseAPIModel responseAPI = LibraryUtil.parseObjectToOtherObject(object, ResponseAPIModel.class);
            singleSaleAddCallbackReceive.requestSingleSaleAddFailed(responseAPI);
        }
    }
}