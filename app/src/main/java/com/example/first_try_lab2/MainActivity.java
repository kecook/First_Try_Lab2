package com.example.first_try_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity<onClick> extends AppCompatActivity implements View.OnClickListener{

    Button one_btn;
    Button two_btn;
    Button three_btn;
    Button four_btn;
    Button five_btn;
    Button six_btn;
    Button seven_btn;
    Button eight_btn;
    Button nine_btn;
    Button clear_btn;
    Button zero_btn;
    Button buy_btn;
    TextView selected_product;
    TextView total_amount;
    TextView quantity;
    Calculation model;
    String calcualtion_string = "";



    ListView inventory_list;
    String[] listOfItems;
//    ArrayList<String> shopInventory;

//    ArrayList<ProductModel>product = new ArrayList<ProductModel>(4){
////            product.add.ProductModel
//            new ProductModel("pants",10,20.99),
//            new ProductModel("Shirt", 20, 10.99),
//            new ProductModel("Shoes", 10, 40.99),
//                    new ProductModel("Hat", 15, 14.99)
//            };
 CustomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList<StoreManager> productDetail = new ArrayList<StoreManager>();
        model = new Calculation();
        listOfItems = new String[]{"pants","Shirts","Shoes", "Hats"};
        StoreManager productDetail = new StoreManager();//create obj for storeManager where inicalized the class product

        one_btn = findViewById(R.id.one_btn);
        two_btn = findViewById(R.id.two_btn);
        three_btn = findViewById(R.id.three_btn);
        four_btn = findViewById(R.id.four_btn);
        five_btn = findViewById(R.id.five_btn);
        six_btn = findViewById(R.id.six_btn);
        seven_btn = findViewById(R.id.seven_btn);
        eight_btn = findViewById(R.id.eight_btn);
        nine_btn = findViewById(R.id.nine_btn);
        clear_btn = findViewById(R.id.clear_btn);
        zero_btn = findViewById(R.id.zero_btn);
        buy_btn = findViewById(R.id.buy_btn);
        selected_product = findViewById(R.id.selected_product);
        total_amount = findViewById(R.id.total_amount);
        quantity = findViewById(R.id.quantity);
        inventory_list = findViewById(R.id.inventory_list);


        one_btn.setOnClickListener(this);
        two_btn.setOnClickListener(this);
        three_btn.setOnClickListener(this);
        four_btn.setOnClickListener(this);
        five_btn.setOnClickListener(this);
        six_btn.setOnClickListener(this);
        seven_btn.setOnClickListener(this);
        eight_btn.setOnClickListener(this);
        nine_btn.setOnClickListener(this);
        zero_btn.setOnClickListener(this);
        clear_btn.setOnClickListener(this);
        buy_btn.setOnClickListener(this);


//        Toast.makeText(getApplicationContext(),"The selected plant is " + productDetail  ,Toast.LENGTH_LONG).show();

//        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.inventory_list,R.id.text_in_row,productDetail);
        adapter = new CustomeAdapter(getApplicationContext(),productDetail.myProduct);
        inventory_list.setAdapter(adapter);

//
    }
        @Override
    public void onClick(View view){
        if (view.getId() == R.id.clear_btn){
            Log.d("Calcualtor","Clear clicked");    // C
            quantity.setText("");
            calcualtion_string = "";
            model.clear();
        }
//        else if (view.getId() == R.id.buy_btn){
//            Log.d("Calcualtor","equal  clicked"); // =
//            int r = model.calc();
//            calcualtion_string = calcualtion_string + " = " + r;
//            result.setText(calcualtion_string );
//            if (model.mode == 2) {
//                history_text.setText(model.getHistory());
//            }
//        }
        else {
            String v = ((Button)view).getText().toString(); // 1 2 + -
            calcualtion_string = calcualtion_string + "  " + v;
            quantity.setText(calcualtion_string);
            model.push(v);
            Log.d("Calcualtor","number or Op clicked"); // 2 + 3 + 4 - 5

        }

    }
}