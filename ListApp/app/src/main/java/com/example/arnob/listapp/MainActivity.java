package com.example.arnob.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] prices;
    String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res= getResources();
        myListView =(ListView) findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items);
        prices=res.getStringArray(R.array.prices);
        description =res.getStringArray(R.array.description);

        itemAdapter itemAdapter=new itemAdapter(this,items,prices,description);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetail = new Intent(getApplicationContext(),DetailView.class);
                showDetail.putExtra("com.example.arnob.ITEM_INDEX",position);
                startActivity(showDetail);
            }
        });
    }
}
