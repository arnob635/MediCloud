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

public class itemAdapter2 extends BaseAdapter {

    LayoutInflater mInflater;

    String[] name;
    String[] date;
    String[] time;

    public itemAdapter2 (Context c,String[] i,String[] p,String[] d){
        name = i;
        date = p;
        time = d;
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
        View v=mInflater.inflate(R.layout.mylistview_appn,null);
        TextView nameTextview=(TextView) v.findViewById(R.id.docnameListText);
        TextView dateTextview=(TextView) v.findViewById(R.id.dateListText);
        TextView timeTextview=(TextView) v.findViewById(R.id.timeListText);

        String name = this.name[position];
        String date= this.date[position];
        String time= this.time[position];

        nameTextview.setText(name);
        dateTextview.setText(date);
        timeTextview.setText(time);

        return v;
    }
}