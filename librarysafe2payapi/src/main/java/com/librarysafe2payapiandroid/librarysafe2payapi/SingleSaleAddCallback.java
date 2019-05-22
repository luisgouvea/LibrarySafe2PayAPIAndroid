package com.librarysafe2payapiandroid.librarysafe2payapi;

public interface SingleSaleAddCallback {
    void requestSingleSaleAddSuccess(SingleSaleModel authenticationRequest);
    void requestSingleSaleAddFailed(ResponseAPIModel errorResponseAPI);
}
