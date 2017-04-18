package com.example.venkataraman.hola;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private TextView ca;
    private EditText e_mail, pass;
    private Button button;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            //close this activity
            finish();
            //opening profile activity
            startActivity(new Intent(getApplicationContext(), NavActivity.class));
        }

        e_mail = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        button = (Button) findViewById(R.id.log);

        ca = (TextView) findViewById(R.id.reg);

        progressDialog = new ProgressDialog(this);

        button.setOnClickListener(this);
        ca.setOnClickListener(this);
    }

    public void userLogin() {
        final String em = e_mail.getText().toString();
        final String pa = pass.getText().toString();

        if (TextUtils.isEmpty(em)) {
            Toast.makeText(this, "Please Enter Your Email Id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pa)) {
            Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(em, pa).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), NavActivity.class));
                        }
                    }
                });
    }

    public void onRegClick() {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            userLogin();
        }

        if (v == ca) {
            onRegClick();
        }
    }
}
