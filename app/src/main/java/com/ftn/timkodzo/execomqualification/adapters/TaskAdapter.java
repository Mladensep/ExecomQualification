package com.ftn.timkodzo.execomqualification.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ftn.timkodzo.execomqualification.R;
import com.ftn.timkodzo.execomqualification.TaskModel;

import java.util.List;

/**
 * Created by Mladen on 10/26/2016.
 */
public class TaskAdapter extends BaseAdapter {

    private Activity activity;
    private List<TaskModel> taskModels;

    public TaskAdapter(Activity activity, List<TaskModel> taskModels) {
        this.activity = activity;
        this.taskModels = taskModels;
    }



    @Override
    public int getCount() {
        return taskModels.size();
    }

    @Override
    public Object getItem(int position) {
        return taskModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater li = LayoutInflater.from(activity);
            v = li.inflate(R.layout.task_item, null, false);

        }

        TextView name = (TextView)v.findViewById(R.id.nameTaskId);
        name.setText(taskModels.get(position).getTaskName());

        return v;

    }
}
