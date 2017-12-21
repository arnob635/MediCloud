package sks.jakfromspace.medicloud;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Coded by JAKfromSpace on 20-Dec-17 for Medicloud.
 */

public class AppointmentList extends AppCompatActivity implements BackgroundResponse, AdapterView.OnItemClickListener {

    ListView list;
    String[][] appnList;
    itemAdapter2 adapter;
    String[] appnSlots = new String[]{"10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appn_list);

        BackgroundProcess bg = new BackgroundProcess(this);
        bg.delegate = this;
        bg.execute("getAppnList", SingletonPatient.getInstance().getpID());

        list = (ListView) findViewById(R.id.appnListView);
    }

    @Override
    public void BGProcessDone(String[][] output) {
        if(output != null) {
            String name[] = new String[output.length], did[] = new String[output.length], date[] = new String[output.length], time[] = new String[output.length];
            for (int i = 0; i < output.length; i++) {
                did[i] = output[i][0];
                name[i] = output[i][1];
                date[i] = output[i][2];
                time[i] = appnSlots[Integer.parseInt(output[i][3])];
            }
            adapter = new itemAdapter2(this, name, date, time);
            list.setAdapter(adapter);
            list.setOnItemClickListener(this);
            appnList = output;
        }
        else {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Not Sick?")
                    .setMessage("It seems you have ZERO appointments")
                    .setPositiveButton("Oh Well...", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}