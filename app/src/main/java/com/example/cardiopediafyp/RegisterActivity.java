package com.example.cardiopediafyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RegisterActivity extends AppCompatActivity {
    TextView textView;
    EditText FullName, Email, Password, ConfirmPassword;
    Button Register;
    Switch switchtodoc;
    FirebaseAuth auth;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.tvSwitchToLogin);
        FullName = findViewById(R.id.etFullName);
        Email = findViewById(R.id.etRegisterEmail);
        Password = findViewById(R.id.etRegisterPassword);
        ConfirmPassword = findViewById(R.id.etConfirmPassword);
        Register = findViewById(R.id.btnRegister);
        switchtodoc = findViewById(R.id.switchtodoc);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FullName.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Enter Full Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Email.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Password.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ConfirmPassword.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Password.getText().toString().equals(ConfirmPassword.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth = FirebaseAuth.getInstance();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String id =task.getResult().getUser().getUid();
                        if (task.isSuccessful()){
                            String uid = task.getResult().getUser().getUid();
                            Users users = new Users(uid, FullName.getText().toString(), Email.getText().toString(), Password.getText().toString(), switchtodoc.isChecked() ? 1 : 0);
                            firebaseDatabase.getReference().child("Users").child(uid).setValue(users);
                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, PatientDashboardActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
