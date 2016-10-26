package com.ftn.timkodzo.execomqualification.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ftn.timkodzo.execomqualification.DatabaseHelper;
import com.ftn.timkodzo.execomqualification.R;
import com.ftn.timkodzo.execomqualification.TaskModel;

public class Main2Activity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editTitle;
    EditText editTask;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDb = new DatabaseHelper(this);

        editTitle = (EditText) findViewById(R.id.editTitle);
        editTask = (EditText) findViewById(R.id.editTask);
        button = (Button) findViewById(R.id.buttonSubmitId);



    }

    public void save (View view) {

        boolean isAdd = myDb.insertData(editTitle.getText().toString(), editTask.getText().toString());

        if (isAdd == true)
            Toast.makeText(Main2Activity.this, "Data inserted!", Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(Main2Activity.this, "Error!", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }



}
