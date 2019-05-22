package com.librarysafe2payapiandroid.librarysafe2payapi;

public interface GetTransactionCallback {
    void requestGetTransactionSuccess(ModelTransactionBase modelTransactionBase);
    void requestGetTransactionFailed(ResponseAPIModel errorResponseAPI);
}
