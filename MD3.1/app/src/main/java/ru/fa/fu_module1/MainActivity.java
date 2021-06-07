package ru.fa.fu_module1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSave, btnLoad;
    EditText etName;
    public static final String APP_PREFERENCES = "mysettings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        etName = findViewById(R.id.etName);

    }


    @Override
    public void onClick(View v) {
        String name = "";
        SharedPreferences mSettings = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor ed = mSettings.edit();
        switch (v.getId()){
            case R.id.btnSave:
                name = etName.getText().toString();
                ed.putString("name", name);
                ed.apply();
                Log.i("SPREF", name);
            case R.id.btnLoad:
                name = mSettings.getString("name", "");
                etName.setText(name);
            default:
                break;
        }

    }
}