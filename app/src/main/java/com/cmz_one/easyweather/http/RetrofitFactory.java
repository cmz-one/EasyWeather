package com.cmz_one.easyweather.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cmz_o on 2016/9/27.
 */

public class RetrofitFactory {

    public static final String BASE_URL = "http://apis.baidu.com/apistore/weatherservice/";
    private Retrofit retrofit;
    private static RetrofitFactory instance;

    private RetrofitFactory() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException
            {
                Request newRequest = chain.request().newBuilder().addHeader("apikey", "fdfba5459a3e2ba6f043d82e14391fb0").build();
                return chain.proceed(newRequest);
            }
        }).build();//添加header部分

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }

    public static RetrofitFactory getInstance() {
        if (instance == null) {
            synchronized (RetrofitFactory.class) {
                if (instance == null) {
                    instance = new RetrofitFactory();
                }
            }
        }
        return instance;
    }

    public RetrofitService getService() {
        RetrofitService service = retrofit.create(RetrofitService.class);
        return service;
    }
}
