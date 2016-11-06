package com.app.xxy.dropdownpopwindow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.xxy.dropdownpopwindow.R;

import java.util.List;

/**
 * Created by xxy on 2016/11/4.
 */
public class PopWindowAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData;

    public PopWindowAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         viewHolder holder;
        if(view == null) {
            holder = new viewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_popwindow_content, null);
            holder.tv_content = (TextView) view.findViewById(R.id.tv_content);
            view.setTag(holder);
        } else {
          holder = (viewHolder) view.getTag();
        }
        holder.tv_content.setText(mData.get(i));
        return view;
    }

    class viewHolder {
        TextView tv_content;
    }
}
