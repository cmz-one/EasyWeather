package com.cmz_one.easyweather.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.cmz_one.easyweather.fragment.Item_Fragment;
import com.cmz_one.easyweather.utils.Location;
import com.cmz_one.easyweather.R;
import com.cmz_one.easyweather.utils.SPUtils;
import com.cmz_one.easyweather.adapter.FragmentAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.Bundler;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private List<String> citylist;
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;
    private Location location;
    private FragmentAdapter adapter;
    private FragmentPagerItems fragmentPagerItems;
    private ArrayList<FragmentPagerItem> list = new ArrayList<FragmentPagerItem>();
    private String district;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        SPUtils.init(getApplicationContext());
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        fragmentPagerItems = new FragmentPagerItems(this);
        location = new Location(MainActivity.this,handler);
        location.location();
        getCityList();
        addList();

    }

    private void addList(){
        for(int i=0;i<citylist.size();i++){
            FragmentPagerItem itemSP = FragmentPagerItem.of(citylist.get(i), Item_Fragment.class,new Bundler().putString("city",citylist.get(i)).get());
            list.add(itemSP);
        }
    }


    /**
     * 初始化Toolbar
     */
    public void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.action_add){
                    Intent intent = new Intent(MainActivity.this,CityManager_Activity.class);
                    startActivityForResult(intent,0);

                }
                return true;
            }
        });

    }

    private void getCityList(){
        String citys = (String) SPUtils.get("CITY", "");
        if (!citys.equals("")) {
            if(citylist!=null){
                citylist.clear();
            }
            citylist = Arrays.asList(citys.split(","));
            citylist = new ArrayList<String>(citylist);
            //遍历ArrayList，把每个区、县字符截去
            for(int i = 0;i<citylist.size();i++){
                String str = citylist.get(i);

                    String nstr = str.substring(0, str.length() - 1);//截取区/县字符
                    citylist.set(i, nstr);

            }
        } else {
            citylist = new ArrayList<String>();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            getCityList();
            Log.e("eeeeee","------------------"+citylist.toString());
            list.clear();
            FragmentPagerItem item = FragmentPagerItem.of("当前", Item_Fragment.class,new Bundler().putString("city",district).get());
            list.add(item);
            addList();
            fragmentPagerItems.clear();
            fragmentPagerItems.addAll(list);
            adapter = new FragmentAdapter(
                    getSupportFragmentManager(), fragmentPagerItems);
            viewPager.removeAllViews();
            viewPager.setAdapter(adapter);
            viewPagerTab.setViewPager(viewPager);

        }
    }

    private Handler handler = new Handler(){

        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Bundle bundle = msg.getData();
                    district = bundle.getString("District");
                    FragmentPagerItem item = FragmentPagerItem.of("当前", Item_Fragment.class,new Bundler().putString("city",district).get());
                    list.add(0,item);
                    fragmentPagerItems.addAll(list);
                    adapter = new FragmentAdapter(
                            getSupportFragmentManager(), fragmentPagerItems);
                    viewPager.setAdapter(adapter);
                    viewPager.setOffscreenPageLimit(4);
                    viewPagerTab.setViewPager(viewPager);

                    break;

                default:
                    break;
            }
        }
    };









}
