package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    EditText signupName, signupUsername, signupPhone, signupPassword;
    Button signupButton;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activivty_register);

        TextView changetoLOG = (TextView) findViewById(R.id.btnChangeToLogin);
        changetoLOG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this,
                        login.class);
                startActivity(intent);
                finish();
            }
        });

        signupName = (EditText) findViewById(R.id.fullnameInput_REG);
        signupPhone = (EditText) findViewById(R.id.PhoneInput_REG);
        signupUsername = (EditText) findViewById(R.id.UsernameInput_REG);
        signupPassword = (EditText) findViewById(R.id.PasswordInput_REG);
        signupButton = (Button) findViewById(R.id.btnRegister);
        return false;
    }

}