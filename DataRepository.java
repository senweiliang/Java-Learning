package com.senweiliang.habbits.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.senweiliang.habbits.model.Habit;

/**
 * Created by 梁森维 on 2018/1/23.
 */

public class DataRepository {
    public static  Habit[] data=new Habit[]{
            new Habit("Running"),
            new Habit("Reading"),
            new Habit("Go to bed early")
    };

}
