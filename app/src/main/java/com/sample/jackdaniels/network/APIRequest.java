package com.sample.jackdaniels.network;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIRequest {
    public static final long CONNECTION_TIME_OUT = 60;
    public static final long READ_TIME_OUT = 60;
    public static final long WRITE_TIME_OUT = 60;
    private static volatile APIRequest instance = null;
    private HttpLoggingInterceptor logging;
    private OkHttpClient okHttpClient;

    private APIRequest() {
        logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient().newBuilder().addInterceptor(logging)
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    public static APIRequest getInstance() {
        if (instance == null) {
            synchronized (APIRequest.class) {
                if (instance == null)
                    instance = new APIRequest();
            }
        }
        return instance;
    }

    public API getProvider() {
        API apis = new Retrofit.Builder()
                .baseUrl(URLS.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .build().create(API.class);
        return apis;
    }
}
