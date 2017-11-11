package sks.jakfromspace.medicloud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editemail, editpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editemail = (EditText) findViewById(R.id.editEmail);
        editpass = (EditText) findViewById(R.id.editPassword);
    }

    public void OnLogin(View view){
        String username = editemail.getText().toString();
        String pass = editpass.getText().toString();
        String type = "login";

        BackgroundProcess bgP = new BackgroundProcess(this);
        bgP.execute(type, username, pass);
    }
}
