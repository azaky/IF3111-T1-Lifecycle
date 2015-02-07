package com.azaky.android.pbd.androidlifecycletutorial;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class TracerActivity extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tracer);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tracer, menu);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notify("onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        notify("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notify("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        notify("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notify("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState");
    }

    private void notify(String methodName) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = new Notification.Builder(this)
                .setContentTitle(methodName + " " + strings[strings.length - 1]).setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentText(name).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), noti);
    }
}
