package com.librarysafe2payapiandroid.librarysafe2payapi;

public class SingleSaleIntegration {

    private static SingleSaleAddRequest singleSaleAddRequest;

    public SingleSaleIntegration() {
    }

    public static void addSingleSale(SingleSaleAddCallback callback, double amount, int status) {
        singleSaleAddRequest = new SingleSaleAddRequest(callback);
        singleSaleAddRequest.addSingleSale(amount, status);
    }
}
