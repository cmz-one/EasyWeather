package com.cmz_one.easyweather.http;

import com.cmz_one.easyweather.bean.WeatherBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



/**
 * Created by cmz_o on 2016/8/8.
 */

public interface RetrofitService {
    @GET("recentweathers")
    Call<WeatherBean> getWeather(@Query("cityname")String cityname);
}