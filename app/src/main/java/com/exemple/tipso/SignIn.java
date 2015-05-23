package com.exemple.tipso;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

    Button btn, btn2;
    EditText email, passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn = (Button) findViewById(R.id.btnSignIn);
        btn2 = (Button) findViewById(R.id.login_btn);
        email = (EditText) findViewById(R.id.email_signIn);
        passWord = (EditText) findViewById(R.id.password_singIn);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (email.getText().length() > 0 && passWord.getText().length() > 0 && checkLogin(email.getText().toString(), passWord.getText().toString())) {
                    // login user
                    Intent intent = new Intent(getApplicationContext(), SignIn.class);
                    startActivity(intent);
                    finish();
                } else {

                    Toast.makeText(getApplicationContext(), "Please try again !", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(getApplicationContext(), LogIn.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean checkLogin(String email, String passWord) {

        String KEY_SUCCESS = "success";
        ArrayList nameValuePairs = new ArrayList();
        nameValuePairs.add(new BasicNameValuePair("tag", "login"));
        nameValuePairs.add(new BasicNameValuePair("email", email));
        nameValuePairs.add(new BasicNameValuePair("passWord", passWord));

        try {
            /********************************************/
          /* Exécute la requête vers le serveur local */
            /********************************************/

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://10.0.2.2/Tipso/JSON/User/login.php");
            try {
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpEntity entity = response.getEntity();
            InputStream is = null;
            try {
                is = entity.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(line + "\n");
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            /***************************/
          /* Résultats de la requête */
            /***************************/

            String result = sb.toString();
            JSONObject jObj = null;
            try {
                jObj = new JSONObject(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            /**********************************************/
          /* Si le résultat de la requête n'est pas nul */
            /**********************************************/

            if (jObj.getString(KEY_SUCCESS) != null) {
                String res = jObj.getString(KEY_SUCCESS);

                /********************************************/
            /* Si il vaut 1, l'utilisateur est connecté */
                /********************************************/

                if (Integer.parseInt(res) == 1) {
                    Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
                    return true;
                } else
                    Toast.makeText(getApplicationContext(), jObj.get("error_msg").toString(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }


        return false;
    }

    public void authentication(View view) {
        Intent intent = new Intent(getApplicationContext(), Acceuil.class);
        startActivity(intent);
        finish();
    }

}
