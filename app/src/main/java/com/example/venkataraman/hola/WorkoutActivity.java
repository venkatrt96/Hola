package com.example.venkataraman.hola;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.icu.util.Calendar;
import android.widget.Toast;

public class WorkoutActivity extends AppCompatActivity {

    SQLiteDatabaseHelper db;
    SQLiteDatabase d;
    Cursor cursor;

    TextView day, progress, history;

    CheckBox pu, plu, su, c, p, t, e, cy;
    EditText puc, pluc, suc, cc, pt, tt, et, cyt;

    Button process;

    String today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Workout Plan");

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.Sugar));

        day = (TextView) findViewById(R.id.day);

        Calendar calendar = Calendar.getInstance();
        String day_of_week = getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
        day.setText("Day : "+day_of_week);
        //getWork(day_of_week);

        int date = calendar.get(Calendar.DATE);
        String Date = String.valueOf(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        String Month = String.valueOf(month);
        int year = calendar.get(Calendar.YEAR);
        String Year = String.valueOf(year);
        //Toast.makeText(this, Date+" "+Month+" "+Year, Toast.LENGTH_SHORT).show();

        today = Date+"/"+Month+"/"+Year;

        //init
        pu = (CheckBox) findViewById(R.id.pu);
        plu = (CheckBox) findViewById(R.id.plu);
        su = (CheckBox) findViewById(R.id.su);
        c = (CheckBox) findViewById(R.id.c);
        p = (CheckBox) findViewById(R.id.p);
        t = (CheckBox) findViewById(R.id.t);
        e = (CheckBox) findViewById(R.id.e);
        cy = (CheckBox) findViewById(R.id.cy);

        puc = (EditText) findViewById(R.id.npu);
        pluc = (EditText) findViewById(R.id.nplu);
        suc = (EditText) findViewById(R.id.nsu);
        cc = (EditText) findViewById(R.id.nc);
        pt = (EditText) findViewById(R.id.pt);
        tt = (EditText) findViewById(R.id.tt);
        et = (EditText) findViewById(R.id.et);
        cyt = (EditText) findViewById(R.id.cyt);

        process = (Button) findViewById(R.id.process);
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processing();
            }
        });

        progress = (TextView) findViewById(R.id.progress);

        history = (TextView) findViewById(R.id.history);

        progress.setVisibility(View.GONE);
        //history.setVisibility(View.GONE);

        db = new SQLiteDatabaseHelper(this);
        d = openOrCreateDatabase("Hola.db", Context.MODE_PRIVATE, null);

        history.setText("History : \n\n");

        /*
        cursor = d.rawQuery("select * from work group by date", null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();

            String story = history.getText().toString();
            String getStory = "";

            int count = cursor.getCount();

            while (count > 0) {
                String d = cursor.getString(0);
                String cal = cursor.getString(1);

                getStory = getStory+"Date : "+d+"\n"+"Calories Burnt : "+cal+"\n\n";

                count--;
                cursor.moveToNext();
            }
            story = story + getStory;

            history.setText(story);
        }
        else {
            String story = history.getText().toString();
            String getStory = "";

            story = story + getStory;

            history.setText(story);
        }
        */
    }

    public void processing() {

        int kalCount = 0;

        if (pu.isChecked()) {
            String str = puc.getText().toString().trim();
            int c = Integer.parseInt(str);
            kalCount = (int) (kalCount + (c*0.825));
        }
        if (plu.isChecked()) {
            String str = pluc.getText().toString().trim();
            int c = Integer.parseInt(str);
            kalCount = (int) (kalCount + c);
        }
        if (su.isChecked()) {
            String str = suc.getText().toString().trim();
            int c = Integer.parseInt(str);
            kalCount = (int) (kalCount + (c*5.6));
        }
        if (c.isChecked()) {
            String str = cc.getText().toString().trim();
            int c = Integer.parseInt(str);
            kalCount = (int) (kalCount + (c*0.159));
        }
        if (p.isChecked()) {
            String str = pt.getText().toString().trim();
            int c = Integer.parseInt(str);
            kalCount = (int) (kalCount + (c*3.5));
        }
        if (t.isChecked()) {
            String str = tt.getText().toString().trim();
            int c = Integer.parseInt(str);
            kalCount = (int) (kalCount + (c*7.55));
        }
        if (e.isChecked()) {
            String str = et.getText().toString().trim();
            int c = Integer.parseInt(str);
            kalCount = (int) (kalCount + (c*10));
        }
        if (cy.isChecked()) {
            String str = cyt.getText().toString().trim();
            int c = Integer.parseInt(str);
            kalCount = (int) (kalCount + (c*6));
        }

        String back = String.valueOf(kalCount);

        progress.setVisibility(View.VISIBLE);

        progress.setText("Calories Burnt : "+back);

        boolean result = db.onInsert(today, back);

        String story = history.getText().toString();
        String getStory = "";

        if (result) {
            history.setVisibility(View.VISIBLE);

            cursor = d.rawQuery("select * from work group by date", null);
            cursor.moveToFirst();

            int count = cursor.getCount();

            while (count > 0) {
                String d = cursor.getString(0);
                String cal = cursor.getString(1);

                getStory = getStory+"Date : "+d+"\n"+"Calories Burnt : "+cal+"\n\n";

                count--;
                cursor.moveToNext();
            }
            story = "History : \n\n" + getStory;

            history.setText(story);
        }
        else {
            Toast.makeText(getApplicationContext(), "Database Error", Toast.LENGTH_LONG).show();
        }
    }

    private String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }
}
