package sks.jakfromspace.medicloud;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by JAKfromSpace on 11-Nov-17.
 */

public class BackgroundProcess extends AsyncTask<String, String, String> {

    Context context;
    String type;

    Intent newIntent;
    boolean loginSuccess = false;

    BackgroundProcess (Context c){
        context = c;
    }


    @Override
    protected String doInBackground(String... params) {

        type = params[0];
        String loginURL = "http://sks.heliohost.org/login.php";
        String registerURL = "http://sks.heliohost.org/register.php";

        if(type.equals("login")) try {
            String username = params[1];
            String password = params[2];
            URL url = new URL(loginURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream out = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String postdata = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username, "UTF-8")+"&"
                    +URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
            writer.write(postdata);
            writer.flush();
            writer.close();
            out.close();

            InputStream in = httpURLConnection.getInputStream();
            String result = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            in.close();
            result = sb.toString();
            Log.i("Json",result);
            JSONObject responseJSON = new JSONObject(result);
            boolean isDoc  = responseJSON.getInt("isDoc") > 0;

            loginSuccess = responseJSON.getBoolean("success");
            MainActivity.isDoc = isDoc;

            reader.close();
            in.close();
            httpURLConnection.disconnect();

            if(!isDoc) {
                String patname = responseJSON.getString("patname");
                String dob = responseJSON.getString("dob");
                String bg = responseJSON.getString("bg");
                String sex = responseJSON.getString("sex");
                String phone = responseJSON.getString("phone");
                String address = responseJSON.getString("address");

                newIntent = new Intent(context, Patientstart.class);
                newIntent.putExtra("patname",patname);
                newIntent.putExtra("dob",dob);
                newIntent.putExtra("bg",bg);
                newIntent.putExtra("sex",sex);
                newIntent.putExtra("phone",phone);
                newIntent.putExtra("address",address);
            }else{
                //newIntent = new Intent(context, Docstart.class);
                Toast toast = Toast.makeText(context, "Hello Doctor " + username, Toast.LENGTH_LONG);
                toast.show();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        else if(type.equals("register")){try {
            //int id = Integer.parseInt(params[1]);
            String name = params[1];
            String dob = params[2];
            String blood_group = params[3];
            String sex = params[4];
            String phone_number = params[5];
            String address = params[6];
            String email = params[7];
            String password = params[8];
            URL url = new URL(registerURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream out = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));

            String postdata = URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")+"&"
                    +URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8")+"&"
                    +URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name, "UTF-8")+"&"
                    +URLEncoder.encode("dob", "UTF-8")+"="+URLEncoder.encode(dob, "UTF-8")+"&"
                    +URLEncoder.encode("blood_group", "UTF-8")+"="+URLEncoder.encode(blood_group, "UTF-8")+"&"
                    +URLEncoder.encode("sex", "UTF-8")+"="+URLEncoder.encode(sex, "UTF-8")+"&"
                    +URLEncoder.encode("phone_number", "UTF-8")+"="+URLEncoder.encode(phone_number, "UTF-8")+"&"
                    +URLEncoder.encode("address", "UTF-8")+"="+URLEncoder.encode(address, "UTF-8");
            System.out.println(postdata);
            writer.write(postdata);
            writer.flush();
            writer.close();
            out.close();

            InputStream in = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,"iso-8859-1"));
            String result="", line="";
            while ((line = reader.readLine()) != null){
                result += line;
            }
            reader.close();
            in.close();
            httpURLConnection.disconnect();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String result) {
        if(type.equals("login") && loginSuccess) {
            context.startActivity(newIntent);
            Toast toast = Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG);
            toast.show();
        }else{
            Toast toast = Toast.makeText(context, "Error, Check Credentials", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
