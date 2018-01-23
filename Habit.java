package com.senweiliang.habbits.model;

/**
 * Created by 梁森维 on 2018/1/23.
 */

public class Habit {
    private String habitName;
    private String textMon ="1";
    public Habit(String habit_name){
        this.habitName =habit_name;
    }

    public void setTextMon(String textMon) {
        this.textMon = textMon;
    }
    public String getTextMon() {
        return textMon;
    }
    public String getHabitName() {
        return habitName;
    }
    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }
}
