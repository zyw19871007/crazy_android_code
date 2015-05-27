package com.sdu.zyw.shadow.myapplication;

import android.content.ClipData;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SimpleAdapterActivity extends ActionBarActivity {

    private String[] name = {"1","2","3"};
    private String[] des= {"a","b","c"};
    private int[] img= {R.mipmap.user2,R.mipmap.user2,R.mipmap.user};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("header", name[i]);
            item.put("name", des[i]);
            item.put("img", img[i]);
            list.add(item);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.array_item, new String[]{"header", "name", "img"}, new int[]{R.id.adapter1, R.id.adapter2, R.id.adapter3});
        ListView listView = (ListView) findViewById(R.id.simplist);
        listView.setAdapter(simpleAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_simple_adapter, menu);
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
