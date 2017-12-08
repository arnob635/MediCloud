package sks.jakfromspace.medicloud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DocListActivity extends AppCompatActivity implements BackgroundResponse, AdapterView.OnItemClickListener {

    ListView list;
    ArrayAdapter<String[]> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_list);

        BackgroundProcess bg = new BackgroundProcess(this);
        bg.delegate = this;
        bg.execute("getDocList");

        list = (ListView) findViewById(R.id.docList);
    }

    @Override
    public String[][] BGProcessDone(String[][] output) {
        String s[][] = new String[output.length][output[0].length];
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,s);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        return output;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView temp = (TextView) view;
        Toast.makeText(this, temp.getText()+" "+position,Toast.LENGTH_SHORT);
    }
}
