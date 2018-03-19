
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
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int seconds = 30;

    private TextView countdownText;
    private TextView hintText;
    private TextView scoreText;


    private int score;
    private TextView hint;

    int cards[] = new int [9];

    int pickOneIndex;
    int pickOneValue;

    int pickTwoIndex;
    int pickTwoValue;
    int oldSecondIndex;

    boolean fliped[] = new boolean[9];

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


    private ImageButton[] imageBtns = new ImageButton[9];

    int randomCard;
    int cardPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0 ; i < 9 ; i ++)
        {
            fliped[i] = false;
        }
        imageBtns[0] = (ImageButton) findViewById(R.id.card1);
        imageBtns[1] = (ImageButton) findViewById(R.id.card2);
        imageBtns[2] = (ImageButton) findViewById(R.id.card3);
        imageBtns[3] = (ImageButton) findViewById(R.id.card4);
        imageBtns[4] = (ImageButton) findViewById(R.id.card5);
        imageBtns[5] = (ImageButton) findViewById(R.id.card6);
        imageBtns[6] = (ImageButton) findViewById(R.id.card7);
        imageBtns[7] = (ImageButton) findViewById(R.id.card8);
        imageBtns[8] = (ImageButton) findViewById(R.id.card9);

        //Buttons on click listener

        imageBtns[0].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(0);
        } });


        imageBtns[1].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(1);
        } });


        imageBtns[2].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(2);
        } });


        imageBtns[3].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(3);
        } });


        imageBtns[4].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(4);
        } });


        imageBtns[5].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(5);
        } });


        imageBtns[6].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(6);
        } });

        imageBtns[7].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(7);
        } });


        imageBtns[8].setOnClickListener(new View.OnClickListener()
        {public void onClick(View v)
        {
            pickCard(8);
        } });

        resetCards();
        random();

        countdownText = findViewById(R.id.timer);
        hintText = findViewById(R.id.hint);
        scoreText = findViewById(R.id.scoreTxt);



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

    public void onClickDeclaration()
    {

    }

    public void random()
    {
        int tempCards[]= new int[5];
        int randomCard;
        boolean dupe = false;

        for (int x = 0 ; x < tempCards.length ; x++)
        {
            tempCards[x] = -1;
        }

        for (int i = 0 ; i < tempCards.length ; i++)
        {
            dupe = false;
            do
            {
                randomCard = new Random().nextInt(52);

                for (int d = 0 ; d < tempCards.length ; d++)
                {
                    if (randomCard == tempCards[d])
                        dupe = true;
                }

            }   while (dupe == true);

            tempCards[i] = randomCard;

        }

        int index ;

        for (int x = 0 ; x < cards.length ; x++)
        {
            cards[x] = -1;
        }

        for (int i = 0 ; i < 4; i++)
        {
            do {
                index = new Random().nextInt(9);
            }while (cards[index] != -1);

            cards[index] = tempCards[i];

            do {
                index = new Random().nextInt(9);
            }   while (cards[index] != -1);

            cards[index] = tempCards[i];

        }

        do {
            index = new Random().nextInt(9);
        }   while (cards[index] != -1);
        cards[index] = tempCards[4];

    }

    public void pickCard(int cardIndex)
    {
        if (pickOneIndex == -1 && fliped[cardIndex] == false)
        {
            pickOneIndex = cardIndex;
            pickOneValue = cards[cardIndex];
            fliped[cardIndex] = true;
            hintText.setText("Now pick another card");
            imageBtns[cardIndex].setImageResource(DRAWABLE_ID[cards[cardIndex]]);
        }
        else if (pickOneIndex == cardIndex && fliped[cardIndex] == true && pickTwoIndex == -1)
        {
            pickOneIndex = -1;
            pickOneValue = -1;
            fliped[cardIndex] = false;
            hintText.setText("Pick a card!");
            imageBtns[cardIndex].setImageResource(DRAWABLE_ID[52]);
            if (oldSecondIndex != -1)
                imageBtns[oldSecondIndex].setImageResource(DRAWABLE_ID[52]);

        }
        else if (pickTwoIndex == -1 && fliped[cardIndex] == false)
        {
            pickTwoIndex = cardIndex;
            pickTwoValue = cards[cardIndex];
            if (oldSecondIndex != -1)
                imageBtns[oldSecondIndex].setImageResource(DRAWABLE_ID[52]);
            oldSecondIndex = cardIndex;
            fliped[cardIndex] = true;
            imageBtns[cardIndex].setImageResource(DRAWABLE_ID[cards[cardIndex]]);
            if (pickOneValue == pickTwoValue) {
                hintText.setText("Right!");
                oldSecondIndex = -1;
                resetCards();
                score++;
                scoreText.setText("Score: " + score);
            }
            else {
                hintText.setText("Wrong! Pick again...");
                fliped[cardIndex] = false;

                pickTwoIndex = -1;
                pickTwoValue = -1;

            }


        }


        // Toast.makeText(MainActivity.this, "CardIndex: " + cardIndex + ", CardValue: " + cards[cardIndex], Toast.LENGTH_LONG).show();

    }

    public void resetCards()
    {
        pickOneIndex = -1;
        pickOneValue = -1;
        pickTwoIndex = -1;
        pickTwoValue = -1;
        oldSecondIndex = -1;
    }

    public void resetGame()
    {
         for (int i = 0 ; i < imageBtns.length ; i ++)
         {
            imageBtns[i].setImageResource(DRAWABLE_ID[52]);
         }

        score = 0;
        scoreText.setText("Score: " + score);
        hintText.setText("Pick a card!");

        resetCards();
    }


}
