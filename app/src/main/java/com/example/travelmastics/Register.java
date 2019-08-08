package com.example.travelmastics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    private LinearLayout Prof_Section;
    private Button login;
    private EditText email, name, password;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Prof_Section = findViewById(R.id.prof_section);
        db = new DatabaseHelper(this);

        login = findViewById(R.id.login);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = email.getText().toString();
                String nameText = name.getText().toString();
                String passText = password.getText().toString();


                if(emailText.equals("") || nameText.equals("") || passText.equals("")){

                    Toast.makeText(getApplicationContext(),"fill in all the fields",Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkMail = db.checkUSerExists(emailText);
                    if(checkMail){
                        Boolean insert = db.insertUser(nameText, emailText, passText);
                        if(insert){
                            Toast.makeText(getApplicationContext(),"User inserted",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),"Failed to add user",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"User already exists",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
