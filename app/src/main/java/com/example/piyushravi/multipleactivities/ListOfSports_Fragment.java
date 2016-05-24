package com.example.piyushravi.multipleactivities;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListOfSports_Fragment extends Fragment implements AdapterView.OnItemClickListener {
    ListView list;
    ListView list2;
    private Activity activity;
    private MyConnector myconnector;
    OnNameItemSelectedListener ots;

    public ListOfSports_Fragment() {

    }

    //@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sportsfragment, container, false);

        list = (ListView) view.findViewById(R.id.listView);
        list2 = (ListView) view.findViewById(R.id.listView2);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.country_name, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        Log.d("Sports", "Country Names Launched");

        list.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String name = parent.getItemAtPosition(position).toString();
        myconnector.getValueFromFragmentUsingInterface(name);

        if (position == 0) {

                ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.india_sports, android.R.layout.simple_list_item_1);
                list2.setAdapter(adapter);


                Log.d("Sports","Indian Sports Launched");

        } else if (position == 1) {
            ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.usa_sports, android.R.layout.simple_list_item_1);
            list2.setAdapter(adapter);

            Log.d("Sports", "USA Sports Launched");

        } else if (position == 2) {
            ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.mexico_sports, android.R.layout.simple_list_item_1);
            list2.setAdapter(adapter);

            Log.d("Sports", "Mexico Sports Launched");

        }else return;
    }


    public interface OnNameItemSelectedListener{
        public void onNameItemPicked(String name);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if(activity instanceof MyConnector){
            myconnector=(MyConnector)activity;
        }

    }




}



