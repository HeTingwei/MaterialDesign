package com.example.htw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.htw.materialdesign.R;

/**
 * Created by HeTingwei on 2018/4/1.
 */

public class MainActivity extends AppCompatActivity {

    String[] data = new String[]{
            "Toolar",
            "侧面滑动的菜单(Drawerlayout and NavigationView)",
            "悬浮按钮和可交互提示(FloatingActionButton Snackbar,Coordinator)",
            "卡片布局(CardView AppbarLayout recyclerView)",
            "可折叠式标题栏(CollapsingToolbarLayoutActivity)"
    };

    Class<?> cla[] = new Class[]{ToolbarActivity.class, ScrollMenuActivity.class,
            FloatingButtonActivity.class,CardViewActivity.class,
            CollapsingToolbarLayoutActivity.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(new Intent(MainActivity.this, cla[position]));

            }
        });

    }

}
