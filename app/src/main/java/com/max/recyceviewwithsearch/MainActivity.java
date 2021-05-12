package com.max.recyceviewwithsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.max.recyceviewwithsearch.Adapter.RecycleviewAdapter;
import com.max.recyceviewwithsearch.Adapter.mydatalist;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<mydatalist> mydata;
    RecycleviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);

        MenuItem search = menu.findItem(R.id.searchicon);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}