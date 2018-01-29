package com.senweiliang.habbits;

import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.senweiliang.habbits.adapter.MyDataAdapter;
import com.senweiliang.habbits.repository.DataRepository;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_listview) ListView  listView;
    private DataRepository repository=null;
    SQLiteDatabase sqLiteDatabase=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//保持竖屏
        listView.setEmptyView(findViewById(R.id.empty_layout));
        MyDataAdapter adapter=new MyDataAdapter(this, DataRepository.data);
        listView.setAdapter(adapter);
        sqLiteDatabase=this.openOrCreateDatabase("habit_app.db",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS signInData(habit_name Text,ID INTEGER)");

    }
    @OnClick
    public void AddHabit(MenuItem item){

        sqLiteDatabase.execSQL("INSERT INTO signInData VALUES('Testing',1)");
        Toast.makeText(this, "SQLite AddHabit", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);


        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_about) {
            return true;
        }
        if (id==R.id.action_add){

            AddHabit(item);
        }
        if (id==R.id.action_calendar){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        sqLiteDatabase.close();
    }


}
