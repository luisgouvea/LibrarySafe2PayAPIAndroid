package com.librarysafe2payapiandroid.librarysafe2payapiandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.librarysafe2payapiandroid.librarysafe2payapi.GetTransactionCallback;
import com.librarysafe2payapiandroid.librarysafe2payapi.ModelTransactionBase;
import com.librarysafe2payapiandroid.librarysafe2payapi.ResponseAPIModel;
import com.librarysafe2payapiandroid.librarysafe2payapi.Safe2PayConfig;
import com.librarysafe2payapiandroid.librarysafe2payapi.TransactionIntegration;

public class MainActivity extends AppCompatActivity implements GetTransactionCallback {

    private GetTransactionCallback getTransactionCallback = this;
    private String key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Safe2PayConfig.setKey(key);

        TransactionIntegration.getTransaction(getTransactionCallback, 413125);
    }

    @Override
    public void requestGetTransactionSuccess(ModelTransactionBase modelTransactionBase) {
        String gg = "fff";
    }

    @Override
    public void requestGetTransactionFailed(ResponseAPIModel errorResponseAPI) {
        String gg = "fff";
    }
}