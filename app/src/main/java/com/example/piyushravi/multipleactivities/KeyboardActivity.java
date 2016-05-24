package com.example.piyushravi.multipleactivities;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class KeyboardActivity extends AppCompatActivity {
    Button backButton;
    Button hideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        Intent intent = getIntent();
        String name= intent.getExtras().getString("name");
        EditText editText=(EditText)findViewById(R.id.editText1);
        editText.setText(name);

        backButton=(Button)findViewById(R.id.button1);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View button) {
                finish();
            }
        });

        hideButton= (Button)findViewById(R.id.button2);

        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager manager;
                manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(hideButton.getWindowToken(), 0);

            }
        });

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
