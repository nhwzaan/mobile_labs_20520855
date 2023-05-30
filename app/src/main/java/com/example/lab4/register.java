package com.example.lab4;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

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

        Button btnReg = (Button) findViewById(R.id.btnRegister);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName = signupName.getText().toString();
                String phone = signupPhone.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String encryptedPassword = encrypted.sha256(password);
                if (
                        (fullName != null && !fullName.equals("")) &&
                                (phone != null && !phone.equals("")) &&
                                (username != null && !username.equals("")) &&
                                (password != null && !password.equals("")) &&
                                (username.length() >= 6 && password.length() >= 6)
                ){

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    // Create a new user with a first and last name
                    Map<String, Object> user = new HashMap<>();
                    user.put("fullname", fullName);
                    user.put("phone", phone);
                    user.put("username", username);
                    user.put("password", encryptedPassword);



                    // Add a new document with a generated ID
                    db.collection("users")
                            .add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error adding document", e);
                                }
                            });

                    Intent intent = new Intent(register.this,
                            login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }



}