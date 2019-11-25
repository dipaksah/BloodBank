package com.dipak.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin;
    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin=findViewById(R.id.btnLogin);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etEmail.getText().toString())){

                    etEmail.setError("Incorrect Username");
                    etEmail.requestFocus();
                    return;
                } else if (TextUtils.isEmpty(etPassword.getText().toString())){

                    etPassword.setError("Incorrect password");
                    etPassword.requestFocus();
                    return;
                }else {

                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();

                    LoginOperation operation = new LoginOperation(email, password);
                    Boolean log = operation.login();
                    if (log == true) {
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    } else
                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
