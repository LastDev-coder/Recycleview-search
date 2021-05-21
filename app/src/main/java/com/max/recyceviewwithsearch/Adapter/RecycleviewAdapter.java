package com.max.recyceviewwithsearch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.max.recyceviewwithsearch.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewAdapter extends RecyclerView.Adapter {
    List<mydatalist> mydata;

    public RecycleviewAdapter(List<mydatalist> mydata) {
        this.mydata = mydata;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.viewlist, parent, false);
        return new RecycleviewViewholder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecycleviewViewholder viewHolderTwo = (RecycleviewViewholder) holder;
        mydatalist list = mydata.get(position);
        viewHolderTwo.textView.setText(list.getName());
    }

    @Override
    public int getItemCount() {
        return mydata.size();
    }

    public void getFilter(ArrayList<mydatalist> filterList) {
        mydata = filterList;
        notifyDataSetChanged();
    }


    public class RecycleviewViewholder extends RecyclerView.ViewHolder {
        TextView textView;

        public RecycleviewViewholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.listtext);

        }
    }
}
