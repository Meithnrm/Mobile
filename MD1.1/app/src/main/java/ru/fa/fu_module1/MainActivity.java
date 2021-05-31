package ru.fa.fu_module1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mainTextView;
    Button btnOk;
    Button btnCancel;
    Button btnMain;
    EditText editText;

    ListView mainListView;
    ArrayAdapter<String> mArrayAdapter;
    ArrayList<String> mNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.main_textView);
        btnOk = findViewById(R.id.ok_btn);
        btnCancel = findViewById(R.id.cnc_btn);
        btnMain = findViewById(R.id.main_button);
        editText = findViewById(R.id.main_edittext);
        mainTextView.setText("Кто-то " +  getString(R.string.hello_world));

        mainListView = findViewById(R.id.main_listview);
        mNameList = new ArrayList<>();
        mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);



        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // получаем нажатый элемент
                Log.d("omg android", position + ": " + mNameList.get(position));
                mainTextView.setText(mNameList.get(position) + " " + getString(R.string.hello_world));

            }
        });

        btnMain.setOnClickListener(v -> {
            try{
                String currentValue = editText.getText().toString();
                if(currentValue.length() == 0){
                    Toast.makeText(this, R.string.error2, Toast.LENGTH_SHORT).show();
                }
                else{
                    mainTextView.setText(currentValue + " " + getString(R.string.hello_world));
                    mNameList.add(currentValue);
                    mArrayAdapter.notifyDataSetChanged();

                }

            } catch (Exception e){
                Toast.makeText(this, R.string.error1, Toast.LENGTH_SHORT).show();
            }
        });

        btnOk.setOnClickListener(v -> {
            mainTextView.setText(R.string.ok);
            Toast.makeText(this, R.string.ok, Toast.LENGTH_SHORT).show();
        });

        btnCancel.setOnClickListener(v -> {
            mainTextView.setText(R.string.cancel);
            Toast.makeText(this, R.string.cancel, Toast.LENGTH_SHORT).show();
        });


    }
}