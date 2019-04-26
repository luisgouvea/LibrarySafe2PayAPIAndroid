package com.librarysafe2payapiandroid.librarysafe2payapi.manager.singleSale;

import com.librarysafe2payapiandroid.librarysafe2payapi.services.singleSale.add.SingleSaleAddCallback;
import com.librarysafe2payapiandroid.librarysafe2payapi.services.singleSale.add.SingleSaleAddRequest;

public class SingleSaleIntegration {

    private SingleSaleAddRequest singleSaleAddRequest;

    public SingleSaleIntegration() {
    }

    public void addSingleSale(SingleSaleAddCallback callback, double amount, int status) {
        this.singleSaleAddRequest = new SingleSaleAddRequest(callback);
        singleSaleAddRequest.addSingleSale(amount, status);
    }
}
