package com.cmz_one.easyweather.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cmz_one.easyweather.R;
import com.cmz_one.easyweather.http.RetrofitFactory;
import com.cmz_one.easyweather.bean.WeatherBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cmz_o on 2016/9/29.
 */

public class Item_Fragment extends Fragment {

    private TextView tv_city,tv_date,tv_curTemp,tv_type,tv_feng,tv_aqi,tv_2day,tv_3day,tv_4day,tv_weather_0day
            ,tv_weather_1day,tv_weather_2day,tv_weather_3day,tv_weather_4day,tv_temp_0day,tv_temp_1day,tv_temp_2day,
            tv_temp_3day,tv_temp_4day;
    private View view;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_weather, null);
        initView();
        bundle = getArguments();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getWeather(bundle.getString("city"));
    }

    private void initView(){
        tv_city = (TextView) view.findViewById(R.id.tv_city);
        tv_date = (TextView)  view.findViewById(R.id.tv_date);
        tv_curTemp = (TextView)  view.findViewById(R.id.tv_curTemp);
        tv_feng = (TextView)  view.findViewById(R.id.tv_feng);
        tv_type = (TextView)  view.findViewById(R.id.tv_type);
        tv_aqi = (TextView)  view.findViewById(R.id.tv_aqi);
        tv_2day = (TextView)  view.findViewById(R.id.tv_2day);
        tv_3day = (TextView)  view.findViewById(R.id.tv_3day);
        tv_4day = (TextView)  view.findViewById(R.id.tv_4day);
        tv_weather_0day = (TextView)  view.findViewById(R.id.tv_weather_0day);
        tv_weather_1day = (TextView)  view.findViewById(R.id.tv_weather_1day);
        tv_weather_2day = (TextView)  view.findViewById(R.id.tv_weather_2day);
        tv_weather_3day = (TextView)  view.findViewById(R.id.tv_weather_3day);
        tv_weather_4day = (TextView)  view.findViewById(R.id.tv_weather_4day);
        tv_temp_0day = (TextView)  view.findViewById(R.id.tv_temp_0day);
        tv_temp_1day = (TextView)  view.findViewById(R.id.tv_temp_1day);
        tv_temp_2day = (TextView)  view.findViewById(R.id.tv_temp_2day);
        tv_temp_3day = (TextView)  view.findViewById(R.id.tv_temp_3day);
        tv_temp_4day = (TextView)  view.findViewById(R.id.tv_temp_4day);
    }
    private void setTextView(WeatherBean weatherBean){
        tv_city.setText(weatherBean.getRetData().getCity());
        tv_date.setText(weatherBean.getRetData().getToday().getDate()+"   " + weatherBean.getRetData().getToday().getWeek());
        tv_curTemp.setText(weatherBean.getRetData().getToday().getCurTemp());
        tv_type.setText(weatherBean.getRetData().getToday().getType()+" "+weatherBean.getRetData().getToday().getLowtemp()+"~"
                +weatherBean.getRetData().getToday().getHightemp());
        tv_feng.setText(weatherBean.getRetData().getToday().getFengli()+" "+weatherBean.getRetData().getToday().getFengxiang());
        String air=Air(weatherBean.getRetData().getToday().getAqi());
        tv_aqi.setText("空气质量："+air);
        tv_weather_0day.setText(weatherBean.getRetData().getHistory().get(1).getType());
        tv_temp_0day.setText(weatherBean.getRetData().getHistory().get(1).getLowtemp()+"~"+weatherBean.getRetData().getHistory().get(1).getHightemp());
        tv_2day.setText(weatherBean.getRetData().getForecast().get(1).getWeek());
        tv_3day.setText(weatherBean.getRetData().getForecast().get(2).getWeek());
        tv_4day.setText(weatherBean.getRetData().getForecast().get(3).getWeek());
        tv_weather_1day.setText(weatherBean.getRetData().getForecast().get(0).getType());
        tv_weather_2day.setText(weatherBean.getRetData().getForecast().get(1).getType());
        tv_weather_3day.setText(weatherBean.getRetData().getForecast().get(2).getType());
        tv_weather_4day.setText(weatherBean.getRetData().getForecast().get(3).getType());
        tv_temp_1day.setText(weatherBean.getRetData().getForecast().get(0).getLowtemp()+"~"+weatherBean.getRetData().getForecast().get(0).getHightemp());
        tv_temp_2day.setText(weatherBean.getRetData().getForecast().get(1).getLowtemp()+"~"+weatherBean.getRetData().getForecast().get(1).getHightemp());
        tv_temp_3day.setText(weatherBean.getRetData().getForecast().get(2).getLowtemp()+"~"+weatherBean.getRetData().getForecast().get(2).getHightemp());
        tv_temp_4day.setText(weatherBean.getRetData().getForecast().get(3).getLowtemp()+"~"+weatherBean.getRetData().getForecast().get(3).getHightemp());
    }

    private String Air(int aqi){
        if(aqi<=50){
            return "优";
        }else if(aqi<=100){
            return "良";
        }else if(aqi<=150){
            return "轻度污染";
        }else if(aqi<=200){
            return "中度污染";
        }else if(aqi<=300){
            return "重度污染";
        }else {
            return "严重污染";
        }
    }

    public void getWeather(String district){
        Call<WeatherBean> call = RetrofitFactory.getInstance().getService().getWeather(district);
        call.enqueue(new Callback<WeatherBean>(){
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response){
                //请求成功处理数据
                WeatherBean weatherBean = response.body();
                setTextView(weatherBean);
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t){
                //进行异常情况处理
            }
        });
    }
}
