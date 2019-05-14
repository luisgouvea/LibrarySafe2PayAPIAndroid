package com.librarysafe2payapiandroid.librarysafe2payapi;

public class SingleSaleModel {

    private int status;
    private double amount;

    protected int getStatus() {
        return status;
    }

    protected void setStatus(int status) {
        this.status = status;
    }

    protected double getAmount() {
        return amount;
    }

    protected void setAmount(double amount) {
        this.amount = amount;
    }
}
