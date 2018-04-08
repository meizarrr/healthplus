package com.example.android.bluetoothlegatt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class ConnectDeviceFragment extends Fragment {

    private View view;
    private ImageView imgDevice;
    private Button btnConnect;

    public ConnectDeviceFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_connect_device_fragment, container, false);
        initWidgets();
        return view;
    }

    private void initWidgets(){
        initImageDevice();
        initButtonConnect();
    }
    private void initImageDevice(){
        imgDevice = view.findViewById(R.id.imgDevice);
        if(isConnectedToDevice()){
            imgDevice.setImageDrawable(getActivity().getApplicationContext().getResources().getDrawable(R.drawable.ic_connected));
        } else{
            imgDevice.setImageDrawable(getActivity().getApplicationContext().getResources().getDrawable(R.drawable.ic_disconnected));
        }
    }
    private void initButtonConnect(){
        btnConnect = view.findViewById(R.id.btnConnect);
        if(isConnectedToDevice()){
            btnConnect.setText("DISCONNECT");
        } else{
            btnConnect.setText("CONNECT");
        }

        // TODO : Connect ke device implementasinya disini
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private boolean isConnectedToDevice(){
        boolean status = false;
        return status;
    }
}
