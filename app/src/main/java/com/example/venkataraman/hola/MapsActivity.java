package com.example.venkataraman.hola;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.test.mock.MockPackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    GPSTracker gps;

    public GoogleMap mMap;

    public double x = 0, y = 0;
    public LatLng point, point1, point2;
    public Marker init, me, dest;
    public int clickCounter = 0;
    public double dist = 0;
    public int lvl = 0;

    public TextView dt, ln;
    public Button wai;

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    public String dist_trav, lvl_on;

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition will
                //execute every time, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        dt = (TextView) findViewById(R.id.dt);
        ln = (TextView) findViewById(R.id.ln);

        wai = (Button) findViewById(R.id.wai);

        wai.setFocusable(true);
        wai.setFocusableInTouchMode(true);
        wai.requestFocus();

        //DB
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..");
        progressDialog.setCancelable(false);
        progressDialog.show();


        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        firebaseUser = firebaseAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("UserProgress").child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProgress userProgress = dataSnapshot.getValue(UserProgress.class);

                dist_trav = userProgress.dist_trav;
                lvl_on = userProgress.lvl_on;

                //dt.setText("Distance Travelled : "+userProgress.dist_trav);
                //ln.setText("Level No. : "+userProgress.lvl_on);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Server is Busy..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setTrafficEnabled(true);

        gps = new GPSTracker(MapsActivity.this);

        if(gps.canGetLocation()){

            x = gps.getLatitude();
            y = gps.getLongitude();

            point = new LatLng(x, y);
            init = mMap.addMarker(new
                    MarkerOptions().position(point).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                            .flat(true));

            float zoomLevel = (float) 16.0;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, zoomLevel));

            wai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    GPSTracker gpsL = new GPSTracker(MapsActivity.this);

                    float[] results = new float[1];
                    results[0] = 0F;

                    if (clickCounter == 0) {
                        double a = 0, b = 0;
                        a = gpsL.getLatitude();
                        b = gpsL.getLongitude();
                        point1 = new LatLng(a, b);

                        Location.distanceBetween(point.latitude, point.longitude, point1.latitude, point1.longitude, results);

                        me = mMap.addMarker(new
                                MarkerOptions().position(point1).title("You Moved Here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                                .flat(true));
                        clickCounter++;

                        point2 = point1;
                    }
                    else if (clickCounter > 0) {

                        me.remove();

                        double a = 0, b = 0;
                        a = gpsL.getLatitude();
                        b = gpsL.getLongitude();
                        point1 = new LatLng(a, b);

                        Location.distanceBetween(point2.latitude, point2.longitude, point1.latitude, point1.longitude, results);

                        me = mMap.addMarker(new
                                MarkerOptions().position(point1).title("You Moved Here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                                .flat(true));

                        point2 = point1;
                    }

                    mMap.moveCamera(CameraUpdateFactory.newLatLng(point1));

                    if (results[0] > 20F) {
                        dist = dist + (results[0] / 1000);
                        dt.setText("Distance Travelled : " + Double.toString(dist) + " kms");
                    }
                }
            });

        }
        else{
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
    }

    @Override
    protected void onPause() {
        FirebaseUser user = firebaseAuth.getCurrentUser();

        double tmp = dist + Double.parseDouble(dist_trav);

        databaseReference.child("UserProgress").child(user.getUid()).child("dist_trav").setValue(Double.toString(tmp));
        //databaseReference.child("UserProgress").child(user.getUid()).child("lvl_on").setValue("");

        if (tmp >= (double) 0 && tmp < (double) 5) {
            databaseReference.child("UserProgress").child(user.getUid()).child("lvl_on").setValue("Level 1");
        }
        else if (tmp >= 5 && tmp < 15) {
            databaseReference.child("UserProgress").child(user.getUid()).child("lvl_on").setValue("Level 2");
        }
        else if (tmp >= 15 && tmp < 30) {
            databaseReference.child("UserProgress").child(user.getUid()).child("lvl_on").setValue("Level 3");
        }
        else if (tmp >= 30 && tmp < 50) {
            databaseReference.child("UserProgress").child(user.getUid()).child("lvl_on").setValue("Level 4");
        }
        else if (tmp >= 50 && tmp < 100) {
            databaseReference.child("UserProgress").child(user.getUid()).child("lvl_on").setValue("Level 5");
        }
        else if (tmp >= 100) {
            databaseReference.child("UserProgress").child(user.getUid()).child("lvl_on").setValue("Level 6");
        }

        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
