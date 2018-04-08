package com.example.android.bluetoothlegatt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.bluetoothlegatt.model.DailyHealthData;
import com.example.android.bluetoothlegatt.model.DailyHealthDataType;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private DailyHealthDataRecyclerViewAdapter dailyHealthDataRecyclerViewAdapter;
    private List<DailyHealthData> dailyHealthDataList = new ArrayList<>();

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home_fragment, container, false);
        initWidgets();
        return view;
    }

    private void initWidgets(){
        initRecyclerView();
    }
    private void initRecyclerView(){
        recyclerView = view.findViewById(R.id.dailyHealthDataRecyclerView);
        dailyHealthDataRecyclerViewAdapter = new DailyHealthDataRecyclerViewAdapter(dailyHealthDataList, getActivity().getApplicationContext());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(dailyHealthDataRecyclerViewAdapter);
        populateDummyDailyHealthData();
    }

    //TODO : Ganti data2 dummy ini dengan data yang diambil dari smartband/smartwatch
    private void populateDummyDailyHealthData(){
        DailyHealthData step = new DailyHealthData(
                1021,
                "steps",
                DailyHealthDataType.STEP
        );
        DailyHealthData distance = new DailyHealthData(
                1.72,
                "km",
                DailyHealthDataType.DISTANCE
        );
        DailyHealthData calories = new DailyHealthData(
                14.51,
                "cal",
                DailyHealthDataType.CALORIES
        );
        DailyHealthData sleep = new DailyHealthData(
                7,
                "hours",
                DailyHealthDataType.SLEEP
        );
        dailyHealthDataList.add(step);
        dailyHealthDataList.add(distance);
        dailyHealthDataList.add(calories);
        dailyHealthDataList.add(sleep);
    }
}
