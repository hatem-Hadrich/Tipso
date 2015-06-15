package com.exemple.tipso;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;


public class splash extends Activity {

    ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progress = (ProgressBar) findViewById(R.id.progressBar);
        MyTask mt = new MyTask();
        mt.execute();
    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(SaveSharedPreference.getUserEmail(splash.this).length() == 0 && SaveSharedPreference.getUserPassword(splash.this).length() == 0)
            {
                // call Login Activity
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
                finish();
            }
            else
            {
                // Call Next Activity
                Intent intent = new Intent(getApplicationContext(), Acceuil.class);
                startActivity(intent);
                finish();
            }

            return "Hello my friend on tipso";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progress.setVisibility(View.INVISIBLE);

        }
    }
}
