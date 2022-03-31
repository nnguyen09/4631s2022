package com.example.catshoppingstoreapplcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catshoppingstoreapplcation.views.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Shopping extends AppCompatActivity {
    private  String selectedCategory;
    private Spinner categorySpinner;
    private ArrayAdapter<CharSequence>  categoryAdapter;
    private FirebaseAuth firebaseAuth;
    private TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        //init txt logout
        logout = findViewById(R.id.txtLogout);

        //interest spinner initialization
        categorySpinner = findViewById(R.id.spinnerCategory);
        categoryAdapter = ArrayAdapter.createFromResource(this,R.array.CatProducts, R.layout.spinner_layout);

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
                            Intent food = new Intent(Shopping.this, Food.class);
                            startActivity(food);

                        case "Toy":
                            Intent toy = new Intent(Shopping.this, Toy.class);
                            startActivity(toy);

                        case "Cat Clothing":
                            Intent clothes = new Intent(Shopping.this, Food.class);
                            startActivity(clothes);
                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






    }

    private void logout(){

        firebaseAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.txtLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Shopping.this, MainActivity.class));
            }
        });
    }

}