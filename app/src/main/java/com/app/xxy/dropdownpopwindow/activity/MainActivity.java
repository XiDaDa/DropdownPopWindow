package com.app.xxy.dropdownpopwindow.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.xxy.dropdownpopwindow.R;
import com.app.xxy.dropdownpopwindow.view.DropdownPopWindow;
import com.app.xxy.dropdownpopwindow.xinterface.PopWindowCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxy on 2016/11/2.
 */
public class MainActivity extends Activity implements View.OnClickListener,PopWindowCallback {
    private TextView tv_header;
    private TextView tv_content;
    private LinearLayout lr_header;
    private List<String> mData =  new ArrayList<>();
    private DropdownPopWindow popWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPopWindow();
    }

    private void initView() {
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_header = (TextView) findViewById(R.id.tv_head);
        lr_header = (LinearLayout) findViewById(R.id.rl_header);
        lr_header.setOnClickListener(this);
    }

    private void initPopWindow() {
        mData.add("测试一");
        mData.add("测试二");
        mData.add("测试三");
        popWindow = new DropdownPopWindow(lr_header,this,mData);
        popWindow.setCallback(this);
    }

    @Override
    public void onClick(View view) {
        if(popWindow.isShow()) {
            popWindow.closePopWindow();
        } else {
            popWindow.showPopWindow();
        }
    }

    @Override
    public void setData(String data, int position) {
        tv_header.setText(data);
        tv_content.setText(data);
    }
}
