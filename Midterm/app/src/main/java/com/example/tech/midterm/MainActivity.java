/*
Card Game Midterm
John Paul Valdez 101055854
Gavin Tang 101089279
March 12, 2017
Choose 2 cards each turn to match. Clear out the board to win!
 */


package com.example.tech.midterm;

import android.os.CountDownTimer;
import java.util.concurrent.TimeUnit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int playerScore = 0;
    private int countDown = 30;

    private TextView time;
    private TextView pScore;

    private int score;
    private TextView hint;

    int randomCard;
    int cardPos;

    private boolean duplication = false;
    private int[] initialize = new int [8];
    private int[] cards = new int[16];

    boolean firstCardPicked = false;
    boolean secondCardPicked = false;
    boolean isMatched = false;


    boolean hasTime = true;
    static int DRAWABLE_ID[] =
            {

                    R.drawable.card_1d,R.drawable.card_1c,R.drawable.card_1h,R.drawable.card_1s,
                    R.drawable.card_2d,R.drawable.card_2c,R.drawable.card_2h,R.drawable.card_2s,
                    R.drawable.card_3d,R.drawable.card_3c,R.drawable.card_3h,R.drawable.card_3s,
                    R.drawable.card_4d,R.drawable.card_4c,R.drawable.card_4h,R.drawable.card_4s,
                    R.drawable.card_5d,R.drawable.card_5c,R.drawable.card_5h,R.drawable.card_5s,
                    R.drawable.card_6d,R.drawable.card_6c,R.drawable.card_6h,R.drawable.card_6s,
                    R.drawable.card_7d,R.drawable.card_7c,R.drawable.card_7h,R.drawable.card_7s,
                    R.drawable.card_8d,R.drawable.card_8c,R.drawable.card_8h,R.drawable.card_8s,
                    R.drawable.card_9d,R.drawable.card_9c,R.drawable.card_9h,R.drawable.card_9s,
                    R.drawable.card_10d,R.drawable.card_10c,R.drawable.card_10h,R.drawable.card_10s,
                    R.drawable.card_11d,R.drawable.card_11c,R.drawable.card_11h,R.drawable.card_11s,
                    R.drawable.card_12d,R.drawable.card_12c,R.drawable.card_12h,R.drawable.card_12s,
                    R.drawable.card_13d,R.drawable.card_13c,R.drawable.card_13h,R.drawable.card_13s,  R.drawable.cardback

            };


    private ImageButton card1;
    private ImageButton card2;
    private ImageButton card3;
    private ImageButton card4;
    private ImageButton card5;
    private ImageButton card6;
    private ImageButton card7;
    private ImageButton card8;
    private ImageButton card9;
    private ImageButton card10;
    private ImageButton card11;
    private ImageButton card12;
    private ImageButton card13;
    private ImageButton card14;
    private ImageButton card15;
    private ImageButton card16;

    private ImageButton imageBtns[] = {

    card1 = (ImageButton) findViewById(R.id.card00),
    card2 = (ImageButton) findViewById(R.id.card01),
    card3 = (ImageButton) findViewById(R.id.card02),
    card4 = (ImageButton) findViewById(R.id.card03),
    card5 = (ImageButton) findViewById(R.id.card04),
    card6 = (ImageButton) findViewById(R.id.card05),
    card7 = (ImageButton) findViewById(R.id.card06),
    card8 = (ImageButton) findViewById(R.id.card07),
    card9 = (ImageButton) findViewById(R.id.card08),
    card10 = (ImageButton) findViewById(R.id.card09),
    card11 = (ImageButton) findViewById(R.id.card10),
    card12 = (ImageButton) findViewById(R.id.card11),
    card13 = (ImageButton) findViewById(R.id.card12),
    card14 = (ImageButton) findViewById(R.id.card13),
    card15 = (ImageButton) findViewById(R.id.card14),
    card16 = (ImageButton) findViewById(R.id.card15)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.timer);
        hint = findViewById(R.id.hint);
//timer
        new CountDownTimer(3000,1000)
        {

            public void onTick(long millisUntilFinished)
            {
                time.setText("Time: " + -millisUntilFinished /1000);
            }

            public void onFinish()
            {
                time.setText("Finish!");
                hasTime = false;
            }
        };
    timeFinish();
    randCart();

    }
//game done
  public void timeFinish()
    {
        if(!hasTime )
        {
            finish();
        }
    }
//randomizes card
    public void randCart()
    {
        for (int i = 0; i < 16; i ++)
        {
            cards[i] = -1;
        }

        for (int i = 0; i < 8; i ++)
        {
            do {
                randomCard = new Random().nextInt(52);
                for (int card = 0 ; card < i ; card++)
                {
                    if (initialize[card] == randomCard)
                        duplication = true;
                }
            } while (!duplication);
            initialize[i] = randomCard;
        }

        for (int i = 0; i < 16; i ++)
        {
            do {
                cardPos = new Random().nextInt(16);
            } while (cards[cardPos] != -1);
            cards[i] = initialize[i%2];

        }
    }
//turn check
    public void turn()
    {
        if( !firstCardPicked && !secondCardPicked)
        {
            hint.setText("Pick a card!");
        }
        else if(firstCardPicked == true && secondCardPicked == false)
        {
            hint.setText("Pick your seconds card!");
        }
        else if(firstCardPicked == true && secondCardPicked == true)
        {
        if (isMatched)
        {
            score++;
        }
        else
            {
            hint.setText("Try again!");
             }
        }

    }


    //Image Buttons
 //public  void addListenerOnButton(int x ) {
  //  }
}

