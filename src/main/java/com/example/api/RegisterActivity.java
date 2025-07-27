package com.example.api;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText etRegisterEmail, etRegisterUsername, etRegisterPassword;
    private EditText etFirstName, etLastName, etAge, etBirthDate;
    private Button btnSubmitRegistration;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegisterEmail = findViewById(R.id.etRegisterEmail);
        etRegisterUsername = findViewById(R.id.etRegisterUsername);
        etRegisterPassword = findViewById(R.id.etRegisterPassword);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAge = findViewById(R.id.etAge);
        etBirthDate = findViewById(R.id.etBirthDate);
        btnSubmitRegistration = findViewById(R.id.btnSubmitRegistration);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Users");

        btnSubmitRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String email = etRegisterEmail.getText().toString();
        String password = etRegisterPassword.getText().toString();
        String username = etRegisterUsername.getText().toString();
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String age = etAge.getText().toString();
        String birthDate = etBirthDate.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ||
                TextUtils.isEmpty(username) || TextUtils.isEmpty(firstName) ||
                TextUtils.isEmpty(lastName) || TextUtils.isEmpty(age) ||
                TextUtils.isEmpty(birthDate)) {
            Toast.makeText(RegisterActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    String userId = firebaseUser.getUid();

                    User newUser = new User(email, username, firstName, lastName, age, birthDate);
                    mDatabase.child(userId).setValue(newUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(RegisterActivity.this, "Failed to save user data: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

                    }
                });
    }
}
