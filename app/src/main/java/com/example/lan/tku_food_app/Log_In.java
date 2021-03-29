package com.example.lan.tku_food_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lan.tku_food_app.Common.Common;
import com.example.lan.tku_food_app.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Log_In extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private ProgressBar loginProgress;
    private EditText loginID;
    private EditText loginPassword;
    private TextView signUp;

    DatabaseReference databaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);

        databaseUser = FirebaseDatabase.getInstance().getReference("User");

        loginButton = findViewById(R.id.login_button);
        loginProgress = findViewById(R.id.login_progress);
        loginProgress.setVisibility(View.INVISIBLE);

        loginID = (EditText) findViewById(R.id.login_id);
        loginPassword = (EditText) findViewById(R.id.login_password);
        signUp = (TextView) findViewById(R.id.Sign_Up);

        //Init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Sign_Up.class);
                startActivity(startIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginProgress(loginID.getText().toString(),
                        loginPassword.getText().toString());
            };
        });
    };


    private void loginProgress(final String login_id, final String login_password) {
        databaseUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(login_id).exists()){
                    if(!login_id.isEmpty()){
                        User login = dataSnapshot.child(login_id).getValue(User.class);
                        if(login.getPassword().equals(login_password)){
                            Toast.makeText(Log_In.this, "Success Login", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            Common.currentUser = login;
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(Log_In.this, "Password is wrong !", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Log_In.this, "Login ID is not registered !", Toast.LENGTH_SHORT).show();
                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

            ;

        });





    }

    @Override
    public void onClick(View v) {

    }
}
