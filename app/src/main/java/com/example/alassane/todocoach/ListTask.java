package com.example.alassane.todocoach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Coach coach = (Coach) getIntent().getParcelableExtra("parcel_data");
        setContentView(R.layout.activity_list_task);
    }
}
