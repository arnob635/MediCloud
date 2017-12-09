package sks.jakfromspace.medicloud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DocGetInfoActivity extends AppCompatActivity {

    TextView tName, tDid, tSpec, tPhone;

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
        String dob = patintent.getExtras().getString("did");
        String bg = patintent.getExtras().getString("spec");
        String phone = patintent.getExtras().getString("phone");

        tName.setText(name);
        tDid.setText(dob);
        tSpec.setText(bg);
        tPhone.setText(phone);

    }

}
