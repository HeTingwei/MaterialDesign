package com.example.htw;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.htw.materialdesign.R;

/**
 * Created by HeTingwei on 2018/4/1.
 * <p>
 * 可折叠式标题栏CollapsingToolbarLayout
 * CollapsingToolbarLayout必须做AppBarLayout的子布局，
 * AppBarLayout必须做CoordinatorLayout的子布局
 */

public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    private CollapsingToolbarLayout mCollapsingToolbar;
    private AppBarLayout mAppBarLayout;
    private TextView mTextFruit;
    private ImageView mImageView;
    private Toolbar mToolbar;

    private StringBuffer content = new StringBuffer();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);
        initText();
        initView();
    }

    private void initView() {
        mAppBarLayout = findViewById(R.id.appBar);
        mCollapsingToolbar = findViewById(R.id.collapsing_toolbar);
        mTextFruit = findViewById(R.id.fruit_text);
        mImageView = findViewById(R.id.fruit_image_view);
        mToolbar = findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        mCollapsingToolbar.setTitle("一堆苹果");
        mImageView.setImageResource(R.drawable.some_apples);
        mTextFruit.setText(content.toString());
    }

    private void initText(){
        for (int i = 0; i <50 ; i++) {
            content.append("There are some apples. ");
        }
    }
}
