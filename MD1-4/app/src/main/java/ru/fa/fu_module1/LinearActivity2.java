package ru.fa.fu_module1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LinearActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear2);

        LinearLayout llBottom = (LinearLayout) findViewById(R.id.llBottom);

        TextView tvBottom = (TextView) findViewById(R.id.tvBottom);

        Button btnBottom = (Button) findViewById(R.id.btnBottom);

        llBottom.setBackgroundResource(R.color.llBottomColor);

        tvBottom.setText(R.string.tvBottomText);

        btnBottom.setText(R.string.btnBottomText);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_main) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.menu_la2){
            Intent intent = new Intent(this, LinearActivity2.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.menu_frame){
            Intent intent = new Intent(this, FrameActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.menu_rel){
            Intent intent = new Intent(this, RelativeActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, TableActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}