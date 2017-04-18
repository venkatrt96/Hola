package com.example.venkataraman.hola;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;

    //defining a database reference
    private DatabaseReference databaseReference;

    //our new views
    private EditText editTextName, editTextAddress, h, w;
    private Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("My Profile");

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.Sugar));


        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();


        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting the database reference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //getting the views from xml resource
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextName = (EditText) findViewById(R.id.editTextName);
        h = (EditText) findViewById(R.id.h);
        w = (EditText) findViewById(R.id.w);

        buttonSave = (Button) findViewById(R.id.buttonSave);


        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome " + user.getEmail());

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(ProfileActivity.this, NavActivity.class);
            startActivity(i);
            //finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }


    private void saveUserInformation() {
        //Getting values from database
        String name = editTextName.getText().toString().trim();
        String add = editTextAddress.getText().toString().trim();
        String height = h.getText().toString().trim();
        String weight = w.getText().toString().trim();

        //creating a userinformation object
        //UserInformation userInformation = new UserInformation(name, add);
        //userInformation.setHeight(height);
        //userInformation.setWeight(weight);

        //getting the current logged in user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (!editTextName.getText().toString().trim().equals("")) {
            databaseReference.child("UserProfile").child(user.getUid()).child("name").setValue(editTextName.getText().toString().trim());
        }
        if (!editTextAddress.getText().toString().trim().equals("")) {
            databaseReference.child("UserProfile").child(user.getUid()).child("address").setValue(editTextAddress.getText().toString().trim());
        }
        if (!h.getText().toString().trim().equals("")) {
            databaseReference.child("UserProfile").child(user.getUid()).child("height").setValue(h.getText().toString().trim());
        }
        if (!w.getText().toString().trim().equals("")) {
            databaseReference.child("UserProfile").child(user.getUid()).child("weight").setValue(w.getText().toString().trim());
        }

        //displaying a success toast
        Toast.makeText(this, "Information Saved", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if (view == buttonLogout) {
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        if(view == buttonSave){
            saveUserInformation();

            Intent i = new Intent(ProfileActivity.this, NavActivity.class);
            startActivity(i);
            finish();
        }

    }
}