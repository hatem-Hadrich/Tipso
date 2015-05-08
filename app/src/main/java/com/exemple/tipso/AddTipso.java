package com.exemple.tipso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Hadrich-Hatem on 04/05/2015.
 */
public class AddTipso extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_tipso);
    }

    public void cancel(View view) {

        Intent intent = new Intent(getApplicationContext(), Acceuil.class);
        startActivity(intent);
        finish();
    }
}
