package com.example.woonhyoungcheong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        Log.e("payment", "completed");

        Intent intent = getIntent();
        ArrayList<String> name = intent.getStringArrayListExtra("checked_items");
        Log.e("intent data",name.toString());
        sample_JSON = "{\"user_id\":\"460\",\"writings\":{";
        String ids = "";
        for(int i = 0; i < name.size(); i++)
        {
            ids += "\"" + String.valueOf(i)+ "\":\"" + name.get(i) + "\"";
            if(i != name.size()-1)
                ids += ",";
        }
        ids += "}}";
        sample_JSON += ids;
        checked = (TextView)findViewById(R.id.sample_payment);
        new HttpPostRequest().execute("");
    }

    private class HttpPostRequest extends AsyncTask<String, Void, String> {
        private String parser = "";
        @Override
        protected String doInBackground(String... info) {
            String sResult = "Error";

            try {
                Log.e("data",sample_JSON);
                URL url = new URL("http://ec2-52-78-239-42.ap-northeast-2.compute.amazonaws.com/a.php/?data=" + sample_JSON);
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
            int half_index = result.length()/2;
            parser = result.substring(half_index);
            String dummy = parser.substring(0,10);
            Log.e("dummy",parser.substring(0,10));
            String replacement = "";

            parser = parser.replace(parser.substring(0,10),replacement);
            parser = parser.replace("\"",replacement);
            parser = parser.replace(" ",replacement);
            Log.e("after parsing",parser);


            try {
                checked.setText("http://ec2-52-78-239-42.ap-northeast-2.compute.amazonaws.com/" + parser);
                checked.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ec2-52-78-239-42.ap-northeast-2.compute.amazonaws.com/" + parser));

                        startActivity(intent);


                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Texting", "error in settext");
            }
        }
    }
}
