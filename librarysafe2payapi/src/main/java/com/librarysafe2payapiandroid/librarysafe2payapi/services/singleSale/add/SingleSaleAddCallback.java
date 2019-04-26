package com.librarysafe2payapiandroid.librarysafe2payapi.services.singleSale.add;

import com.librarysafe2payapiandroid.librarysafe2payapi.models.singleSale.SingleSale;
import com.librarysafe2payapiandroid.librarysafe2payapi.models.util.ResponseAPI;

public interface SingleSaleAddCallback {
    void requestSingleSaleAddSuccess(SingleSale authenticationRequest);
    void requestSingleSaleAddFailed(ResponseAPI errorResponseAPI);
}
