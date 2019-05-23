package com.librarysafe2payapiandroid.librarysafe2payapi;

import com.google.gson.annotations.SerializedName;

public class ModelTransactionBase {

    @SerializedName("Amount")
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
