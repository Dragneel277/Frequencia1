package com.example.frequencia1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextBirthdate = findViewById(R.id.editTextBirthdate);
        RadioGroup radioGroupSex = findViewById(R.id.radioGroupSex);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String email = editTextEmail.getText().toString();
                String birthdate = editTextBirthdate.getText().toString();
                String gender = getSelectedGender(radioGroupSex);
                String password = editTextPassword.getText().toString();

                if (name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || birthdate.isEmpty() || gender.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    User newUser = new User(name, password, name, phoneNumber, email, birthdate, gender);

                    if (UserDatabase.addUser(newUser)) {
                        Intent intent = new Intent(RegisterActivity.this, SelectionActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegisterActivity.this, "name already taken put another surname", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private String getSelectedGender(RadioGroup radioGroupSex) {
        int selectedId = radioGroupSex.getCheckedRadioButtonId();
        if (selectedId == R.id.radioMale) {
            return "Men";
        } else if (selectedId == R.id.radioFemale) {
            return "Women";
        } else {
            return "";
        }
    }
}
