package com.example.sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sqlite.R;
import com.example.sqlite.model.Student;

import java.util.List;

public class StudentAdapter extends ArrayAdapter {
    Context context;
    int resource;
    List<Student> list;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.list=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textName=convertView.findViewById(R.id.text_name);
            viewHolder.textDateOfBirth=convertView.findViewById(R.id.text_dateOfBirth);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Student student=list.get(position);
        viewHolder.textName.setText(student.getStudentID()+". "+ student.getName());
        viewHolder.textDateOfBirth.setText(student.getDateOfBirth());
        return convertView;
    }

    public class ViewHolder{
        private TextView textName;
        private TextView textDateOfBirth;
    }
}
