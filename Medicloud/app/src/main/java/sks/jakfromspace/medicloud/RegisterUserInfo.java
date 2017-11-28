package sks.jakfromspace.medicloud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUserInfo extends AppCompatActivity {
    EditText name,dob,blood_group,sex,phone_number,address;
    //String str_name,str_dob,str_blood_group,str_sex,str_phone_number,str_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user_info);

        name = (EditText)findViewById(R.id.et_name);
        dob = (EditText)findViewById(R.id.et_dob);
        blood_group= (EditText)findViewById(R.id.et_blood_group);
        sex = (EditText)findViewById(R.id.et_sex);
        phone_number = (EditText)findViewById(R.id.et_phone_number);
        address = (EditText)findViewById(R.id.et_address);
    }

    public void onRegNext(View view){

        String type = getIntent().getExtras().getString("type", "register");
        String str_email = getIntent().getExtras().getString("str_email");
        String str_password = getIntent().getExtras().getString("str_password");

        //BackgroundProcess bgProcessAccount = new BackgroundProcess(this);
        //bgProcessAccount.execute(type1, str_email, str_password);

        String str_name = name.getText().toString();
        String str_dob = dob.getText().toString();
        String str_blood_group = blood_group.getText().toString();
        String str_sex = sex.getText().toString();
        String str_phone_number = phone_number.getText().toString();
        String str_address = address.getText().toString();
        //String type2 = "registerUpdate";
        boolean formcom = str_name.length()!=0 && str_dob.length()!=0 && str_sex.length()!=0 && str_phone_number.length()!=0;
        if(formcom) {
            BackgroundProcess bgProcessUser = new BackgroundProcess(this);
            bgProcessUser.execute(type, str_name, str_dob, str_blood_group, str_sex, str_phone_number, str_address, str_email, str_password);
            //Button nextUpdateButt = (Button) findViewById(R.id.bt_update);
            //nextUpdateButt.setEnabled(false);

            startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "Please Complete the Form", Toast.LENGTH_SHORT);
            toast.show();
        }
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 2 seconds
            }
        }, 5000);*/

    }
}
