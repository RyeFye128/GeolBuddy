package com.example.ryanspc.geolbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity implements View.OnClickListener {

    ImageView headerImage;
    Button rockIdentification, rockLookup, mineralLookup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        headerImage = new ImageView(this);

        rockIdentification = (Button) findViewById(R.id.rockIdent);
        rockLookup = (Button)findViewById(R.id.rockLookup);
        mineralLookup = (Button) findViewById(R.id.mineralLookup);

        rockIdentification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //decide action based on button id
        Button temp = (Button)v;
        switch(temp.getText().toString())
        {
            case "Rock Flowchart":
                //stuff
                Intent intent = new Intent(Home.this, Choose_flow_chart.class);
                startActivity(intent);

                break;
            case "Rock Lookup":
                //Premium
                break;
            case "Mineral Lookup":
                //Premium
                break;
        }
    }
}
