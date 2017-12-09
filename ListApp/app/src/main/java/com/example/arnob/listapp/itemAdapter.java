package com.example.arnob.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by arnob on 8/30/2017.
 */

public class itemAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    String[] items;
    String[] prices;
    String[] description;

    public itemAdapter (Context c,String[] i,String[] p,String[] d){
        items=i;
        prices=p;
        description=d;
        mInflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {

        return items.length;
    }

    @Override
    public Object getItem(int position)
    {
        return items[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=mInflater.inflate(R.layout.mylistview_detail,null);
        TextView nameTextview=(TextView) v.findViewById(R.id.nameTextview);
        TextView descriptionTextview=(TextView) v.findViewById(R.id.descriptionTextview);
        TextView priceTextview=(TextView) v.findViewById(R.id.priceTextview);

        String name =items[position];
        String desc= description[position];
        String cost= prices[position];

        nameTextview.setText(name);
        descriptionTextview.setText(desc);
        priceTextview.setText(cost);



        return v;
    }
}
