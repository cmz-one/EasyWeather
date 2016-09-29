package com.cmz_one.easyweather.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
/**
 * Created by cmz_o on 2016/8/8.
 */
public class Location {

    private Context context;
    private Handler handler;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    public Location(Context context, Handler handler) {
        this.context = context;
        this.handler = handler;
    }

    public void location(){
        mLocationClient = new LocationClient(context);     //声明LocationClient类
        mLocationClient.registerLocationListener( myListener );    //注册监听函数
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            Message message = new Message();
            message.what = 1;
            if(bdLocation == null){
                message.what = 0;
            }
            Bundle bundle = new Bundle();
            String district= bdLocation.getDistrict();
            district = district.substring(0,district.length()-1);//截取区/县字符
            bundle.putString("District",district);
            message.setData(bundle);
            handler.sendMessage(message);
            mLocationClient.stop();
        }
    }
}
