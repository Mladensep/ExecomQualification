package com.ftn.timkodzo.execomqualification.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ftn.timkodzo.execomqualification.DatabaseHelper;
import com.ftn.timkodzo.execomqualification.R;
import com.ftn.timkodzo.execomqualification.TaskModel;
import com.ftn.timkodzo.execomqualification.activity.Main2Activity;
import com.ftn.timkodzo.execomqualification.adapters.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Cursor cursor;
    private DatabaseHelper databaseHelper;
    private ListView listView;
    private List <TaskModel> list;
    private Activity activity;

    private  TextView nameTask;
    private TextView desctiptionTask;

    public void addTask (View view) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }

    public void allDataShow () {

        cursor = databaseHelper.getAll();

        list = new ArrayList<>();
        while (cursor.moveToNext()) {

            TaskModel taskModel = new TaskModel();
            taskModel.setId(cursor.getInt(0));
            taskModel.setTaskName(cursor.getString(1));
            taskModel.setTaskContent(cursor.getString(2));

            list.add(taskModel);

        }

        TaskAdapter adapter = new TaskAdapter(this, list);
        listView.setAdapter(adapter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        databaseHelper = new DatabaseHelper(this);

        button = (Button) findViewById(R.id.buttonId);
        listView = (ListView) findViewById(R.id.listId);


        allDataShow();

        activity = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
