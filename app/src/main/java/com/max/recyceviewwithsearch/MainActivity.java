package com.max.recyceviewwithsearch;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.max.recyceviewwithsearch.Adapter.RecycleviewAdapter;
import com.max.recyceviewwithsearch.Adapter.mydatalist;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<mydatalist> mydata;
    RecycleviewAdapter adapter;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        editText = findViewById(R.id.editText);
        mydata = new ArrayList<>();
        mydata.add(new mydatalist("c"));
        mydata.add(new mydatalist("c++"));
        mydata.add(new mydatalist("c#"));
        mydata.add(new mydatalist("scala"));
        mydata.add(new mydatalist("java"));
        mydata.add(new mydatalist("dart"));
        mydata.add(new mydatalist("r"));
        mydata.add(new mydatalist("rubi"));
        mydata.add(new mydatalist("html"));
        mydata.add(new mydatalist("css"));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new RecycleviewAdapter(mydata);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String toString) {

        ArrayList filterList = new ArrayList();

        for (mydatalist mydatalist : mydata) {
            if (mydatalist.getName().toLowerCase().contains(toString.toLowerCase())) {
                filterList.add(mydatalist);
            }

        }
        adapter.getFilter(filterList);
    }


}