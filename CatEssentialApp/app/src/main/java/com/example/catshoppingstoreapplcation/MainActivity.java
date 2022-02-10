package com.example.catshoppingstoreapplcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//this is a test
public class MainActivity extends AppCompatActivity {
    private TextView txtLogin, txtRegister;
    private Button btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        txtLoginOnClick();
        txtAboutOnClick();

    }

    //handling

    //handling button about on click
    public void txtAboutOnClick(){
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(MainActivity.this, About.class);
                startActivity(about);
            }
        });
    }

    //creating login page
    public void txtLoginOnClick(){
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainActivity.this, Login.class);
                startActivity(login);
            }
        });
    }

    //init textview and button view
    private void initView(){
        //init txtLogin
        txtLogin = findViewById(R.id.txtLogin);
        //init about Button
        btnAbout = findViewById(R.id.btnAbout);
        //init sign up text view
        txtRegister = findViewById(R.id.txtSignUp);
    }
}
