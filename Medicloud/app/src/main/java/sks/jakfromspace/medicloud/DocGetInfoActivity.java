package sks.jakfromspace.medicloud;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class DocGetInfoActivity extends AppCompatActivity {

    TextView tName, tDid, tSpec, tPhone;
    String phone, did, appnDate, appnTime;
    String[] appnSlots = new String[]{"10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm"};

    DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //final Context c = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_get_info);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Intent patintent = getIntent();

        tName = (TextView) findViewById(R.id.docNameTextView);
        tDid = (TextView) findViewById(R.id.didTextView);
        tSpec = (TextView) findViewById(R.id.specTextView);
        tPhone = (TextView) findViewById(R.id.docPhoneTextView);

        String name = patintent.getExtras().getString("name");
        did = SingletonPatient.getInstance().getdID();
        String bg = patintent.getExtras().getString("date");
        phone = patintent.getExtras().getString("phone");

        tName.setText(name);
        tDid.setText(did);
        tSpec.setText(bg);
        tPhone.setText(phone);

    }

    public void CallDoc(View v){
        String number = phone;
        Uri call = Uri.parse("tel:" + number);
        Intent surf = new Intent(Intent.ACTION_DIAL, call);
        startActivity(surf);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void GetAppn(View v){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        final String pid = SingletonPatient.getInstance().getpID();
        final Context c = this;

        DatePickerDialog dialog = new DatePickerDialog(this, android.R.style.Theme_Material_Dialog_MinWidth, dateSetListener, year, month, day);

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                appnDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                //tost(pid+" searching appn with "+did+"\nOn date: "+appnDate);
                BackgroundProcess bg = new BackgroundProcess(c);
                bg.execute("setAppn",appnDate, pid, did);
            }
        };
        dialog.show();

    }

    public void tost(String s){
        Toast toast = Toast.makeText(this, s, Toast.LENGTH_LONG);
        toast.show();
    }

}
