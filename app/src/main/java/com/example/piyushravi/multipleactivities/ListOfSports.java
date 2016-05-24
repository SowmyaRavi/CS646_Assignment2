package com.example.piyushravi.multipleactivities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ListOfSports extends AppCompatActivity implements ListOfSports_Fragment.OnNameItemSelectedListener,MyConnector {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_sports);
        final ListOfSports_Fragment mNameFragment = new ListOfSports_Fragment();
        setFragment(mNameFragment);
        Button back = (Button) findViewById(R.id.button4);
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.fragment) == null) {
            fm.beginTransaction().add(R.id.fragment, fragment).commit();
        }
    }

   public void onNameItemPicked(String name) {


   }

   public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getValueFromFragmentUsingInterface(final String name) {

        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
        Button back = (Button) findViewById(R.id.button4);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                intent.putExtra("name", name);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    }



