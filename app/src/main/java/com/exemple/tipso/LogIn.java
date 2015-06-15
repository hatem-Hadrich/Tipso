package com.exemple.tipso;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by Akrem on 05/05/2015.
 */
public class LogIn extends Activity {

    String url = "http://10.0.2.2/Tipso/JSON/User/addUser.php";
    Button joinUs;
    ProgressBar progress;

    EditText firstName, secondName, email, passWord, passWordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        firstName = (EditText) findViewById(R.id.firstName);
        secondName = (EditText) findViewById(R.id.secondName);
        email = (EditText) findViewById(R.id.email);
        passWord = (EditText) findViewById(R.id.passWord);
        passWordConfirm = (EditText) findViewById(R.id.passWordConfirm);
        progress = (ProgressBar) findViewById(R.id.progressBar2);
        joinUs = (Button) findViewById(R.id.join);

        joinUs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TextUtils.isEmpty(firstName.getText().toString())) {
                    firstName.setError("Please enter your first name");
                    return;
                }
                if (TextUtils.isEmpty(secondName.getText().toString())) {
                    secondName.setError("Please enter your second name");
                    return;
                }
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Please enter your email");
                    return;
                }
                if (TextUtils.isEmpty(passWord.getText().toString())) {
                    passWord.setError("Please enter your password");
                    return;
                }
                if (TextUtils.isEmpty(passWordConfirm.getText().toString())) {
                    passWordConfirm.setError("Please confirm your password");
                    return;
                }
                if ((passWord.getText().toString()).equals(passWordConfirm.getText().toString())) {
                    MyTask task = new MyTask();
                    String s = "?firstName=" + firstName.getText().toString() +
                            "&secondName=" + secondName.getText().toString() +
                            "&email=" + email.getText().toString() +
                            "&passWord=" + passWord.getText().toString();

                    task.execute(url, s);
                } else {
                    passWordConfirm.setText("");
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                }
            }
        });
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String content = HttpManager.sendData(params[0], params[1]);
            return content;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progress.setVisibility(View.INVISIBLE);

            Intent intent = new Intent(getApplicationContext(), SignIn.class);
            startActivity(intent);
            finish();
        }
    }
}
