package com.exemple.tipso;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SignIn extends Activity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btn = (Button) findViewById(R.id.btnSignIn);
    }

    public void authentication(View view) {
        Intent intent = new Intent(getApplicationContext(), Acceuil.class);
        startActivity(intent);
        finish();
    }
}
