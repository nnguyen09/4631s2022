package com.example.catshoppingstoreapplcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.catshoppingstoreapplcation.repositories.CartRepo;

public class addpaymentdetails extends AppCompatActivity {
Button PlaceOrderBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpaymentdetails);
        PlaceOrderBTN=findViewById(R.id.PlaceOrderBTN);


        PlaceOrderBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CartRepo.addproductstocart.clear();
                Toast.makeText(addpaymentdetails.this, "Your Items Are Being Shipped To YOu.", Toast.LENGTH_LONG).show();
                Intent it=new Intent(addpaymentdetails.this,Shopping.class);
                startActivity(it);
            }
        });



        }
}