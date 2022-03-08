package com.nikfen.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DuoActivity extends AppCompatActivity {

    ImageView[] tiles = new ImageView[9];
    TextView xWinsV, oWinsV, turnDuo;
    int[] tileContainers = new int[9];
    int counter, xWins, oWins = 0;
    int turn = 1;
    boolean readyToMove = true;
    int[] winnerCross = new int[3];
    int[] winnerCircle = new int[3];
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duo);


        tiles[0] = (ImageView) findViewById(R.id.buttonDou1);
        tiles[1] = (ImageView) findViewById(R.id.buttonDou2);
        tiles[2] = (ImageView) findViewById(R.id.buttonDou3);
        tiles[3] = (ImageView) findViewById(R.id.buttonDou4);
        tiles[4] = (ImageView) findViewById(R.id.buttonDou5);
        tiles[5] = (ImageView) findViewById(R.id.buttonDou6);
        tiles[6] = (ImageView) findViewById(R.id.buttonDou7);
        tiles[7] = (ImageView) findViewById(R.id.buttonDou8);
        tiles[8] = (ImageView) findViewById(R.id.buttonDou9);

        xWinsV = (TextView) findViewById(R.id.xWinsDuo);
        oWinsV = (TextView) findViewById(R.id.oWinsDuo);
        turnDuo = (TextView) findViewById(R.id.turnDuo);


        for (int i = 0; i < 9; i++) {
            tileContainers[i] = 0;
        }

    }


    public void buttonDou1(View view) {
        buttonProcess(0);
    }

    public void buttonDou2(View view) {
        buttonProcess(1);
    }

    public void buttonDou3(View view) {
        buttonProcess(2);
    }

    public void buttonDou4(View view) {
        buttonProcess(3);
    }

    public void buttonDou5(View view) {
        buttonProcess(4);
    }

    public void buttonDou6(View view) {
        buttonProcess(5);
    }

    public void buttonDou7(View view) {
        buttonProcess(6);
    }

    public void buttonDou8(View view) {
        buttonProcess(7);
    }

    public void buttonDou9(View view) {
        buttonProcess(8);
    }

    public void buttonProcess(int numberButton) {
        if (tileContainers[numberButton] == 0 && readyToMove) {
            if (turn % 2 != 0) {
                turnDuo.setText("Turn - X");
                tileContainers[numberButton] = 1;
                tiles[numberButton].setImageResource(R.drawable.tic_tac_circle_unactive);
                turn++;
            } else {
                turnDuo.setText("Turn - O");
                tileContainers[numberButton] = 2;
                tiles[numberButton].setImageResource(R.drawable.tic_tac_cross_unactive);
                turn++;
            }
            checkWin();
        }


    }
    public void checkWin() {
        int win;
        win = checkColons();
        winnerCheck(win);
        win = checkRows();
        winnerCheck(win);
        win = checkDiags();
        winnerCheck(win);
    }


    public int checkColons() {
        for (int y = 0; y < 3; y++) {
            int X = 0;
            int O = 0;
            int r = 0;

            for (int z = 0; z < 9; z += 3) {

                if (tileContainers[z + y] == 1) {
                    O++;
                    winnerCircle[r] = z + y;
                }
                if (tileContainers[z + y] == 2) {
                    X++;
                    winnerCross[r] = z + y;
                }
                r++;
            }

            if (X == 3) return 2;
            else if (O == 3) return 1;
        }
        return 0;
    }

    public int checkRows() {
        for (int y = 0; y < 9; y += 3) {
            int X = 0;
            int O = 0;

            for (int z = 0; z < 3; z++) {

                if (tileContainers[z + y] == 1) {
                    O++;
                    winnerCircle[z] = z + y;
                }
                if (tileContainers[z + y] == 2) {
                    X++;
                    winnerCross[z] = z + y;
                }
            }

            if (X == 3) return 2;
            else if (O == 3) return 1;

        }
        return 0;
    }

    public int checkDiags() {
        int g = 0;
        int X = 0;
        int O = 0;
        for (int z = 0; z < 9; z += 4) {

            if (tileContainers[z] == 1) {
                O++;
                winnerCircle[g] = z;
            }
            if (tileContainers[z] == 2) {
                X++;
                winnerCross[g] = z;
            }
            g++;
        }
        if (X == 3) return (2);
        else if (O == 3) return (1);
        g = 0;
        X = 0;
        O = 0;
        for (int z = 2; z < 7; z += 2) {

            if (tileContainers[z] == 1) {
                O++;
                winnerCircle[g] = z;
            }
            if (tileContainers[z] == 2) {
                X++;
                winnerCross[g] = z;
            }
            g++;
        }

        if (X == 3) return (2);
        else if (O == 3) return (1);
        else return (0);
    }
    public void winnerCheck(int win) {
        if (win == 1) {
            Toast.makeText(this, "Win circle", Toast.LENGTH_SHORT).show();
            paintRed(winnerCircle, win);
            readyToMove = false;
            oWins++;
            oWinsV.setText("O wins - " + oWins);
        } else if (win == 2) {
            Toast.makeText(this, "Win cross", Toast.LENGTH_SHORT).show();
            paintRed(winnerCross, win);
            readyToMove = false;
            xWins++;
            xWinsV.setText("X wins - " + xWins);
        }
        if (counter > 8 && win == 0) Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();

    }
    public void paintRed(int[] a, int win) {
        for (int i = 0; i < a.length; i++) {
            if(win == 1){
                tiles[a[i]].setImageResource(R.drawable.tic_tac_circle_active);
            }
            if(win == 2){
                tiles[a[i]].setImageResource(R.drawable.tic_tac_cross_active);
            }
        }
    }
    public void restartDuo(View view) {
        for(int i = 0; i<tileContainers.length;i++){
            tileContainers[i] = 0;
        }
        for (int i = 0; i<tiles.length; i++){
            tiles[i].setImageResource(R.drawable.tic_tac_button_empty);
        }
        readyToMove = true;
        flag = false;
        counter = 0;
    }
}