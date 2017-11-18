package sks.jakfromspace.medicloud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.password;

public class register extends AppCompatActivity {

    EditText email,password;
    String str_email,Str_password;
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

        BackgroundProcess bgP = new BackgroundProcess(this);
        bgP.execute(type, str_email, str_password);

    }
}
