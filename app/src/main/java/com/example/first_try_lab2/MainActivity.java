package com.example.first_try_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Adapter;

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
    int index =0;



    ListView inventory_list;
    String[] listOfItems;

 CustomeAdapter adapter;
 double selectedPrice;
 int selectedQtn;
 StoreManager productDetail = new StoreManager();//create obj for storeManager where inicalized the class product


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        model = new Calculation();
        listOfItems = new String[]{"pants","Shirts","Shoes", "Hats"};


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

//        inventory_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Object listItem = inventory_list.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(),"Click ListItem Number"+listItem.toString(), Toast.LENGTH_LONG).show();
//
////                StoreManager selectedProductFromList = inventory_list.getItemAtPosition(position);
////                selected_product.setText(selectedProductFromList.toString());
////                Toast.makeText(getApplicationContext(),"Select a plant " + inventory_list.getItemAtPosition(position)  ,Toast.LENGTH_LONG).show();
//            }
        adapter = new CustomeAdapter(getApplicationContext(),productDetail.myProduct);
        inventory_list.setAdapter(adapter);
    inventory_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        index = position;
     String selectedItem = productDetail.myProduct.get(position).name;
     selectedPrice = productDetail.myProduct.get(position).price;
     selectedQtn = productDetail.myProduct.get(position).qnt;
     selected_product.setText(selectedItem);
    }
    });

    }


        @Override
    public void onClick(View view){
        if (view.getId() == R.id.clear_btn){
            Log.d("Calcualtor","Clear clicked");    // C
            quantity.setText("");
            total_amount.setText("");
            selected_product.setText("");
            calcualtion_string = "";
            model.clear();
        }
        else if (view.getId() == R.id.buy_btn){
            Log.d("buy button clicked","hello");
            String temp = quantity.getText().toString();
            if(temp.isEmpty()){
                Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_LONG).show();
            }else {
                int qntEntered = Integer.parseInt(temp);
                if (qntEntered > selectedQtn) {
                    Toast.makeText(getApplicationContext(), "Not enough stock", Toast.LENGTH_LONG).show();
                } else {
                    double result = model.totalAmount(qntEntered, selectedPrice);
                    total_amount.setText(result + "");
                    int newQnt = selectedQtn - qntEntered;
                    productDetail.myProduct.get(index).setQnt(newQnt);
                    adapter.notifyDataSetChanged();
//                    inventory_list(index)=selectedQtn;
                }
            }
     }
        else {
            String v = ((Button)view).getText().toString(); // 1 2 + -
            calcualtion_string = calcualtion_string + v;
            quantity.setText(calcualtion_string);
            model.push(v);
            Log.d("Calcualtor","number or Op clicked"); // 2 + 3 + 4 - 5

        }

    }
}