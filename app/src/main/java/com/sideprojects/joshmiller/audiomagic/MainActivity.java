package com.sideprojects.joshmiller.audiomagic;

import android.app.Activity;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.media.audiofx.AcousticEchoCanceler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends Activity {
    private final ArrayList<NoteThread> notes = new ArrayList<NoteThread>();
    public Frequencies frequencies = new Frequencies();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout mainview = (LinearLayout) findViewById(R.id.mainview);
        for(int i = 0; i < frequencies.letters.length; i ++){
            Key k = new Key(getApplicationContext(),frequencies.notes.get(frequencies.letters[i]));
            k.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mainview.addView(k);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
