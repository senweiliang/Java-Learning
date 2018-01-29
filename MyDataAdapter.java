package com.senweiliang.habbits.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.senweiliang.habbits.R;
import com.senweiliang.habbits.model.Habit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

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
            holder=new ViewHolder(row,context);
//            holder.habitName=(TextView) row.findViewById(R.id.habitName);
//            holder.textMon=(TextView) row.findViewById(R.id.textMon);
            holder.checkBox1.setOnClickListener((v)->{
                Toast.makeText(context,"CHECKED",Toast.LENGTH_LONG).show();
            });
            row.setTag(holder);

        }
        else{
            holder=(ViewHolder)row.getTag();
        }

//        SQLiteDatabase sqLiteDatabase=context.openOrCreateDatabase("habit_app.db",MODE_PRIVATE,null);
//        Cursor query=sqLiteDatabase.rawQuery("SELECT * from signInData WHERE habit_name=Testing",null);
//        if(query.moveToFirst()){
//            do{
//                String habitName=query.getString(0);
//                int ID=query.getInt(1);
//                holder.habitName.setText(habitName);
//                Toast.makeText(context, habitName + ":" + ID, Toast.LENGTH_SHORT).show();
//            }while(query.moveToNext());
//        }
//        else{
//            Toast.makeText(context,"没有数据",Toast.LENGTH_LONG).show();
//        }
//        sqLiteDatabase.close();

//        Habit habit=data[position];
//        holder.habitName.setText(habit.getHabitName());



        return row;
    }

    static class ViewHolder{
        @BindView(R.id.habitName) TextView habitName;
        @BindView(R.id.checkBox1) CheckBox checkBox1;
        @BindView(R.id.checkBox2) CheckBox checkBox2;
        @BindView(R.id.checkBox3) CheckBox checkBox3;
        @BindView(R.id.checkBox4) CheckBox checkBox4;
        @BindView(R.id.checkBox5) CheckBox checkBox5;
        @BindView(R.id.checkBox6) CheckBox checkBox6;
        @BindView(R.id.checkBox7) CheckBox checkBox7;

        @OnClick(R.id.checkBox1)
        public void onCheck1(View view){
            Toast.makeText(context, Toast.LENGTH_LONG, view.getId()).show();
        }
       Context context=null;
       public ViewHolder(View row,Context context){
           ButterKnife.bind(this,row);
           this.context=context;
       }
    }

}
