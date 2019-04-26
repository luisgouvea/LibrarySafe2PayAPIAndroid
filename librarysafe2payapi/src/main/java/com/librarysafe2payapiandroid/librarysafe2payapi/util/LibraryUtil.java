package com.librarysafe2payapiandroid.librarysafe2payapi.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.Primitives;
import com.librarysafe2payapiandroid.librarysafe2payapi.models.util.ResponseAPI;

import java.lang.reflect.Type;

import retrofit2.Response;

public class LibraryUtil {

    public static <T> T parseResponseAPI (Response<ResponseAPI> responseRetrofit, Class<T> classToParse) {
        if (responseRetrofit == null) {
            return Primitives.wrap(classToParse).cast(new ResponseAPI());
        }
        if (responseRetrofit.code() == 200) {
            ResponseAPI responseAPI = responseRetrofit.body();
            if (LibraryUtil.hasErrorResponseAPI(responseAPI) == false) {
                return LibraryUtil.parseObjectToOtherObject(responseAPI, classToParse);
            } else {
                return Primitives.wrap(classToParse).cast(responseAPI);
            }
        }
        return Primitives.wrap(classToParse).cast(new ResponseAPI());
    }

    public static <T> T parseObjectToOtherObject(Object responseAPI, Class<T> classToParse) {
        Gson gSerializer = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

        String json = gSerializer.toJson(responseAPI);

        Object object = gSerializer.fromJson(json, (Type) classToParse);

        return Primitives.wrap(classToParse).cast(object);
    }

    public static Boolean hasErrorResponseAPI (ResponseAPI responseAPI) {
        if (responseAPI == null) {
            return true;
        }
        if (responseAPI.isHasError() == false && responseAPI.getResponseDetail() != null) {
            return false;
        }
        return true;
    }

    public static Boolean checkTypeResponseAPI (Object object) {
        if (object instanceof ResponseAPI) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean stringIsNull(String stringTarget) {
        if (stringTarget == null) {
            return true;
        }
        stringTarget = stringTarget.trim();
        if (stringTarget.equals("") || stringTarget.length() <= 0) {
            return true;
        }

        return false;
    }

    public static boolean doubleIsNull(double doubleTarget) {

        if (doubleTarget <= 0) {
            return true;
        }

        return false;
    }

    public static boolean intIsNull(int doubleTarget) {

        if (doubleTarget == 0) {
            return true;
        }

        return false;
    }
}
