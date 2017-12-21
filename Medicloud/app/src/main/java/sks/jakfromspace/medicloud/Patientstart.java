package sks.jakfromspace.medicloud;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Patientstart extends AppCompatActivity {

    TextView tName, tDob, tBg, tSex, tPhone, tAdd;
    Button btGetDoc, btHist, btPresc, btEmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientstart);
        Intent patintent = getIntent();

        tName = (TextView) findViewById(R.id.specTextView);
        tDob = (TextView) findViewById(R.id.dobTextView);
        tBg = (TextView) findViewById(R.id.BGtextView);
        tSex = (TextView) findViewById(R.id.sexTextView);
        tPhone = (TextView) findViewById(R.id.phoneTextView);
        tAdd = (TextView) findViewById(R.id.addTextView);

        String name = patintent.getExtras().getString("patname");
        String dob = patintent.getExtras().getString("dob");
        String bg = patintent.getExtras().getString("bg");
        String sex = patintent.getExtras().getString("sex");
        String phone = patintent.getExtras().getString("phone");
        String address = patintent.getExtras().getString("address");

        tName.setText(name);
        tDob.setText(dob);
        tBg.setText(bg);
        tSex.setText(sex);
        tPhone.setText(phone);
        tAdd.setText(address);
    }


    public void onGetDoc(View view) {
        startActivity(new Intent(this, DocListActivity.class));
    }

    public void onGetMyHist(View view)  {
        startActivity(new Intent(this, AppointmentList.class));
    }

    public void onGetMyPresc(View view) {

    }

    public void onEmergency(View view) {
        String number = "10678";
        Uri call = Uri.parse("tel:" + number);
        Intent surf = new Intent(Intent.ACTION_DIAL, call);
        startActivity(surf);
    }
}
