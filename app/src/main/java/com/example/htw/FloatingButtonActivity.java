package com.example.htw;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.htw.materialdesign.R;

/**
 * Created by HeTingwei on 2018/4/1.
 */

public class FloatingButtonActivity extends AppCompatActivity {

    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_button);
        initView();
    }

    private void initView() {
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //讲setAction方法去掉就不会在Snackbar右端显示可点击按钮
                Snackbar.make(view, "这是一个Snackbar", Snackbar.LENGTH_SHORT).setAction("点击", new
                        View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(FloatingButtonActivity.this, "Snackbar上的按钮被点击了", Toast
                                .LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }


}
