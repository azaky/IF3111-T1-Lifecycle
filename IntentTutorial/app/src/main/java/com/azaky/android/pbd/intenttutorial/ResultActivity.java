package com.azaky.android.pbd.intenttutorial;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;


public class ResultActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textView = ((TextView)findViewById(R.id.textView2));
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String value = extra.getString("name");
            if (value != null) {
                textView.setText(value);
            }
            else {
                textView.setText("Null bro");
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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

    @Override
    public void finish() {

        Intent intent = new Intent();

        // TODO 2 read the data of the EditText field
        // with the id returnValue
        EditText editText = (EditText) findViewById(R.id.editText3);
        String value = editText.getText().toString();

        // TODO 3 put the text from EditText
        // as String extra into the intent
        // use editText.getText().toString();
        intent.putExtra("reply", value);

        // TODO 4 use setResult(RESULT_OK, intent);
        // to return the Intent to the application
        setResult(RESULT_OK, intent);

        super.finish();
    }
}
