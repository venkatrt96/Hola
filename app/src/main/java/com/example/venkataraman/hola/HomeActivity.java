package com.example.venkataraman.hola;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    public TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Hola Health Assistant");

        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.Sugar));

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent j = new Intent(HomeActivity.this, FirstActivity.class);
                    startActivity(j);
                }
                if (position == 1) {
                    Intent j = new Intent(HomeActivity.this, MapsActivity.class);
                    startActivity(j);
                }
                if (position == 2) {
                    Intent j = new Intent(HomeActivity.this, TestActivity.class);
                    startActivity(j);
                }
                if (position == 3) {
                    Intent j = new Intent(HomeActivity.this, DietActivity.class);
                    startActivity(j);
                }
                if (position == 4) {
                    Intent j = new Intent(HomeActivity.this, ProgActivity.class);
                    startActivity(j);
                }
                if (position == 5) {
                    Intent j = new Intent(HomeActivity.this, ProfileActivity.class);
                    startActivity(j);
                }
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {

            mContext = c;
        }

        public int getCount() {

            return mThumbsIda.length;
        }

        public Object getItem(int position) {
            return  null;
        }

        public long getItemId(int position) {

            return 0;
        }

        public View getView (int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;

            imageView.setLayoutParams(new GridView.LayoutParams(width/2,height/3));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            imageView.setImageResource(mThumbsIda[position]);
            return imageView;
        }

        private Integer[] mThumbsIda = {
                R.drawable.unnamed,
                R.drawable.mapsicon,
                R.drawable.en,
                R.drawable.diet,
                R.drawable.stat,
                R.drawable.profileicon9

        };
    }
}
