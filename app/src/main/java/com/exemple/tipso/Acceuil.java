package com.exemple.tipso;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;


public class Acceuil extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(this));
    }

}
