package sks.jakfromspace.medicloud;

/**
 * Coded by JAKfromSpace on 09-Dec-17 for Medicloud.
 */
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

    String[] name;
    String[] spec;
    String[] desc;

    public itemAdapter (Context c,String[] i,String[] p,String[] d){
        name = i;
        spec = p;
        desc = d;
        mInflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {

        return name.length;
    }

    @Override
    public Object getItem(int position)
    {
        return name[position];
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
        TextView priceTextview=(TextView) v.findViewById(R.id.specTextview);

        String name = this.name[position];
        String desc= this.desc[position];
        String cost= spec[position];

        nameTextview.setText(name);
        descriptionTextview.setText(desc);
        priceTextview.setText(cost);



        return v;
    }
}