package sks.jakfromspace.medicloud;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editemail, editpass;
    public static boolean isDoc = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editemail = (EditText) findViewById(R.id.editEmail);
        editpass = (EditText) findViewById(R.id.editPassword);
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public void OnLogin(View view) {
        String username = editemail.getText().toString();
        String pass = editpass.getText().toString();
        String type = "login";

        BackgroundProcess bgP = new BackgroundProcess(this);
        bgP.execute(type, username, pass);
    }

    public void onSignUp(View view) {
        startActivity(new Intent(this, Register.class));
    }

}
