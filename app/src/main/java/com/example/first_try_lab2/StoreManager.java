package com.example.first_try_lab2;

import java.util.ArrayList;

public class StoreManager {
    ArrayList<ProductModel> myProduct;

    StoreManager(){
        this.myProduct = new ArrayList<>(4);
        this.myProduct.add(new ProductModel("pants", 10, 20.99));
        this.myProduct.add(new ProductModel("Shirt", 20, 15.99));
        this.myProduct.add(new ProductModel("Shoes",10, 40.99));
        this.myProduct.add(new ProductModel("hat", 4, 8.99));
    }
}
