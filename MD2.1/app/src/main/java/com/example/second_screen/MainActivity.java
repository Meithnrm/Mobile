package com.example.second_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAct2;
    final String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAct2 = findViewById(R.id.btnActTwo);

        btnAct2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnActTwo:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    //жизненный цикл

    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Старт активити");
        Toast.makeText(this, "Старт активити", Toast.LENGTH_SHORT).show();
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Остановка активити");
        Toast.makeText(this, "Остановка активити", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Рестарт активити");
        Toast.makeText(this, "Рестарт активити", Toast.LENGTH_SHORT).show();
    }

}