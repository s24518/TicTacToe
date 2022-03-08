package com.nikfen.tictactoe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void singleButton(View view) {
        Intent intent = new Intent(this, SinglePlayActivity.class);
        startActivity(intent);
    }

    public void duoButton(View view) {

        Intent intent = new Intent(this, DuoActivity.class);
        startActivity(intent);

    }

}