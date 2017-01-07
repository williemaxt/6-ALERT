package com.example.solutions611.ereport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



    }

    private void switchActivity() {
        /*Switch the activity*/
        Intent changePage = new Intent(settingsActivity.this, page1.class);
        startActivity(changePage);
    }

}
