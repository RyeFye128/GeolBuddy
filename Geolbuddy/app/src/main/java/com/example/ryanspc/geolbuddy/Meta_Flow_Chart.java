package com.example.ryanspc.geolbuddy;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Meta_Flow_Chart extends AppCompatActivity {

    private RockHolder[] metaRocks;
    ImageView picture;

    private int current, previous,nextYes, nextNo;
    private String currentText;
    Button yesButton, noButton, backButton, restartButton;
    TextView sentence;


    int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta__flow__chart);

        metaRocks = new RockHolder[99];

        // ------ assign the buttons to their XML counterparts -------
        yesButton = (Button) findViewById(R.id.yesButtonMeta);
        noButton = (Button) findViewById(R.id.noButtonMeta);
        sentence = (TextView) findViewById(R.id.descriptionMeta);
        backButton = (Button) findViewById(R.id.backButtonMeta);
        restartButton = (Button) findViewById(R.id.restartButtonMeta);

        yesButton = (Button)findViewById(R.id.yesButtonMeta);
        noButton = (Button)findViewById(R.id.noButtonMeta);
        sentence = (TextView)findViewById(R.id.descriptionMeta);
        backButton = (Button)findViewById(R.id.backButtonMeta);
        restartButton = (Button)findViewById(R.id.restartButtonMeta);
        //based on the flowchart handout.... default for startup.

        picture =  (ImageView)findViewById(R.id.questionPictureMeta);
        picture.setImageResource(R.drawable.mtbutton);

        setupArray();//create db


        yesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                RockHolder nextOption = metaRocks[nextYes];
                updateEverything(nextOption);
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                if (nextNo == -2) {
                    CharSequence text = "Double check it, go back if necessary and try again";
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
                    toast.show();
                    return; //dont update anything.
                }
                RockHolder nextOption = metaRocks[nextNo];
                updateEverything(nextOption);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (previous == -1)
                {
                    CharSequence text = "You're at the beginning already!";
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }
                RockHolder nextOption = metaRocks[previous];
                updateEverything(nextOption);
            }
        });

        //resets back to the start
        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if(current == 0)//at the start already...
                {
                    CharSequence text = "You're at the beginning already!";
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }
                RockHolder nextOption = metaRocks[0];
                updateEverything(nextOption);
            }
        });
    }

    //this method is going to handle the array
    private void setupArray()
    {
        ImageView temp1 = new ImageView(this);//initialization

        //next:-1 means youre at the end, a -2 means that option is invalid
        int index = 0;
        metaRocks[0] = new RockHolder("Is the rock foliated?");
        metaRocks[0].setCurrent(0);
        metaRocks[0].setNext(1);
        metaRocks[0].setNextNo(9);
        metaRocks[0].setPrevious(-1);
        metaRocks[0].setWhatRock("");

        index = 1;
        metaRocks[index] = new RockHolder("Is it fine-grained, with excellenct cleavage?");
        metaRocks[index].setCurrent(1);
        metaRocks[index].setNext(2);
        metaRocks[index].setNextNo(3);
        metaRocks[index].setPrevious(0);
        metaRocks[index].setWhatRock("");

        index = 2;
        metaRocks[index] = new RockHolder("This rock is a Slate");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(-1);
        metaRocks[index].setNextNo(-1);
        metaRocks[index].setPrevious(1);
        metaRocks[index].setWhatRock("Slate");

        index = 3;
        metaRocks[index] = new RockHolder("Is it fine-grained and shiny?");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(4);
        metaRocks[index].setNextNo(5);
        metaRocks[index].setPrevious(1);
        metaRocks[index].setWhatRock("");

        index = 4;
        metaRocks[index] = new RockHolder("This rock is a Phyllite");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(-1);
        metaRocks[index].setNextNo(-1);
        metaRocks[index].setPrevious(3);
        metaRocks[index].setWhatRock("Phyllite");

        index = 5;
        metaRocks[index] = new RockHolder("Is is medium to coarse-grained, very shiny, and rich in micas?");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(6);
        metaRocks[index].setNextNo(7);
        metaRocks[index].setPrevious(3);
        metaRocks[index].setWhatRock("");

        index = 6;
        metaRocks[index] = new RockHolder("This rock is a Schist");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(-1);
        metaRocks[index].setNextNo(-1);
        metaRocks[index].setPrevious(5);
        metaRocks[index].setWhatRock("Schist");

        index = 7;
        metaRocks[index] = new RockHolder("Is it medium to coarse-grained, with alternating light and dark minerals?");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(8);
        metaRocks[index].setNextNo(-2);//will trigger an error toast
        metaRocks[index].setPrevious(5);
        metaRocks[index].setWhatRock("");


        index = 8;
        metaRocks[index] = new RockHolder("This rock is a Gneiss");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(-1);
        metaRocks[index].setNextNo(-1);
        metaRocks[index].setPrevious(7);
        metaRocks[index].setWhatRock("Gneiss");


        index = 9;
        metaRocks[index] = new RockHolder("Is its hardness greater than 6(cannot scratch it with a steel nail)?");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(10);
        metaRocks[index].setNextNo(11);
        metaRocks[index].setPrevious(0);
        metaRocks[index].setWhatRock("");


        index = 10;
        metaRocks[index] = new RockHolder("This rock is a Quartzite");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(-1);
        metaRocks[index].setNextNo(-1);
        metaRocks[index].setPrevious(9);
        metaRocks[index].setWhatRock("Quartzite");

        index = 11;
        metaRocks[index] = new RockHolder("Does it fizz in contact with HCl?");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(12);
        metaRocks[index].setNextNo(-2);//will trigger an error toast
        metaRocks[index].setPrevious(9);
        metaRocks[index].setWhatRock("");


        index = 12;
        metaRocks[index] = new RockHolder("This rock is a Marble");
        metaRocks[index].setCurrent(index);
        metaRocks[index].setNext(-1);
        metaRocks[index].setNextNo(-1);
        metaRocks[index].setPrevious(11);
        metaRocks[index].setWhatRock("Marble");

        updateEverything(metaRocks[0]);
    }

    //loads in image according to current index
    private void adjustImage()
    {
        switch(current)
        {
            case 0:
                //is the rock foliated?
                picture.setImageResource(R.drawable.foliate);

                break;
            case 1:
                //fine-grained, dark, with excellent cleavage?
                picture.setImageResource(R.drawable.holder);
                break;
            case 2:
                //Slate
                picture.setImageResource(R.drawable.slate);
                break;
            case 3:
                //Fine-grained and shiny?
                picture.setImageResource(R.drawable.shiny);
                break;
            case 4:
                //phyllite
                picture.setImageResource(R.drawable.phyllite);
                break;
            case 5:
                //medium to coarse-grained, very shiny, and rich in micas?
                picture.setImageResource(R.drawable.shinymica);
                break;
            case 6 :
                //Schist
                picture.setImageResource(R.drawable.micashcist);
                break;
            case 7:
                //medium to coarse-grained, alternating light and dark layers?
                picture.setImageResource(R.drawable.altlayers);
                break;
            case 8:
                //Gneiss
                picture.setImageResource(R.drawable.gneiss);
                break;
            case 9:
                //hardness greater than 6? (cannot be scratched with a steel nail)
                picture.setImageResource(R.drawable.holder);
                break;
            case 10:
                //Quartzite
                picture.setImageResource(R.drawable.quartzite);
                break;
            case 11:
                //Fizzed with HCl
                picture.setImageResource(R.drawable.fizz);
                break;
            case 12:
                //Marble
                picture.setImageResource(R.drawable.marble);
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
