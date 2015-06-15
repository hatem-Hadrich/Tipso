package com.exemple.tipso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class SignIn extends Activity {

    Button btnSignIn, btnLogIn;
    EditText email, passWord;
    String KEY_SUCCESS = "success";
    boolean okay= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnLogIn = (Button) findViewById(R.id.login_btn);

        email = (EditText) findViewById(R.id.email_signIn);
        passWord = (EditText) findViewById(R.id.password_singIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Please enter your email");
                    return;
                }
                if (TextUtils.isEmpty(passWord.getText().toString())) {
                    passWord.setError("Please enter your password ");
                    return;
                }
                if (email.getText().length() > 0 && passWord.getText().length() > 0 ) {
                    // login user
                    checkLogin(email.getText().toString(), passWord.getText().toString(),okay);

                }
                else {
                    passWord.setText("");
                    Toast.makeText(getApplicationContext(), "Please check your information !", Toast.LENGTH_LONG).show();
                }

            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogIn.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void checkLogin(final String email, final String passWord , final boolean okay) {

        Thread th =new Thread(new Runnable() {
        @Override
        public void run() {
            try {

              /* Exécute la requête vers le serveur local */
                ArrayList nameValuePairs = new ArrayList();
                nameValuePairs.add(new BasicNameValuePair("email", email));
                nameValuePairs.add(new BasicNameValuePair("passWord", passWord));
                HttpPost httppost = new HttpPost("http://10.0.2.2/Tipso/JSON/User/login.php");
                HttpClient httpclient = new DefaultHttpClient();
                try {
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                HttpResponse response = null;
                try {
                    response = httpclient.execute(httppost);

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                HttpEntity entity = response.getEntity();
                InputStream is = null;
                try {
                    is = entity.getContent();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                StringBuilder sb = new StringBuilder();
                String line = null;
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                sb.append(line + "\n");
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
              /* Résultats de la requête */
                String result = sb.toString();
                JSONObject jObj = null;
                try {
                    jObj = new JSONObject(result);
                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
                /* Si le résultat de la requête n'est pas nul */
                if (jObj.getString(KEY_SUCCESS) != null) {
                    String res = jObj.getString(KEY_SUCCESS);

                /* Si il vaut 1, l'utilisateur est connecté */
                    if (Integer.parseInt(res) == 1) {
                        SaveSharedPreference.setEmailAndPassword(getApplicationContext(),email,passWord);
                        Intent intent = new Intent(getApplicationContext(),Acceuil.class);
                        startActivity(intent);
                        finish();
                        //Log.i("res================>", "ggggggggggggg");
                        return;
                    } else {
                        Intent intent = new Intent(getApplicationContext(),SignIn.class);
                        startActivity(intent);
                        finish();
                        return;
                    }


                }
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            }
        });
        th.start();

    }

    public void authentication(View view) {
        Intent intent = new Intent(getApplicationContext(), Acceuil.class);
        startActivity(intent);
        finish();
    }

}
