package com.example.first_try_lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ManagerPanelActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<HistoryModel> productHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_panel);
        Button history;
        Button restock;


        history = (Button) findViewById(R.id.history);
        restock = (Button) findViewById(R.id.restock);
        history.setOnClickListener(this);
        restock.setOnClickListener(this);
        productHistory = this.getIntent().getExtras().getParcelableArrayList("history list");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.history) {
            Intent hisIntent = new Intent(getApplicationContext(), HistoryPageActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("history list", productHistory);
            hisIntent.putExtras(bundle);

            startActivity(hisIntent);

//        }else if(v.getId()==R.id.restock){
//            Intent restockIntent = new Intent(getApplicationContext(),RestockActivity.class);
//
//
//        }
        }


    }
}

