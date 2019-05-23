package com.librarysafe2payapiandroid.librarysafe2payapi;

import com.google.gson.annotations.SerializedName;

public class ResponseAPIModel<T> {
    @SerializedName("ResponseDetail")
    private T responseDetail;

    @SerializedName("HasError")
    private boolean hasError;

    @SerializedName("Error")
    private String error;

    @SerializedName("ErrorCode")
    private String errorCode;

    protected static final String errorBase = "Não foi possível comunicar-se com o servidor";
    protected static final String codeBase = "404";

    protected ResponseAPIModel() {
        this.setError(ResponseAPIModel.errorBase);
        this.setErrorCode(ResponseAPIModel.codeBase);
        this.setHasError(true);
        this.setResponseDetail(null);
    }

    protected void setResponseDetail(T responseDetail) {
        this.responseDetail = responseDetail;
    }

    protected T getResponseDetail() {
        return responseDetail;
    }

    protected void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    protected boolean isHasError() {
        return hasError;
    }

    protected String getError() {
        return error;
    }

    protected void setError(String error) {
        this.error = error;
    }

    protected String getErrorCode() {
        return errorCode;
    }

    protected void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
