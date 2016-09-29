package com.cmz_one.easyweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cmz_one.easyweather.R;
import com.cmz_one.easyweather.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmz_o on 2016/9/24.
 */

public class CityAdapter extends ArrayAdapter<String> {

    private List<String> list = new ArrayList<String>();
    private int resourceID;

    public CityAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        resourceID  = resource;
        list = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
            viewHolder.button = (ImageButton) view.findViewById(R.id.btn_delete);
            viewHolder.textView = (TextView) view.findViewById(R.id.tv_city);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(list.get(position));
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                String listStr = list.toString().replace("[","").replace("]","").replace(" ","");
                SPUtils.put("CITY", listStr);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    class ViewHolder {
        TextView textView;
        ImageButton button;
    }


}
