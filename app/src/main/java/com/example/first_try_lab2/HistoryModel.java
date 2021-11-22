package com.example.first_try_lab2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class HistoryModel extends ProductModel implements Parcelable {
    String purchaseDate;

    public HistoryModel(String name, int qnt, double price, String purchaseDate) {
        super(name, qnt, price);
        this.purchaseDate = purchaseDate;
    }
    protected  HistoryModel(Parcel in){
        super(in);

        this.purchaseDate = in.readString();

    }
    public static final Creator<HistoryModel> CREATOR= new Creator<HistoryModel>() {
        @Override
        public HistoryModel createFromParcel(Parcel source) {
            return new HistoryModel(source);
        }
        @Override
        public HistoryModel[] newArray(int size) {
            return new HistoryModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest,flags);
        dest.writeString(purchaseDate);

    }
}
