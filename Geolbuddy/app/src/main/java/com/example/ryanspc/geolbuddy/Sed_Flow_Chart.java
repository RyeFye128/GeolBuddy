package com.example.ryanspc.geolbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Sed_Flow_Chart extends AppCompatActivity {

    private RockHolder[] sedRocks;
    ImageView picture;

    // ----- stores a copy of current index at all times --------
    private int current, previous, nextYes, nextNo;
    private String currentText;
    Button yesButton, noButton, backButton, restartButton;
    TextView sentence;


    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sed__flow__chart);

        sedRocks = new RockHolder[99];
        duration = Toast.LENGTH_SHORT;
// ------ assign the buttons to their XML counterparts -------
        yesButton = (Button) findViewById(R.id.yesButtonSed);
        noButton = (Button) findViewById(R.id.noButtonSed);
        sentence = (TextView) findViewById(R.id.descriptionSed);
        backButton = (Button) findViewById(R.id.backButtonSed);
        restartButton = (Button) findViewById(R.id.restartButtonSed);

        picture = (ImageView) findViewById(R.id.questionPictureSed);
        picture.setImageResource(R.drawable.igbutton);

        setupArray();//create db

        yesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                RockHolder nextOption = sedRocks[nextYes];
                updateEverything(nextOption);

            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                if (nextNo == -8) {
                    CharSequence text = "Double check it, go back if necessary and try again";
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
                    toast.show();
                    return; //dont update anything.
                }

                RockHolder nextOption = sedRocks[nextNo];
                updateEverything(nextOption);

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (previous == -1) {
                    CharSequence text = "You're at the beginning already!";
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }
                RockHolder nextOption = sedRocks[previous];
                updateEverything(nextOption);

            }
        });

        //resets back to the start
        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (current == 0)//at the start already...
                {
                    CharSequence text = "You're at the beginning already!";
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }
                RockHolder nextOption = sedRocks[0];
                updateEverything(nextOption);

            }
        });
    }

    //this method is going to handle the array
    private void setupArray() {
        ImageView temp1 = new ImageView(this);

        //load a new image and store that one in the current rock


        //TODO get the sed pictures ready.
        //next:-1 means youre at the end, a -2 means that option is invalid
        //if index = 5, 14, the yes/no have to change.
        int index = 0;
        sedRocks[0] = new RockHolder("Does it fizz with HCl?");
        sedRocks[0].setCurrent(0);
        sedRocks[0].setNext(1);
        sedRocks[0].setNextNo(7);
        sedRocks[0].setPrevious(-1);
        sedRocks[0].setWhatRock("");

        index = 1;
        sedRocks[index] = new RockHolder("Are fossils present?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(5);
        sedRocks[index].setNextNo(2);
        sedRocks[index].setPrevious(0);
        sedRocks[index].setWhatRock("");

        index = 2;
        sedRocks[index] = new RockHolder("This rock is a Limestone");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(1);
        sedRocks[index].setWhatRock("Limestone");

        index = 5;
        sedRocks[index] = new RockHolder("Look at the fossils, are they:");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(4);
        sedRocks[index].setNextNo(6);
        sedRocks[index].setPrevious(1);
        sedRocks[index].setWhatRock("");

        index = 4;
        sedRocks[index] = new RockHolder("This rock is a Fossiliferous Limestone");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(5);
        sedRocks[index].setWhatRock("Fossiliferous Limestone");

        index = 6;
        sedRocks[index] = new RockHolder("This rock is Chalk, a form of Limestone");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(5);
        sedRocks[index].setWhatRock("");

        index = 7;
        sedRocks[index] = new RockHolder("Does it have a clastic texture? Can you see gravel, sand silt, or clay?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(8);
        sedRocks[index].setNextNo(18);
        sedRocks[index].setPrevious(0);
        sedRocks[index].setWhatRock("");

        index = 8;
        sedRocks[index] = new RockHolder("Are the grains easy to see, greater than 2mm?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(9);
        sedRocks[index].setNextNo(12);
        sedRocks[index].setPrevious(7);
        sedRocks[index].setWhatRock("");

        index = 9;
        sedRocks[index] = new RockHolder("Are the grains angular?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(10);
        sedRocks[index].setNextNo(11);
        sedRocks[index].setPrevious(8);
        sedRocks[index].setWhatRock("");

        index = 10;
        sedRocks[index] = new RockHolder("This rock is a Breccia");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(9);
        sedRocks[index].setWhatRock("Breccia");

        index = 11;
        sedRocks[index] = new RockHolder("This rock ia a Conglomerate");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(9);
        sedRocks[index].setWhatRock("Conglomerate");

        index = 12;
        sedRocks[index] = new RockHolder("Are the grains barely visible, less than 2mm?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(13);
        sedRocks[index].setNextNo(14);//special case
        sedRocks[index].setPrevious(8);
        sedRocks[index].setWhatRock("");

        index = 13;
        sedRocks[index] = new RockHolder("This rock is a Sandstone");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(12);
        sedRocks[index].setWhatRock("");

        index = 14;
        sedRocks[index] = new RockHolder("Look at the grains. Are they gritty or smooth?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(15);
        sedRocks[index].setNextNo(17);
        sedRocks[index].setPrevious(12);
        sedRocks[index].setWhatRock("");

        index = 15;
        sedRocks[index] = new RockHolder("This rock is a Siltstone");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(14);
        sedRocks[index].setWhatRock("Siltstone");

        index = 17;
        sedRocks[index] = new RockHolder("This rock is a Shale");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(14);
        sedRocks[index].setWhatRock("");

        index = 18;
        sedRocks[index] = new RockHolder("Is the rock black?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(19);
        sedRocks[index].setNextNo(22);
        sedRocks[index].setPrevious(7);
        sedRocks[index].setWhatRock("");

        index = 19;
        sedRocks[index] = new RockHolder("Does it form rounded nodules?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(20);
        sedRocks[index].setNextNo(21);
        sedRocks[index].setPrevious(18);
        sedRocks[index].setWhatRock("");

        index = 20;
        sedRocks[index] = new RockHolder("This rock is Phosphate");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(19);
        sedRocks[index].setWhatRock("");

        index = 21;
        sedRocks[index] = new RockHolder("This rock is Coal");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(19);
        sedRocks[index].setWhatRock("");

        index = 22;
        sedRocks[index] = new RockHolder("Does it have conchoidal fracture, like glass?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(23);
        sedRocks[index].setNextNo(24);
        sedRocks[index].setPrevious(18);
        sedRocks[index].setWhatRock("");

        index = 23;
        sedRocks[index] = new RockHolder("This rock is a Chert");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(22);
        sedRocks[index].setWhatRock("Chert");

        index = 24;
        sedRocks[index] = new RockHolder("Are the cystals cubic?");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(25);
        sedRocks[index].setNextNo(26);
        sedRocks[index].setPrevious(22);
        sedRocks[index].setWhatRock("");

        index = 25;
        sedRocks[index] = new RockHolder("This rock is Rock Salt");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(24);
        sedRocks[index].setWhatRock("Rock Salt");

        index = 26;
        sedRocks[index] = new RockHolder("This rock is Gypsum");
        sedRocks[index].setCurrent(index);
        sedRocks[index].setNext(-1);
        sedRocks[index].setNextNo(-1);
        sedRocks[index].setPrevious(24);
        sedRocks[index].setWhatRock("Gypsum");


        updateEverything(sedRocks[0]);
    }

    //load the appropriate image depending on step youre in on the flow chart.
    private void adjustImage() {
        switch (current) {
            case 0:
                //Does the rock fizz with hcl?
                picture.setImageResource(R.drawable.fizz);
                break;
            case 1:
                //are fossils present?
                picture.setImageResource(R.drawable.fossils);
                break;
            case 2:
                //Limestone
                picture.setImageResource(R.drawable.ls);
                break;
            case 4:
                //fossil-ls
                picture.setImageResource(R.drawable.fls);
                break;
            case 5:
                //macro or micro fossils
                picture.setImageResource(R.drawable.macmic);
                break;
            case 6:
                //chalk
                picture.setImageResource(R.drawable.chalk);
                break;
            case 7:
                //Clastic texture?
                picture.setImageResource(R.drawable.clastic);
                break;
            case 8:
                //Grains easily visible?
                picture.setImageResource(R.drawable.grains);
                break;
            case 9:
                //Angular grains?
                picture.setImageResource(R.drawable.roundess);
                break;
            case 10:
                //Breccia
                picture.setImageResource(R.drawable.brecc);
                break;
            case 11:
                //Conglomerate
                picture.setImageResource(R.drawable.cong);
                break;
            case 12:
                //barely visible grains?
                picture.setImageResource(R.drawable.grains);
                break;
            case 13:
                //Sandstone, qtz
                picture.setImageResource(R.drawable.qtzss);
                break;
            case 14:
                //Smooth or gritty grains
                picture.setImageResource(R.drawable.holder);
                break;
            case 15:
                //Siltstone
                picture.setImageResource(R.drawable.siltstone);
                break;
            case 17:
                //Shale
                picture.setImageResource(R.drawable.shale);
                break;
            case 18:
                //Black?
                picture.setImageResource(R.drawable.blk);
                break;
            case 19:
                //Form rounded nodules?
                picture.setImageResource(R.drawable.nodule);
                break;
            case 20:
                //Phosphate
                picture.setImageResource(R.drawable.phosphate);
                break;
            case 21:
                //Coal
                picture.setImageResource(R.drawable.coal);
                break;
            case 22:
                //Conchoidal fracture
                picture.setImageResource(R.drawable.conchfrac);
                break;
            case 23:
                //Chert
                picture.setImageResource(R.drawable.chert);
                break;
            case 24:
                //Cubic crystals?
                picture.setImageResource(R.drawable.cubic);
                break;
            case 25:
                //Halite
                picture.setImageResource(R.drawable.salt);
                break;
            case 26:
                //Gypsum
                picture.setImageResource(R.drawable.gypsum);
                break;
        }
    }

    //update everything and load it in
    private void updateEverything(RockHolder r) {

        yesButton.setEnabled(true);
        noButton.setEnabled(true);
        current = r.getCurrent();
        previous = r.getPrevious();
        nextYes = r.getNext();
        nextNo = r.getNextNo();
        sentence.setText(r.getDescription());
        adjustImage();

        //Below are some exceptions when loading a new index.
        if(current == 5)//a special case, yes becomes "Large Fossils" and no becomes "Microfossils"
        {
            yesButton.setText("Large Fossils");
            noButton.setText("Micro Fossils");
        }
        else if(current == 14)//a special case, yes becomes "Fine grains, gritty" and no become "Very-fine, smooth"
        {
            yesButton.setText("Fine grains, gritty");
            noButton.setText("Fine grains, smooth");
        }
        else//return it to normal for the flow chart
        {
            yesButton.setText("Yes");
            noButton.setText("No");
        }

        if(nextYes == -1)// if its at the end and there is no yes option
        {
            yesButton.setEnabled(false);
            yesButton.setBackgroundColor(Color.GRAY);

        }
        else
        {
            yesButton.setBackgroundColor(Color.parseColor("#003cb3"));
            yesButton.setEnabled(true);
        }
        if(nextNo == -1)// if its at the end and there is no no option
        {
            noButton.setEnabled(false);
            noButton.setBackgroundColor(Color.GRAY);//gray it out nicely
        }
        else
        {
            noButton.setEnabled(true);
            noButton.setBackgroundColor(Color.parseColor("#003cb3"));//add back the original color
        }
    }
}