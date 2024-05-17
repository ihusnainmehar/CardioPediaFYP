package com.example.cardiopediafyp;

import static com.example.cardiopediafyp.R.id.tvSwitchToLogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    TextView tv;
    EditText LoginEmail, LoginPassword;
    Button ButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Set padding to handle system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        tv = findViewById(R.id.tvSwitchToRegister);
        LoginEmail = findViewById(R.id.etLoginEmail);
        LoginPassword = findViewById(R.id.etLoginPassword);
        ButtonLogin = findViewById(R.id.btnLogin);

        // Set click listener for the TextView
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LoginEmail.getText().toString().isEmpty()){
                    LoginEmail.setError("Email is required");
                    return;
                }
                if (LoginPassword.getText().toString().isEmpty()){
                    LoginPassword.setError("Password is required");
                }
                FirebaseAuth auth = FirebaseAuth.getInstance();
                if (!(LoginEmail.getText().toString().isEmpty() && LoginPassword.getText().toString().isEmpty())){
                    auth.signInWithEmailAndPassword(LoginEmail.getText().toString(),LoginPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                               Intent intent = new Intent(LoginActivity.this, PatientDashboardActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                String uid = task.getResult().getUser().getUid();
                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                firebaseDatabase.getReference().child("Users").child(uid).child("usertype").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        int usertype = snapshot.getValue(Integer.class);
                                        if (usertype == 1){
                                            Intent intent = new Intent(LoginActivity.this, DoctorDashboardActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                        else if (usertype == 0){
                                            Intent intent = new Intent(LoginActivity.this, PatientDashboardActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                            else {
                                LoginPassword.setError("Incorrect Password");
                                LoginPassword.requestFocus();
                            }
                        }
                    });

                }
            }
        });
        return false;
    }
}
