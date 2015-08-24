package com.sideprojects.joshmiller.audiomagic;

import java.util.EnumMap;
import java.util.HashMap;

/**
 * Created by josh on 8/24/15.
 */
public class Frequencies {
    public HashMap<String, Double> notes;
    public String[] letters = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
    public Frequencies(){
        notes.put("A",440.0);
        notes.put("A#",466.2);
        notes.put("B",493.9);
        notes.put("C",523.3);
        notes.put("C#", 554.4);
        notes.put("D", 587.3);
        notes.put("D#",622.3);
        notes.put("E",659.3);
        notes.put("F",698.5);
        notes.put("G",784.0);
        notes.put("G#",830.6);
    }
}
