package com.example.cardiopediafyp;

import static com.example.cardiopediafyp.R.id.bottom_home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PatientDashboardActivity extends AppCompatActivity {
    TextView tvFirstName;
    EditText editText;
    ImageView searchButton;
    ImageView account_info, MedTrack, findadoctor, docslot, patienthistory;
    BottomNavigationView bottomNavigationView;

    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        // Initialize views
        tvFirstName = findViewById(R.id.textHello);
        editText = findViewById(R.id.edittexts);
        searchButton = findViewById(R.id.searchbtn);
        account_info = findViewById(R.id.imageMenu);
        MedTrack = findViewById(R.id.MedTrack);
        findadoctor = findViewById(R.id.FindADoctor);
        docslot = findViewById(R.id.DocSlot);
        patienthistory = findViewById(R.id.PatientRecord);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set window insets listener
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return WindowInsetsCompat.CONSUMED;
            });
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredValue = editText.getText().toString();
                Intent intent = new Intent(PatientDashboardActivity.this, sercvicesActivity.class);
                intent.putExtra("enteredValue", enteredValue); // Pass the entered value as an extra
                startActivity(intent);
            }
        });
        bottomNavigationView.setSelectedItemId(bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                return true;
            } else if (item.getItemId() == R.id.bottom_services) {
                startActivity(new Intent(PatientDashboardActivity.this, sercvicesActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_about) {
                startActivity(new Intent(PatientDashboardActivity.this, aboutappActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_chatbot) {
                startActivity(new Intent(PatientDashboardActivity.this, chatbotActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });


//        bottomNavigationView.setOnItemSelectedListener(item ->{
//            switch (item.getItemId()) {
//                case R.id.bottom_home:
//                    startActivity(new Intent(PatientDashboardActivity.this, PatientDashboardActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//                case R.id.bottom_services:
//                    startActivity(new Intent(PatientDashboardActivity.this, sercvicesActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//                case R.id.bottom_about:
//                    startActivity(new Intent(PatientDashboardActivity.this, aboutappActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//                case R.id.bottom_chatbot:
//                    startActivity(new Intent(PatientDashboardActivity.this, chatbotActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//            }
//            return false;
//        });
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.menuHome:
//                        startActivity(new Intent(PatientDashboardActivity.this, PatientDashboardActivity.class));
//                        return true;
//                    case R.id.menuALL:
//                        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//                        if (currentUser != null) {
//                            Intent intent = new Intent(PatientDashboardActivity.this, sercvicesActivity.class);
//                            startActivity(intent);
//                        } else {
//                            // User is not logged in, show a message and redirect to LoginActivity
//                            Intent loginIntent = new Intent(PatientDashboardActivity.this, LoginActivity.class);
//                            loginIntent.putExtra("fromMainActivity", true); // Pass extra to handle redirection
//                            startActivity(loginIntent);
//                        }
//                        return true;
//                    case R.id.menusocial:
//                        startActivity(new Intent(PatientDashboardActivity.this, aboutappActivity.class));
//                        return true;
//                    case R.id.menuchatbot:
//                        startActivity(new Intent(PatientDashboardActivity.this, chatbotActivity.class));
//                        return true;
//                }
//                return false;
//            }
//        });
        // Set click listener for MedTrack
        if (MedTrack != null) {
            MedTrack.setOnClickListener(v -> {
                Intent intent = new Intent(PatientDashboardActivity.this, MedTrackActivity.class);
                startActivity(intent);
                finish();
            });
        }
        // Set click listener for findadoctor
        if (findadoctor != null) {
            findadoctor.setOnClickListener(v -> {
                Intent intent = new Intent(PatientDashboardActivity.this, FindADoctorActivity.class);
                startActivity(intent);
                finish();
                });
        }

        // Set click listener for DocSlot
        if (docslot != null) {
            docslot.setOnClickListener(v -> {
                Intent intent = new Intent(PatientDashboardActivity.this, DocSlotActivity.class);
                startActivity(intent);
                finish();
            });
        }

        // Set click listener for PatientHistory
        if (patienthistory != null) {
            patienthistory.setOnClickListener(v -> {
                Intent intent = new Intent(PatientDashboardActivity.this, PatientRecordActivity.class);
                startActivity(intent);
                finish();
            });
        }
        account_info = findViewById(R.id.imageMenu);
        account_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientDashboardActivity.this, AccountInfo.class);
                startActivity(intent);
            }
        });

    }
}
