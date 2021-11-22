package com.example.first_try_lab2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HistoryPageActivity extends AppCompatActivity implements HistoryAdaptor.listClickListener {
       RecyclerView history_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);
//        history_table = findViewById(R.id.purHistory);
        history_table.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(HistoryModel selectedHistoryItem) {

    }
}