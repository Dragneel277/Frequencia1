package com.example.frequencia1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView loginText = findViewById(R.id.loginText);
        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String enteredUsername = editTextUsername.getText().toString();
                    String enteredPassword = editTextPassword.getText().toString();

                    if (UserDatabase.isValidCredentials(enteredUsername, enteredPassword)) {
                        Intent intent = new Intent(LoginActivity.this, SelectionActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });
                Intent intent = new Intent(LoginActivity.this, SelectionActivity.class);
                startActivity(intent);
                finish(); // Close the login activity
        }

