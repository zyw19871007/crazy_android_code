package com.sdu.zyw.shadow.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class AsyncTaskActivity extends ActionBarActivity {

    private TextView textView;
    private Button button;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        textView = (TextView) findViewById(R.id.asynctasdtext);
        button = (Button) findViewById(R.id.asyncbtn);
        progressDialog = new ProgressDialog(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownTask downTask = new DownTask(AsyncTaskActivity.this);
                try {
                    downTask.execute(new URL("http://www.crazyit.org/ethos.php"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    class DownTask extends AsyncTask<URL, Integer, String> {


        int hasRead = 0;
        Context context;

        public DownTask(Context ctx) {
            context = ctx;
        }


        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.setText("already" + values[0]);
            progressDialog.setProgress(values[0]);

        }

        @Override
        protected void onPreExecute() {
            progressDialog.setTitle("ing");
            progressDialog.setMessage("wait");
            progressDialog.setMax(902);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
//            progressDialog.setTitle("ing");
//            progressDialog.setMessage("wait");
//            progressDialog.setMax(202);
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//            progressDialog.show();
        }

        @Override
        protected String doInBackground(URL... params) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URLConnection conn = params[0].openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                    hasRead++;
                    publishProgress(hasRead);

                }
                return stringBuilder.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_async_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
