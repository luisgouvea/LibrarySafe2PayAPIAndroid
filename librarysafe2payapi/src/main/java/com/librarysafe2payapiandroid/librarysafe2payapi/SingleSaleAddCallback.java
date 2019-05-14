package com.librarysafe2payapiandroid.librarysafe2payapi;

import com.librarysafe2payapiandroid.librarysafe2payapi.SingleSaleModel;
import com.librarysafe2payapiandroid.librarysafe2payapi.ResponseAPIModel;

public interface SingleSaleAddCallback {
    void requestSingleSaleAddSuccess(SingleSaleModel authenticationRequest);
    void requestSingleSaleAddFailed(ResponseAPIModel errorResponseAPI);
}
