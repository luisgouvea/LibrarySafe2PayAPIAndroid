package com.librarysafe2payapiandroid.librarysafe2payapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.Primitives;

import java.lang.reflect.Type;

import retrofit2.Response;

public class LibraryUtil {

    protected static <T> T parseResponseAPI(Response<ResponseAPIModel> responseRetrofit, Class<T> classToParse) {
        if (responseRetrofit == null) {
            //return Primitives.wrap(classToParse).cast(new ResponseAPIModel());
            return null;
        }
        if (responseRetrofit.code() == 200) {
            ResponseAPIModel responseAPI = responseRetrofit.body();
            if (LibraryUtil.hasErrorResponseAPI(responseAPI) == false) {
                return LibraryUtil.parseObjectToOtherObject(responseAPI.getResponseDetail(), classToParse);
            } else {
                return Primitives.wrap(classToParse).cast(responseAPI);
            }
        }
        return null;
        //return Primitives.wrap(classToParse).cast(new ResponseAPIModel());
    }

    protected static <T> T parseObjectToOtherObject(Object responseAPI, Class<T> classToParse) {
        Gson gSerializer = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

        String json = gSerializer.toJson(responseAPI);

        Object object = gSerializer.fromJson(json, (Type) classToParse);

        if (classToParse == ResponseAPIModel.class) {
            return Primitives.wrap(classToParse).cast(new ResponseAPIModel());
        }
        return Primitives.wrap(classToParse).cast(object);
    }

    protected static Boolean hasErrorResponseAPI(ResponseAPIModel responseAPI) {
        if (responseAPI == null) {
            return true;
        }
        if (responseAPI.isHasError() == false && responseAPI.getResponseDetail() != null) {
            return false;
        }
        return true;
    }

    protected static Boolean checkTypeResponseAPI(Object object) {
        if (object == null || object instanceof ResponseAPIModel) {
            return false;
        } else {
            return true;
        }
    }

    protected static boolean stringIsNull(String stringTarget) {
        if (stringTarget == null) {
            return true;
        }
        stringTarget = stringTarget.trim();
        if (stringTarget.equals("") || stringTarget.length() <= 0) {
            return true;
        }

        return false;
    }

    protected static boolean doubleIsNull(double doubleTarget) {

        if (doubleTarget <= 0) {
            return true;
        }

        return false;
    }

    protected static boolean intIsNull(int doubleTarget) {

        if (doubleTarget == 0) {
            return true;
        }

        return false;
    }
}
