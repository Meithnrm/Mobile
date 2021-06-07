package com.example.tasklist_db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnDelete, btnRead;
    EditText etName;
    DBHelper dbHelper;

    public class DBHelper extends SQLiteOpenHelper {


        public DBHelper(Context context) {
            super(context, "MyDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnRead = findViewById(R.id.btnRead);
        etName = findViewById(R.id.etName);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnRead.setOnClickListener(this);

        dbHelper = new DBHelper(this);


    }

    public void readNow(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query("mytable", null, null, null, null, null, null);
        String result = "";
        if (c.moveToFirst()) {
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            do {
                result = result + c.getString(nameColIndex) + ";";
            } while (c.moveToNext());
            etName.setText(result);
        }
    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (v.getId()){
            case R.id.btnAdd:
                cv.put("name", name);
                db.insert("mytable", null, cv);
                break;
            case R.id.btnDelete:
                db.delete("mytable", null, null);
                break;
            case R.id.btnRead:
                readNow();
                break;
            default:

                break;
        }
    }
}