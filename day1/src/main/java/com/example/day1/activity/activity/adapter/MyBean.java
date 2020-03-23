package com.example.day1.activity.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.day1.R;
import com.example.day1.activity.activity.bean.NewsInfo;

import java.util.ArrayList;
import java.util.List;

public class MyBean extends BaseAdapter {
    private List<NewsInfo> list = new ArrayList<>();
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lay,parent,false);
            holder = new Holder();
            holder.textView = convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        NewsInfo newsInfo = list.get(position);
        holder.textView.setText(newsInfo.desc);
        return convertView;
    }
    class Holder{
        TextView textView;
    }
    public void clear() {
        list.clear();
    }
    public void addAll(List<NewsInfo> data){
        if (data!=null){
            list.addAll(data);
        }
    }
}
