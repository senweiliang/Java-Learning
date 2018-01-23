package com.senweiliang.habbits.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.senweiliang.habbits.R;
import com.senweiliang.habbits.model.Habit;

/**
 * Created by 梁森维 on 2018/1/23.
 */

public class MyDataAdapter extends BaseAdapter{
    Context context=null;
    Habit[] data=null;
    public MyDataAdapter(Context context,Habit[] data){
        this.context=context;
        this.data=data;
    }
    @Override
    public int getCount(){return data.length;}

    @Override
    public Habit getItem(int position){return data[position];}

    @Override
    public long getItemId(int position){return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row=convertView;
        ViewHolder holder=null;
        if(row==null){//如果没有创建
            LayoutInflater inflater=LayoutInflater.from(context);
            row=inflater.inflate(R.layout.listview_row,parent,false);
            holder=new ViewHolder();
            holder.habitName=(TextView) row.findViewById(R.id.habitName);
            holder.textMon=(TextView) row.findViewById(R.id.textMon);
            holder.textMon.setOnClickListener((v)->{
                Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show();
            });
            row.setTag(holder);
        }
        else{
            holder=(ViewHolder)row.getTag();
        }
        Habit habit=data[position];
        holder.habitName.setText(habit.getHabitName());
        holder.textMon.setText(habit.getTextMon());


        return row;
    }

    private static class ViewHolder{
        TextView habitName;
        TextView textMon;
    }

}
