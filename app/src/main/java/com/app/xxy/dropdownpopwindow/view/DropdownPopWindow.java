package com.app.xxy.dropdownpopwindow.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.app.xxy.dropdownpopwindow.R;
import com.app.xxy.dropdownpopwindow.adapter.PopWindowAdapter;
import com.app.xxy.dropdownpopwindow.xinterface.PopWindowCallback;

import java.util.List;

/**
 * Created by xxy on 2016/11/2.
 */

public class DropdownPopWindow implements AdapterView.OnItemClickListener, View.OnClickListener{
    private Context mContext;
    private List<String> mData;
    private boolean mIsShow;
    private PopupWindow popupWindow;
    private PopWindowCallback mCallback;
    private View mView;

    public DropdownPopWindow(View v, Context context, List<String> data) {
        mContext = context;
        mData = data;
        mView = v;
    }

    public void showPopWindow() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.popwindow_main, null, false);
        ListView listView = (ListView) view.findViewById(R.id.lv_popwindow);
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_popwindow);
        ll.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(new PopWindowAdapter(mContext, mData));
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAsDropDown(mView);
        mIsShow = true;
    }

    public void closePopWindow() {
        popupWindow.dismiss();
        mIsShow = false;
        popupWindow = null;
    }

    public boolean isShow() {
        return mIsShow;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(mCallback != null) {
            mCallback.setData(mData.get(i), i);
            closePopWindow();
        }

    }

    public void setCallback(PopWindowCallback callback) {
        mCallback = callback;
    }

    @Override
    public void onClick(View view) {
        closePopWindow();
    }
}
