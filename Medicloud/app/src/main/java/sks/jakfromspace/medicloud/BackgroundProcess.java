package sks.jakfromspace.medicloud;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

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
    AlertDialog alert;

    BackgroundProcess (Context c){
        context = c;
    }


    @Override
    protected String doInBackground(String... params) {
        int newID = -1;
        String type = params[0];
        String loginURL = "http://localhost/MEDICLOUD/login.php";
        String registerURL = "http://localhost/MEDICLOUD/register.php";

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
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,"iso-8859-1"));
            String result="", line="";
            while ((line = reader.readLine()) != null){
                result += line;
            }
            reader.close();
            in.close();
            httpURLConnection.disconnect();
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } else if(type.equals("register")){try {
            String email = params[1];
            String password = params[2];
           // String cpassword = params[3];
            URL url = new URL(registerURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream out = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String postdata = URLEncoder.encode("email", "UTF-8")+"="
                    +URLEncoder.encode(email, "UTF-8")+"&"
                    +URLEncoder.encode("password", "UTF-8")+"="
                    +URLEncoder.encode(password, "UTF-8");
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
            JSONObject responseJSON = new JSONObject(result);
            newID = responseJSON.getInt("id");

            reader.close();
            in.close();
            httpURLConnection.disconnect();
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        } else if(type.equals("registerUpdate")){try {
            int id = Integer.parseInt(params[1]);
            String name = params[2];
            String dob = params[3];
            String blood_group = params[4];
            String sex = params[5];
            String phone_number = params[6];
            String address = params[7];
            URL url = new URL(registerURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream out = httpURLConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String postdata = URLEncoder.encode("id", "UTF-8")+"="
                    +URLEncoder.encode(String.valueOf(id), "UTF-8")+"&"
                    +URLEncoder.encode("name", "UTF-8")+"="
                    +URLEncoder.encode(name, "UTF-8")
                    +URLEncoder.encode("dob", "UTF-8")+"="
                    +URLEncoder.encode(dob, "UTF-8")
                    +URLEncoder.encode("blood_group", "UTF-8")+"="
                    +URLEncoder.encode(blood_group, "UTF-8")
                    +URLEncoder.encode("sex", "UTF-8")+"="
                    +URLEncoder.encode(sex, "UTF-8")
                    +URLEncoder.encode("phone_number", "UTF-8")+"="
                    +URLEncoder.encode(phone_number, "UTF-8")
                    +URLEncoder.encode("address", "UTF-8")+"="
                    +URLEncoder.encode(address, "UTF-8");
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

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alert = new AlertDialog.Builder(context).create();
        alert.setTitle("Login State");
    }

    @Override
    protected void onPostExecute(String result) {
        alert.setMessage(result);
        alert.show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
