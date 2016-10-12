package com.example.ryanspc.geolbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//import Ids for comparison on click
import static com.example.ryanspc.geolbuddy.R.id.IgneousFlow;
import static com.example.ryanspc.geolbuddy.R.id.MetaFlow;
import static com.example.ryanspc.geolbuddy.R.id.SedimentaryFlow;

public class Choose_flow_chart extends AppCompatActivity implements View.OnClickListener{

    ImageButton ig, sed, meta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_flow_chart);

        ig = (ImageButton) findViewById(IgneousFlow);
        sed = (ImageButton) findViewById(SedimentaryFlow);
        meta = (ImageButton) findViewById(MetaFlow);

        ig.setOnClickListener(this);
        sed.setOnClickListener(this);
        meta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //decide what to do based on button name
        ImageButton temp = (ImageButton)v;
        switch(temp.getId())
        {
            case IgneousFlow:
                //stuff
                Intent intent = new Intent(Choose_flow_chart.this, Igneous_flow_chart.class);
                startActivity(intent);
                break;

            case SedimentaryFlow:
                //
                Intent sedintent = new Intent(Choose_flow_chart.this, Sed_Flow_Chart.class);
                startActivity(sedintent);
                break;

            case MetaFlow:
                Intent metaintent = new Intent(Choose_flow_chart.this, Meta_Flow_Chart.class);
                startActivity(metaintent);
                break;

        }
    }
}
