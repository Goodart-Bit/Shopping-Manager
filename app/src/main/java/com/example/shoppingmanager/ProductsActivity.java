package com.example.shoppingmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {
    ArrayList<String> productStrings;
    TextView products_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        productStrings = getIntent().getExtras().getStringArrayList("saved_products");
        products_list = findViewById(R.id.products_label);
        displayProducts();
    }

    private void displayProducts(){
        String products_st = "";
        for (String item_st:productStrings) {
            products_st += "• " + item_st + "\n\n";
        }
        products_list.setText(products_st);
    }
}