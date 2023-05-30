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

public class login extends AppCompatActivity {

    //EditText usernameEntered = (EditText) findViewById(R.id.UsernameInput);
    //Button loginButton = (Button) findViewById(R.id.btnLogin);

    private String getColoredSpanned(String text, String color)
    {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        TextView title = findViewById(R.id.ApplicationName);
        String first = getColoredSpanned("recursion", "#5DADE2");
        String second = getColoredSpanned(" game", "#000000");
        title.setText(Html.fromHtml(first + " " + second));

        CheckBox show = (CheckBox) findViewById(R.id.checkPasswordHideorShow);
        EditText passwordEntered = findViewById(R.id.PasswordInput);
        //boolean check = show.isChecked();
        show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    passwordEntered.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    passwordEntered.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        TextView changetoREG = (TextView) findViewById(R.id.btnChangeToRegister);
        changetoREG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,
                        register.class);
                startActivity(intent);
                finish();
            }
        });
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

}