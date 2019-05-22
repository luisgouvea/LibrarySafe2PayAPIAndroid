package com.librarysafe2payapiandroid.librarysafe2payapi;

public class TransactionIntegration {

    private static GetTransactionRequest getTransactionRequest;

    public TransactionIntegration() {
    }

    public static void getTransaction(GetTransactionCallback getTransactionCallback, int idTransaction) {
        getTransactionRequest = new GetTransactionRequest(getTransactionCallback);
        getTransactionRequest.getTransaction(idTransaction);
    }
}
