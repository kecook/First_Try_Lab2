package com.example.first_try_lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdaptor extends RecyclerView.Adapter<HistoryAdaptor.viewHolder> {
    Context context;
    ArrayList<HistoryModel> allHistory;

    public interface listClickListener {
        void onItemClick( HistoryModel selectedHistoryItem);
    }
    public listClickListener listener;

    public static class viewHolder extends RecyclerView.ViewHolder{
        private final TextView purHistory;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            purHistory = itemView.findViewById(R.id.purHistory);
        }

        public TextView getPurHistory() {
            return purHistory;
        }
    }

    HistoryAdaptor(Context c, ArrayList<HistoryModel> adapterHistory){
        context = c;
        allHistory = adapterHistory;
    }
    @NonNull
    @Override
    public HistoryAdaptor.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_view_holder,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
    holder.getPurHistory().setText(allHistory.get(position).name);
    holder.getPurHistory().setText(allHistory.get(position).purchaseDate);
    holder.getPurHistory().setText(allHistory.get(position).qnt);
    holder.itemView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){listener.onItemClick(allHistory.get(position)); }
    });
//    holder.getPurHistory().setText(allHistory.get(position).price);
    }



    @Override
    public int getItemCount() {
        return allHistory.size();
    }
}
