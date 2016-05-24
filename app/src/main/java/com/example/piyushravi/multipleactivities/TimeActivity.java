package com.example.piyushravi.multipleactivities;

import android.app.AlertDialog;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TimeActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyApp_Settings";
    SharedPreferences sharedPreferences;
    TimePicker timePicker;
    public int hour;
    public int minute;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        Log.d("Time", "Activity Launched");



        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        loadTimer(timePicker);
        Button save = (Button) findViewById(R.id.button);

        loadTimer(timePicker);
        editor= sharedPreferences.edit();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TimeActivity.this);
                alertDialogBuilder.setMessage("Do you want to save changes?");

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        hour = timePicker.getCurrentHour();
                        minute = timePicker.getCurrentMinute();

                        editor.putInt("hour", hour);
                        editor.putInt("minute", minute);
                        editor.commit();

                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       /* sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                        timePicker.setCurrentHour(sharedPreferences.getInt("hour", 1));
                        timePicker.setCurrentMinute(sharedPreferences.getInt("minute", 2));*/
                        dialog.cancel();


                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    public void loadTimer(TimePicker timepicker) {


            sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            timepicker.setCurrentHour(sharedPreferences.getInt("hour", 1));
            timepicker.setCurrentMinute(sharedPreferences.getInt("minute", 2));

    }
    public void onBackPressed() {

        Log.i("Time", "Back");

        Intent toPassBack = getIntent();
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        toPassBack.putExtra("Hour", timePicker.getCurrentHour());
        toPassBack.putExtra("Minute", timePicker.getCurrentMinute());
        setResult(RESULT_OK, toPassBack);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
