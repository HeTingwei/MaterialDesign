package com.example.htw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.htw.materialdesign.R;

/**
 * Created by HeTingwei on 2018/4/1.
 */

public class ToolbarActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        toolbar = findViewById(R.id.toolbar);

        //下面方法只有在setSupportActionBar前才能生效
        toolbar.setLogo(R.drawable.ic_launcher_foreground);//在侧setNavigationIcon图标右侧添加一个图标
        toolbar.setTitle("标题");//不设置就使用activity的label，依然没有的话就是app的label
        toolbar.setSubtitle("子标题");
        setSupportActionBar(toolbar);
//添加左侧图标的点击事件在setSupportActionBar之后才能生效
        addHomeButton();
    }



    //在ToolBar最左侧添加一个按钮
    private void addHomeButton() {
        toolbar.setNavigationIcon(R.drawable.ic_home_black_24dp);//左侧按钮图标(不设置就没有)
        //左侧按钮点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToolbarActivity.this, "home is click", Toast.LENGTH_SHORT).show();
            }
        });
    }


//在toolbar右侧开始添加按钮及其点击事件，这些之中只要有
//    不直接显示出来的就会在ToolBar右侧自动加一个more按钮
//    点击就会显示菜单，显示未显示在toolbar上的项
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();

                break;
            case R.id.backup:
                Toast.makeText(this, "more", Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
