package com.sideprojects.joshmiller.audiomagic;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by josh on 8/5/15.
 */
public class Key extends Button {
    private double frequency;
    private NoteThread t;
    public Key(Context c,  double frequency){
        super(c);
        this.frequency = frequency;
        this.t = new NoteThread(frequency,44100);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Thread.State s = t.getState();
                    s.name();
                    t.start();
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    t.endNote();
                    t = new NoteThread(t.getFrequency(),44100);
                }
                return false;

            }
        });
    }

}
