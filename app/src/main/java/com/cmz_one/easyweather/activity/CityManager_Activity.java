package com.cmz_one.easyweather.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;
import com.cmz_one.easyweather.R;
import com.cmz_one.easyweather.utils.SPUtils;
import com.cmz_one.easyweather.adapter.CityAdapter;
import com.cmz_one.easyweather.bean.Citybean;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cmz_o on 2016/9/18.
 */
public class CityManager_Activity extends Activity {

    private Button btn_AddCity;
    private WheelPicker wp_province, wp_city, wp_district;
    private ListView lv_city;
    private Citybean CityData;
    private List<String> provinceList = new ArrayList<String>();
    private List<String> cityList = new ArrayList<String>();
    private List<String> districtList = new ArrayList<String>();
    private int provinceSelectedIndex;
    private String SelectedItem;//最终选择地区
    private List<String> lv_CityData;
    private boolean IsCityNull;
    private String cityStr;
    private CityAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        initListView();//初始化ListView
        GetCityData(readLocalJson());
        initView();
        setResult(1);
    }

    private void initView() {
        btn_AddCity = (Button) findViewById(R.id.btn_AddCity);
        btn_AddCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View outerView = LayoutInflater.from(CityManager_Activity.this).inflate(R.layout.add_city, null);
                wp_province = (WheelPicker) outerView.findViewById(R.id.wp_province);
                wp_city = (WheelPicker) outerView.findViewById(R.id.wp_city);
                wp_district = (WheelPicker) outerView.findViewById(R.id.wp_district);

                wp_province.setIndicator(true);
                wp_city.setIndicator(true);
                wp_district.setIndicator(true);
                wp_province.setIndicatorColor(Color.parseColor("#03A9F4"));
                wp_city.setIndicatorColor(Color.parseColor("#03A9F4"));
                wp_district.setIndicatorColor(Color.parseColor("#03A9F4"));
                wp_province.setSelectedItemTextColor(Color.parseColor("#000000"));
                wp_city.setSelectedItemTextColor(Color.parseColor("#000000"));
                wp_district.setSelectedItemTextColor(Color.parseColor("#000000"));
                wp_province.setAtmospheric(true);
                wp_city.setAtmospheric(true);
                wp_district.setAtmospheric(true);

                if (CityData != null) {
                    for (int i = 0; i < CityData.getChina().size(); i++) {
                        provinceList.add(CityData.getChina().get(i).getProvince());
                    }

                    cityList.clear();
                    districtList.clear();
                    cityList.add(CityData.getChina().get(0).getCity().get(0).getName());
                    for (int i = 0; i < CityData.getChina().get(0).getCity().get(0).getArea().size(); i++) {
                        districtList.add(CityData.getChina().get(0).getCity().get(0).getArea().get(i));
                    }
                    SelectedItem = CityData.getChina().get(0).getCity().get(0).getArea().get(0);
                }

                wp_province.setData(provinceList);
                wp_city.setData(cityList);
                wp_district.setData(districtList);
                wp_city.setSelectedItemPosition(0);
                wp_district.setSelectedItemPosition(0);

                wp_province.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(WheelPicker picker, Object data, int position) {
                        provinceSelectedIndex = position;
                        cityList.clear();
                        districtList.clear();

                        for (int i = 0; i < CityData.getChina().get(position).getCity().size(); i++) {
                            cityList.add(CityData.getChina().get(position).getCity().get(i).getName());
                        }

                        if (CityData.getChina().get(provinceSelectedIndex).getCity().get(0).getArea() != null) {
                            for (int i = 0; i < CityData.getChina().get(provinceSelectedIndex).getCity().get(0).getArea().size(); i++) {
                                districtList.add(CityData.getChina().get(provinceSelectedIndex).getCity().get(0).getArea().get(i));
                            }
                            SelectedItem = CityData.getChina().get(provinceSelectedIndex).getCity().get(0).getArea().get(0);
                        }

                        wp_city.setData(cityList);
                        wp_city.setSelectedItemPosition(0);
                        wp_district.setData(districtList);
                        wp_district.setSelectedItemPosition(0);
                    }
                });
                wp_city.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(WheelPicker picker, Object data, int position) {
                        districtList.clear();
                        if (CityData.getChina().get(provinceSelectedIndex).getCity().get(position).getArea() != null) {
                            for (int i = 0; i < CityData.getChina().get(provinceSelectedIndex).getCity().get(position).getArea().size(); i++) {
                                districtList.add(CityData.getChina().get(provinceSelectedIndex).getCity().get(position).getArea().get(i));
                            }
                            SelectedItem = CityData.getChina().get(provinceSelectedIndex).getCity().get(position).getArea().get(0);
                        }

                        if (districtList != null) {
                            wp_district.setData(districtList);
                            wp_district.setSelectedItemPosition(0);
                        }
                    }
                });

                wp_district.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(WheelPicker picker, Object data, int position) {
                        SelectedItem = (String) data;
                    }
                });


                AlertDialog alertDialog = new AlertDialog.Builder(CityManager_Activity.this)
                        .setTitle("选择地区")
                        .setView(outerView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            /**
                             * 添加城市至sp储存
                             * */
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (provinceSelectedIndex == 1) {
                                    SelectedItem = "上海市";
                                }
                                if(!lv_CityData.contains(SelectedItem)){
                                    if (IsCityNull) {
                                        SPUtils.put("CITY", SelectedItem);
                                    } else {
                                        SPUtils.put("CITY", cityStr + "," + SelectedItem);
                                    }
                                    lv_CityData.add(SelectedItem);
                                    arrayAdapter.notifyDataSetChanged();
                                }else {
                                    Toast.makeText(CityManager_Activity.this,"该城市已存在",Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("取消", null)
                        .create();
                alertDialog.show();
                setDialogWindowAttr(alertDialog, CityManager_Activity.this);
            }
        });
    }

    public void initListView() {
        cityStr = (String) SPUtils.get("CITY", "");
        lv_city = (ListView) findViewById(R.id.lv_city);
        if (!cityStr.equals("")) {
            lv_CityData = Arrays.asList(cityStr.split(","));
            lv_CityData = new ArrayList<String>(lv_CityData);

        } else {
            lv_CityData = new ArrayList<String>();
            IsCityNull = true;
        }
        arrayAdapter = new CityAdapter(this, R.layout.lv_item,lv_CityData);
        lv_city.setAdapter(arrayAdapter);
    }

    public void setDialogWindowAttr(AlertDialog dlg, Context ctx) {
        Window window = dlg.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;//宽高可设置具体大小
        dlg.getWindow().setAttributes(lp);
    }

    public static <T> T ParseJson(String jsonString, Class<T> clazz) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = gson.fromJson(jsonString, clazz);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("解析json失败");
        }
        return t;
    }

    public void GetCityData(String chineseCitys) {
        CityData = ParseJson(chineseCitys, Citybean.class);

    }

    /**
     * 读取JSON文件
     */
    public String readLocalJson() {
        InputStream inputStream = getResources().openRawResource(R.raw.chinese);
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "GB2312");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("DDDDD----------", sb.toString() + "");
        return sb.toString();
    }
}
