package com.librarysafe2payapiandroid.librarysafe2payapi;

import retrofit2.Call;
import retrofit2.Response;

public class GetTransactionRequest extends RequestBaseRetrofit implements RequestBaseInterfaceRetrofit {
    private GetTransactionCallback getTransactionCallback;
    private int idTransaction;

    protected GetTransactionRequest(GetTransactionCallback getTransactionCallback) {
        this.getTransactionCallback = getTransactionCallback;
    }

    protected void getTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
        this.requestDoInBackground();
    }

    @Override
    public void requestDoInBackground() {
        TransactionMethodsInterface transactionMethodsInterface = InitialRetrofit.getRetrofit().create(TransactionMethodsInterface.class);
        Call<ResponseAPIModel> call = transactionMethodsInterface.getTransaction(idTransaction);
        executeRequestBase(call, this);
    }

    @Override
    public void requestPostExecute(Call<ResponseAPIModel> call, Response<ResponseAPIModel> responseRetrofit, Throwable t) {
        Object object = LibraryUtil.parseResponseAPI(responseRetrofit, ModelTransactionBase.class); // Response API ou ModelTransactionBase
        if (LibraryUtil.checkTypeResponseAPI(object)) {
            ModelTransactionBase modelTransactionBase = LibraryUtil.parseObjectToOtherObject(object, ModelTransactionBase.class);
            getTransactionCallback.requestGetTransactionSuccess(modelTransactionBase);
        } else {
            ResponseAPIModel responseAPI = LibraryUtil.parseObjectToOtherObject(object, ResponseAPIModel.class);
            getTransactionCallback.requestGetTransactionFailed(responseAPI);
        }
    }
}
