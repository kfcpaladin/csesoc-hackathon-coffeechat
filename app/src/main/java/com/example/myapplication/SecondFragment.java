package com.example.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import java.io.IOException;

public class SecondFragment extends Fragment {
    public static int roomno = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView Meetingcode = (TextView)view.findViewById(R.id.textView2);
        Meetingcode.setText("872851");
        final RadioButton button1 = (RadioButton)view.findViewById(R.id.radioButton);
        final RadioButton button2 = (RadioButton)view.findViewById(R.id.radioButton2);
        final RadioButton button3 = (RadioButton)view.findViewById(R.id.radioButton3);
        final RadioButton button4 = (RadioButton)view.findViewById(R.id.radioButton4);

        final MediaPlayer officeambient = MediaPlayer.create(getContext(), R.raw.office);
        final MediaPlayer cafeambient = MediaPlayer.create(getContext(), R.raw.cafe);

        //test stuff to see if eq works. It does
        final Equalizer loweq = new Equalizer(0, officeambient.getAudioSessionId());
        loweq.setEnabled(true);
        loweq.setBandLevel((short) 4, (short) -1500);
        loweq.setBandLevel((short) 3, (short) -1500);
        short nobands = loweq.getNumberOfBands();
        short nopresets = loweq.getNumberOfPresets();
        short[] bandrange = loweq.getBandLevelRange();
        loweq.setEnabled(false);
        boolean eqenabl = loweq.getEnabled();



        Log.d("EQ", String.valueOf(nobands));
        Log.d("EQ", String.valueOf(nopresets));
        Log.d("EQ", String.valueOf(bandrange[0]) + String.valueOf(bandrange[1]));
        Log.d("EQ", String.valueOf(eqenabl));
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                roomno = 1;
                button2.setChecked(false);
                button3.setChecked(false);
                button4.setChecked(false);
                cafeambient.start();
                cafeambient.setVolume(0.1f, 0.1f);
                if(officeambient.isPlaying()){
                officeambient.stop();
                    try {
                        officeambient.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                roomno = 2;
                button1.setChecked(false);
                button3.setChecked(false);
                button4.setChecked(false);
                officeambient.start();
                officeambient.setVolume(0.1f, 0.1f);
                if(cafeambient.isPlaying()){
                cafeambient.stop();
                    try {
                        cafeambient.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                roomno = 3;
                button1.setChecked(false);
                button2.setChecked(false);
                button4.setChecked(false);
                loweq.setEnabled(true);
                Log.d("EQ", String.valueOf((boolean)loweq.getEnabled()));
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                roomno = 4;
                button1.setChecked(false);
                button2.setChecked(false);
                button3.setChecked(false);
                loweq.setEnabled(false);
                Log.d("EQ", String.valueOf((boolean)loweq.getEnabled()));
            }
        });

        view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (roomno == 1) {
                    if(officeambient.isPlaying()){
                        officeambient.stop();}
                    if(cafeambient.isPlaying()){
                        cafeambient.stop();}
                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_fragment3);
                }
                if (roomno == 2) {
                    if(officeambient.isPlaying()){
                        officeambient.stop();}
                    if(cafeambient.isPlaying()){
                        cafeambient.stop();}
                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_fragment4);

                }
            }
        });

        /*
        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

         */
    }
}