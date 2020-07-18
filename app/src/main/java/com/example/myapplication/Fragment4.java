package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.media.audiofx.PresetReverb;
import android.media.audiofx.Virtualizer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment4.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment4 newInstance(String param1, String param2) {
        Fragment4 fragment = new Fragment4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ImageView iv1 = (ImageView)view.findViewById(R.id.imageView15);
        final ImageView iv2 = (ImageView)view.findViewById(R.id.imageView16);
        final ImageView iv3 = (ImageView)view.findViewById(R.id.imageView10);
        final ImageView iv4 = (ImageView)view.findViewById(R.id.imageView14);
        final TextView tv1 = (TextView)view.findViewById(R.id.textView4);

        final MediaPlayer officeambient = MediaPlayer.create(getContext(), R.raw.office);
        final MediaPlayer officesample = MediaPlayer.create(getContext(), R.raw.sample);
        final Equalizer sampleeq = new Equalizer(0, officesample.getAudioSessionId());
        sampleeq.setBandLevel((short) 4, (short) -150);
        sampleeq.setBandLevel((short) 0, (short) -150);
        sampleeq.setBandLevel((short) 2, (short) 150);
        sampleeq.setEnabled(true);
        officeambient.setVolume((float)0.02, (float)0.02);
        officeambient.start();
        final Virtualizer samplevr = new Virtualizer(0, officesample.getAudioSessionId());
        samplevr.setStrength((short)500);

        samplevr.setEnabled(true);

        final PresetReverb samplerv = new PresetReverb(0, officesample.getAudioSessionId());
        samplerv.setPreset(PresetReverb.PRESET_SMALLROOM);
        samplerv.setEnabled(true);
        iv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv1.setImageResource(R.drawable.circle2);
                iv2.setImageResource(R.drawable.circle);
                iv3.setImageResource(R.drawable.circle);
                iv4.setImageResource(R.drawable.circle);
                officesample.setVolume(0.75f, 1.0f);
                officesample.start();
                tv1.setText("Sample1 speaking");
            }
        });

        iv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv1.setImageResource(R.drawable.circle);
                iv2.setImageResource(R.drawable.circle2);
                iv3.setImageResource(R.drawable.circle);
                iv4.setImageResource(R.drawable.circle);
                officesample.setVolume(0.35f, 0.5f);
                sampleeq.setBandLevel((short)4, (short)-300);
                sampleeq.setBandLevel((short)3, (short)-150);
            }
        });

        iv3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv1.setImageResource(R.drawable.circle);
                iv2.setImageResource(R.drawable.circle);
                iv3.setImageResource(R.drawable.circle2);
                iv4.setImageResource(R.drawable.circle);
                officesample.setVolume(0.2f, 0.3f);
                sampleeq.setBandLevel((short)4, (short)-450);
                sampleeq.setBandLevel((short)3, (short)-300);
                sampleeq.setBandLevel((short)2, (short)-150);
            }
        });

        iv4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iv1.setImageResource(R.drawable.circle);
                iv2.setImageResource(R.drawable.circle);
                iv3.setImageResource(R.drawable.circle);
                iv4.setImageResource(R.drawable.circle2);

                officesample.setVolume(0.15f, 0.2f);
                sampleeq.setBandLevel((short)4, (short)-600);
                sampleeq.setBandLevel((short)3, (short)-450);
                sampleeq.setBandLevel((short)2, (short)-300);
            }
        });


    }
}