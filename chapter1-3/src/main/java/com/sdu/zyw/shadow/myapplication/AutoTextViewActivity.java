package com.sdu.zyw.shadow.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import static android.R.layout.simple_dropdown_item_1line;


public class AutoTextViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_text_view);
        String[] strings = new String[]{"abbb","bbbb","cccc","ddafa"};
        ArrayAdapter arrayAdapter;
        arrayAdapter = new ArrayAdapter(this, simple_dropdown_item_1line, strings);
        AutoCompleteTextView autoCompleteTextView= (AutoCompleteTextView)findViewById(R.id.autotext);
        autoCompleteTextView.setAdapter(arrayAdapter);
        AlertDialog.Builder builder;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_auto_text_view, menu);
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
