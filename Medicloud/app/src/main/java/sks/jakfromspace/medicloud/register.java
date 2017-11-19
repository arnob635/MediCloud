package sks.jakfromspace.medicloud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);


    }

    public void onReg(View view){
        String str_email= email.getText().toString();
        String str_password = password.getText().toString();
        String type = "register";
        Intent regIntent = new Intent(getApplicationContext(), RegisterUserInfo.class);
        regIntent.putExtra("type", type);
        regIntent.putExtra("str_email", str_email);
        regIntent.putExtra("str_password", str_password);
        startActivity(regIntent);
        //BackgroundProcess bgP = new BackgroundProcess(this);
        //bgP.execute(type, str_email, str_password);

    }
}
