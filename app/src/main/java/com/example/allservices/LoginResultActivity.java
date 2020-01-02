package com.example.allservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginResultActivity extends AppCompatActivity {

    TextView TextView_email, TextView_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView_email = findViewById(R.id.TextView_email);
        TextView_password = findViewById(R.id.TextView_password);

        //putExtras에 넣은 값들을 가지고 와야하는데 bundle에 넣어서 가지고 오면 넣은 값인 string을 가져올 수 있다.
        Intent intent = getIntent();
        Bundle bundle =  intent.getExtras();
        String email = bundle.getString("email");
        String password = bundle.getString("password");

        TextView_email.setText(email);
        TextView_password.setText(password);
    }
}
