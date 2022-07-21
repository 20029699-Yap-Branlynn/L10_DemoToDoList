package sg.edu.rp.c346.id20029699.demotodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomArrayAdapter extends ArrayAdapter<ToDoItem> {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> todoList;

    public CustomArrayAdapter(Context context, int resource,  ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        todoList = objects;
    }


    public View getView(int position, View convertView, ViewGroup parent){
// Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        // Obtain the Android Version information based on the position
        ToDoItem currentVersion = todoList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentVersion.getTitle());
        tvDate.setText(currentVersion.toString());

        Calendar currentDate = Calendar.getInstance();
        currentDate.set(2022, 7,21);

        if(currentVersion.getDate().before(currentDate))
            tvDate.setTextColor(Color.RED);


        return rowView;
    }

}