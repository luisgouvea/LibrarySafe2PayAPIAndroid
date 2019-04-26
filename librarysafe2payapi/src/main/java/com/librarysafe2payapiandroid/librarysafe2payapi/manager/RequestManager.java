package com.librarysafe2payapiandroid.librarysafe2payapi.manager;

import com.librarysafe2payapiandroid.librarysafe2payapi.services.singleSale.add.SingleSaleAddCallback;
import com.librarysafe2payapiandroid.librarysafe2payapi.services.singleSale.add.SingleSaleAddRequest;

public class RequestManager {

    private SingleSaleAddRequest singleSaleAddRequest;

    public RequestManager() {
    }


    public void addSingleSale(SingleSaleAddCallback callback, double amount, int status) {
        this.singleSaleAddRequest = new SingleSaleAddRequest(callback);
        singleSaleAddRequest.addSingleSale(amount, status);
    }
}
