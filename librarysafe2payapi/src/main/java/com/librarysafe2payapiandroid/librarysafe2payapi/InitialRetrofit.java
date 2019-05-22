package com.librarysafe2payapiandroid.librarysafe2payapi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.librarysafe2payapiandroid.librarysafe2payapi.ServicesURL.DOMAIN_BASE;

public class InitialRetrofit {

//    private static Retrofit.Builder builderRetrofit =
//            new Retrofit.Builder()
//                    .baseUrl(DOMAIN_BASE)
//                    .addConverterFactory(GsonConverterFactory.create());
//
//
//    private static Retrofit retrofit = builderRetrofit.build();

    protected static Retrofit getRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("X-API-KEY", Safe2PayConfig.getKey())
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DOMAIN_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
