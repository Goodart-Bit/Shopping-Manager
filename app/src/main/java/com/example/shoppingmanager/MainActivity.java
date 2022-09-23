package com.example.shoppingmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistryOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText productName, productType, productPrice, productDetails;
    Button save_btn, view_btn;
    ArrayList<String> products = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productName = findViewById(R.id.product_name);
        productType = findViewById(R.id.product_type);
        productPrice = findViewById(R.id.product_price);
        productDetails = findViewById(R.id.product_details);
        save_btn = findViewById(R.id.save_button);
        view_btn = findViewById(R.id.view_button);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(productName.getText().toString().equals("") || productType.getText().toString().equals("") || productPrice.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"DATOS INVALIDOS, INTENTE OTRA VEZ", Toast.LENGTH_LONG).show();
                    return;
                }
                Product new_product = new Product(productName.getText().toString(), productType.getText().toString(),
                        productPrice.getText().toString(), productDetails.getText().toString());
                products.add(new_product.toString());
                Toast.makeText(MainActivity.this,"PRODUCTO GUARDADO EXITOSAMENTE", Toast.LENGTH_LONG).show();
                clean();
                System.out.println(products.get(products.size() - 1).toString());
            }
        });

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProductsActivity.class);
                intent.putStringArrayListExtra("saved_products",products);
                startActivity(intent);
            }
        });
    }

    private void clean(){
        productName.setText("");
        productType.setText("");
        productPrice.setText("");
        productDetails.setText("");
    }
}