package com.example.catshoppingstoreapplcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catshoppingstoreapplcation.repositories.CartRepo;
import com.example.catshoppingstoreapplcation.views.Food;
import com.example.catshoppingstoreapplcation.views.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Shopping extends AppCompatActivity {
    private  String selectedCategory;
    private Spinner categorySpinner;
    private ArrayAdapter<CharSequence>  categoryAdapter;
    private FirebaseAuth firebaseAuth;
    private TextView logout;
    private ImageView opencart;
    private TextView cartitemscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        //init txt logout
        logout = findViewById(R.id.txtLogout);
        opencart=findViewById(R.id.imageView);
        cartitemscount=findViewById(R.id.cartitemscount);
        //interest spinner initialization
        categorySpinner = findViewById(R.id.spinnerCategory);

        categoryAdapter = ArrayAdapter.createFromResource(this,R.array.CatProducts, R.layout.spinner_layout);
        int lengthofcartitems=CartRepo.addproductstocart.toArray().length;

        cartitemscount.setText(Integer.toString(lengthofcartitems));
        //specified layout
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String category_selected = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Shopping.this, category_selected + " selected", Toast.LENGTH_SHORT).show();

                //obtain the selected state
                selectedCategory = categorySpinner.getSelectedItem().toString();

                int parentID = adapterView.getId();

                if(parentID == R.id.spinnerCategory) {
                    switch (selectedCategory) {
                        case "Food":

                            SharedPreferences sharedPref = getSharedPreferences("application", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("Category","Food");
                            editor.apply();



                            Intent food = new Intent(Shopping.this, Food.class);

                            startActivity(food);
                            break;
                        case "Toy":
                            SharedPreferences sharedPrefrences = getSharedPreferences("application", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editorr = sharedPrefrences.edit();
                            editorr.putString("Category","Toy");
                            editorr.apply();
                            Intent toy = new Intent(Shopping.this, Food.class);

                            startActivity(toy);
                            break;
                        case "Cat Clothing":
                            SharedPreferences sharedPrefrencess = getSharedPreferences("application", Context.MODE_PRIVATE);
                            SharedPreferences.Editor edittorr = sharedPrefrencess.edit();
                            edittorr.putString("Category","Cloathing");
                            edittorr.apply();


                            Intent clothes = new Intent(Shopping.this, Food.class);

                            startActivity(clothes);
                            break;
                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        opencart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent opencart=new Intent(Shopping.this,CartItemsActivity.class);
                startActivity(opencart);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               logout();
            }
        });


    }

    private void logout(){

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Shopping.this, MainActivity.class));
      //  logout = findViewById(R.id.txtLogout);

    }

    @Override
    protected void onResume() {
        super.onResume();
        int lengthofcartitems=CartRepo.addproductstocart.toArray().length;

        cartitemscount.setText(Integer.toString(lengthofcartitems));
    }
}