package com.example.first_try_lab2;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductModel implements Parcelable {

    public String name;
    public int qnt;
    public double price;

    ProductModel(String name, int qnt, double price){
        this.name = name;
        this.qnt = qnt;
        this.price = price;
    }
    protected  ProductModel(Parcel in){
        name = in.readString();
        qnt = in.readInt();
        price = in.readDouble();
    }
    public static final Creator<ProductModel> CREATOR= new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel source) {
            return new ProductModel(source);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };
    public void setQnt(int qnt){
        this.qnt = qnt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(qnt);
        dest.writeDouble(price);
    }


}
