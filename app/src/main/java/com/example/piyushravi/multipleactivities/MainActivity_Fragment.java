package com.example.piyushravi.multipleactivities;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MainActivity_Fragment extends ListFragment{

    public MainActivity_Fragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mainactivity_fragment,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(),R.array.country_name,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
    }

}
