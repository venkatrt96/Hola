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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText e_mail, pass;
    private Button b;

    private ProgressDialog pd;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        e_mail = (EditText) findViewById(R.id.editText2);
        pass = (EditText) findViewById(R.id.editText3);

        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);

        pd = new ProgressDialog(this);
    }

    private void registerUser() {
        final String em = e_mail.getText().toString();
        final String pa = pass.getText().toString();

        if (TextUtils.isEmpty(em)) {
            Toast.makeText(this, "Please Enter Your Email Id", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pa)) {
            Toast.makeText(this, "Please Enter A Password", Toast.LENGTH_SHORT).show();
            return;
        }

        pd.setMessage("Registering User ...");
        pd.setCancelable(false);
        pd.show();

        firebaseAuth.createUserWithEmailAndPassword(em, pa).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //init cond
                            databaseReference = FirebaseDatabase.getInstance().getReference();
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            databaseReference.child("UserProgress").child(user.getUid()).child("dist_trav").setValue("0.0");
                            databaseReference.child("UserProgress").child(user.getUid()).child("lvl_on").setValue("");

                            pd.dismiss();

                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        }
                        else {
                            pd.dismiss();

                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == b) {
            registerUser();
        }
    }
}
