package com.example.htw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.htw.materialdesign.R;

import java.util.ArrayList;

/**
 * Created by HeTingwei on 2018/4/1.
 *
* 用recyclerview展示子项cardview,使用AppbarLayout
* */
public class CardViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        initView();
    }

    private void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(new FruitAdapter());
    }

    class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

        ArrayList<Fruit> list = new ArrayList<>();

        public FruitAdapter() {
            initData();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(CardViewActivity.this).inflate(R.layout
                            .recyclervew_item,
                    parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(list.get(position).getText());
            holder.imageView.setImageResource(list.get(position).getImageId());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        private void initData(){
            for (int i = 0; i <10; i++) {
                    list.add(new Fruit(R.drawable.apple, "Apple"));
                    list.add(new Fruit(R.drawable.banana, "Banana"));
            }
        }


        class ViewHolder extends RecyclerView.ViewHolder {
            CardView cardView;
            ImageView imageView;
            TextView textView;
            public ViewHolder(View view) {
                super(view);
                cardView = (CardView) view;
                imageView = cardView.findViewById(R.id.img);
                textView = cardView.findViewById(R.id.text);
            }
        }
    }

    class Fruit {
        private int imageId;
        private String text;

        public Fruit(int imageId, String text) {
            this.imageId = imageId;
            this.text = text;
        }

        public int getImageId() {
            return imageId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
