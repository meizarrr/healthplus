package com.example.android.bluetoothlegatt.model;

public class DailyHealthData {

    private double value;
    private String unit;
    private DailyHealthDataType dailyHealthDataType;

    public DailyHealthData(double value, String unit, DailyHealthDataType dailyHealthDataType) {
        this.value = value;
        this.unit = unit;
        this.dailyHealthDataType = dailyHealthDataType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public DailyHealthDataType getDailyHealthDataType() {
        return dailyHealthDataType;
    }

    public void setDailyHealthDataType(DailyHealthDataType dailyHealthDataType) {
        this.dailyHealthDataType = dailyHealthDataType;
    }
}
