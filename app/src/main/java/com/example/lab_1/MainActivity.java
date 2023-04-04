package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.customListView);
        listView.setNestedScrollingEnabled(false);
        ListViewAdapter customAdapter = new ListViewAdapter(getApplicationContext());
        listView.setAdapter(customAdapter);

        gridView = findViewById(R.id.gridView);
        gridView.setNestedScrollingEnabled(false);
        GridViewAdapter customGridAdapter = new GridViewAdapter(getApplicationContext());
        gridView.setAdapter(customGridAdapter);
    }
}
