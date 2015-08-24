package com.sideprojects.joshmiller.audiomagic;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

/**
 * Created by josh on 8/1/15.
 */
public class NoteThread extends Thread{
    private double frequency;
    private int sampleRate;
    private boolean isRunning = false;
    public NoteThread(double frequency,int sampleRate){
        this.frequency = frequency;
        this.sampleRate= sampleRate;
    }
    public void run(){
        isRunning = true;
        setPriority(Thread.MAX_PRIORITY);
        int bufferSize = AudioTrack.getMinBufferSize(sampleRate, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
        AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC,sampleRate,AudioFormat.CHANNEL_OUT_MONO,AudioFormat.ENCODING_PCM_16BIT,bufferSize,AudioTrack.MODE_STREAM);
        short samples[] = new short[bufferSize];
        int amplitude = 10000;
        double twoPi = 8.*Math.atan(1.);
        double ph = 0.0;
        audioTrack.play();
        while(isRunning){
            for(int i = 0; i< bufferSize; i++){
                samples[i] = (short) (amplitude*Math.sin(ph));
                ph += twoPi*frequency/sampleRate;
          }
            audioTrack.write(samples,0,bufferSize);
        }
        audioTrack.stop();
        audioTrack.release();
    }
    public void endNote(){
        this.isRunning = false;
    }

    public double getFrequency() {
        return frequency;
    }
}

