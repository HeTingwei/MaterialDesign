package com.example.htw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.htw.materialdesign.R;

/**
 * Created by HeTingwei on 2018/4/1.
 *
* DrawerLayout布局文件完成以后，就可以直接通过在屏幕向拉出布局
* */
public class ScrollMenuActivity extends AppCompatActivity {

    private DrawerLayout mLayoutDrawer;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_menu);
        initView();
    }

    private void initView() {
        mLayoutDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_home_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayoutDrawer.openDrawer(GravityCompat.START);
            }
        });
        //navigationView子项点击事件
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_friends);//设置打开时选定的项
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mLayoutDrawer.closeDrawers();
                Toast.makeText(ScrollMenuActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        //获取navigationView的头部layout
        View header = navigationView.getHeaderView(0);
        header.findViewById(R.id.avatar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ScrollMenuActivity.this, "头像", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
