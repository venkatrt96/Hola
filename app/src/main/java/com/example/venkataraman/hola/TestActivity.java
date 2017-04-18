package com.example.venkataraman.hola;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView btype, btypecontent;
    public Button eval;
    public ProgressDialog progressDialog;

    public RadioGroup gender, shoulder, jeans, fore, tends, looks, mat, wei, chest;
    public String selection, selection1, selection2, selection3, selection4, selection5, selection6, selection7, selection8;
    public boolean[] flag = new boolean[10];

    public int endo = 0, ecto = 0, meso = 0;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("Knowing My Body");

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.Sugar));

        btype = (TextView) findViewById(R.id.btype);
        btypecontent = (TextView) findViewById(R.id.btypecontent);

        String bstr = "There are 3 body types :\n" + "Complete the below given options to know yours !";
        btypecontent.setText(bstr);

        eval = (Button) findViewById(R.id.eval);
        eval.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);

        gender = (RadioGroup) findViewById(R.id.gender);
        shoulder = (RadioGroup) findViewById(R.id.shoulder);
        jeans = (RadioGroup) findViewById(R.id.jeans);
        fore = (RadioGroup) findViewById(R.id.fore);
        tends = (RadioGroup) findViewById(R.id.tends);
        looks = (RadioGroup) findViewById(R.id.looks);
        mat = (RadioGroup) findViewById(R.id.mat);
        wei = (RadioGroup) findViewById(R.id.wei);
        chest = (RadioGroup) findViewById(R.id.chest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(TestActivity.this, NavActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == eval) {

            progressDialog.setMessage("Calculating..");
            progressDialog.setCancelable(false);
            progressDialog.show();

            if (gender.getCheckedRadioButtonId() != -1) {
                int id= gender.getCheckedRadioButtonId();
                View radioButton = gender.findViewById(id);
                int radioId = gender.indexOfChild(radioButton);
                RadioButton genderChildAt = (RadioButton) gender.getChildAt(radioId);
                selection = (String) genderChildAt.getText();
                flag[0] = true;
            }
            else {
                flag[0] = false;
            }

            if (shoulder.getCheckedRadioButtonId() != -1) {
                int id= shoulder.getCheckedRadioButtonId();
                View radioButton = shoulder.findViewById(id);
                int radioId = shoulder.indexOfChild(radioButton);
                RadioButton shoulderChildAt = (RadioButton) shoulder.getChildAt(radioId);
                selection1 = (String) shoulderChildAt.getText();
                flag[1] = true;
            }
            else {
                flag[1] = false;
            }

            if (jeans.getCheckedRadioButtonId() != -1) {
                int id= jeans.getCheckedRadioButtonId();
                View radioButton = jeans.findViewById(id);
                int radioId = jeans.indexOfChild(radioButton);
                RadioButton jeansChildAt = (RadioButton) jeans.getChildAt(radioId);
                selection2 = (String) jeansChildAt.getText();
                flag[2] = true;
            }
            else {
                flag[2] = false;
            }

            if (fore.getCheckedRadioButtonId() != -1) {
                int id= fore.getCheckedRadioButtonId();
                View radioButton = fore.findViewById(id);
                int radioId = fore.indexOfChild(radioButton);
                RadioButton foreChildAt = (RadioButton) fore.getChildAt(radioId);
                selection3 = (String) foreChildAt.getText();
                flag[3] = true;
            }
            else {
                flag[3] = false;
            }

            if (tends.getCheckedRadioButtonId() != -1) {
                int id= tends.getCheckedRadioButtonId();
                View radioButton = tends.findViewById(id);
                int radioId = tends.indexOfChild(radioButton);
                RadioButton tendsChildAt = (RadioButton) tends.getChildAt(radioId);
                selection4 = (String) tendsChildAt.getText();
                flag[4] = true;
            }
            else {
                flag[4] = false;
            }

            if (looks.getCheckedRadioButtonId() != -1) {
                int id= looks.getCheckedRadioButtonId();
                View radioButton = looks.findViewById(id);
                int radioId = looks.indexOfChild(radioButton);
                RadioButton looksChildAt = (RadioButton) looks.getChildAt(radioId);
                selection5 = (String) looksChildAt.getText();
                flag[5] = true;
            }
            else {
                flag[5] = false;
            }

            if (mat.getCheckedRadioButtonId() != -1) {
                int id= mat.getCheckedRadioButtonId();
                View radioButton = mat.findViewById(id);
                int radioId = mat.indexOfChild(radioButton);
                RadioButton matChildAt = (RadioButton) mat.getChildAt(radioId);
                selection6 = (String) matChildAt.getText();
                flag[6] = true;
            }
            else {
                flag[6] = false;
            }

            if (wei.getCheckedRadioButtonId() != -1) {
                int id= wei.getCheckedRadioButtonId();
                View radioButton = wei.findViewById(id);
                int radioId = wei.indexOfChild(radioButton);
                RadioButton weiChildAt = (RadioButton) wei.getChildAt(radioId);
                selection7 = (String) weiChildAt.getText();
                flag[7] = true;
            }
            else {
                flag[7] = false;
            }

            if (chest.getCheckedRadioButtonId() != -1) {
                int id= chest.getCheckedRadioButtonId();
                View radioButton = chest.findViewById(id);
                int radioId = chest.indexOfChild(radioButton);
                RadioButton chestChildAt = (RadioButton) chest.getChildAt(radioId);
                selection8 = (String) chestChildAt.getText();
                flag[8] = true;
            }
            else {
                flag[8] = false;
            }

            for (int i = 0; i < 9; i++) {
                if (flag[i] == false) {
                    flag[9] = false;
                    break;
                }

                flag[9] = true;
            }

            if (!flag[9]) {
                Toast.makeText(getApplicationContext(), "Check All The Boxes !", Toast.LENGTH_LONG).show();
            }
            else {
                ecto = 0;
                endo = 0;
                meso = 0;

                //Toast.makeText(getApplicationContext(), "Cool !", Toast.LENGTH_LONG).show();

                if (selection1.equals("Wider than my hips")) {
                    ecto++;
                }
                else if (selection1.equals("The same width as my hips")) {
                    meso++;
                }
                else if (selection1.equals("Narrower than my hips")) {
                    endo++;
                }

                if (selection2.equals("Tight around my glutes")) {
                    endo++;
                }
                else if (selection2.equals("Perfect around my glutes")) {
                    meso++;
                }
                else if (selection2.equals("Loose around my glutes")) {
                    ecto++;
                }

                if (selection3.equals("Big")) {
                    endo++;
                }
                else if (selection3.equals("Average")) {
                    meso++;
                }
                else if (selection3.equals("Small")) {
                    ecto++;
                }

                if (selection4.equals("Carry a bit of extra fat")) {
                    endo++;
                }
                else if (selection4.equals("Stay lean, yet muscular")) {
                    meso++;
                }
                else if (selection4.equals("Stay skinny")) {
                    ecto++;
                }

                if (selection5.equals("Round and soft")) {
                    endo++;
                }
                else if (selection5.equals("Square and rugged")) {
                    meso++;
                }
                else if (selection5.equals("Long and narrow")) {
                    ecto++;
                }

                if (selection6.equals("The middle finger and thumb do not touch")) {
                    endo++;
                }
                else if (selection6.equals("The middle finger and thumb just touch")) {
                    meso++;
                }
                else if (selection6.equals("The middle finger and thumb overlap")) {
                    ecto++;
                }

                if (selection7.equals("Gain weight easily, but find it hard to lose")) {
                    endo++;
                }
                else if (selection7.equals("I can gain and lose without too much of a struggle.")) {
                    meso++;
                }
                else if (selection7.equals("Have trouble gaining weight in the form of muscle or fat.")) {
                    ecto++;
                }

                if (selection8.equals("43 inches or more.")) {
                    endo++;
                }
                else if (selection8.equals("37-43 inches.")) {
                    meso++;
                }
                else if (selection8.equals("37 inches or less.")) {
                    ecto++;
                }
            }

            String str = "Ectomorph : "+Float.toString((float) ecto*100/8)+
                    "%\nMesomorph : "+Float.toString((float) meso*100/8)+
                    "%\nEndomorph : "+Float.toString((float) endo*100/8)+"%\n\n";

            if (endo > ecto && endo > meso) {
                btype.setText(str+"You're primarily an ENDOMORPH");
            }
            else if (meso > ecto && meso > endo) {
                btype.setText(str+"You're primarily an MESOMORPH");
            }
            else if (ecto > endo && ecto > meso) {
                btype.setText(str+"You're primarily an ECTOMORPH");
            }
            else if (endo == meso && endo > ecto && meso > ecto) {
                btype.setText(str+"You're half ENDOMORPH & half ENDOMORPH");
            }
            else if (ecto == meso && ecto > endo && meso > endo) {
                btype.setText(str+"You're half ENDOMORPH & half ECTOMORPH");
            }

            progressDialog.dismiss();
        }
    }
}
