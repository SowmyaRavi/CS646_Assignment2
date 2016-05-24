package com.example.piyushravi.multipleactivities;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button buttonClick;
    private static final int INTENT_REQUEST = 1233;
    private static final int INTENT_REQUEST2 = 1234;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        Log.d("Main", "MainActivity Launched");
    }

    public void clickThis(View v) {
        spinner = (Spinner) findViewById(R.id.spinner);
        buttonClick = (Button) findViewById(R.id.button);
        String act = spinner.getSelectedItem().toString();
        Resources res = getResources();
        String[] string = res.getStringArray(R.array.activities);


        if (act.equals(string[0])) {
            Intent intent = new Intent(MainActivity.this, ListOfSports.class);
            startActivityForResult(intent, INTENT_REQUEST2);
            Log.d("Main", "Sports Activity Launched");

        }
        else if (act.equals(string[1])) {
            Intent intent1 = new Intent(MainActivity.this, TimeActivity.class);
            startActivityForResult(intent1, INTENT_REQUEST);
            Log.d("Main", "Time Activity Launched");

        }
        else if (act.equals(string[2])) {

            editText = (EditText) findViewById(R.id.input_text);
            Intent intent2 = new Intent(MainActivity.this, KeyboardActivity.class);
            intent2.putExtra("name", editText.getText().toString());
            startActivity(intent2);
            Log.d("Main", "Keyboard Activity Launched");
        }
        else return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_selection, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.time_activity: {
                startActivity(new Intent(MainActivity.this, TimeActivity.class));
                Log.d("Main", "TimeActivity Launched from icon");
                break;
            }
            case R.id.input_activity: {
                startActivity(new Intent(MainActivity.this, KeyboardActivity.class));
                Log.d("Main", "KeyBoardActivity Launched from icon");
                break;
            }
            case R.id.sports_activity: {
                startActivity(new Intent(MainActivity.this, ListOfSports.class));
                Log.d("Main", "Sport Activity Launched from icon");
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INTENT_REQUEST) {

            switch (resultCode) {

                case RESULT_OK:

                    editText = (EditText) findViewById(R.id.input_text);

                    int hour = data.getIntExtra("Hour", -1);
                    int minute = data.getIntExtra("Minute", -1);
                    editText.setText(new StringBuilder().append(hour).append(":").append(minute));
                    break;

                case RESULT_CANCELED:
                    break;
            }
        }
        if (requestCode == INTENT_REQUEST2) switch (resultCode) {

            case RESULT_OK:
                String name = data.getExtras().getString("name");
                editText.setText(new StringBuilder().append(name));
                break;

            case RESULT_CANCELED:
                break;
        }

    }
}


