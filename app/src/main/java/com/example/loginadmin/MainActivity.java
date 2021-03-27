package com.example.loginadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private EditText eEmail;
    private EditText ePassword;
    private Button eLogin;
    private Button eRegister;

    private String LoginEmail =  "admin@gmail.com";
    private String LoginPassword ="12345678";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eEmail = findViewById(R.id.editTextTextPersonName);
        ePassword = findViewById(R.id.editTextTextPassword);
        eLogin = findViewById(R.id.button);
        eRegister = findViewById(R.id.button);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputEmail = eEmail.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the login details correctly", Toast.LENGTH_SHORT).show();
                } else {
                        isValid = validate(inputEmail,inputPassword);

                        if (!isValid){
                            Toast.makeText(MainActivity.this, "Incorrect credentials entered", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "Login sucessful", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(MainActivity.this, HomePage.class);
                            startActivity(intent);
                        }
                }
            }





        });


   }
     private boolean validate (String Email, String Password){
        if(Email.equals(LoginEmail) && Password.equals(LoginPassword)){
            return true;
        }
        return false;
     }



}