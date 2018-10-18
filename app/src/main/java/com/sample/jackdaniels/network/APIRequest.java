package com.poc.firbaseretrofit;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 14-02-2018.
 */

public class NetworkService {
    public static final long CONNECTION_TIME_OUT = 60;
    public static final long READ_TIME_OUT = 60;
    public static final long WRITE_TIME_OUT = 60;
    private static volatile NetworkService instance = null;
    private HttpLoggingInterceptor logging = null;
    private OkHttpClient okHttpClient = null;

    private NetworkService() {
        logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient().newBuilder().addInterceptor(logging)
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    public static NetworkService getInstance() {
        if (instance == null) {
            synchronized (NetworkService.class) {
                if (instance == null)
                    instance = new NetworkService();
            }
        }
        return instance;
    }

    public APIs getProvider() {
        APIs apis = new Retrofit.Builder()
                .baseUrl(URLs.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .build().create(APIs.class);
        return apis;
    }
}
