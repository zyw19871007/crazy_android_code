package com.sdu.zyw.shadow.myapplication;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock);
        final Button start = (Button) findViewById(R.id.start);
        final Chronometer counter = (Chronometer) findViewById(R.id.counter);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.setBase(SystemClock.elapsedRealtime());
                Log.d("test", String.valueOf(SystemClock.currentThreadTimeMillis()));
                Log.d("test", String.valueOf(SystemClock.elapsedRealtime()));
                counter.start();
                start.setEnabled(false);

            }

            });
        counter.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (chronometer.getBase() - SystemClock.elapsedRealtime() < -5000) {
                    chronometer.stop();
                    start.setEnabled(true);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
