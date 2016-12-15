package com.example.woonhyoungcheong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by cheon on 2016-11-14.
 */

public class Payment extends Activity{
    TextView checked;
    String sample_JSON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        Intent intent = getIntent();
        ArrayList<String> name = intent.getStringArrayListExtra("checked_items");
        sample_JSON = "[{'user_id':'1','writings':{";
        String ids = "";
        for(int i = 0; i < name.size(); i++)
        {
            ids += "'" + String.valueOf(i)+ "':'" + name.get(i) + "'";
            if(i != name.size()-1)
                ids += ",";
        }
        ids += "}}]";
        checked = (TextView)findViewById(R.id.sample_payment);
        new HttpPostRequest().execute("");
    }

    private class HttpPostRequest extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... info) {
            String sResult = "Error";

            try {
                URL url = new URL("http://172.31.3.47/sample.php/?data=" + sample_JSON);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                String body = "";
/*                        "op=" + info[0] +"&"
                        +"phone=" + info[1] + "&"
                        +"product=" + info[2] + "&"
                        +"price=" + info[3] + "&"
                        +"token=" + info[4];
*/
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                osw.write(body);
                osw.flush();

                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuilder builder = new StringBuilder();
                String str;

                while ((str = reader.readLine()) != null) {
                    builder.append(str);
                }
                sResult     = builder.toString();
                Log.d("Fire", sResult);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResult;
        }

        @Override
        protected void onPostExecute(String result){

            checked.setText(result);
        }
    }
}
