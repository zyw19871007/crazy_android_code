package com.sdu.zyw.shadow.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CalPrime extends ActionBarActivity {
    private EditText editText;
    private Button button;
    private calthred thread;
    class calthred extends Thread{
        public Handler handler;
        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 123) {
                        for (int i = 0; i < 60000; i++) {
                            for (int j = 0; j < 60000; j++) {
                                
                            }
                            
                        }
                        Toast.makeText(CalPrime.this, "lalal", Toast.LENGTH_LONG).show();
                    }
                }
            };
            Looper.loop();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_prime);
        editText = (EditText) findViewById(R.id.calprimeedit);
        button = (Button) findViewById(R.id.calpribtn);
        thread = new calthred();
        thread.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = 123;
                thread.handler.sendMessage(msg);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cal_prime, menu);
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
