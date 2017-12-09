package sks.jakfromspace.medicloud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DocListActivity extends AppCompatActivity implements BackgroundResponse, AdapterView.OnItemClickListener {

    ListView list;
    String[][] doclist;
    itemAdapter adapter;

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
    public void BGProcessDone(String[][] output) {
        String name[] = new String[output.length], did[] = new String[output.length], spec[] = new String[output.length], desc[] = new String[output.length];
        for(int i=0; i<output.length; i++){
            did[i] = output[i][0];
            name[i] = output[i][1]; //i know its 1 because that's where the name is stored in the bgp
            spec[i] = output[i][2];
            desc[i] = output[i][6];
        }
        adapter = new itemAdapter(this, name, spec, did);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        doclist = output;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        BackgroundProcess bgp = new BackgroundProcess(this);
        //TextView temp = (TextView) view;
        bgp.execute("getDocInfo", ""+(position+1));
        //startActivity(new Intent(this, DocGetInfoActivity.class));
        //Toast.makeText(this, temp.getText()+" "+position,Toast.LENGTH_SHORT).show();
    }
}
