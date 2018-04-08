package com.example.android.bluetoothlegatt;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bluetoothlegatt.model.DailyHealthData;
import com.example.android.bluetoothlegatt.model.DailyHealthDataType;

import java.util.List;

public class DailyHealthDataRecyclerViewAdapter extends RecyclerView.Adapter<DailyHealthDataRecyclerViewAdapter.DailyHealthDataViewHolder> {

    private List<DailyHealthData> dailyHealthDataList;
    private Context context;

    public DailyHealthDataRecyclerViewAdapter(List<DailyHealthData> dailyHealthDataList, Context context) {
        this.dailyHealthDataList = dailyHealthDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public DailyHealthDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_daily_health_data_adapter, parent, false);
        DailyHealthDataViewHolder dailyHealthDataViewHolder = new DailyHealthDataViewHolder(view);
        return dailyHealthDataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DailyHealthDataViewHolder holder, final int position) {
        Drawable drawable = getDrawableBasedOnType(dailyHealthDataList.get(position).getDailyHealthDataType());
        holder.dailyHealthDataImage.setImageDrawable(drawable);
        holder.txtValue.setText(String.valueOf(dailyHealthDataList.get(position).getValue()));
        holder.txtUnit.setText(dailyHealthDataList.get(position).getUnit());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = dailyHealthDataList.get(position).getDailyHealthDataType().toString();
                Toast.makeText(context, type + " is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Drawable getDrawableBasedOnType(DailyHealthDataType dailyHealthDataType){
        Drawable drawable = null;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (dailyHealthDataType.equals(DailyHealthDataType.STEP)) {
                    drawable = context.getDrawable(R.drawable.ic_step);
            } else if (dailyHealthDataType.equals(DailyHealthDataType.DISTANCE)) {
                drawable = context.getDrawable(R.drawable.ic_distance);
            } else if (dailyHealthDataType.equals(DailyHealthDataType.CALORIES)) {
                drawable = context.getDrawable(R.drawable.ic_calories);
            } else if (dailyHealthDataType.equals(DailyHealthDataType.SLEEP)) {
                drawable = context.getDrawable(R.drawable.ic_sleep);
            }
        }
        return drawable;
    }

    @Override
    public int getItemCount() {
        return dailyHealthDataList.size();
    }

    public class DailyHealthDataViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView dailyHealthDataImage;
        TextView txtValue, txtUnit;
        public DailyHealthDataViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.cardView);
            dailyHealthDataImage = view.findViewById(R.id.dailyHealthDataImage);
            txtValue = view.findViewById(R.id.txtValue);
            txtUnit = view.findViewById(R.id.txtUnit);
        }
    }

}
