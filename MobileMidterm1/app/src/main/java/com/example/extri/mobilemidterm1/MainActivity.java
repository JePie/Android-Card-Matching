
/*Card Game Midterm
        John Paul Valdez 101055854
        Gavin Tang 101089279
        March 12, 2017
        Choose 2 cards each turn to match. Clear out the board to win!
        */
package com.example.extri.mobilemidterm1;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int playerScore = 0;
    private int seconds = 30;

    private TextView countdownText;

    private TextView pScore;

    private int score;
    private TextView hint;

    static int DRAWABLE_ID[] =
            {
                    R.drawable.card_1d,
                    R.drawable.card_1c,
                    R.drawable.card_1h,
                    R.drawable.card_1s,
                    R.drawable.card_2d,
                    R.drawable.card_2c,
                    R.drawable.card_2h,
                    R.drawable.card_2s,
                    R.drawable.card_3d,
                    R.drawable.card_3c,
                    R.drawable.card_3h,
                    R.drawable.card_3s,
                    R.drawable.card_4d,
                    R.drawable.card_4c,
                    R.drawable.card_4h,
                    R.drawable.card_4s,
                    R.drawable.card_5d,
                    R.drawable.card_5c,
                    R.drawable.card_5h,
                    R.drawable.card_5s,
                    R.drawable.card_6d,
                    R.drawable.card_6c,
                    R.drawable.card_6h,
                    R.drawable.card_6s,
                    R.drawable.card_7d,
                    R.drawable.card_7c,
                    R.drawable.card_7h,
                    R.drawable.card_7s,
                    R.drawable.card_8d,
                    R.drawable.card_8c,
                    R.drawable.card_8h,
                    R.drawable.card_8s,
                    R.drawable.card_9d,
                    R.drawable.card_9c,
                    R.drawable.card_9h,
                    R.drawable.card_9s,
                    R.drawable.card_10d,
                    R.drawable.card_10c,
                    R.drawable.card_10h,
                    R.drawable.card_10s,
                    R.drawable.card_11d,
                    R.drawable.card_11c,
                    R.drawable.card_11h,
                    R.drawable.card_11s,
                    R.drawable.card_12d,
                    R.drawable.card_12c,
                    R.drawable.card_12h,
                    R.drawable.card_12s,
                    R.drawable.card_13d,
                    R.drawable.card_13c,
                    R.drawable.card_13h,
                    R.drawable.card_13s,
                    R.drawable.cardback
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


    int randomCard;
    int cardPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownText = findViewById(R.id.timer);

        card1 = (ImageButton) findViewById(R.id.card1);
        card2 = (ImageButton) findViewById(R.id.card2);
        card3 = (ImageButton) findViewById(R.id.card3);
        card4 = (ImageButton) findViewById(R.id.card4);
        card5 = (ImageButton) findViewById(R.id.card5);
        card6 = (ImageButton) findViewById(R.id.card6);
        card7 = (ImageButton) findViewById(R.id.card7);
        card8 = (ImageButton) findViewById(R.id.card8);
        card9 = (ImageButton) findViewById(R.id.card9);
//timer
      new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long seconds)
            {
                countdownText.setText("Time: " + seconds / 1000);
                if(seconds == 0){

                }
            }

            @Override
            public void onFinish() {
                hint.setText("Times up!");
            }
        }.start();

    }



}
