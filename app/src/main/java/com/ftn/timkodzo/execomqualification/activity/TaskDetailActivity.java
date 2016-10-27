package com.ftn.timkodzo.execomqualification.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ftn.timkodzo.execomqualification.dataBase.DatabaseHelper;
import com.ftn.timkodzo.execomqualification.R;
import com.ftn.timkodzo.execomqualification.model.TaskModel;

public class TaskDetailActivity extends AppCompatActivity {

    private int taskId;

    private TextView name;
    private TextView task;
    private CheckBox checkBox;
    private DatabaseHelper myDb;
    private TaskModel taskModel;

    public void deleteTask (View view) {

        myDb.deleteTask(taskModel);

        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        taskId = getIntent().getIntExtra("taskId", 0);

        Cursor cursor;
        myDb = new DatabaseHelper(this);

        cursor = myDb.getTaskById(taskId);

        taskModel = new TaskModel();

        while (cursor.moveToNext()) {

            taskModel.setId(cursor.getInt(0));
            taskModel.setTaskName(cursor.getString(1));
            taskModel.setTaskContent(cursor.getString(2));
            taskModel.setDone(cursor.getInt(3) == 1);

        }

        name = (TextView) findViewById(R.id.nameId);
        task = (TextView) findViewById(R.id.taskId);
        checkBox = (CheckBox) findViewById(R.id.checkBoxId);

        name.setText(taskModel.getTaskName());
        task.setText(taskModel.getTaskContent());
        checkBox.setChecked(taskModel.isDone());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                myDb.updataTask(taskId, isChecked);

                if (isChecked)
                    Toast.makeText(TaskDetailActivity.this, "Task is done!", Toast.LENGTH_SHORT).show();

                else
                    Toast.makeText(TaskDetailActivity.this, "Task is not done!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
