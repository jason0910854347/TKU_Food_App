package com.example.lan.tku_food_app;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lan.tku_food_app.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Ref;

public class Sign_Up extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;

    EditText signup_name, signup_studentID, signup_password, signup_confirmpassword;
    Button signup_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        database =FirebaseDatabase.getInstance();
        users = database.getReference("User");

        signup_name = (EditText) findViewById(R.id.signup_name);
        signup_studentID = (EditText) findViewById(R.id.signup_studentID);
        signup_password = (EditText) findViewById(R.id.signup_password);

        signup_button = (Button) findViewById(R.id.signup_button);

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = new User(signup_name.getText().toString(),
                        signup_studentID.getText().toString(),
                        signup_password.getText().toString());
                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(user.getStudent_id()).exists())
                            Toast.makeText(Sign_Up.this, "The Student's Id is Already Exist !", Toast.LENGTH_SHORT).show();
                        else{
                            users.child(user.getStudent_id()).setValue(user);
                            Toast.makeText(Sign_Up.this, "Success Register !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}
