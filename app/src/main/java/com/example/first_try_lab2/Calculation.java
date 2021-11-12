package com.example.first_try_lab2;
import java.util.ArrayList;

public class Calculation {

    ArrayList<String> operators_oprands_list = new ArrayList<>(0);
//    int index = 0;
    String oneExp;
//    ArrayList<String> History = new ArrayList<>(0);


public void push(String valueToPush){
    oneExp = oneExp + valueToPush;
    this.operators_oprands_list.add(valueToPush);
}


public double totalAmount(int prodQnt, double prodPrice){
    double total = prodQnt * prodPrice;
    return total;

}

    public void clear(){
        operators_oprands_list.clear();
    }

}