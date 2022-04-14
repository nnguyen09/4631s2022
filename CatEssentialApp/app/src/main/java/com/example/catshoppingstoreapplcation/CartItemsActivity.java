package com.example.catshoppingstoreapplcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.catshoppingstoreapplcation.adapter.cartcustomadapter;
import com.example.catshoppingstoreapplcation.models.Product;
import com.example.catshoppingstoreapplcation.models.cartmodel;
import com.example.catshoppingstoreapplcation.repositories.CartRepo;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CartItemsActivity extends AppCompatActivity {
    TextView noproductstext;
    Button proceedtopayment;
    ListView mylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_items);
        mylist=(ListView) findViewById(R.id.mylist);
        noproductstext=(TextView) findViewById(R.id.noproductstext);
        proceedtopayment=(Button) findViewById(R.id.proceedtopayment);
        if(CartRepo.addproductstocart.toArray().length>0){

        ArrayList<cartmodel> arrayList=new ArrayList<>();
        for(int op=0;op<CartRepo.addproductstocart.toArray().length;op++){
          //  arrayList.add(CartRepo.addproductstocart.get(op).getName());
            arrayList.add(new cartmodel(CartRepo.addproductstocart.get(op).getName(),CartRepo.addproductstocart.get(op).getPrice(),CartRepo.addproductstocart.get(op).getImageUrl()));

        }

        //ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        cartcustomadapter myadapter=new cartcustomadapter(this,R.layout.listrow,arrayList);

        mylist.setAdapter(myadapter);
        }
        else{
            noproductstext.setText("Currently No Items Are In Cart.");
        }

        proceedtopayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iit=new Intent(CartItemsActivity.this,addpaymentdetails.class);
                startActivity(iit);

            }
        });



    }
}