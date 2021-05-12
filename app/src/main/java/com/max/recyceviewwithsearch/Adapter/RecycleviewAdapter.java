package com.max.recyceviewwithsearch.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.max.recyceviewwithsearch.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewAdapter extends RecyclerView.Adapter implements Filterable {
    List<mydatalist> mydata;
    List<mydatalist> mydata2;

    public RecycleviewAdapter(List<mydatalist> mydata) {
        this.mydata = mydata;
        mydata2 = new ArrayList<>(mydata);
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

    @Override
    public Filter getFilter() {
        return mydata2filter;
    }


    private Filter mydata2filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<mydatalist> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(mydata2);
            } else {
                String filerText = constraint.toString().toLowerCase().trim();
                for (mydatalist item : mydata2) {
                    if (item.getName().toLowerCase().contains(filerText)) {
                        filterList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mydata.clear();
            mydata.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class RecycleviewViewholder extends RecyclerView.ViewHolder {
        TextView textView;

        public RecycleviewViewholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.listtext);

        }
    }
}
