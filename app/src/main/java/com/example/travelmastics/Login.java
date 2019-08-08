package com.example.travelmastics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Login extends AppCompatActivity {

    private LinearLayout Prof_Section;
    private Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Prof_Section = findViewById(R.id.prof_section);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailSignUp();
            }
        });
    }
    public void emailSignUp(){
        Intent register = new Intent(this, Register.class);
        startActivity(register);
    }
}
