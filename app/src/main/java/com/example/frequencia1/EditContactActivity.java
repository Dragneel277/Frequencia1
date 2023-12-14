package com.example.frequencia1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        // Retrieve contact details from the intent (you should pass them from the previous activity)
        String contactName = getIntent().getStringExtra("name");
        String contactNumber = getIntent().getStringExtra("number");
        String contactEmail = getIntent().getStringExtra("email");

        TextView welcomeText = findViewById(R.id.welcomeText);
        ImageView contactImageView = findViewById(R.id.contactImageView);
        TextView nameText = findViewById(R.id.nameText);
        TextView numberText = findViewById(R.id.numberText);
        TextView emailText = findViewById(R.id.emailText);
        Button backToListButton = findViewById(R.id.backToListButton);

        welcomeText.setText("Welcome, " + contactName);

        nameText.setText("Name: " + contactName);
        numberText.setText("Number: " + contactNumber);
        emailText.setText("Email: " + contactEmail);

        backToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditContactActivity.this, ContactListActivity.class);
                startActivity(intent);
                finish(); // Close the edit contact activity
            }
        });
    }
}
