package com.example.first_try_lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

public class CustomeAdapter extends BaseAdapter {
    Context myContext;
//    Context list_activity_context;
    List<ProductModel> myList;
    LayoutInflater inflater;

    CustomeAdapter(Context myContext, List myList){
        this.myContext = myContext;

        this.myList= myList;
        inflater=(LayoutInflater.from(myContext));

    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.inventory_list,null);
         TextView name = (TextView)convertView.findViewById(R.id.product_name);
        TextView price = (TextView)convertView.findViewById(R.id.product_price);
         TextView qnt = (TextView)convertView.findViewById(R.id.product_qnt);

        name.setText(myList.get(position).name);
       price.setText(myList.get(position).price+"");
        qnt.setText(myList.get(position).qnt+"");


        return convertView;
    }
}
