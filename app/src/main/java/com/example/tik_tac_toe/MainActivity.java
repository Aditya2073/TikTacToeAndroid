package com.example.tik_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public void game_reset(View view){
        gameactive = true;
        activeplayer = 0;
        for (int i = 0; i<gamestate.length; i++){
            gamestate[i] = 2;
            ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        }
    }



    //Player Representation
    // 0 = x
    // 1 = o
    int activeplayer = 0;

    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    //GameStates
    // 0 = o
    // 1 = x
    // 2 = null

    int [][] winpositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gameactive = true;

    TextView x_score, o_score;
    public void user_tap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            game_reset(view);
        }
        if (gamestate[tappedimage] == 2){
            gamestate[tappedimage] = activeplayer;
            if (activeplayer == 0){
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
            }
            else{
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
            }

        }
        x_score = (TextView) findViewById(R.id.textView);
        o_score = (TextView) findViewById(R.id.textView2);
        for(int [] winposition: winpositions){
            if(gamestate[winposition[0]] == gamestate[winposition[1]] && gamestate[winposition[1]] == gamestate[winposition[2]] && gamestate[winposition[0]] !=2){
                String win = "W";
                String lose = "L";
                gameactive = false;
                if(gamestate[winposition[0]] == 0){
                    x_score.setText(win);
                    o_score.setText(lose);
                    game_reset(view);
                }
                else{
                    o_score.setText(win);
                    x_score.setText(lose);
                    game_reset(view);
                }
            }

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
